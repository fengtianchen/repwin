<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.swu.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title>书籍互借网</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<!-- 头部开始 -->
	<div class="top">
		<div class="menu">
			<a class="index" href="index.html"></a> <a class="phone"
				href="index.html">主页</a> <a href="publish.html">借出去</a> <a
				href="browse.html">借进来</a> <a href="">关于</a> <a href="">积分</a> <a
				href="">社区</a> <span></span>
		</div>
		<c:if test="${not empty user}">
			<div class="login">
				<a style="color: blue; text-decoration: none;" href="#">${user.username}</a>
				<a id="logouta" href="logout">退出</a>
			</div>
		</c:if>
		<c:if test="${empty user}">
			<div class="login">
				<a href="login.html">登录</a>
			</div>
		</c:if>
	</div>
	<!-- 头部结束 -->
	<!-- banner开始 -->
	<div class="banner">
		<div class="banner_center"></div>
	</div>
	<!-- banner结束 -->
	<!-- 主体开始 -->
	<div class="main">
		<h2>精品推荐</h2>
		<div class="goods">
			<ul>
				<c:forEach var="ps" items="${lists}" begin="0" end="3">
					<li><a href="borrow?pid=${ps.publishmessageid}"> <img
							src="upload/${ps.pbook.bookimage}" alt="" width="256"
							height="256" />
							<h3>
								<b>书名：</b>${ps.pbook.bookname}</h3>
							<div>
								<p>
									<b>借书时间：</b>
								</p>
								<p>${ps.begin}到 ${ps.end}</p>
								<br />
								<p>
									<b>作者：</b>${ps.pbook.bookauthor}</p>
								<br />
								<p>
									<b>出版社：</b>${ps.pbook.bookpress}</p>
								<br />
								<p>
									<b>简介：</b>${ps.pbook.bookintoduction}</p>
							</div> <span>立即借阅</span>
					</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="more">
			<a href=""></a>
		</div>
	</div>
	<!-- 主体结束 -->
	<!-- 底部开始 -->
	<div class="footer">
		<div class="team"></div>
		<div class="copyright">ICP证：B2-20080101 © 2016
			bookborrow.com版权所有</div>
	</div>
	<!-- 底部结束 -->
</body>
</html>