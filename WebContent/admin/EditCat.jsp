<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">

	<div class="module">
		 <h2><span>Sửa Danh Mục</span></h2>
			<%
				Category category = (Category) request.getAttribute("dmtin");
			%>
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/sua-danh-muc?editcat=<%=category.getID_cat() %>" method="post" >
				<p>
					<label>Tên Danh Mục</label>
					<input type="text" name="tendanhmuc" value="<%=category.getTenDM()%>" class="input-medium" />
				</p>
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="Sửa" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập Lại" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/template/admin/inc/footer.jsp" %> 