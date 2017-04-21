<%@page import="model.bean.Tintuc"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
<%
		if(request.getParameter("msg")!=null){
		int msg = Integer.parseInt(request.getParameter("msg"));
		if(msg==2){
			out.print("<h3>xóa thành công</h3>");
		} else if(msg==0){
			out.print("<h3>xóa thất bại</h3>");
		} else if(msg==5){
			out.print("<h3>xóa thành công</h3>");
		
		}
			}
		
	%>
	<div class="module">
		 <h2><span>Thêm tin tức</span></h2>
			<%
				if(request.getAttribute("tin")!=null){
					Tintuc tin = (Tintuc) request.getAttribute("tin");
				
			%>
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/editnews?nid=<%=tin.getIdnew() %>" enctype="multipart/form-data" method="post">
				<p>
					<label>Tên tin</label>
					<input type="text" name="tentin" value="<%=tin.getName() %>" class="input-medium" />
				</p>
				<p>
					<label>Danh mục tin</label>
					
					<select  name="danhmuc" class="input-short">
					<%	
						String selected = "";
						ArrayList<Category> list  = (ArrayList<Category>) request.getAttribute("listcat");
						for(Category category : list){
							if(tin.getIdcat() == category.getID_cat()){
								selected ="selected ='selected'";
							}else{
								selected = "";
							}
					%>
						<option <%=selected %> value="<%=category.getID_cat()%>"><%=category.getTenDM() %></option>
					<%} %>
					</select>
					
				</p>
				<p>
					<label>Hình ảnh</label>
					<input type="file"  name="hinhanh" value="" />
					<a href= "<%=request.getContextPath()%>/admin/xoaanh?nid=<%=tin.getIdnew()%>"><img style="width: 150px; height: 100px;" src="<%=request.getContextPath()%>/files/<%=tin.getPicture()%>">xóa</a>
				</p>
				<p>
					<label>Mô tả</label>
					<textarea name="mota" rows="7" cols="90" class="input-medium"><%=tin.getPreview() %></textarea>
				</p>
				<p>
					<label>Chi tiết</label>
					<textarea  name="chitiet"  rows="7" cols="90" class="input-long"><%=tin.getChitiet() %></textarea>
				</p>
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="submit" /> 
					<input class="submit-gray" name="reset" type="reset" value="reset" />
				</fieldset>
			</form>
			<%}%>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/template/admin/inc/footer.jsp" %> 