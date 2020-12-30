package com.saltlux.intern.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.saltlux.tms.api.IN2TMSAnalyzer;
import com.saltlux.tms3.util.TYPE;

@Service
public class TextAnalysis {

	//특수문자만으로 이루어진 어절 제외하기
	public String specialExclude(String parsedText) {
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		String nonspecText = parsedText.replaceAll(match, "");
		return nonspecText;
	}
	
	//형태소 분석
	public String tmsAnalysis(String parsedText) throws Exception {
		IN2TMSAnalyzer command = new IN2TMSAnalyzer();
		command.setServer("127.0.0.1", 10100); 
		
		Map<Long, String> rs = command.getRawStream(parsedText, TYPE.LANG_KOR | TYPE.TYPE_NE_STR);	
		String json = null;
		if(rs == null) {
			  System.out.println(command.getLastErrorMessage());
		}else {
			  json = rs.get(TYPE.LANG_KOR | TYPE.TYPE_NE_STR);
		}
		
		//json 파싱
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(json);
		JsonArray sentences = element.getAsJsonObject().get("sentence").getAsJsonArray();
		
		StringBuilder text = new StringBuilder();
		for(int i=0; i<sentences.size(); i++){
			JsonObject sentence = (JsonObject)sentences.get(i);
			JsonArray temp_morph = sentence.get("morp_r").getAsJsonArray();
			
			JsonArray morph;
			if(temp_morph.size() == 0) {
				morph = sentence.get("morp").getAsJsonArray();
			}else {
				morph = temp_morph;
			}
			for(int j=0; j<morph.size(); j++) {
				JsonObject word = (JsonObject)morph.get(j);
				String one = word.get("lemma").getAsString();
				text.append(one);
				text.append(" ");
			}
		}
		return text.toString();
		
	}
	
	//어절 개수, 공백으로 분리한 개수
	public int splitNum(String text) {
		
		String[] array = text.split(" ");
		
		List<String> list = new ArrayList<>(Arrays.asList(array));
		list.removeAll(Collections.singleton(""));

		// Creates a new array with the same size as the list and copies the list
		// elements to it.
		array = list.toArray(new String[list.size()]);
		
		int num = array.length;
		
		return num;
	}
	
}
