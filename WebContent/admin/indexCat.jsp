<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/admin/show-them-danh-muc" class="button">
			<span>Thêm Danh Mục <img src="<%=request.getContextPath()%>/template/admin/images/plus-small.gif" alt="ThÃªm tin"></span>
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
			out.print("<h3>thanh cong</h3>");
		}else if(msg == 2 ){
			out.print("<h3>thanh cong</h3>");
		}
	}
	%>
<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách danh muc</span></h2>
		
		<div class="module-table-body">
			<form action="">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						
						<th style="width:20%">Danh mục</th>
						
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
				 <%
				  ArrayList<Category> listcat = (ArrayList<Category>) request.getAttribute("listcat");
				 	if(listcat !=null ){
				 	for (Category category:listcat){
				 %>
					<tr>
						<td class="align-center"><%=category.getID_cat() %></td>
						
						<td><a href=""><%=category.getTenDM() %></a></td>
						
						<td align="center">
							<a href="<%=request.getContextPath()%>/admin/Show-sua-danh-muc?cid=<%=category.getID_cat() %>">Sửa <img src="<%=request.getContextPath()%>/template/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath()%>/admin/xoa-danh-muc?cid=<%=category.getID_cat() %>">Xóa <img src="<%=request.getContextPath()%>/template/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
					</tr>
				<%}}  %>
				
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