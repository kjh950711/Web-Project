package com.saltlux.intern.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@Service
public class XmlValidation {
	
	@Autowired
	XmlParser xp;
	
	//xml파일 유효성 검증1
	public String validator(MultipartFile xmlFile) {
		
	    DocumentBuilder parser;
	    Document document;
		try {
			// 1. parse an XML document into a DOM tree
			parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File file = new File(xmlFile.getOriginalFilename());
			xmlFile.transferTo(file);
			document = parser.parse(file);
			
			// 2. create a SchemaFactory capable of understanding WXS schemas
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			
			// 3. load a WXS schema, represented by a Schema instance
			Source schemaFile = new StreamSource(new File(XmlValidation.class.getResource("/").getPath()+"../xsd/sjml.xsd"));
			Schema schema = factory.newSchema(schemaFile);
			
			// 4. create a Validator instance, which can be used to validate an instance document
			Validator validator = schema.newValidator();
			
			// 5. validate the DOM tree
			validator.validate(new DOMSource(document));
			
			//xml파일 유효성 검증 2 =================================================
			int extraResult = validator_extra(file);
			if (extraResult > 0) {
				String msg = "파일의 "+ Integer.toString(extraResult) + "번째 줄을 확인해 주세요.";
				return msg;
			}else {
				return "true";				
			}
			//===================================================================
		} catch (ParserConfigurationException | IOException | SAXException e1) {
			int temp = 0;
			for (int i = 0; i < 3; i++) {
				temp = e1.toString().indexOf(" ", temp+1);
			}
			System.out.println(e1.toString().substring(temp+1));
			return e1.toString().substring(temp+1);
		}		
	}
	
	public int validator_extra(File file) {
		
		//입력 스트림 생성
        FileReader filereader;
		try {
			filereader = new FileReader(file);
			//입력 버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			int lineNum = 1;
			while((line = bufReader.readLine()) != null){
				line = line.replaceAll(" ", "");
				String lastChar = line.substring(line.length()-1, line.length());
				if(lastChar.equals(">") == false) {
					return lineNum;
				}
				lineNum++;
			}
			//.readLine()은 끝에 개행문자를 읽지 않는다.            
			bufReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
// 참조: https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/package-summary.html