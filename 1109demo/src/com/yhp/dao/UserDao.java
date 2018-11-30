package com.yhp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yhp.entity.User;
import com.yhp.util.BaseDao;

public class UserDao {
	public boolean login(User user){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=BaseDao.getConnection();
			ps=conn.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs=ps.executeQuery();
			user=new User();
			while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				System.out.println(user);
			}
			if(user!=null){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
