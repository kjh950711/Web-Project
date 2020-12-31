package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.kosa.model.ScheduleImpl;
import com.kosa.vo.ScheduleInfoVO;
import com.kosa.vo.ScheduleListVO;
 

public class SeleniumTest {
 
    public static void main(String[] args) {
 
        SeleniumTest selTest = new SeleniumTest();
        selTest.crawl();
        
    }
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/kosa/chromedriver.exe";
   
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumTest() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "http://race.kra.co.kr/thisweekrace/ChulmaDate.do?Act=01&Sub=5";
    }
 
    public void crawl() { 
    	String[] h_imgs = {"http://studbook.kra.co.kr/h_photo/041/041647-l.jpg",   // 제주 말 사진 없음 -> 랜덤이미지로 대체
						   "http://studbook.kra.co.kr/h_photo/043/043370-l.jpg",
						   "http://studbook.kra.co.kr/h_photo/040/040578-l.jpg",
						   "http://studbook.kra.co.kr/h_photo/040/040690-l.jpg",
						   "http://studbook.kra.co.kr/h_photo/038/038452-l.jpg",
						   "http://studbook.kra.co.kr/h_photo/038/038563-l.jpg",
						   "http://studbook.kra.co.kr/h_photo/041/041756-l.jpg",
						   "http://studbook.kra.co.kr/h_photo/041/041489-l.jpg",
						   "http://studbook.kra.co.kr/h_photo/040/040713-l.jpg",
						   "http://studbook.kra.co.kr/h_photo/039/039265-l.jpg",
						   "http://studbook.kra.co.kr/h_photo/041/041111-l.jpg",
						   "http://studbook.kra.co.kr/h_photo/039/039240-l.jpg"
                           };
    	
    	try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
    		Impl smd = new Impl();
            driver.get(base_url);
            Select drp_gdate = new Select(driver.findElement(By.name("search_date")));
            List<WebElement> optList = drp_gdate.getOptions();
            for(int i = 0; i < optList.size(); i++) {
            	System.out.println("---------------" + (i + 1) + "번째 select 화면 ----------------");
            	//drp_gdate.selectByIndex(i);
            	driver.findElement(By.cssSelector("#contents > form:nth-child(5) > div > select")).click();
            	String date = driver.findElement(By.cssSelector("#contents > form:nth-child(5) > div > select > option:nth-child(" + (i + 1) + ")")).getText();
            	String g_date = date.substring(3, date.length());
            	driver.findElement(By.cssSelector("#contents > form:nth-child(5) > div > select > option:nth-child(" + (i + 1) + ")")).click();
            	driver.findElement(By.cssSelector("div > button.btnType4")).click();
            	System.out.println("버튼 클릭해서 화면 전환");
            	System.out.println("경주 일자 : " + g_date);
            	
            	
            	// 테이블 수로 for문 돌림
            	int table_size = driver.findElements(By.cssSelector("#chulmaTbl > table.tableType2")).size();
            	for(int j = 1; j <= table_size; j++){
            		// 
            		String place = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child("+ j +") > thead > tr:nth-child(1) > th:nth-child(1)")).getText();
            		String g_round = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child("+ j +") > thead > tr:nth-child(1) > th:nth-child(2)")).getText();
            		String h_class = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child("+ j +") > thead > tr:nth-child(1) > th:nth-child(3)")).getText();
            		String distance = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child("+ j +") > thead > tr:nth-child(1) > th:nth-child(4)")).getText();
            		String g_name = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child("+ j +") > thead > tr:nth-child(1) > th:nth-child(6)")).getText();
            		String g_time = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child("+ j +") > thead > tr:nth-child(1) > th:nth-child(7)")).getText();
            		
            		
            		ScheduleInfoVO sivo = new ScheduleInfoVO();
            		sivo.setGameDate(g_date);
            		int parsed_g_round = Integer.parseInt(g_round.substring(1, g_round.indexOf("경")));
            		sivo.setGameRound(parsed_g_round);
            		sivo.sethClass(h_class);
            		sivo.setGameDistance(distance);
            		sivo.setGameName(g_name);
            		sivo.setGameTime(g_time);
            		sivo.setGamePlace(place);
            		
            		System.out.println("--------------" + g_date + " " + g_time + " " + place + " " + parsed_g_round + " " + h_class + " " + g_name + " " + optList.size());
            		smd.scheduleInfoInsert(sivo);
            		
            		// 테이블 안에있는 리스트 
            		int list_size = driver.findElements(By.cssSelector("#chulmaTbl > table:nth-child(" + j + ") > tbody > tr")).size();
            		for(int k = 1; k < list_size; k++) {
            			
            			String hno = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child(" + j + ") > tbody > tr:nth-child(" + k + ") > td:nth-child(1)")).getText();
            			String hrname = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child(" + j + ") > tbody > tr:nth-child(" + k + ") > td:nth-child(2)")).getText();
            			String h_sex = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child(" + j + ") > tbody > tr:nth-child(" + k + ") > td:nth-child(4)")).getText();
            			String h_age = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child(" + j + ") > tbody > tr:nth-child(" + k + ") > td:nth-child(5)")).getText();
            			String h_weight = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child(" + j + ") > tbody > tr:nth-child(" + k + ") > td:nth-child(6)")).getText();
            			String pyname = driver.findElement(By.cssSelector("#chulmaTbl > table:nth-child(" + j + ") > tbody > tr:nth-child(" + k + ") > td:nth-child(7)")).getText();
            			
            			System.out.println("제" + parsed_g_round + "경주, " + "마번 : " + k + " " + hrname + " " + h_sex + " " + h_age + " " + h_weight + " " + pyname + " " + list_size);
            			
            			ScheduleListVO slvo = new ScheduleListVO();

            			slvo.setGamePlace(place);
            			slvo.setGameRound(parsed_g_round);
            			slvo.sethName(hrname);
            			slvo.sethSex(h_sex);
            			slvo.sethAge(Integer.parseInt(h_age));
            			slvo.sethWeight(Double.parseDouble(h_weight));
            			slvo.setGameDate(g_date);
            			slvo.setGameHno(k);
            			slvo.sethPhoto(h_imgs[(int)(Math.random() * h_imgs.length)]);
            			
            			if(pyname.startsWith("(")) {
            				pyname = pyname.substring(4, pyname.length());
            			}
            			slvo.setpName(pyname);
            			
            			smd.scheduleListInsert(slvo);
            			
            		}
            	}
            	// 그 전 페이지로 돌아감
            	driver.get(base_url);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {

        }
 
    }
    
 
}

class Impl{
	// 스케줄 공통부분
		public int scheduleInfoInsert(ScheduleInfoVO sivo) {
			DBConn db = new DBConn();
			Connection conn = db.conn();
			PreparedStatement ps = null;		
			int res= 0;
			
			try {
				String sql = "insert into schedule_info2 values(?, ?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, sivo.gethClass());
				ps.setString(2, sivo.getGameDistance());
				ps.setString(3, sivo.getGameName());
				ps.setString(4, sivo.getGameTime());
				ps.setString(5, sivo.getGameDate());
				ps.setInt(6, sivo.getGameRound());
				ps.setString(7, sivo.getGamePlace());
				
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
				String sql = "insert into schedule_list2 values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, slvo.getGameRound());
				ps.setString(2, slvo.gethName());
				ps.setString(3, slvo.gethSex());
				ps.setInt(4, slvo.gethAge());
				ps.setDouble(5, slvo.gethWeight());
				ps.setString(6, slvo.getpName());
				ps.setString(7, slvo.getGamePlace());
				ps.setString(8, slvo.getGameDate());
				ps.setInt(9, slvo.getGameHno());
				ps.setString(10, slvo.gethPhoto());
							
				res = ps.executeUpdate();  		
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.close(ps, conn);
			}
			return res;
		}	
}

class DBConn {	
	public Connection conn() {
		Connection conn = null;
		Properties prop = new Properties();
		String path = "C:\\kosa\\workspace_spring\\dark_horse\\src\\main\\resources\\oracle.properties";
		
		try {		
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
			String URL = (String)prop.get("ORACLE_URL");
			String USER = (String)prop.get("ORACLE_USER");
			String PASSWORD = (String)prop.get("ORACLE_PASSWORD");
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);  // db연결		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	// select
	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// insert update delete
	public void close(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}