/* 작성자: 최보름
 * 기능: 기수 차트 month, 1위횟수,2위횟수 라인그래프 jdbc파일 , 
 	private String pyname;
 	//pyname을 받아서 쿼리
	private int first_count;
	private int second_count;
	private String month;
 * */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConn;



public class playerChartImpl{

	public static void main(String[] args) {
		/*playerChartImpl c = new playerChartImpl();
		ArrayList p = c.secondSelect("김옥성");
		System.out.println(p);*/
	}
	
	public ArrayList<String> monthSelect(String pyname) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<>();

		try {			
			String sql = "select month from player_score where pyname=? order by month";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pyname);			
			
			rs = pstmt.executeQuery();  
			while(rs.next()) {

				list.add("'"+rs.getString("Month")+"'");			
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, pstmt, conn);
		}
		return list;	
	}
	
	public ArrayList firstSelect(String pyname) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList list = new ArrayList();

		try {			
			String sql = "select first_count from player_score where pyname=? order by month";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pyname);			
			
			rs = pstmt.executeQuery();  
			while(rs.next()) {

				list.add(rs.getInt("first_count"));			
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, pstmt, conn);
		}
		return list;	
	}
	
	public ArrayList secondSelect(String pyname) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList list = new ArrayList();

		try {			
			String sql = "select second_count from player_score where pyname=? order by month";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pyname);			
			
			rs = pstmt.executeQuery();  
			while(rs.next()) {

				list.add(rs.getInt("second_count"));			
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, pstmt, conn);
		}
		return list;	
	}

}
