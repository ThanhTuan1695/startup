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
							Category dm = (Category) request.getAttribute("dm");
						%>
						<h1 class="title">Tin tức >> <%=dm.getTenDM() %></h1>
						<div class="items-new">
							<ul>
								<%
								ArrayList<Tintuc> list = (ArrayList<Tintuc>)request.getAttribute("list");
								for(Tintuc tintuc : list){
								%>
								<li>
									<h2>
										<a href="<%=request.getContextPath() %>/chitiet?idct=<%=tintuc.getIdnew()%>&idcat=<%=tintuc.getIdcat() %>" title=""><%=tintuc.getName() %></a>
									</h2>
									<div class="item">
										<a href="<%=request.getContextPath() %>/chitiet" title=""><img src="images/tmp/h1.jpg" alt="" /></a>
										<p><%=tintuc.getPreview() %></p>
										<div class="clr"></div>
									</div>
								</li>
					<%} %>
							</ul>
							
							<div class="paginator">
								<a href="">Trang 1</a> | 
								<a href="" class="active">Trang 2</a> |
								<a href="">Trang 3</a> |
								<a href="">Trang 4</a>
							</div>
						</div>
					</div>
				</div>
				<div class="clr"></div>
<%@include file="/template/public/inc/footer.jsp" %>  	