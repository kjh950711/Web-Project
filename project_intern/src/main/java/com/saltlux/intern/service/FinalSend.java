package com.saltlux.intern.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saltlux.intern.vo.resultVO;

@Service
public class FinalSend {
	
	@Autowired
	static
	TextAnalysis ta;
	
	public resultVO analysis(String parsedText) {
		
		resultVO result = new resultVO();
		TextAnalysis ta = new TextAnalysis();
		
		//1 단순 공백 분리 어절 개수
		int simpleNum = ta.splitNum(parsedText);
		result.setSimple(simpleNum);
		
		//2 특수문자 제외 어절 개수
		String nonSpecialText = ta.specialExclude(parsedText);
		int specialExcludeNum = ta.splitNum(nonSpecialText);
		result.setNonSpecial(specialExcludeNum);
		
		//3 형태소 개수
		String tmsText = null;
		int tmsNum = 0;
		try {
			tmsText = ta.tmsAnalysis(parsedText);
			tmsNum = ta.splitNum(tmsText);
			result.setTms(tmsNum);
			
		//4 특수문자 제외 형태소 개수
			String nonSpecialTmsText = ta.specialExclude(tmsText);
			int nonSpecialTmsNum = ta.splitNum(nonSpecialTmsText);
			result.setNonSpecialTms(nonSpecialTmsNum);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return result;
	}
}
