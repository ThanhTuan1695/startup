<%@page import="model.bean.Tintuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath()%>/admin/show-addnews" class="button">
			<span>Thêm Tin<img src="<%=request.getContextPath()%>/template/admin/images/plus-small.gif" alt="ThÃªm tin"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>
	<%
	if(request.getParameter("msg")!=null){
		int msg = Integer.parseInt(request.getParameter("msg"));
		if(msg==1){
			out.print("<h3>them thanh cong</h3>");
		} else if(msg ==0 ){
			out.print("<h3>that bai</h3>");
		}else if(msg == 3 ){
			out.print("<h3> thanh cong</h3>");
		}else if(msg == 2 ){
			out.print("<h3> sua thanh cong</h3>");
		}else if(msg == 4 ){
			out.print("<h3>admin bạn không thể xóa </h3>");
		}
	}
	%>
<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách tin</span></h2>
		
		<div class="module-table-body">
			<form action="">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Tên</th>
						<th style="width:20%">Danh mục</th>
						<th style="width:16%; text-align: center;">Hình ảnh</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
				<%
					if(request.getAttribute("list")!=null){
					ArrayList<Tintuc> list  = (ArrayList<Tintuc>) request.getAttribute("list");
					for(Tintuc tintuc :  list){
				
				%>
					<tr>
						<td class="align-center"><%=tintuc.getIdnew() %></td>
						<td><a href=""><%=tintuc.getName() %></a></td>
						<td><%=tintuc.getNamecat()%></td>
						<td align="center"><img src="<%=request.getContextPath()%>/files/<%=tintuc.getPicture() %>" class="hoa" /></td>
						<td align="center">
							<a href="<%=request.getContextPath()%>/admin/show-editnews?nid=<%=tintuc.getIdnew()%>">Sửa <img src="<%=request.getContextPath()%>/template/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath()%>/admin/delnews?nid=<%=tintuc.getIdnew()%>">Xóa <img src="<%=request.getContextPath()%>/template/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
					</tr>
				<%}} %>
				</tbody>
			</table>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 <div class="pagination">           
			<div class="numbers">
				<span>Trang:</span> 
				<a href="">1</a> 
				<span>|</span> 
				<a href="">2</a> 
				<span>|</span> 
				<span class="current">3</span> 
				<span>|</span> 
				<a href="">4</a> 
				<span>|</span> 
				<a href="">5</a> 
				<span>|</span> 
				<a href="">6</a> 
				<span>|</span> 
				<a href="">7</a>
				<span>|</span> 
				<a href="">8</a> 
				<span>|</span> 
				<a href="">9</a>
				<span>|</span> 
				<a href="">10</a>   
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="/template/admin/inc/footer.jsp" %> 