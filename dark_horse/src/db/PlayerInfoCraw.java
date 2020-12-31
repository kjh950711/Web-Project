/* 작성자: 최보름
 * 기능: selenium 사용 기수 프로필 크롤링 (우승정보 제외)
 * 상세정보: 마사회 기수정보 프로필 목록(base url)에서 기수명 클릭 => 프로필 페이지 크롤링
 * 	private String pyname;
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

package db;

import java.awt.RenderingHints.Key;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import model.PlayerInfoImpl;
import vo.PyVO;

public class PlayerInfoCraw {
	
	private WebDriver driver;
	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/kosa/etcjar/selenium/chromedriver.exe";
	//크롤링 할 URL
	private String base_url;

	public static void main (String[] args) {
		PlayerInfoCraw seoul = new PlayerInfoCraw("http://race.kra.co.kr/jockey/ProfileJockeyListActive.do?Act=08&Sub=1&meet=1");
		PlayerInfoCraw jeju = new PlayerInfoCraw("http://race.kra.co.kr/jockey/ProfileJockeyListActive.do?Act=08&Sub=1&meet=2");
		PlayerInfoCraw busan = new PlayerInfoCraw("http://race.kra.co.kr/jockey/ProfileJockeyListActive.do?Act=08&Sub=1&meet=3");
		seoul.Player_Craw();
		jeju.Player_Craw();
		busan.Player_Craw();
//		seoul.PyPrize_Craw();
		
	}


    public PlayerInfoCraw(String URL) {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver(options);
        base_url = URL;
    }
	


		public void Player_Craw() {
		
				PlayerInfoImpl impl = new PlayerInfoImpl();
				PyVO vo = new PyVO();
	            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
	            driver.get(base_url);
	            //System.out.println(driver.getPageSource());
	            //기수 숫자 == 클릭 횟수
	            int pList_size = driver.findElements(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr")).size();

	            //baseurl에서 기수명 클릭  => 크롤링
	            for(int i = 1; i <= pList_size; i++) { 
	            	driver.findElement(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr:nth-child(" + i + ") > td:nth-child(2) > div > a")).click();
	            	System.out.println(pList_size);
	            	//크롤링:PLACE, P_PHOTO, pYNAME, AGENCY, P_BIRTHDAY ,P_DEBUT, P_WEIGHT, P_CLOTH, P_WIN_CNT_ALL, P_WIN_CNT_YEAR, 
	            	String place = driver.findElement(By.cssSelector("#contents > p")).getText();
	            	String p_photo = driver.findElement(By.cssSelector("#contents > div.profile > img")).getAttribute("src");
	            	String pyname = driver.findElement(By.cssSelector("#contents > div.profile > ul > li:nth-child(1)")).getText();
	            	String agency = driver.findElement(By.cssSelector("#contents > div.profile > ul > li:nth-child(2)")).getText();
	            	String p_birthday = driver.findElement(By.cssSelector("#contents > div.profile > ul > li:nth-child(3)")).getText();
	            	String p_debut = driver.findElement(By.cssSelector("#contents > div.profile > ul > li:nth-child(4)")).getText();
	            	String p_weightstr = driver.findElement(By.cssSelector("#contents > div.profile > ul > li:nth-child(5)")).getText();
	            	String p_cloth = driver.findElement(By.cssSelector("#contents > div.profile > p > img")).getAttribute("src");
	            	String p_win_cnt_all = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
	            	String p_win_cnt_year = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
	            	String p_win_rate_allstr = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(3)")).getText();
	            	String p_win_rate_yearstr = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(2) > td:nth-child(3)")).getText();
	            	String p_g_cntstr = driver.findElement(By.cssSelector("#contents > div.tableType1 > table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
	            	//데이터 가공: substring, str->int
	            	place=place.replace(" ", "");
	            	int placeidx = place.indexOf("경마"); 
	            	place = place.substring(0, placeidx);
	            	pyname = pyname.substring(2,pyname.length());
	            	agency = agency.substring(3,agency.length());
	            	if(agency.contains("(")) {
	            		int agencyidx = agency.indexOf("(");  
	            		agency = agency.substring(0,agencyidx);
	            	}
	            	p_birthday = p_birthday.substring(4,p_birthday.length());
	            	p_debut = p_debut.substring(4,p_debut.length());
	            	p_weightstr=p_weightstr.replace(" ", "");
	            	p_weightstr=p_weightstr.substring(6,p_weightstr.length());
	            	int p_weightstridx = p_weightstr.indexOf("Kg");
	            	int p_weightstridx2=0;
	            	p_weightstr=p_weightstr.substring(0,p_weightstridx);
	            	if(p_weightstr.contains("소속조")) {
	            		p_weightstr=p_weightstr.substring(4,p_weightstr.length());
	            		if(p_weightstr.contains(".")) {
	            			p_weightstridx2 = p_weightstr.indexOf(".");
	            			p_weightstr=p_weightstr.substring(0,p_weightstridx2);
	            		}
	            	}
	            	int p_weight = Integer.parseInt(p_weightstr);
	            	p_win_rate_allstr=p_win_rate_allstr.replace(" ", "");
	            	p_win_rate_allstr=p_win_rate_allstr.substring(3,p_win_rate_allstr.length()-1);
	            	Double p_win_rate_all = Double.parseDouble(p_win_rate_allstr);
	            	p_win_rate_yearstr=p_win_rate_yearstr.replace(" ", "");
	            	p_win_rate_yearstr=p_win_rate_yearstr.substring(3,p_win_rate_yearstr.length()-1);
	            	Double p_win_rate_year = Double.parseDouble(p_win_rate_yearstr);
	            	int p_g_cnt=0;
	            	int p_g_cntidx=0;
	            	if(p_g_cntstr.contains("전")) {
	            		p_g_cntidx=p_g_cntstr.indexOf("전");
		            	p_g_cntstr=p_g_cntstr.substring(0,p_g_cntidx);
		            	p_g_cnt=Integer.parseInt(p_g_cntstr);
	            	}else {
	            		p_g_cntidx=p_g_cntstr.indexOf("(");
		            	p_g_cntstr=p_g_cntstr.substring(0,p_g_cntidx);
		            	p_g_cnt=Integer.parseInt(p_g_cntstr);
	            	}
	            	
	            	//vo삽입
	            	vo.setPlace(place); 		
	            	vo.setP_photo(p_photo); 
	            	vo.setPyname(pyname);
	            	vo.setAgency(agency); 	
	            	vo.setP_birthday(p_birthday); 	
	            	vo.setP_debut(p_debut); 	
	            	vo.setP_weight(p_weight); 
	            	vo.setP_cloth(p_cloth); 
	            	vo.setP_win_cnt_all(p_win_cnt_all);
	            	vo.setP_win_cnt_year(p_win_cnt_year);
	            	vo.setP_win_rate_all(p_win_rate_all); 	
	            	vo.setP_win_rate_year(p_win_rate_year); 	
	            	vo.setP_g_cnt(p_g_cnt); 	
	            	
	            	//votest
	            	System.out.println(
	            			vo.getPlace()+' '+vo.getP_photo()+' '+vo.getPyname()+' '+vo.getAgency()+' '+vo.getP_birthday()+' '+vo.getP_debut()
	            			+' '+vo.getP_weight()+' '+vo.getP_cloth()+' '+vo.getP_win_cnt_all()+' '+vo.getP_win_cnt_year()+' '+
	            			vo.getP_win_rate_all()+' '+vo.getP_win_rate_year()
	            			+' '+vo.getP_g_cnt());
	  
	            	//DB삽입
	            	impl.pyInsert(vo);
	            	driver.navigate().back();
	            }
	            driver.close();
		}
		
		public void PyPrize_Craw() {
			//문제해결 테스트 코드 : 우승성적이 없는 데이터 처리
			
			PyVO vo = new PyVO();
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
            
            for(int i = 1; i <= 3; i++) {
            //클릭횟수
            driver.findElement(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr:nth-child("+i+") > td:nth-child(2) > div > a")).click();
            //우승성적이 없는 데이터 처리를 위해, tr의 텍스트를 가져옴
            String divstr= driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr > td")).getText();
            //tr의 텍스트가 자료가 없습니다. == 자료가 없는 데이터
            if(divstr.equals("자료가 없습니다.")) {
            	System.out.println("자료가 없습니다.");
            	//그냥 뒤로가기
            	driver.navigate().back();
            ////tr텍스트가 그외 == 자료가 있는 데이터
            }else{ 
            	System.out.println(driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr > td:nth-child(3)")).getText());
            	//데이터 크롤링
            	driver.navigate().back();
            }
            }
	}


	}


