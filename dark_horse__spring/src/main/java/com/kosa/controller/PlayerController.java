/* 작성자: 최보름 고민정
 * 기능: arraylist를 set해서 기수목록(상위승률50위)페이지 player_list.jsp로 포워딩하는 서블릿
 * 넘겨 받아야 하는 정보: 없음
 * */

package com.kosa.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosa.model.PlayerChart;
import com.kosa.model.PlayerInfo;
import com.kosa.model.PlayerPrize;
import com.kosa.vo.PlayerChartVO;
import com.kosa.vo.PlayerPrizeVO;
import com.kosa.vo.PlayerVO;


@Controller
public class PlayerController{
	
	//@Autowired
	@Resource(name="playerInfoImpl")
	private PlayerInfo svcPi;
	
	@Resource(name="pyPrizeImpl")
	private PlayerPrize svcPr;	

	@Resource(name="playerChartImpl")
	private PlayerChart svrPc;
	
		
	@RequestMapping(value = "/player_list", method = RequestMethod.GET)  
	public String playerList(Model model) {		
		ArrayList<PlayerVO> pyprofileList = svcPi.pyOrderSelect(); //기수 정보 top50
		model.addAttribute("pyVOList", pyprofileList);  
		return "py_list";	//jsp
	}
	
	@RequestMapping(value = "/player_detail")
	protected String playerProfile(Model model, @RequestParam("pName") String pname) {

		//request.setCharacterEncoding("utf-8"); 
		//기수명 받아서 기수 프로필 vo생성 
		PlayerVO pyprofile = svcPi.pyName(pname); //pyname의 select 데이터 담긴 vo

		//기수명 받아서 기수 우승정보 arraylist생성 	
		ArrayList<PlayerPrizeVO> prlist = svcPr.pyPrizeSelect(pname);
		 
		ArrayList<String> chartTempList = svrPc.monthSelect(pname);
		ArrayList<Integer> firstTempList = svrPc.firstSelect(pname);
		ArrayList<Integer> secondTempList = svrPc.secondSelect(pname);
		
		ArrayList<String> chartlist = new ArrayList<String>();
		ArrayList<String> firstlist = new ArrayList<String>();
		ArrayList<String> secondlist = new ArrayList<String>();
		
		for(String s : chartTempList) {
			chartlist.add("'"+s+"'");
		}
		for(int s : firstTempList) {
			firstlist.add("'"+s+"'");
			//[5,4,3,...]
		}
		for(int s : secondTempList) {
			secondlist.add("'"+s+"'");
		}
			 

		model.addAttribute("gvo", pyprofile); 
		model.addAttribute("prizelist", prlist); 
		model.addAttribute("chartlist", chartlist); 
		model.addAttribute("firstlist", firstlist); 
		model.addAttribute("secondlist", secondlist); 
		return "py_profile";
		
	}
}
