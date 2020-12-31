package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConn;
import vo.HorseInfoVO;
import vo.HorseScoreVO;

public class HorseImpl {
	
	public static void main(String[] args) {
		/*HorseImpl i = new HorseImpl();
		HorseInfoVO hvo = i.HorseInfoSelect("017847");
		System.out.println(hvo);*/
	}
	public ArrayList<String> hrnameSelect() {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> hrname_list = new ArrayList<>();		
		try {
			String sql ="select hrname from horse_info";
			
			ps = conn.prepareStatement(sql);		
			rs = ps.executeQuery();
			while(rs.next()) {
				hrname_list.add(rs.getString("hrname"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, ps, conn);
		}
		return hrname_list;
	}
	
	public int horseInfoInsert(HorseInfoVO hivo) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement ps = null;	
		
		String sql = "insert into horse_info values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, hivo.getHrname());
			ps.setString(2, hivo.getHrno());
			ps.setString(3, hivo.getH_sex());
			ps.setString(4, hivo.getH_birthday());
			ps.setString(5, hivo.getH_class());
			ps.setString(6, hivo.getTrname());
			ps.setString(7, hivo.getOwname());
			ps.setInt(8, hivo.getRating());
			ps.setString(9, hivo.getPlace());
			ps.setString(10, hivo.getH_photo());
			ps.setString(11, hivo.getH_prize());
			ps.setDouble(12, hivo.getH_win_rate());
			ps.setInt(13, hivo.getTraining_cnt());
			
			res = ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(ps, conn);
		}
		return res;
	}
	
	public int horseInfoUpdate(HorseInfoVO hvo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBConn db = new DBConn();
		conn = db.conn();
		
		String sql = "update horse_info set place=? where hrno=?";
		int res = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hvo.getPlace());
			pstmt.setString(2, hvo.getHrno());
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
		return res;
	}
	
	public HorseInfoVO HorseInfoSelect(String hrname) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			DBConn db = new DBConn();
			
			String sql = "select * from horse_info where hrname like ?";
			HorseInfoVO hvo = new HorseInfoVO();
			
			try {
				conn = db.conn();
	
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + hrname + "%");
				rs = pstmt.executeQuery();
				
				rs.next();
				hvo.setHrname(rs.getString("hrname"));
				hvo.setHrno(rs.getString("hrno"));
				hvo.setH_sex(rs.getString("h_sex"));
				hvo.setH_birthday(rs.getString("h_birthday"));
				hvo.setH_class(rs.getString("h_class"));
				hvo.setTrname(rs.getString("trname"));
				hvo.setOwname(rs.getString("owname"));
				hvo.setRating(rs.getInt("rating"));
				hvo.setPlace(rs.getString("place"));
				hvo.setH_photo(rs.getString("h_photo"));
				hvo.setH_prize(rs.getString("h_prize"));
				hvo.setH_win_rate(rs.getDouble("h_win_rate"));
				hvo.setTraining_cnt(rs.getInt("training_cnt"));

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.close(rs, pstmt, conn);
			}
			return hvo;
	   }
	   public ArrayList<HorseInfoVO> horseSelect() {
		      DBConn db = new DBConn();
		      Connection conn = db.conn();
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      ArrayList<HorseInfoVO> list = new ArrayList<HorseInfoVO>();      
		      try {
		         String sql ="select rownum,s.* from (select horse_info.*,rownum from horse_info order by h_win_rate desc) s where rownum<=50";
		         
		         ps = conn.prepareStatement(sql);      
		         rs = ps.executeQuery();
		         while(rs.next()) {
		            HorseInfoVO hivo = new HorseInfoVO();
		            hivo.setRownum(rs.getInt("rownum"));
		            hivo.setHrname(rs.getString("hrname"));
		            hivo.setHrno(rs.getString("hrno"));
		            hivo.setH_sex(rs.getString("h_sex"));
		            hivo.setH_class(rs.getString("h_class"));
		            hivo.setTrname(rs.getString("trname"));
		            hivo.setOwname(rs.getString("owname"));
		            hivo.setRating(rs.getInt("rating"));
		            hivo.setPlace(rs.getString("place"));
		            hivo.setH_photo(rs.getString("h_photo"));
		            hivo.setH_prize(rs.getString("h_prize"));
		            hivo.setH_win_rate(rs.getDouble("h_win_rate"));
		            hivo.setTraining_cnt(rs.getInt("training_cnt"));
		            hivo.setH_birthday(rs.getString("h_birthday"));
		            
		            list.add(hivo);
		         }
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         db.close(rs, ps, conn);
		      }
		      return list;
		   }

	
	      
	
	
}