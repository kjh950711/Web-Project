package com.kosa.controller;

import java.util.ArrayList;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosa.model.HorseInfo;
import com.kosa.model.HorseScore;
import com.kosa.vo.HorseChartVO;
import com.kosa.vo.HorseInfoVO;
import com.kosa.vo.HorseScoreVO;


@Controller
public class HorseController {
	
	@Resource(name="HorseInfoImpl")
	private HorseInfo hi;
	
	@Resource(name="HorseScoreImpl")
	private HorseScore hs;
	
	@RequestMapping(value = "/horse_detail")
	public String horseDetail(Model model, @RequestParam("hName") String hname) {
		
		HorseInfoVO hvo = hi.HorseInfoSelect(hname);
		String hrno = hvo.getHno();
		HorseScoreVO hsvo = hs.HorseScoreSelect_rank(hrno);
		
		System.out.println(hvo.toString());
		
		ArrayList<HorseChartVO> monranklist = hs.HorseScoreSelect_monrank(hrno);
		System.out.println(monranklist);
		
		ArrayList<String> monlist = new ArrayList<String>();
		ArrayList<String> ranklist = new ArrayList<String>();
		for (HorseChartVO vo : monranklist) {
			monlist.add("'" + Integer.toString(vo.getGameMonth()) + "월'");
			ranklist.add(Integer.toString(vo.getAvgRankMon()));
		}
		
		model.addAttribute("hvo", hvo);
		model.addAttribute("hsvo", hsvo);
		model.addAttribute("monlist", monlist);
		model.addAttribute("ranklist", ranklist);
		
		return "hr_profile";
	}
	
	@RequestMapping(value = "/horse_list")
	public String horseList(Model model) {
		
		ArrayList<HorseInfoVO> hlist = hi.horseSelect();
		model.addAttribute("hlist", hlist);
		
		return "hr_list";
		
	}

}
