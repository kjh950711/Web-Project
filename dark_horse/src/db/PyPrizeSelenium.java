package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import db.DBConn;
import model.PyPrizeImpl;
import vo.PyPrizeVO;


public class PyPrizeSelenium {


	public static void main(String[] args) {

		PyPrizeSelenium pyS = new PyPrizeSelenium();
		pyS.crawl();

	}
	//WebDriver
	private WebDriver driver;

	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/kosa/chromedriver_win32/chromedriver.exe";

	//크롤링 할 URL
	private String base_url;

	public PyPrizeSelenium() {
		super();

		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		//Driver SetUp
		driver = new ChromeDriver();
		//서울 meet=1 제주 2 부산3
		base_url = "http://race.kra.co.kr/jockey/ProfileJockeyListActive.do?Act=08&Sub=1&meet=3";
	}

	public void crawl() {   
		try {
			//get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
			PyPrizeImpl ppi = new PyPrizeImpl();
			driver.get(base_url);

			int pl_size = driver.findElements(By.cssSelector("#contents > div.tableType2.normal_title > table > tbody > tr")).size();
			// 테이블 row수로 for문 돌림
			for(int i = 1; i <pl_size +1 ; i++){
				// 클릭 수행
				PyPrizeVO pvo = new PyPrizeVO();
				String pyname =driver.findElement(By.cssSelector("div.tableType2.normal_title > table > tbody > tr:nth-child(" + i + ")> td:nth-child(2) > div > a ")).getText();
				pvo.setPyname(pyname);
				//ppi.PyPrizeInsert(pvo);

				//String pyname = driver.findElement(By.cssSelector("")).getText();
				driver.findElement(By.cssSelector("d"
						+ "iv.tableType2.normal_title > table > tbody > tr:nth-child(" + i + ")> td:nth-child(2) > div > a ")).click();
				
				System.out.println(pyname);
				List<WebElement> h_list = driver.findElements(By.cssSelector("#contents > div.tableType2 > table > tbody > tr"));   
				//System.out.println(h_list);
				String divstr= driver.findElement(By.cssSelector("#contents > div.tableType2 > table > tbody > tr > td")).getText();
				 if(divstr.equals("자료가 없습니다.")) {
					 ppi.PyPrizeInsert(pvo);
					 driver.navigate().back();
				 }else { 
					for(int j = 0; j < h_list.size(); j++) {
						String g_date = h_list.get(j).findElement(By.cssSelector("td:nth-child(1)> a")).getText();
						String p_prize = h_list.get(j).findElement(By.cssSelector("td:nth-child(2)")).getText();
						String hrname = h_list.get(j).findElement(By.cssSelector("td:nth-child(3)")).getText();
						
						System.out.println(g_date);
						System.out.println(p_prize);
						System.out.println(hrname);
						pvo.setG_date(g_date);
						pvo.setP_prize(p_prize);
						pvo.setHrname(hrname);
						ppi.PyPrizeInsert(pvo);

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

