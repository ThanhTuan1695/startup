<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Danh mục tin</h2>
<ul>
	<%
	CategoryDAO categoryDAO = new CategoryDAO();
	
	ArrayList<Category> listdm = categoryDAO.getItems();
	
		for(Category category :listdm){
	%>
	<li><a href="<%=request.getContextPath()%>/danhmuctintuc?dmid=<%=category.getID_cat()%>"><%=category.getTenDM() %></a></li>
	<%} %>
</ul>
