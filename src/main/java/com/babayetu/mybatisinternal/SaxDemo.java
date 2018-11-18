package com.babayetu.mybatisinternal;

import java.io.IOException;
import java.io.Reader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.ibatis.io.Resources;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class SaxDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader xmlReader = parser.getXMLReader();
		xmlReader.setContentHandler(new BookParserHandler());
		
		String resources = "com/babayetu/mybatisinternal/book.xml";
		
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resources);
			xmlReader.parse(new InputSource(reader));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
