package com.kosa.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kosa.model.HorseInfo;
import com.kosa.model.HorseScore;
import com.kosa.model.PlayerInfoImpl;
import com.kosa.model.Schedule;
import com.kosa.vo.NewsVO;
import com.kosa.vo.ScheduleInfoListVO;
import com.kosa.vo.ScheduleInfoVO;


@Controller
public class MainController {
	
	@Resource(name="scheduleImpl")
	private Schedule si;
	
	@Resource(name="HorseScoreImpl")
	private HorseScore hs;
	
	@Resource(name="HorseInfoImpl")
	private HorseInfo hi;
	
	@Resource(name="playerInfoImpl")
	private PlayerInfoImpl pi;  
//	
	@RequestMapping(value="/main")
	public String scheduleList(Model model){
		ScheduleInfoVO ssivo = new ScheduleInfoVO();
		ssivo.setGamePlace("서울");
		ssivo.setGameDate("2019.11.09 (토)");
		ssivo.setGameRound(1);
		ArrayList<ScheduleInfoListVO> sList = si.gameListSelect(ssivo);
		System.out.println(sList.toString());
		// 옵션 리스트
		ArrayList<ScheduleInfoVO> s_optList = si.infoOptionSelect("서울");
		ArrayList<NewsVO> nList = si.getNews();
		
		model.addAttribute("sList", sList);
		System.out.println("sList : " + sList.toString());
		model.addAttribute("sList_infoVo", sList.get(0));
		model.addAttribute("s_optList", s_optList);
		model.addAttribute("nList", nList);
		
		ArrayList<Double> avgscorearr = new ArrayList<Double>();
        ArrayList<String> hNameList = new ArrayList<String>();
        String todayhrname = null;
        for(int i=0; i<sList.size(); i++) {
            todayhrname=sList.get(i).gethName();
            System.out.println("todayhrname : " + todayhrname);
            String hrname = "'" + todayhrname + "'";
            String num = "";
            System.out.println("hs.chartavgrank(hrname) : " + hs.chartavgrank(todayhrname));
            if(hs.chartavgrank(todayhrname) == null) {
            	num = "0.0";
            }
            else {
            	num = String.format("%.2f" , hs.chartavgrank(todayhrname));            	
            }
            avgscorearr.add(Double.parseDouble(num));
            hNameList.add(hrname);
        }
         System.out.println(avgscorearr);
         
         model.addAttribute("avgscorearr", avgscorearr);
         model.addAttribute("hNameList", hNameList);	
		
		return "index";
	}	
	
	@RequestMapping(value="/main/{gamePlace}")
	@ResponseBody
	public HashMap<String, Object> scheduleListbyPlace(Model model, @PathVariable("gamePlace") String gamePlace){
		Gson gson = new Gson();
		ArrayList<ScheduleInfoListVO> hList = null;
		ArrayList<ScheduleInfoVO> optList = null;
		
		if(gamePlace.equals("서울")) {
			ScheduleInfoVO ssivo = new ScheduleInfoVO();
			ssivo.setGamePlace("서울");
			ssivo.setGameDate("2019.11.09 (토)");
			ssivo.setGameRound(1);
			hList = si.gameListSelect(ssivo);
			System.out.println("place 값만 들어왔을 때 : 서울 " + hList.toString());
		
			// 옵션 리스트
			optList = si.infoOptionSelect("서울");
			
		}else if(gamePlace.equals("부경")) {
			ScheduleInfoVO bsivo = new ScheduleInfoVO();
			bsivo.setGamePlace("부경");
			bsivo.setGameDate("2019.11.08 (금)");
			bsivo.setGameRound(1);
			hList = si.gameListSelect(bsivo);
			System.out.println("place 값만 들어왔을 때 : 부경 " + hList.toString());
		
			// 옵션 리스트
			optList = si.infoOptionSelect("부경");

			
		}else if(gamePlace.equals("제주")) {
			ScheduleInfoVO jsivo = new ScheduleInfoVO();
			jsivo.setGamePlace("제주");
			jsivo.setGameDate("2019.11.08 (금)");
			jsivo.setGameRound(1);
			hList = si.gameListSelect(jsivo);
			System.out.println("place 값만 들어왔을 때 : 제주 " + hList.toString());
		
			// 옵션 리스트
			optList = si.infoOptionSelect("제주");
			
		}
		System.out.println(hList.toString());
		System.out.println(optList.toString());
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("hList", hList);
		map.put("optList", optList);
		
		return map;
	}
	
	@RequestMapping(value="/main/{gamePlace}/{gameDate}/{gameRound}")
	@ResponseBody
	public HashMap<String, Object> scheduleListbyPlaceTime(Model model, @PathVariable("gamePlace") String gamePlace,
								                                         @PathVariable("gameDate") String gameDate,
								                                         @PathVariable("gameRound") String gameRound){
		ArrayList<ScheduleInfoListVO> hList = null;
		ArrayList<ScheduleInfoVO> optList = null;
		ScheduleInfoVO scivo = new ScheduleInfoVO();
		scivo.setGamePlace(gamePlace);
		scivo.setGameDate(gameDate);
		scivo.setGameRound(Integer.parseInt(gameRound));
		hList = si.gameListSelect(scivo);
		System.out.println(" 탭으로 넘기고 (place값 받고), search버튼 눌렀을 때 " + hList.toString());
		
		// 옵션 리스트
		optList = si.infoOptionSelect(gamePlace);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("hList", hList);
		map.put("optList", optList);
		
		return map;
	
	}
			
	@RequestMapping(value="/main_search/{search_val}")
	@ResponseBody
	public String mainSearch(Model model, @PathVariable String search_val) {
		
		Gson gson = new Gson();
		String jsonStr = "";
		if(search_val.equals("hName")) {
			ArrayList<String> hrname_list = new ArrayList<String>();
			ArrayList<String> list = hi.hNameSelect();
			
			// 영어이름 없애기
			for(String hrname : list) {
				if(hrname.contains("(")) {
					hrname = hrname.substring(0, hrname.indexOf("(")).trim();
				}
				hrname_list.add(hrname);
			}
			jsonStr = gson.toJson(hrname_list);
			
		} else {
			ArrayList<String> pyname_list = pi.pySelect();
			jsonStr = gson.toJson(pyname_list);
		}
		return jsonStr;
	}
}
