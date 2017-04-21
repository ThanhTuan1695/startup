<%@page import="model.bean.User"%>
<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">

	<div class="module">
		 <h2><span>Thêm Người Dùng</span></h2>
	<%
			if(request.getParameter("msg")!=null){
		int msg = Integer.parseInt(request.getParameter("msg"));
		if(msg==4){
			out.print("<h3>tên đã có bạn hãy nhập lại tên khác</h3>");
		} 
		}
	%>
		 <div class="module-body">
		 	<%
		 		if (request.getAttribute("users")!=null){
		 			User user1 = (User) request.getAttribute("users");
		 	%>
			<form action="<%=request.getContextPath() %>/admin/edituser?uid=<%=user1.getId_user() %>" method="post" >
				<p>
					<label>Tên  Người Dùng :</label>
					<input type="text" name="tennguoidung" value="<%=user1.getUsername()%>" class="input-medium"  disabled="disabled"/>
				</p>
				<p>
					<label>password:</label>
					<input type="password" name="pass" value="" class="input-medium" />
				</p>
				<p>
					<label>fullname:</label>
					<input type="text" name="fullname" value="<%=user1.getFullname() %>" class="input-medium" />
				</p>
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="sửa" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập Lại" />
				</fieldset>
			</form>
			<%} %>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/template/admin/inc/footer.jsp" %> 