package com.yanchen;

import java.util.ArrayList;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	String value = null;
	Book book = null;
	private ArrayList<Book> bookList = new ArrayList<Book>();
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	int bookIndex = 0;
	/**
	 * 用来标识解析开始
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("SAX解析开始");
	}
	/**
	 * 用来标识解析结束
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("SAX解析结束");
	}
}
