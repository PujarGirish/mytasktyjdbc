package com.ty.userapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ty.userapp.dto.User;

import connectionpool.Connectionpol;

public class UserDao {

	static Connection con;
	static {
		con = Connectionpol.getConnectionObject();
	}

	public void Saveuser(User user) {

		try {
			PreparedStatement pstm = con.prepareStatement("INSERT INTO detauls_of_users VALUES(?,?,?,?)");

			pstm.setInt(1, user.getId());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, user.getPassword());

			pstm.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fetchallusersdata() {
		String sql = "Select * from detauls_of_users";
		try {
			Statement stm = con.createStatement();

			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String emial = rs.getString(3);
				String password = rs.getString(4);
				System.out.println("user id is " + id);
				System.out.println("user name is " + name);
				System.out.println("user email id  is " + emial);
				System.out.println("user password is " + password);
				System.out.println("===================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void FindByUserFindByEmail(String email, String password) {
		String sql = "select * from detauls_of_users where email=? and password=? ";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, password);

			ResultSet resultSet = pstm.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String emial = resultSet.getString(3);
				String userPassword = resultSet.getString(4);
				System.out.println("user id is " + id);
				System.out.println("user name is " + name);
				System.out.println("user email id  is " + emial);
				System.out.println("user password is " + userPassword);
				System.out.println("===================================");
			} else {
				System.err.println("User Not Found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
