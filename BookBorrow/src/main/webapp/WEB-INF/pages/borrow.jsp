<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.swu.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>书籍信息发布</title>
<link rel="stylesheet" href="css/publish.css">
	<link rel="stylesheet" href="css/main_borrow.css" />
	<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
</head>
<body>
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
	</div>
	<h1>借阅信息填写</h1>
	<div class="main">
		<div class="goods">
			<ul>
				<c:if test="${not empty borrowMsg}">
					<h2 id="pubh3" style="color: red; position: absolute; left: 520px;"><center>${borrowMsg}</center></h2>
				</c:if>
				<c:if test="${empty borrowMsg}">
					<li><a href=""> <img
							src="upload/${publishMessage.pbook.bookimage}" alt="" width="256"
							height="256" />
							<h3>
								<b>书名：</b>${publishMessage.pbook.bookname}
							</h3>
							<div>
								<p>
									<b>借书时间：</b>
								</p>
								<p>${publishMessage.begin}
									-<br /> ${publishMessage.end}
								</p>
								<br />
								<p>
									<b>作者：</b>${publishMessage.pbook.bookauthor}
								</p>
								<p>
									<b>出版社：</b>${publishMessage.pbook.bookpress}
								</p>
								<p>
									<b>简介：</b>${publishMessage.pbook.bookintoduction}
								</p>
							</div>
					</a></li>
					<li id="info"><a href="#">
							<h3>
								<b>请选择借阅时间：</b>
							</h3>
							<form action="borrowbook" method="get">
								<div>
									<br />

									<p>
										<input type="date" name="begin" />
									</p>
									<p>到</p>
									<p>
										<input type="date" name="end" />
									</p>
									<p>
										<input type="hidden" name="borrowuserid"
											value="${user.userid}" />
									</p>
									<p>
										<input type="hidden" name="publishmessageid" value="${pid}" />
									</p>
								</div>
								<input type="submit" value="立即借阅" />
							</form>
					</a></li>
				</c:if>
			</ul>
		</div>
	</div>


</body>
</html>