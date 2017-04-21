package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectMySQLLibrary;
import model.bean.Tintuc;

public class NewDao {
	private Connection conn;
	private ConnectMySQLLibrary connectMySQLLibrary;
	private String table;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;

	public NewDao() {
		this.table = "news";
		this.connectMySQLLibrary = new ConnectMySQLLibrary();
	}

	public ArrayList<Tintuc> getTin() {
		ArrayList<Tintuc> list = new ArrayList<Tintuc>();
		conn = connectMySQLLibrary.getConnectMySQL();
		String sql = "SELECT * FROM " + table;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Tintuc tin = new Tintuc(rs.getInt("id_news"),
						rs.getInt("id_cat"), rs.getString("name"),
						rs.getString("preview_text"));
				list.add(tin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	public ArrayList<Tintuc> getitemTin(int idcat) {
		ArrayList<Tintuc> list = new ArrayList<Tintuc>();
		conn = connectMySQLLibrary.getConnectMySQL();
		String sql = "SELECT * FROM " + table + " WHERE id_cat = ? ";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idcat);
			rs = pst.executeQuery();
			while (rs.next()) {
				Tintuc tin = new Tintuc(rs.getInt("id_news"),
						rs.getInt("id_cat"), rs.getString("name"),
						rs.getString("preview_text"));
				list.add(tin);
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
		if (list.size() > 0) {
			return list;
		}

		return null;

	}

	public Tintuc getitemchitiet(int did) {
		Tintuc tin = null;
		String sql = "SELECT * , category.name AS namecat, news.name AS namenews FROM "+ table +" INNER JOIN category ON category.id_cat = "+table+".id_cat "+ " WHERE id_news = ?";
		conn = connectMySQLLibrary.getConnectMySQL();

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, did);
			rs = pst.executeQuery();
			if (rs.next()) {
				tin = new Tintuc(rs.getInt("id_news"),
						rs.getInt("id_cat"), rs.getString("namenews"),
						rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("namecat"),rs.getString("picture"));
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
		return tin;
	}

	public ArrayList<Tintuc> getitemnews() {
		ArrayList<Tintuc> list = new ArrayList<Tintuc>();
		String sql = "SELECT * , category.name AS namecat," + table
				+ ".name AS namenew FROM " + table
				+ " INNER JOIN category ON category.id_cat = " + table
				+ ".id_cat ORDER BY id_news DESC ";
		conn = connectMySQLLibrary.getConnectMySQL();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Tintuc tintuc = new Tintuc(rs.getInt("id_news"),
						rs.getInt("id_cat"), rs.getString("namenew"),
						rs.getString("preview_text"),
						rs.getString("detail_text"), rs.getString("namecat"),rs.getString("picture"));
				list.add(tintuc);
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
		if (list.size()> 0 ) {
			return list;
		}
		return null;
	}

	public int addNews(Tintuc tintuc) {
		int result = 0 ;
		
		conn = connectMySQLLibrary.getConnectMySQL();
		String sql = "INSERT INTO "+  table +"(name,preview_text,detail_text,id_cat,picture) VAlUE(?,?,?,?,?)";
		try {
			pst =conn.prepareStatement(sql);
			pst.setString(1, tintuc.getName());
			pst.setString(2, tintuc.getPreview());
			pst.setString(3, tintuc.getChitiet());
			pst.setInt(4, tintuc.getIdcat());
			pst.setString(5, tintuc.getPicture());
			result=pst.executeUpdate();
			//result = 1;
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

	public int edititem(Tintuc tin) {
		int result = 0;
		conn = connectMySQLLibrary.getConnectMySQL();
		String sql = "UPDATE "+  table +" SET name = ?,preview_text =?,detail_text = ?,picture = ?, id_cat =? WHERE id_news  = ?";
		try {
			pst =conn.prepareStatement(sql);
			pst.setString(1, tin.getName());
			pst.setString(2, tin.getPreview());
			pst.setString(3, tin.getChitiet());
			pst.setString(4, tin.getPicture());
			pst.setInt(5, tin.getIdcat());
			pst.setInt(6, tin.getIdnew());
			
			result=pst.executeUpdate();
			//result = 1;
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

	
	public int delitem(int idnews) {
		int rs = 0;
		conn = connectMySQLLibrary.getConnectMySQL();
		String sql = "DELETE FROM "+ table+ " WHERE id_news = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idnews);
			rs = pst.executeUpdate();
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
		return rs;
	}
	
}
