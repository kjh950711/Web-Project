package com.saltlux.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import com.saltlux.intern.service.FinalSend;
import com.saltlux.intern.service.XmlParser;
import com.saltlux.intern.service.XmlValidation;
import com.saltlux.intern.vo.resultVO;

@Controller
public class HomeController {

	@Autowired
	XmlValidation val;
	@Autowired
	XmlParser xp;
	@Autowired
	FinalSend fs;

	
	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public String home() {
		return "file";
	}
	
	@ResponseBody //메소드에서 리턴되는 값은 View 를 통해서 출력되지 않고 HTTP Response Body 에 직접 쓰여짐
	@RequestMapping(value = "/valid", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
	public String test(@RequestParam("xmlFile") MultipartFile xmlFile) {
		
		//xml파일 유효성 검증
		String result = val.validator(xmlFile);
		return result;
	}
	
	@RequestMapping(value ="/result", method = RequestMethod.POST )
	public String upload(Model model, @ModelAttribute("xmlFile") MultipartFile xmlFile,
									  @RequestParam(value="all", defaultValue="part") String all,
									  @RequestParam(value="episode", defaultValue="0") String episode,
									  @RequestParam(value="scene", defaultValue="0") String scene,
									  @RequestParam(value="speaker", defaultValue="") String speaker) {
		String finalText = null;
		Document doc = xp.makeDoc(xmlFile);
		
		//전체 파싱
		if(all.equals("all")) {
			try {
				finalText = xp.parser_all(doc);
			} catch (Throwable e) { 
				System.err.println(e.toString());
			}
		//episode 태그
		}else if(episode != "0") {
			finalText = xp.parser_epi(doc, episode);
			System.out.println(finalText);
		//scene 태그
		}else if(scene != "0") {
			
		//speaker 태그
		}else {
			
		}
		
		//텍스트 분석	
		resultVO vo = fs.analysis(finalText);
		model.addAttribute("vo", vo);
			
		return "result";
	}
	
}