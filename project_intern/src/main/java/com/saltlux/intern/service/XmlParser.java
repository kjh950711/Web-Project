package com.saltlux.intern.service;

/* XPathExpression
item : <item>요소를 모두 선택함
/item : "/" 루트 노드의 자식 노드중에서 <item>엘리먼트를 선택함 (앞에 "/"가 들어가면 절대 경로)
item/jeongpro : <item>엘리먼트의 자식 노드중에서 <jeongpro>엘리먼트를 선택 (상대 경로)
// : 현재 노드의 위치와 상관없이 지정된 노드부터 탐색
//item : 위치와 상관없이 엘리먼트 이름이 <item>인 모든 엘리먼트
item/@id : 모든 <item>엘리먼트의 id속성 노드를 모두 선택함
item[k] : <item>엘리먼트 중에서 k번 째 <item>엘리먼트
item[@attr = val] : attr이라는 속성이 val값을 가지는 모든 <item>엘리먼트

출처: https://jeong-pro.tistory.com/144
*/
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class XmlParser {
	public Document makeDoc(MultipartFile xmlFile) {

		//1.문서를 읽기위한 공장을 만들어야 한다.
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		//2.빌더 생성
        DocumentBuilder dBuilder;
        Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			
		//3.생성된 빌더를 통해서 xml문서를 Document객체로 파싱해서 가져온다
			File file = new File(xmlFile.getOriginalFilename());
			xmlFile.transferTo(file);
			doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();//문서 구조 안정화
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public String parser_all(Document doc) {
		
		StringBuilder text = new StringBuilder();
		 
		//Get all text
		NodeList nList = doc.getElementsByTagName("text");
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			text.append(node.getTextContent().trim()); 
		}
		return text.toString();
	}
	
	public String parser_epi(Document doc, String episode) {
		
		StringBuilder text = new StringBuilder();
		 
		//Get all
		NodeList nList = doc.getElementsByTagName("episode");
		 
		for (int temp = 0; temp < nList.getLength(); temp++) {
		 Node node = nList.item(temp);
		 if (node.getNodeType() == Node.ELEMENT_NODE) {
		    Element eElement = (Element) node;
		    text.append(eElement.getAttribute("n"));
		 }
		 text.append(node.getTextContent().trim()); 
		}
		return text.toString();
	}
}
