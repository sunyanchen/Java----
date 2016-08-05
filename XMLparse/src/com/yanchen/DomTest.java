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
		// 创建一个DocumentBuilderFactory对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// 创建一个documentbuilder对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
			Document document = db.parse("books.xml");
			// 获取所有book节点的集合
			NodeList booklist = document.getElementsByTagName("book");
			System.out.println("共有" + booklist.getLength() + "本书");
			// 遍历每一个book节点
			for (int i = 0; i < booklist.getLength(); i++) {
				System.out.println("=================下面开始遍历第" + (i + 1)
						+ "本书的内容=================");
				// 通过 item(i)方法 获取一个book节点，nodelist的索引值从0开始
				Node book = booklist.item(i);
				// 获取book节点的所有属性集合
				NamedNodeMap attrs = book.getAttributes();
				System.out.println("第 " + (i + 1) + "本书共有" + attrs.getLength()
						+ "个属性");
				// 遍历book的属性
				for (int j = 0; j < attrs.getLength(); j++) {
					// 通过item(index)方法获取book节点的某一个属性
					Node attr = attrs.item(j);
					// 获取属性名
					System.out.print("属性名" + attr.getNodeName());
					// 获取属性值
					System.out.println("-----属性值" + attr.getNodeValue());
				}
				// 解析book节点的子节点
				NodeList childNodes = book.getChildNodes();
				// 遍历childNodes获取每个节点的节点名和节点值
				System.out.println("第" + (i + 1) + "本书有"
						+ childNodes.getLength() + "个子节点");
				for (int j = 0; j < childNodes.getLength(); j++) {
					// 区分出text类型的node以及element类型的node
					if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("第" + (j + 1) + "个节点的节点名："
								+ childNodes.item(j).getNodeName());
						//获取了element类型节点的节点值
						System.out.println("--节点值是：" + childNodes.item(j).getFirstChild().getNodeValue());
						System.out.println("--节点值是:" + childNodes.item(j).getTextContent());
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
