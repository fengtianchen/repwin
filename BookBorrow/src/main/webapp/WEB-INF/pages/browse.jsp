<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.swu.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title>浏览书籍</title>
<link rel="stylesheet" href="css/main_browse.css" />
<link rel="stylesheet" href="css/9a6c5b82795d438583db153d0d6a7474.css" />
</head>
<body style="background-color: #fff">
	<script type="text/javascript">
		document.getElementById("search").addEventListener("keyup", function() {
			if (this.value.length > 0) {
				document.getElementById("cls").style.visibility = "visible";
				document.getElementById("cls").onclick = function() {
					document.getElementById("search").value = "";
				}
			} else {
				document.getElementById("cls").style.visibility = "hidden";
			}
		});
	</script>
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
				<a id="first" href="#"
					style="position: absolute; top: 0px; right: 188px; color: blue; text-decoration: none; display: block; line-height: 115px; text-align: right;">${user.username}</a>
				<a id="logouta" href="logout"
					style="position: absolute; color: #999; text-align: right; top: 30px; right: 201px;">退出</a>
			</div>
		</c:if>

	</div>
	<!-- 头部结束 -->
	<!-- banner开始 -->

	<!-- banner结束 -->
	<!-- 主体开始 -->
	<div class="main">
		<div class="course-nav-box">
			<div class="course-nav-hd">
				<span>浏览书籍</span>
			</div>
			<form action="listblurry" method="post">
				<div id="baidu">
					<div class="input">
						<span id="searchlabel">搜索书籍：</span> <input type="text" id="search"
							name="blurrystr" /> <span class="clear" id="cls">X</span>
					</div>
					<input type="submit" name="submit" value="搜索"
						style="width: 100px; height: 35px; background: #3385ff; color: #fff; border: none;" />
				</div>
			</form>
			<div class="course-nav-row clearfix">
				<span class="hd l">类别：</span>
				<div class="bd">
					<ul class="">
						<li class="course-nav-item on"><a href="browse">全部</a></li>
						<li class="course-nav-item
                                ">
							<a href="listbytype?bclass=小说">小说</a>
						</li>
						<li class="course-nav-item
                                ">
							<a href="listbytype?bclass=文学">文学</a>
						</li>
						<li class="course-nav-item
                                ">
							<a href="listbytype?bclass=计算机">计算机</a>
						</li>
						<li class="course-nav-item
                                ">
							<a href="listbytype?bclass=名著">名著</a>
						</li>
						<li class="course-nav-item
                                ">
							<a href="listbytype?bclass=软件">软件</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="course-tool-bar clearfix">
			<div class="tool-left l">
				<a href="" class="sort-item">最新</a> <a href=""
					class="sort-item active">最热</a>
			</div>
			<div class="tool-right r">
				</span> <span class="tool-item tool-pager"> <span class="pager-num">
				</span> <a href="" class="pager-action pager-prev hide-text disabled">上一页</a>
					<a href="" class="pager-action pager-next hide-text">下一页</a>
				</span>
			</div>
		</div>
		<div class="goods">
			<ul>
				<c:forEach var="ps" items="${lists}">
					<li><a href="borrow?pid=${ps.publishmessageid}"> <img
							src="upload/${ps.pbook.bookimage}" alt="" width="256"
							height="256" />
							<h3>
								<b>书名：</b>${ps.pbook.bookname}</h3>
							<div>
								<p>
									<b>借书时间：</b>
								</p>
								<p>${ps.begin}到${ps.end}</p>
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
		<div class="page">
			<a href="booklist?page=1">首页</a>
			<c:if test="${pager.currentPage != 1}">
				<a href="booklist?page=${pager.currentPage-1}">上一页</a>
			</c:if>
			<c:forEach var="no" begin="1" end="${pager.totalPage}">
				<c:if test="${pager.currentPage == no}">
					<a href="booklist?page=${no}" class="active">${no}</a>
				</c:if>
				<c:if test="${pager.currentPage != no}">
					<a href="booklist?page=${no}">${no}</a>
				</c:if>
			</c:forEach>
			<c:if test="${pager.currentPage != pager.totalPage}">
				<a href="booklist?page=${pager.currentPage+1}">下一页</a>
			</c:if>
			<a href="booklist?page=${pager.totalPage}">尾页</a>
		</div>
	</div>
	<!-- 主体结束 -->
</body>
</html>