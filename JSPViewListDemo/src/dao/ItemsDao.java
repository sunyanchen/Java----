package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import util.DBHelper;
import entity.Items;

public class ItemsDao {
	
	//获得所有商品信息
	public ArrayList<Items> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> listItems = new ArrayList<>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setPrice(rs.getInt("price"));
				item.setNumber(rs.getInt("number"));
				item.setPicture(rs.getString("picture"));
				listItems.add(item);
			}
			return listItems;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//根据商品id获得商品信息
	public Items getItemById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items where id=?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setPrice(rs.getInt("price"));
				item.setNumber(rs.getInt("number"));
				item.setPicture(rs.getString("picture"));
				return item;
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//获取最近浏览的前五条商品信息
	public ArrayList<Items> getViewList(String list) {
		System.out.println("list" + list);
		ArrayList<Items> itemList = new ArrayList<Items>();
		int iCount = 5;
		if (list != null && list.length()>0) {
			String[] arr = list.split(",");
			System.out.println("listlength" + list.length());
			if (list.length()>5) {
				for (int i = list.length()-1; i<list.length()-iCount; i--) {
					itemList.add(getItemById(Integer.parseInt(arr[i])));
				}
			}
			else {
				for (int i =list.length()-1 ;i >= 0; i--) {
					itemList.add(getItemById(Integer.parseInt(arr[i])));
				}
			}
			return itemList;
		}
		else {
			return null;
		}
	}
}
