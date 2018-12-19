<%@ page import="java.text.* ,java.util.*"%>
<%@ page contentType="text/html; charset=utf-8" %>
<div id="header">
					<div id="rightheader">
						<p>
							<% 
								Date date = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							%>
							时间：<%= sdf.format(date) %>
							<br />
						</p>															
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>