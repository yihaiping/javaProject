package com.yhp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	public static Connection getConnection(){
		Connection conn=null;
		String url="jdbc:mysql://127.0.0.1:3306/yhp?useUnicode=true&characterEncoding=UTF-8";
		String username="root";
		String password="604022";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,username,password);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
