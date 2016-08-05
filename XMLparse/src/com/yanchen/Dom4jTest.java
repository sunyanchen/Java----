package com.yanchen;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	public void ParseByDom4j() {
		// ����books.xml�ļ�
		// ����SAXReader�Ķ���reader
		SAXReader saxReader = new SAXReader();
		// ͨ��reader�����read��������books.xml�ļ�,��ȡdocuemnt����
		try {
			Document document = saxReader.read(new File("books.xml"));
			// ͨ��document�����ȡ���ڵ�bookstore
			Element element = document.getRootElement();
			// ͨ��element�����elementIterator������ȡ������
			Iterator it = element.elementIterator();
			// ��������������ȡ���ڵ��е���Ϣ���鼮��
			while (it.hasNext()) {
				System.out.println("=====��ʼ����ĳһ����=====");
				Element book = (Element) it.next();
				// ��ȡbook���������Լ� ����ֵ
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("��������" + attr.getName() + "--����ֵ��"
							+ attr.getValue());
				}
				Iterator itt = book.elementIterator();
				while(itt.hasNext()){
					Element bookChild = (Element)itt.next();
					System.out.println("�ڵ�����" + bookChild.getName() + "--�ڵ�ֵ��" + bookChild.getStringValue());
				}
				System.out.println("=====��������ĳһ����=====");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dom4jTest test = new Dom4jTest();
		test.ParseByDom4j();
	}

}
