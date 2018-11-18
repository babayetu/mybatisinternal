package com.babayetu.mybatisinternal;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class BookParserHandler implements ContentHandler {
	//这里我们先看继承ContentHandler的情况，这个接口中需要实现的方法很多，但是
    //只用到下面前面三个方法。
    
	
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub

	}

	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub

	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub

	}
	
	//接收元素开始的通知，主要处理开始标签
    //uri：名称空间URI，如果元素没有名称空间URI，如果未执行名称空间处理，则为空字符串
    //localName：本地名称（不带前缀），如果未执行命名空间处理，则为空字符串
    //qName：元素名（带有前缀），如果元素名不可用，则为空字符串
    //atts：该元素的属性。如果没有属性，则它将是空Attributes对象。在startElement返回后，
    //此对象的值是未定义的
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println("当前解析到了：" + qName + "， 这个标签是开始标签");
        for(int i = 0; i < atts.getLength(); i++){
            //下面是得到标签中属性和属性的值
            String attname = atts.getQName(i);
            String attvalue = atts.getValue(i);
            System.out.println(attname + "=" + attvalue);
        }

	}
	
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("当前解析到了：" + qName + "， 这个标签是结束标签");
	}
	
	//此方法主要是进行文本处理，数组中得到文本，就是用来得到标签中的值
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("当前解析到了：" + new String(ch, start, length));

	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void processingInstruction(String target, String data) throws SAXException {
		// TODO Auto-generated method stub

	}

	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub

	}

}
