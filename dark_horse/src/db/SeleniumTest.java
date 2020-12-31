package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import model.ScheduleImpl;
import vo.ScheduleInfoVO;
import vo.ScheduleListVO;
 
public class SeleniumTest {
 
    public static void main(String[] args) {
 
        SeleniumTest selTest = new SeleniumTest();
        selTest.crawl();
        
    }
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/kosa/chromedriver_win32/chromedriver.exe";
   
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
    	try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
    		ScheduleImpl smd = new ScheduleImpl();
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
            		sivo.setG_date(g_date);
            		int parsed_g_round = Integer.parseInt(g_round.substring(1, g_round.indexOf("경")));
            		sivo.setG_round(parsed_g_round);
            		sivo.setH_class(h_class);
            		sivo.setDistance(distance);
            		sivo.setG_name(g_name);
            		sivo.setG_time(g_time);
            		sivo.setPlace(place);
            		
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

            			slvo.setPlace(place);
            			slvo.setG_round(parsed_g_round);
            			slvo.setHrname(hrname);
            			slvo.setH_sex(h_sex);
            			slvo.setH_age(Integer.parseInt(h_age));
            			slvo.setH_weight(Double.parseDouble(h_weight));
            			slvo.setG_date(g_date);
            			slvo.setHno(k);
            			
            			if(pyname.startsWith("(")) {
            				pyname = pyname.substring(4, pyname.length());
            			}
            			slvo.setPyname(pyname);
            			
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
