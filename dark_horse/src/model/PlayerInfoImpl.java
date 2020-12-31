/* 작성자: 최보름
 * 기능: 기수 프로필 jdbc파일 , 
 * PYIntro.java 인터페이스 implements
 *  private String pyname;
	private String agency;
	private String p_birthday;
	private String p_debut;
	private int p_weight;
	private double p_win_rate_all;
	private double p_win_rate_year;
	private String p_cloth;
	private String p_photo;
	private String p_win_cnt_all;
	private String p_win_cnt_year;
	private int p_g_cnt;
	private String place;
 * */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.PyVO;
import db.DBConn;



public class PlayerInfoImpl implements PYIntro{

//	public static void main(String[] args) {
//		PlayerInfoImpl i = new PlayerInfoImpl();
//		PyVO p = i.pySelect("김귀배");
//		System.out.println(p.getP_win_rate_all());
//	}
	public ArrayList<String> pynameSelect() {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> pyname_list = new ArrayList<>();

		try {			
			String sql = "select pyname from player_info";
			pstmt = conn.prepareStatement(sql);
						
			rs = pstmt.executeQuery();  
			while(rs.next()) {
				pyname_list.add(rs.getString("pyname"));				
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, pstmt, conn);
		}
		return pyname_list;	
	}
	
	@Override
	public ArrayList<PyVO> pySelect() {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PyVO> list = new ArrayList<>();

		try {			
			String sql = "select rownum,s.* from (select player_info.*,rownum from player_info order by p_win_rate_all desc) s where rownum<=50";
			pstmt = conn.prepareStatement(sql);
						
			rs = pstmt.executeQuery();  
			while(rs.next()) {
				PyVO pvo = new PyVO(); 
				pvo.setRownum(rs.getInt("rownum"));
				pvo.setPyname(rs.getString("pyname"));
				pvo.setAgency(rs.getString("agency"));
				pvo.setP_birthday(rs.getString("p_birthday"));
				pvo.setP_debut(rs.getString("p_debut"));
				pvo.setP_weight(rs.getInt("p_weight"));
				pvo.setP_win_rate_all(rs.getDouble("p_win_rate_all"));
				pvo.setP_win_rate_year(rs.getDouble("p_win_rate_year"));
				pvo.setP_cloth(rs.getString("p_cloth"));
				pvo.setP_photo(rs.getString("p_photo"));
				pvo.setP_win_cnt_all(rs.getString("p_win_cnt_all"));
				pvo.setP_win_cnt_year(rs.getString("p_win_cnt_year"));
				pvo.setP_g_cnt(rs.getInt("p_g_cnt"));
				pvo.setPlace(rs.getString("place"));
				
				list.add(pvo);				
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, pstmt, conn);
		}
		return list;	
	}

	@Override
	public PyVO pySelect(String pyname) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		PyVO pvo = new PyVO(); 
				
		try {
			String sql = "select * from player_info where PYNAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pyname);
						
			rs = pstmt.executeQuery();  
			while(rs.next()) {
				pvo.setPyname(rs.getString("pyname"));
				pvo.setAgency(rs.getString("agency"));
				pvo.setP_birthday(rs.getString("p_birthday"));
				pvo.setP_debut(rs.getString("p_debut"));
				pvo.setP_weight(rs.getInt("p_weight"));
				pvo.setP_win_rate_all(rs.getDouble("p_win_rate_all"));
				pvo.setP_win_rate_year(rs.getDouble("p_win_rate_year"));
				pvo.setP_cloth(rs.getString("p_cloth"));
				pvo.setP_photo(rs.getString("p_photo"));
				pvo.setP_win_cnt_all(rs.getString("p_win_cnt_all"));
				pvo.setP_win_cnt_year(rs.getString("p_win_cnt_year"));
				pvo.setP_g_cnt(rs.getInt("p_g_cnt"));
				pvo.setPlace(rs.getString("place"));			
			}						
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			db.close(rs, pstmt, conn);
		}		
		return pvo;	
	}

	@Override
	public int pyInsert(PyVO pvo) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement pstmt = null;		
		int res = 0;
				
		try {	
			
			String sql = "insert into player_info(PYNAME, AGENCY,P_BIRTHDAY,P_DEBUT,P_WEIGHT,P_WIN_RATE_ALL,P_WIN_RATE_YEAR,P_CLOTH,P_PHOTO,P_WIN_CNT_ALL,P_WIN_CNT_YEAR,P_G_CNT,PLACE) values(?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getPyname());
			pstmt.setString(2, pvo.getAgency());
			pstmt.setString(3, pvo.getP_birthday());
			pstmt.setString(4, pvo.getP_debut());
			pstmt.setInt(5, pvo.getP_weight());
			pstmt.setDouble(6, pvo.getP_win_rate_all());
			pstmt.setDouble(7, pvo.getP_win_rate_year());
			pstmt.setString(8, pvo.getP_cloth());
			pstmt.setString(9, pvo.getP_photo());
			pstmt.setString(10, pvo.getP_win_cnt_all());
			pstmt.setString(11, pvo.getP_win_cnt_year());
			pstmt.setInt(12, pvo.getP_g_cnt());
			pstmt.setString(13, pvo.getPlace());
		
			res = pstmt.executeUpdate();  		
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
		return res;
	}

	@Override
	public int pyUpdate(PyVO pvo) {
		DBConn db = new DBConn();
//		Connection conn = db.conn();
//		PreparedStatement pstmt = null;
		int res = 0;
//		
//		try {
//			String sql = "update player_info set PYNAME=?, AGENCY=?,P_BIRTHDAY=?,P_DEBUT=?,P_WEIGHT=?,P_WIN_RATE_ALL=?,P_WIN_RATE_YEAR=?,P_CLOTH=?,P_PHOTO=?,P_WIN_CNT_ALL=?,P_WIN_CNT_YEAR=?,P_G_CNT=?,PLACE=? where PYNAME=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, pvo.getPYNAME());
//			pstmt.setString(2, pvo.getAGENCY());
//			pstmt.setString(3, pvo.getP_BIRTHDAY());
//			pstmt.setString(4, pvo.getP_DEBUT());
//			pstmt.setInt(5, pvo.getP_WEIGHT());
//			pstmt.setInt(6, pvo.getP_WIN_RATE_ALL());
//			pstmt.setInt(7, pvo.getP_WIN_RATE_YEAR());
//			pstmt.setString(8, pvo.getP_CLOTH());
//			pstmt.setString(9, pvo.getP_PHOTO());
//			pstmt.setString(10, pvo.getP_WIN_CNT_ALL());
//			pstmt.setString(11, pvo.getP_WIN_CNT_YEAR());
//			pstmt.setInt(12, pvo.getP_G_CNT());
//			pstmt.setString(13, pvo.getPLACE());
//			pstmt.setString(14, pvo.getPYNAME());
//						
//			res = pstmt.executeUpdate();  		
//			conn.commit();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			db.close(pstmt, conn);
//		}
		return res;
	}

	@Override
	public int pyDelete(String pyname) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement pstmt = null;
		int res = 0;
				
		try {
			String sql = "delete from player_info where pyname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pyname);
						
			res = pstmt.executeUpdate();  	
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
		return res;
	}

}
