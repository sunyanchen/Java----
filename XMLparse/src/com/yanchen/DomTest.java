package com.yanchen;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest {

	public void ParsebyDom() {
		// ����һ��DocumentBuilderFactory����
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// ����һ��documentbuilder����
			DocumentBuilder db = dbf.newDocumentBuilder();
			// ͨ��DocumentBuilder�����parser��������books.xml�ļ�����ǰ��Ŀ��
			Document document = db.parse("books.xml");
			// ��ȡ����book�ڵ�ļ���
			NodeList booklist = document.getElementsByTagName("book");
			System.out.println("����" + booklist.getLength() + "����");
			// ����ÿһ��book�ڵ�
			for (int i = 0; i < booklist.getLength(); i++) {
				System.out.println("=================���濪ʼ������" + (i + 1)
						+ "���������=================");
				// ͨ�� item(i)���� ��ȡһ��book�ڵ㣬nodelist������ֵ��0��ʼ
				Node book = booklist.item(i);
				// ��ȡbook�ڵ���������Լ���
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("�� " + (i + 1) + "���鹲��" + attrs.getLength()
						+ "������");
				// ����book������
				for (int j = 0; j < attrs.getLength(); j++) {
					// ͨ��item(index)������ȡbook�ڵ��ĳһ������
					Node attr = attrs.item(j);
					// ��ȡ������
					System.out.print("������" + attr.getNodeName());
					// ��ȡ����ֵ
					System.out.println("-----����ֵ" + attr.getNodeValue());
				}
				// ����book�ڵ���ӽڵ�
				NodeList childNodes = book.getChildNodes();
				// ����childNodes��ȡÿ���ڵ�Ľڵ����ͽڵ�ֵ
				System.out.println("��" + (i + 1) + "������"
						+ childNodes.getLength() + "���ӽڵ�");
				for (int j = 0; j < childNodes.getLength(); j++) {
					// ���ֳ�text���͵�node�Լ�element���͵�node
					if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("��" + (j + 1) + "���ڵ�Ľڵ�����"
								+ childNodes.item(j).getNodeName());
						//��ȡ��element���ͽڵ�Ľڵ�ֵ
						System.out.println("--�ڵ�ֵ�ǣ�" + childNodes.item(j).getFirstChild().getNodeValue());
						System.out.println("--�ڵ�ֵ��:" + childNodes.item(j).getTextContent());
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DomTest test = new DomTest();
		test.ParsebyDom();
	}

}
