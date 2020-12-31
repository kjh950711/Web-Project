package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import db.DBConn;
import vo.HorseScoreVO;


public class HorseScoreImpl{
	
	/*public static void main(String[] args) {
		
		HorseScoreImpl hi = new HorseScoreImpl();
        ArrayList<String> mon = hi.HorseScoreSelect_mon("017847");
        ArrayList<String> rank = hi.HorseScoreSelect_rank("017847");

		System.out.println(mon);
		System.out.println(rank);
	}*/
	
	public HorseScoreVO HorseScoreSelect(String hrno) {

        Connection conn = null;
        PreparedStatement pstmt = null; 
        ResultSet rs = null;
        
        DBConn db = new DBConn();         
        String sql = "select * from horse_score where hrno =?"; 
        HorseScoreVO hsvo = new HorseScoreVO();
        
        try {
           conn = db.conn();
           pstmt = conn.prepareStatement(sql);   //prepareStatement : SQL문을 DB에 던져줌
           pstmt.setString(1, hrno);
           rs = pstmt.executeQuery();
           rs.next();
                    
           //VO에 변수 담기
           hsvo.setHrname(rs.getString("hrname"));
           hsvo.setHrno(rs.getString("hrno"));
           hsvo.setRacing_date(rs.getString("racing_date"));
           hsvo.setRank(rs.getInt("rank"));
           hsvo.setDistance(rs.getInt("distance"));
           hsvo.setPyname(rs.getString("pyname"));
           hsvo.setRecord(rs.getString("record"));
           hsvo.setRacing_month(rs.getInt("racing_month"));
                 
           
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
        	db.close(rs, pstmt, conn);
        }
     
        return hsvo; //메모리에 올려준 객체 자체를 반환
     }
	
	public HorseScoreVO HorseScoreSelect_rank(String hrno) {

        Connection conn = null;
        PreparedStatement pstmt = null; 
        ResultSet rs = null;
        
        DBConn db = new DBConn();         
        String sql = "select count(rank) as gamecnt, round(avg(rank), 2) as avgrank from horse_score group by hrno having hrno=?"; 
        HorseScoreVO hsvo = new HorseScoreVO();
        
        try {
           conn = db.conn();
           pstmt = conn.prepareStatement(sql);   //prepareStatement : SQL문을 DB에 던져줌
           pstmt.setString(1, hrno);
           rs = pstmt.executeQuery();
           
           rs.next();
                    
           //VO에 변수 담기
           hsvo.setGamecnt(rs.getInt("gamecnt"));
           hsvo.setAvgrank(rs.getDouble("avgrank"));
           
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
        	db.close(rs, pstmt, conn);
        }
     
        return hsvo; //메모리에 올려준 객체 자체를 반환
    }
      
      public ArrayList<String> HorseScoreSelect_mon(String hrno) {

          Connection conn = null;
          PreparedStatement pstmt = null; 
          ResultSet rs = null;
          
          DBConn db = new DBConn();         
          String sql = "select racing_month, avg(rank) from horse_score where hrno=? group by racing_month order by racing_month"; 
          		
          ArrayList<String> mon = new ArrayList<String>();
          
          try {
             conn = db.conn();
             pstmt = conn.prepareStatement(sql);   //prepareStatement : SQL문을 DB에 던져줌
            
             pstmt.setString(1, hrno);
             rs = pstmt.executeQuery();
             //VO에 변수 담기
             
             while(rs.next()) {
            	 mon.add("'"+Integer.toString(rs.getInt("racing_month"))+"월'");
             }
             
          } catch (SQLException e) {
             e.printStackTrace();
          } finally {
        	  db.close(rs, pstmt, conn);
          }
       
          return mon; //메모리에 올려준 객체 자체를 반환
       }
      
      public ArrayList<String> HorseScoreSelect_monrank(String hrno) {

          Connection conn = null;
          PreparedStatement pstmt = null; 
          ResultSet rs = null;
          
          DBConn db = new DBConn();         
          String sql = "select racing_month, avg(rank) from horse_score where hrno=? group by racing_month order by racing_month"; 
          		
          
          ArrayList<String> rank = new ArrayList<String>();

          try {
             conn = db.conn();
             pstmt = conn.prepareStatement(sql);   //prepareStatement : SQL문을 DB에 던져줌
            
             pstmt.setString(1, hrno);
             rs = pstmt.executeQuery();
                      
             //VO에 변수 담기
             while(rs.next()) {
            	 rank.add(Integer.toString(rs.getInt("avg(rank)")));
             }
             
          } catch (SQLException e) {
             e.printStackTrace();
          } finally {
              db.close(rs, pstmt, conn);
          }
       
          return rank; //메모리에 올려준 객체 자체를 반환
       }
      
      
      
   public int HorseScoreInsert(HorseScoreVO hsvo) {
      DBConn db = new DBConn();
      Connection conn = db.conn();
      PreparedStatement ps = null;      
      int res= 0;
      
      try {
         String sql = "insert into horse_score values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
         ps = conn.prepareStatement(sql);
         ps.setString(1, hsvo.getHrname());
         ps.setString(2, hsvo.getHrno());
         ps.setString(3, hsvo.getRacing_date());
         ps.setInt(4, hsvo.getRank());
         ps.setInt(5, hsvo.getDistance());
         ps.setString(6, hsvo.getPyname());
         ps.setString(7, hsvo.getRecord());
         ps.setInt(8, hsvo.getRacing_month());
         ps.setString(9, hsvo.getPlace());
         
         res = ps.executeUpdate();        
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         db.close(ps, conn);
      }
      return res;
   }
   
   public Double chartavgrank(String hrname) {

       Connection conn = null;
       PreparedStatement pstmt = null; 
       ResultSet rs = null;
       
       DBConn db = new DBConn();         
       String sql = "select avg(rank), hrname from horse_score where hrname like ? group by hrname"; 
       HorseScoreVO hsvo = new HorseScoreVO();
       Double avg=0.0;
       try {
          conn = db.conn();
          pstmt = conn.prepareStatement(sql);   //prepareStatement : SQL문을 DB에 던져줌
          pstmt.setString(1, "%" + hrname + "%");
          rs = pstmt.executeQuery();
          rs.next();
        
          avg= rs.getDouble("avg(rank)");
         
                
          
       } catch (SQLException e) {
          e.printStackTrace();
       } finally {
           db.close(rs, pstmt, conn);
       }
    
       return avg; 
    }

   
}