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
			<form action="<%=request.getContextPath() %>/admin/them-nguoi-dung" method="post" >
				<p>
					<label>Tên  Người Dùng :</label>
					<input type="text" name="tennguoidung" value="" class="input-medium" />
				</p>
				<p>
					<label>password:</label>
					<input type="password" name="pass" value="" class="input-medium" />
				</p>
				<p>
					<label>fullname:</label>
					<input type="text" name="fullname" value="" class="input-medium" />
				</p>
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="Thêm" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập Lại" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/template/admin/inc/footer.jsp" %> 