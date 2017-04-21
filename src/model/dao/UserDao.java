package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectMySQLLibrary;
import model.bean.User;

public class UserDao {
	private ConnectMySQLLibrary connectMySQLLibrary;
	private Connection connection;
	private String table;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public UserDao(){
		this.table = "users";
		this.connectMySQLLibrary = new ConnectMySQLLibrary();
	}

	public ArrayList<User> getitemuser() {
		ArrayList<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM "+ table+ " ORDER BY id_user DESC";
		connection = connectMySQLLibrary.getConnectMySQL();
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				User user = new User(resultSet.getInt("id_user"), resultSet.getString("username"), resultSet.getString("fullname"));
				list.add(user);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (list.size() >0) {
			return list;
		}
		return null;
	}

	public int adduser(User user) {
		int result = 0 ;
		String sql = "INSERT INTO "+ table + "(username,password,fullname) VALUE(?,?,?)";
		connection = connectMySQLLibrary.getConnectMySQL();
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFullname());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public User Checkuser(String ten) {
		User user = null;
		String sql = "SELECT *  FROM "+ table + " WHERE username = ?";
		connection = connectMySQLLibrary.getConnectMySQL();
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ten);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getInt("id_user"), resultSet.getString("username"), resultSet.getString("fullname"),resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}

	public int deleteuser(int iduser) {
		int result = 0 ;
		String sql = "DELETE FROM "+ table + " WHERE id_user = ?  LIMIT 1";
		connection = connectMySQLLibrary.getConnectMySQL();
		
		try {
			preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, iduser);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public User getitemuser(int iduser) {

		User user = null;
		String sql = "SELECT * FROM "+ table + " WHERE id_user = ?";
connection = connectMySQLLibrary.getConnectMySQL();
		
		try {
			preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, iduser);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getInt("id_user"), resultSet.getString("username"), resultSet.getString("fullname"),resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public int edituser(User user) {
		int result = 0;
		String sql =  "UPDATE "+ table + " SET password = ?, fullname = ?  WHERE id_user = ? ";
		
		connection = connectMySQLLibrary.getConnectMySQL();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getFullname());
			preparedStatement.setInt(3, user.getId_user());
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
}
