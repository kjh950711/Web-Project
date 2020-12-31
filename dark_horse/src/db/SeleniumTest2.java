package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class SeleniumTest2 {
 
    public static void main(String[] args) {
 
        SeleniumTest2 selTest = new SeleniumTest2();
        selTest.crawl();
        
    }
 
    
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/kosa/chromedriver_win32/chromedriver.exe";
   
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumTest2() {
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
            driver.get(base_url);
            
            
            
            // 테이블 row수로 for문 돌림
            for(int i = 1; i <= driver.findElements(By.cssSelector("a[href='#KRA']")).size(); i++){
            	// 클릭 수행
            	driver.findElement(By.cssSelector("div.tableType2 > table > tbody > tr:nth-child(" + i + ") > td:nth-child(3) > a")).click();
            	List<WebElement> h_list = driver.findElements(By.cssSelector("#contents > form > div.tableType2 > table > tbody > tr"));
            	System.out.println("tr size : " + h_list.size());
            	for(int j = 0; j < h_list.size(); j++) {
            		String hno = h_list.get(j).findElement(By.cssSelector("td:nth-child(1)")).getText();
            		String hrname = h_list.get(j).findElement(By.cssSelector("td:nth-child(2) > a")).getText();
            		String h_sex = h_list.get(j).findElement(By.cssSelector("td:nth-child(4)")).getText();
            		String h_age = h_list.get(j).findElement(By.cssSelector("td:nth-child(5)")).getText();
            		String h_weight = h_list.get(j).findElement(By.cssSelector("td:nth-child(7)")).getText();
            		String pyname = h_list.get(j).findElement(By.cssSelector("td:nth-child(9) > a")).getText();
            		
            		
            		
//            		System.out.println(hno);
//            		System.out.println(hname);
//            		System.out.println(sex);
//            		System.out.println(age);
//            		System.out.println(weight);
//            		System.out.println(pname);
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
