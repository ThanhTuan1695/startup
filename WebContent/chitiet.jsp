<%@page import="model.bean.Tintuc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/template/public/inc/header.jsp" %>
<div class="leftpanel">
	<%@include file="/template/public/inc/left_bar.jsp" %>  
</div>
<div class="rightpanel">
	<div class="rightbody">
		<% 
			Tintuc tin = (Tintuc) request.getAttribute("chitiet");
		%>
		<h1 class="title"><%=tin.getName() %></h1>
		<div class="items-new">
			<div class="new-detail">
				<p><%=tin.getChitiet() %></p>
				
			</div>
		</div>
		
		<h2 class="title" style="margin-top:30px;color:#BBB">Tin tức liên quan</h2>
		<div class="items-new">
			<ul>
			<%
				ArrayList<Tintuc> list = (ArrayList<Tintuc>) request.getAttribute("list");
				for(Tintuc tintuc : list){
					
				if(tintuc.getIdnew() != tin.getIdnew()){
			%>
				<li>
					<h2>
						<a href="<%=request.getContextPath() %>/chitiet?idct=<%=tintuc.getIdnew()%>&idcat=<%=tintuc.getIdcat() %>" title="Trung Quốc điều thêm 17 tàu đến khu vực giàn khoan"><%=tintuc.getName() %></a>
					</h2>
					<div class="item">
						<a href="<%=request.getContextPath() %>/chitiet?idct=<%=tintuc.getIdnew()%>&idcat=<%=tintuc.getIdcat() %>" title="Trung Quốc điều thêm 17 tàu đến khu vực giàn khoan"><img src="<%=request.getContextPath() %>/template/public/images/tmp/h1.jpg" alt="Trung Quốc điều thêm 17 tàu đến khu vực giàn khoan"></a>
						<p><%=tintuc.getPreview() %></p>
						<div class="clr"></div>
					</div>
				</li>
				<%}} %>
			</ul>
		</div>
	</div>
</div>
<div class="clr"></div>
<%@include file="/template/public/inc/footer.jsp" %>  