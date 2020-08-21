package org.techhub.repository;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.techhub.model.Login;
import org.techhub.model.Register;
@Repository
public class RegistrationRepository {
	Connection con;
	PreparedStatement stmt;

	public RegistrationRepository() {

		com.mysql.jdbc.Driver d;

		try {
			d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean saveRegistration(Register register,MultipartFile photo) {
		// TODO Auto-generated method stub

		try {

			stmt = con.prepareStatement("insert into registration ( name,email,contact,address,photo,username,password) values(?,?,?,?,?,?,?)");
			stmt.setString(1, register.getName());
			stmt.setString(2, register.getEmail());
			stmt.setString(3, register.getContact());
			stmt.setString(4, register.getAddress());
			
			byte[] photoBytes = photo.getBytes();
			
			stmt.setBytes(5, photoBytes);
			stmt.setString(6, register.getUsername());
			stmt.setString(7, register.getPassword());

			int a = stmt.executeUpdate();
			if (a > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public Register getDetails(String username) {
		Register r = new Register();
		try {
			stmt = con.prepareStatement("select * from registration where username=?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setEmail(rs.getString(3));
				r.setContact(rs.getString(4));
				r.setAddress(rs.getString(5));
//				r.setPhoto(rs.getBlob(6));
				r.setUsername(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	public Blob getPhotoById(int id) {
		Blob photo = null;
		try {
			stmt = con.prepareStatement("select * from registration where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				photo = rs.getBlob(6);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return photo;
	}

	public boolean validateUsernameAndPassword(Login login) {
		try {
			stmt = con.prepareStatement("select * from registration where username=? and password=?");
			stmt.setString(1, login.getUsername());
			stmt.setString(2, login.getPassword());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
