package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

import db.DBConn;
import vo.NewsVO;
import vo.ScheduleInfoListVO;
import vo.ScheduleInfoVO;
import vo.ScheduleListVO;

public class ScheduleImpl {
	public static void main(String[] args) {
		/*ArrayList<String> hrname = new ArrayList<>();
		ScheduleImpl si = new ScheduleImpl();
		ArrayList<ScheduleInfoListVO> list = si.getRaceList();
		for(ScheduleInfoListVO vo : list) {
			System.out.println(vo.getHrname());
			hrname.add(vo.getHrname());
		}
		
		for(int i = 0; i < hrname.size(); i++) {
			si.photoUpdate(hrname.get(i));
		}
		System.out.println("done");*/
	}
	
	// 사진 업데이트
	public int photoUpdate(String hrname) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement ps = null;		
		int res= 0;
		
		try {
			String sql = "update schedule_list " + 
					     "set h_photo = (select h_photo " + 
					     "               from HORSE_INFO " + 
					     "               where hrname like ?) " + 
					     "where hrname = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + hrname + "%");
			ps.setString(2, hrname);
						
			res = ps.executeUpdate();  		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(ps, conn);
		}
		return res;
	}
	
	public ArrayList<String> getHrname() {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement ps = null;		
		ArrayList<String> hrname_list = new ArrayList<>();
		
		try {
			String sql = "select hrname from schedule_list";
			ps = conn.prepareStatement(sql);
						
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				hrname_list.add(rs.getString("hrname"));
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(ps, conn);
		}
		return hrname_list;
	}
	
	// 공통 info select option 리스트 출력
	public ArrayList<ScheduleInfoVO> getOptionList(String place) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ScheduleInfoVO> list = new ArrayList<>();
		
		try {
			String sql = "select distinct si.g_date, si.g_round, si.g_time " + 
					"from schedule_info si, schedule_list sl " + 
					"where si.g_date = sl.g_date " + 
					"and si.g_round = sl.g_round " + 
					"and si.place = sl.place " + 
					"and si.place = ? " +
					"order by si.g_date, si.g_round";
			ps = conn.prepareStatement(sql);
			ps.setString(1, place);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ScheduleInfoVO ivo = new ScheduleInfoVO();
				ivo.setG_date(rs.getString("g_date"));
				ivo.setG_round(rs.getInt("g_round"));
				ivo.setG_time(rs.getString("g_time"));
				
				list.add(ivo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, ps, conn);
		}
		return list;
	}
	
	
	
	// 출전리스트 출력
	public ArrayList<ScheduleInfoListVO> getRaceList(ScheduleInfoVO sivo) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ScheduleInfoListVO> list = new ArrayList<>();
		
		try {
			String sql = "select si.distance, si.g_date, si.g_name, si.g_round, si.g_time, sl.h_age, si.h_class, sl.h_sex, sl.h_weight, sl.hrname, si.place, sl.pyname, sl.hno, nvl(sl.h_photo,' ') as h_photo " + 
					"from schedule_info si, schedule_list sl " + 
					"where si.g_date = sl.g_date " + 
					"and si.g_round = sl.g_round " + 
					"and si.place = sl.place " + 
					"and si.place = ? " + 
					"and si.g_date = ? " + 
					"and si.g_round = ? " + 
					"order by sl.hno";
			System.out.println(sql);
			ps = conn.prepareStatement(sql);
			ps.setString(1, sivo.getPlace());
			ps.setString(2, sivo.getG_date());
			ps.setInt(3, sivo.getG_round());
			rs = ps.executeQuery();
			while(rs.next()) {
				ScheduleInfoListVO ilvo = new ScheduleInfoListVO();
				ilvo.setDistance(rs.getString("distance"));
				ilvo.setG_date(rs.getString("g_date"));
				ilvo.setG_name(rs.getString("g_name"));
				ilvo.setG_round(rs.getInt("g_round"));
				ilvo.setG_time(rs.getString("g_time"));
				ilvo.setH_age(rs.getInt("h_age"));
				ilvo.setH_class(rs.getString("h_class"));
				ilvo.setH_sex(rs.getString("h_sex"));
				ilvo.setH_weight(rs.getInt("h_weight"));
				ilvo.setHrname(rs.getString("hrname"));
				ilvo.setPlace(rs.getString("place"));
				ilvo.setPyname(rs.getString("pyname"));
				ilvo.setHno(rs.getInt("hno"));
				ilvo.setH_photo(rs.getString("h_photo"));

				list.add(ilvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, ps, conn);
		}
		return list;
	}
	
	// 전체 출전리스트 출력
		public ArrayList<ScheduleInfoListVO> getRaceList() {
			DBConn db = new DBConn();
			Connection conn = db.conn();
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<ScheduleInfoListVO> list = new ArrayList<>();
			
			try {
				String sql = "select * " + 
						"from schedule_info si, schedule_list sl " + 
						"where si.g_date = sl.g_date " + 
						"and si.g_round = sl.g_round " + 
						"and si.place = sl.place ";
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					ScheduleInfoListVO ilvo = new ScheduleInfoListVO();
					ilvo.setDistance(rs.getString("distance"));
					ilvo.setG_date(rs.getString("g_date"));
					ilvo.setG_name(rs.getString("g_name"));
					ilvo.setG_round(rs.getInt("g_round"));
					ilvo.setG_time(rs.getString("g_time"));
					ilvo.setH_age(rs.getInt("h_age"));
					ilvo.setH_class(rs.getString("h_class"));
					ilvo.setH_sex(rs.getString("h_sex"));
					ilvo.setH_weight(rs.getInt("h_weight"));
					ilvo.setHrname(rs.getString("hrname"));
					ilvo.setPlace(rs.getString("place"));
					ilvo.setPyname(rs.getString("pyname"));
					ilvo.setHno(rs.getInt("hno"));
					ilvo.setH_photo(rs.getString("h_photo"));

					list.add(ilvo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.close(rs, ps, conn);
			}
			return list;
		}
	
	// 스케줄 공통부분
	public int scheduleInfoInsert(ScheduleInfoVO sivo) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement ps = null;		
		int res= 0;
		
		try {
			String sql = "insert into schedule_info values(?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sivo.getH_class());
			ps.setString(2, sivo.getDistance());
			ps.setString(3, sivo.getG_name());
			ps.setString(4, sivo.getG_time());
			ps.setString(5, sivo.getG_date());
			ps.setInt(6, sivo.getG_round());
			ps.setString(7, sivo.getPlace());
			
			res = ps.executeUpdate();  		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(ps, conn);
		}
		return res;
	}
	
	// 날짜별 경주마 리스트
	public int scheduleListInsert(ScheduleListVO slvo) {
		DBConn db = new DBConn();
		Connection conn = db.conn();
		PreparedStatement ps = null;		
		int res= 0;
		
		try {
			String sql = "insert into schedule_list values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, slvo.getG_round());
			ps.setString(2, slvo.getHrname());
			ps.setString(3, slvo.getH_sex());
			ps.setInt(4, slvo.getH_age());
			ps.setDouble(5, slvo.getH_weight());
			ps.setString(6, slvo.getPyname());
			ps.setString(7, slvo.getPlace());
			ps.setString(8, slvo.getG_date());
			ps.setInt(9, slvo.getHno());
						
			res = ps.executeUpdate();  		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(ps, conn);
		}
		return res;
	}
	
	// 뉴스 가져오기
	  public ArrayList<NewsVO> getNews() {
	    	ArrayList<NewsVO> newsList = new ArrayList<>();
	    	 String clientId = "r2WmYtner4RGDc32VZT4";//애플리케이션 클라이언트 아이디값";
	         String clientSecret = "lPM0fcF9Ch";//애플리케이션 클라이언트 시크릿값";
	         JSONObject jsonObj = null;
	         HashMap<String, String> map = new HashMap<>();
	         Gson gson = new Gson();
	         try {
	             String text = URLEncoder.encode("경마", "UTF-8"); //검색어";
	             String apiURL = "https://openapi.naver.com/v1/search/news.json?query="+ text + "&display=9&start=1&sort=date"; // 뉴스의 json 결과
	             URL url = new URL(apiURL);
	             HttpURLConnection con = (HttpURLConnection)url.openConnection();
	             con.setRequestMethod("GET");
	             con.setRequestProperty("X-Naver-Client-Id", clientId);
	             con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	             int responseCode = con.getResponseCode();
	             BufferedReader br;
	             
	             if(responseCode==200) { // 정상 호출
	                 br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	             } else {  // 에러 발생
	                 br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	             }
	             String inputLine;
	             StringBuffer response = new StringBuffer();
	             while ((inputLine = br.readLine()) != null) {
	                 response.append(inputLine);
	             }
	             br.close();
	             

	             JSONParser parser = new JSONParser();
	             Object obj = parser.parse( response.toString() );
	             jsonObj = (JSONObject) obj;

	             System.out.println( jsonObj.get("items").toString() );
	             System.out.println( jsonObj.get("items").getClass() );
	             JSONArray arr = (JSONArray) jsonObj.get("items");
	             
	            /* JSONArray arr = (JSONArray) gson.fromJson(response.toString(), JSONObject.class).get("items");*/
	             
	             for(int i = 0; i < arr.size(); i++) {
	            	 NewsVO nvo = gson.fromJson(arr.get(i).toString(), NewsVO.class);
	            	 System.out.println(nvo.getTitle());
	            	 newsList.add(nvo);
	             }
	             System.out.println(newsList.toString());

	             
	         } catch (Exception e) {
	             System.out.println(e);
	         }
	         return newsList;
	    }
	
}
