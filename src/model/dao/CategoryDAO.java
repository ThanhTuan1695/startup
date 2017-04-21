package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectMySQLLibrary;
import model.bean.Category;
import model.bean.Tintuc;

public class CategoryDAO {
	private Connection conn;
	private ConnectMySQLLibrary connectMySQLLibrary;
	private String table;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public CategoryDAO(){
		this.table = "category";
		this.connectMySQLLibrary = new ConnectMySQLLibrary();
	}
	
	public ArrayList<Category> getItems(){
		ArrayList<Category> list = new ArrayList<Category>();
		String sql ="SELECT * FROM "+ table + " ORDER BY id_cat DESC";
		conn = connectMySQLLibrary.getConnectMySQL();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				Category cat = new Category(rs.getInt("id_cat"), rs.getString("name"));
				list.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (list.size() > 0) {
			return list;
		}
		return null;
		
	}

	public int additem(Category category) {
		int result = 0 ;
		conn = connectMySQLLibrary.getConnectMySQL();
		String sql = "INSERT INTO "+ table + "(name) VALUE (?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, category.getTenDM());
			 result= pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}

	public int deleteitem(int idcat) {
		int result = 0 ;
		conn = connectMySQLLibrary.getConnectMySQL();
		String sql = "DELETE FROM "+ table + " WHERE id_cat = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idcat);
		  result =	pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public Category getdmtin(int idcat) {
		
		Category category = null;
		String sql = "SELECT * FROM " + table + " WHERE id_cat = ? ";
		conn = connectMySQLLibrary.getConnectMySQL();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idcat);
			rs = pst.executeQuery();
			if (rs.next()) {
				category = new Category(rs.getInt("id_cat"), rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return category;
	}

	public int edititem(int editcat, String tendanhmuc) {
		int result = 0;
		conn = connectMySQLLibrary.getConnectMySQL();
		String sql  = "UPDATE " + table+ " SET name = ? WHERE id_cat = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, tendanhmuc);
			pst.setInt(2, editcat);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Category getitemdm(int idcat) {
		Category category = null;
		conn = connectMySQLLibrary.getConnectMySQL();
		String sql = "SELECT * FROM "+ table + " WHERE id_cat = ? ";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idcat);
			rs = pst.executeQuery();
			if(rs.next()){
				category = new Category(rs.getInt("id_cat"), rs.getString("name"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return category;
	}

	
}
