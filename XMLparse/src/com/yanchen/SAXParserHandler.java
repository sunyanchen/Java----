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
	 * ������ʶ������ʼ
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("SAX������ʼ");
	}
	/**
	 * ������ʶ��������
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("SAX��������");
	}
}
