/* 작성자: 최보름
 * 기능: 기수의 우승정보 jdbc파일
 * * private String pyname;
	private String p_prize;
	private String g_date;
	private String hrname;
 * */

package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConn;
import vo.PyPrizeVO;


public class PyPrizeImpl  {

	public static void main(String[] args) {
		PyPrizeImpl i = new PyPrizeImpl();
		ArrayList<PyPrizeVO> p = i.prSelect("김귀배");
		PyPrizeVO vo = new PyPrizeVO();
		for(int z=0; z < p.size();z++) {
			vo=p.get(z);
			System.out.println(vo.getHrname());
		}
	}
	
	public int PyPrizeInsert(PyPrizeVO pvo) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement pstmt = null;      
		int res= 0;

		try {
			String sql = "insert into player_prize(pyname, p_prize, g_date, hrname) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getPyname());
			pstmt.setString(2, pvo.getP_prize());
			pstmt.setString(3, pvo.getG_date());
			pstmt.setString(4, pvo.getHrname());

			res = pstmt.executeUpdate();        

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt, conn);
		}
		return res;
	}


	
	public ArrayList<PyPrizeVO> prSelect(String pyname) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement pstmt = null;      
		ResultSet rs = null;	
		ArrayList<PyPrizeVO> plist = new ArrayList<PyPrizeVO>();
				
		try {
			String sql = "select * from player_prize where pyname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pyname);
						
			rs = pstmt.executeQuery();  
			while(rs.next()) {
				
				PyPrizeVO pvo = new PyPrizeVO();
				pvo.setPyname(rs.getString("Pyname"));
				pvo.setP_prize(rs.getString("P_prize"));
				pvo.setG_date(rs.getString("G_date"));
				pvo.setHrname(rs.getString("Hrname"));
				plist.add(pvo);		
			}						
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			db.close(rs, pstmt, conn);
		}		
		return plist;	
	}
}