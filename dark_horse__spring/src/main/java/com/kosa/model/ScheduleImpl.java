package com.kosa.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kosa.mapper.ScheduleMapper;
import com.kosa.vo.NewsVO;
import com.kosa.vo.ScheduleInfoListVO;
import com.kosa.vo.ScheduleInfoVO;
import com.kosa.vo.ScheduleListVO;

@Service("scheduleImpl")
public class ScheduleImpl implements Schedule{
	
	@Autowired
	private ScheduleMapper mapper;


	@Override
	public ArrayList<String> hNameSelect() {
		return mapper.hNameSelectSQL();
	}

	@Override
	public ArrayList<ScheduleInfoVO> infoOptionSelect(String place) {
		return mapper.infoOptionSelectSQL(place);
	}

	@Override
	public ArrayList<ScheduleInfoListVO> gameListSelect(ScheduleInfoVO sivo) {
		return mapper.gameListSelectSQL(sivo);
	}

	@Override
	public ArrayList<ScheduleInfoListVO> gameListSelect() {
		return mapper.gameListSelectAllSQL();
	}
	
	
	
	
	// 뉴스 가져오기
		public ArrayList<NewsVO> getNews() {
			ArrayList<NewsVO> newsList = new ArrayList<NewsVO>();
			String clientId = "r2WmYtner4RGDc32VZT4";// 애플리케이션 클라이언트 아이디값";
			String clientSecret = "lPM0fcF9Ch";// 애플리케이션 클라이언트 시크릿값";
			JSONObject jsonObj = null;
			HashMap<String, String> map = new HashMap<String, String>();
			Gson gson = new Gson();
			try {
				String text = URLEncoder.encode("경마", "UTF-8"); // 검색어";
				String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + text
						+ "&display=9&start=1&sort=date"; // 뉴스의 json 결과
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("X-Naver-Client-Id", clientId);
				con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
				int responseCode = con.getResponseCode();
				BufferedReader br;

				if (responseCode == 200) { // 정상 호출
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else { // 에러 발생
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(response.toString());
				jsonObj = (JSONObject) obj;

				System.out.println(jsonObj.get("items").toString());
				System.out.println(jsonObj.get("items").getClass());
				JSONArray arr = (JSONArray) jsonObj.get("items");

				/*
				 * JSONArray arr = (JSONArray) gson.fromJson(response.toString(),
				 * JSONObject.class).get("items");
				 */

				for (int i = 0; i < arr.size(); i++) {
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

	@Override
	public void scheduleInfoInsert(ScheduleInfoVO sivo) {		
		mapper.scheduleInfoInsertSQL(sivo);
	}

	@Override
	public void scheduleListInsert(ScheduleListVO slvo) {
		mapper.scheduleListInsertSQL(slvo);
	}
}
