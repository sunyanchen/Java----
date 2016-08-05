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
		// 解析books.xml文件
		// 创建SAXReader的对象reader
		SAXReader saxReader = new SAXReader();
		// 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
		try {
			Document document = saxReader.read(new File("books.xml"));
			// 通过document对象获取根节点bookstore
			Element element = document.getRootElement();
			// 通过element对象的elementIterator方法获取迭代器
			Iterator it = element.elementIterator();
			// 遍历迭代器，获取根节点中的信息（书籍）
			while (it.hasNext()) {
				System.out.println("=====开始遍历某一本书=====");
				Element book = (Element) it.next();
				// 获取book的属性名以及 属性值
				List<Attribute> bookAttrs = book.attributes();
				for (Attribute attr : bookAttrs) {
					System.out.println("属性名：" + attr.getName() + "--属性值："
							+ attr.getValue());
				}
				Iterator itt = book.elementIterator();
				while(itt.hasNext()){
					Element bookChild = (Element)itt.next();
					System.out.println("节点名：" + bookChild.getName() + "--节点值：" + bookChild.getStringValue());
				}
				System.out.println("=====结束遍历某一本书=====");
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
