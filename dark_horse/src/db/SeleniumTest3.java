package db;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import model.HorseImpl;
import vo.HorseInfoVO;
 
public class SeleniumTest3 {
 
    public static void main(String[] args) {
 
        SeleniumTest3 selTest = new SeleniumTest3();
        selTest.crawl();
        
    }
    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/kosa/chromedriver_win32/chromedriver.exe";
   
    //크롤링 할 URL
    private String base_url;
    
    public SeleniumTest3() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://race.kra.co.kr/racehorse/ProfileHorsenameKinds.do?Act=07&Sub=1&meet=2";
    }
 
    public void crawl() {    
    	try {
    		HorseImpl hmd = new HorseImpl();
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
    		
            driver.get(base_url);
            int[] col = {2,3,4,5,7,8,9,10,11,12,14};
            for(int i = 0; i < col.length; i++) {
            	System.out.println("---------------" + (i+1) + "번째 화면 ----------------");
            	driver.findElement(By.cssSelector("#contents > table > tbody > tr > td:nth-child("+ col[i] +") > a")).click(); // 말 리스트 화면으로...
            	
            	int h_list_size = driver.findElements(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr")).size();
            	for(int j = 1; j <= h_list_size; j++){
            		driver.findElement(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr:nth-child(" + j + ") > td:nth-child(2) > a")).click();
            		
            		// 마적사항  
            		String hrno = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(6)")).getText();
            		String hrname = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
            		String h_sex = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(2) > td:nth-child(4)")).getText();
            		String h_birthday = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(3) > td:nth-child(2)")).getText();
            		String h_class = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
            		String trname = "";
            		try {
            			trname = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(2) > td:nth-child(8) > a")).getText();            			
            		}catch(NoSuchElementException e) {
            			trname = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(2) > td:nth-child(8)")).getText();
            		}
            		String owname = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(3) > td:nth-child(8) > a")).getText();
            		String h_prize = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(11) > td:nth-child(4)")).getText();
            		String h_win_rate = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(5) > td:nth-child(3)")).getText();
            		String h_photo = h_imgs[(int)(Math.random() * h_imgs.length)];
            		String rating = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(4)")).getText();
            		
            		
            		
            		// 말 훈련횟수 구하기
            		driver.findElement(By.cssSelector("#contents > ul > li:nth-child(9) > a")).click();
            		int training_cnt = driver.findElements(By.cssSelector("#contents > div.tableType2 > table > tbody > tr")).size();
            		
            		HorseInfoVO hivo = new HorseInfoVO();
            		hivo.setHrno(hrno);
            		
            		// 마명 영어이름() 잘라내기
            		int substr_idx = hrname.indexOf("(");
            		hrname = hrname.substring(0, substr_idx).trim();
            		hivo.setHrname(hrname);
            		
            		hivo.setH_sex(h_sex);
            		hivo.setH_birthday(h_birthday);
            		hivo.setH_class(h_class);
            		hivo.setTrname(trname);
            		hivo.setOwname(owname);
            		hivo.setH_prize(h_prize);
            		
            		// 승률 퍼센트 없애기
            		substr_idx = h_win_rate.indexOf(":") + 2;
            		h_win_rate = h_win_rate.substring(substr_idx, h_win_rate.length() - 1);
            		if(h_win_rate.equals("")) {
            			hivo.setH_win_rate(0.0);
            		}
            		else{
            			hivo.setH_win_rate(Double.parseDouble(h_win_rate));  // substr
            		}
            		
            		hivo.setH_photo(h_photo);
            		hivo.setTraining_cnt(training_cnt);
            		hivo.setPlace("제주");
            		if(rating.equals("")) {
            			hivo.setRating(0);
            		}
            		else{
            			hivo.setRating(Integer.parseInt(rating));
            		}
            		
            		System.out.println(hivo.toString());
            		//hmd.horseInfoInsert(hivo);
            		
            		driver.navigate().back();
            		driver.navigate().back();
            	}
            	driver.get(base_url);
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {

        }
 
    }
    
 
}
