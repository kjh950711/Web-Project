package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import db.DBConn;
import model.HorseImpl;
import model.HorseScoreImpl;
import vo.HorseScoreVO;

public class SeleniumTest4 {
     
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/kosa/chromedriver_win32/chromedriver.exe";
   
    public static String base_url2;
   
    public SeleniumTest4() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();

    }
    
    public static void main(String[] args) {
    	String seoul = "https://race.kra.co.kr/racehorse/ProfileHorsenameKinds.do?Act=07&Sub=1&meet=1";
    	String busan = "https://race.kra.co.kr/racehorse/ProfileHorsenameKinds.do?Act=07&Sub=1&meet=3";
        base_url2 = "https://race.kra.co.kr/racehorse/ProfileHorsenameKinds.do?Act=07&Sub=1&meet=2"; //(제주)등급별, 국산마, 외산마           
        SeleniumTest4 hs = new SeleniumTest4();
        hs.crawl(seoul);
        hs.crawl3(busan);
        hs.crawl2(base_url2);   //제주           
        
        // 사진 insert
        
    }
    public void crawl(String base_url) {//서울
        
        try {
             //get page
             driver.get(base_url);
                     
           // i등급 계 클릭
             HorseScoreImpl hsi = new HorseScoreImpl();
             //int h_size = driver.findElements(By.cssSelector("#contents > div.tableType2 > table > tbody > tr")).size();
             for(int i = 1; i <= 7; i++) {
            	 driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + i + ") > td:nth-child(4) > a")).click(); // 총합 마명 클릭
            	 
            	 int hi_size = driver.findElements(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr")).size();
                 for(int j = 1; j <= hi_size; j++) {
                	 String hrname = driver.findElement(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr:nth-child(" + j + ") > td:nth-child(2) > a")).getText();
                	 driver.findElement(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr:nth-child(" + j + ") > td:nth-child(2) > a")).click(); // 마명 클릭
                     String hno = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(6)")).getText(); //마번
                     
                     driver.findElement(By.cssSelector("#contents > ul > li:nth-child(3) > a")).click(); // 경주성적 클릭
                     
                   
                          // 데이터 가져오는 페이지                                 #contents > div.tableType2 > table > tbody > tr:nth-child(1) > td:nth-child(2)
//                    	 String str = driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr > td")).getText();
//                         if(str.equals("자료가 없습니다.")){
//                         	HorseScoreVO hsvo = new HorseScoreVO();
//                         	hsvo.setHrname(hrname);                          
//                            hsvo.setHrno(hno);
//                            hsvo.setPlace("서울");
//                             System.out.println("데이터 없음");
//                            hsi.HorseScoreInsert(hsvo);
//                             
//                            driver.navigate().back();
//                            driver.navigate().back();
//                         }
//                         else {
                        	 int hk_size = driver.findElements(By.cssSelector("#contents > div.tableType2 > table > tbody > tr")).size();
                             for(int k = 1; k <= hk_size; k++) {
              
                                 String racing_date= driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + k + ") > td:nth-child(2)")).getText();
                                 String rank0 = driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + k + ") > td:nth-child(7)")).getText();
                                 String rank = rank0.trim().substring(0,rank0.indexOf("/"));
                                 String distance = driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + k + ") > td:nth-child(5)")).getText().trim();                                                                      
                                 String pyname = driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + k + ") > td:nth-child(8)")).getText().trim();
                                 String record = driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + k + ") > td:nth-child(11)")).getText().trim(); //경주성적                         
                                 String racing_month0 = racing_date.substring(racing_date.indexOf("/")+1, racing_date.lastIndexOf("/"));
                                 int racing_month = Integer.parseInt(racing_month0);
                                 
                                 HorseScoreVO hsvo = new HorseScoreVO();
                                 hsvo.setHrname(hrname);                          
                                 hsvo.setHrno(hno);
                                 hsvo.setRacing_date(racing_date);         
                                 if(rank.equals("")) {                             
                                    hsvo.setRank(0);
                                 }else {
                                    hsvo.setRank(Integer.parseInt(rank));                            
                                 }                         
                                 if(distance.equals("")) {                             
                                    hsvo.setDistance(0);
                                 }else {
                                    hsvo.setDistance(Integer.parseInt(distance));                             
                                 }   
                                 hsvo.setPyname(pyname);
                                 hsvo.setRecord(record);
                                 hsvo.setRacing_month(racing_month);
                                 hsvo.setPlace("서울");
                                 
                                 System.out.println(i + "번째 총합, " + j + "번째 마명, " + k + "번째 경주성적 : " + hsvo.toString());
                                 
                                 hsi.HorseScoreInsert(hsvo);
                                                              
                              }
                               driver.navigate().back();
                               driver.navigate().back();// 마명 리스트 페이지
                           
                     }
                 	driver.get(base_url);
                    
                 
             }
           
             
         } catch (Exception e) {
             
             e.printStackTrace();
         
         } finally {
         }
  
     }
    
    public void crawl3(String base_url) {//부산
        
        try {
             //get page
             driver.get(base_url);
                     
           // i등급 계 클릭
             HorseScoreImpl hsi = new HorseScoreImpl();
             //int h_size = driver.findElements(By.cssSelector("#contents > div.tableType2 > table > tbody > tr")).size();
             for(int i = 1; i <= 7; i++) {
            	 driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + i + ") > td:nth-child(4) > a")).click(); // 총합 마명 클릭
            	 
            	 int hi_size = driver.findElements(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr")).size();
                 for(int j = 1; j <= hi_size; j++) {
                	 String hrname = driver.findElement(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr:nth-child(" + j + ") > td:nth-child(2) > a")).getText();
                	 driver.findElement(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr:nth-child(" + j + ") > td:nth-child(2) > a")).click(); // 마명 클릭
                	 /*String hrname = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText(); // 마명
*/                     String hno = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(6)")).getText(); //마번
                     
                     driver.findElement(By.cssSelector("#contents > ul > li:nth-child(3) > a")).click(); // 경주성적 클릭
                     
                   
                        	 int hk_size = driver.findElements(By.cssSelector("#contents > div.tableType2 > table > tbody > tr")).size();
                             for(int k = 1; k <= hk_size; k++) {
              
                                 String racing_date= driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + k + ") > td:nth-child(2)")).getText();
                                 String rank0 = driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + k + ") > td:nth-child(7)")).getText();
                                 String rank = rank0.trim().substring(0,rank0.indexOf("/"));
                                 String distance = driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + k + ") > td:nth-child(5)")).getText().trim();                                                                      
                                 String pyname = driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + k + ") > td:nth-child(8)")).getText().trim();
                                 String record = driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr:nth-child(" + k + ") > td:nth-child(11)")).getText().trim(); //경주성적                         
                                 String racing_month0 = racing_date.substring(racing_date.indexOf("/")+1, racing_date.lastIndexOf("/"));
                                 int racing_month = Integer.parseInt(racing_month0);
                                 
                                 HorseScoreVO hsvo = new HorseScoreVO();
                                 hsvo.setHrname(hrname);                          
                                 hsvo.setHrno(hno);
                                 hsvo.setRacing_date(racing_date);         
                                 if(rank.equals("")) {                             
                                    hsvo.setRank(0);
                                 }else {
                                    hsvo.setRank(Integer.parseInt(rank));                            
                                 }                         
                                 if(distance.equals("")) {                             
                                    hsvo.setDistance(0);
                                 }else {
                                    hsvo.setDistance(Integer.parseInt(distance));                             
                                 }   
                                 hsvo.setPyname(pyname);
                                 hsvo.setRecord(record);
                                 hsvo.setRacing_month(racing_month);
                                 hsvo.setPlace("부산");
                                 
                                 System.out.println(hsvo.toString());
                                 
                                 hsi.HorseScoreInsert(hsvo);
                                                              
                              }
                               driver.navigate().back();
                               driver.navigate().back();// 마명 리스트 페이지
                           
                     }
                 	driver.get(base_url);
                    
                 
             }
           
             
         } catch (Exception e) {
             
             e.printStackTrace();
         
         } finally {
         }
  
     }
 
    public void crawl2(String base_url) {//제주
       
        try {
             //get page
             driver.get(base_url);
                     
           // i등급 계 클릭
             HorseScoreImpl hsi = new HorseScoreImpl();
             driver.findElement(By.cssSelector("#contents > table > tbody > tr > td:nth-child(12) > a")).click(); //제주마6등급
             int list_size = driver.findElements(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr")).size();
             for(int i = 183; i <= list_size; i++) { 
            	
                driver.findElement(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > a")).click();
                String hrname = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
                String hno = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(6)")).getText(); //마번                                              
                System.out.println(hrname);
                System.out.println(hno);
                driver.findElement(By.cssSelector("#contents > ul > li:nth-child(3) > a")).click();
                String str = driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr > td")).getText();
                if(str.equals("자료가 없습니다.")){
                	HorseScoreVO hsvo = new HorseScoreVO();
                	hsvo.setHrname(hrname);                          
                    hsvo.setHrno(hno);
                    hsi.HorseScoreInsert(hsvo);
                    
                    driver.navigate().back();
                    driver.navigate().back();
                }
                else {
                	 List<WebElement> hdate_list = driver.findElements(By.cssSelector("#contents > div.tableType2 > table > tbody > tr")); //경주일자 리스트 크기                   
                     for (int k=0; k < hdate_list.size(); k++) {
     
                        String racing_date= hdate_list.get(k).findElement(By.cssSelector("td:nth-child(2) > a")).getText();
                        String rank0 = hdate_list.get(k).findElement(By.cssSelector("td:nth-child(7)")).getText();
                        String rank = rank0.substring(0,rank0.indexOf("/"));
                        String distance = hdate_list.get(k).findElement(By.cssSelector("td:nth-child(5)")).getText();                                                                      
                        String pyname = hdate_list.get(k).findElement(By.cssSelector("td:nth-child(8)")).getText();
                        String record = hdate_list.get(k).findElement(By.cssSelector("td:nth-child(11)")).getText(); //경주성적                         
                        String racing_month0 = racing_date.substring(racing_date.indexOf("/")+1, racing_date.lastIndexOf("/"));
                        int racing_month = Integer.parseInt(racing_month0);
                                                                    
                         System.out.println(racing_date);
                         System.out.println(rank);
                         System.out.println(distance);
                         System.out.println(pyname);
                         System.out.println(record);
                         System.out.println(racing_month);
                        
                        HorseScoreVO hsvo = new HorseScoreVO();
                        hsvo.setHrname(hrname);                          
                        hsvo.setHrno(hno);
                        hsvo.setRacing_date(racing_date);         
                        if(rank.equals("")) {                             
                           hsvo.setRank(0);
                        }else {
                           hsvo.setRank(Integer.parseInt(rank));                            
                        }                         
                        if(distance.equals("")) {                             
                           hsvo.setDistance(0);
                        }else {
                           hsvo.setDistance(Integer.parseInt(distance));                             
                        }   
                        hsvo.setPyname(pyname);
                        hsvo.setRecord(record);
                        hsvo.setRacing_month(racing_month);
                        hsvo.setPlace("제주");
                        
                        hsi.HorseScoreInsert(hsvo);
                                                     
                     }
                      driver.navigate().back();
                      driver.navigate().back();// 마명 리스트 페이지
                  }  
                
             }
             
         } catch (Exception e) {
             
             e.printStackTrace();
         
         } finally {
         }
  
     }
       
}