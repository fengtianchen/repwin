<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.swu.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>书籍信息发布</title>
<style type="text/css">
input {
	vertical-align: middle;
	margin: 0;
	padding: 0
}

.file-box {
	position: relative;
	width: 340px
}

.txt {
	height: 22px;
	border: 1px solid #cdcdcd;
	width: 180px;
}

.btn {
	background-color: #FFF;
	border: 1px solid #CDCDCD;
	height: 24px;
	width: 70px;
}

.file {
	position: absolute;
	top: 0;
	right: 80px;
	height: 24px;
	filter: alpha(opacity : 0);
	opacity: 0;
	width: 260px
}
</style>
<link rel="stylesheet" href="css/publish.css">
	<link rel="stylesheet" href="css/main.css" />
	<script type="text/javascript" src="jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("input[type=file]").change(
					function() {
						$(this).parents(".uploader").find(".filename").val(
								$(this).val());
					});
			$("input[type=file]").each(
					function() {
						if ($(this).val() == "") {
							$(this).parents(".uploader").find(".filename").val(
									"请选择文件...");
						}
					});

		});
	</script>
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
	<h1 id="pubh1">书籍信息发布</h1>
	<h3 id="pubh3" style="color: red">${publishMsg}</h3>
	<div class="demo">
		<form id="thisForm" method="post" action="publishbook"
			enctype="multipart/form-data">
			<table width="100%">
				<tr>
					<td class="tdcon">书籍名：</td>
					<td><input class="stext" type='text' name="bookname"
						id="userName" value="" />
						<div class="tipinfo"></div></td>
				</tr>
				<tr>
					<td class="tdcon">作者</td>
					<td><input class="stext" type="text" name="bookauthor"
						id="passWord" value="" />
						<div class="tipinfo"></div></td>
				</tr>
				<tr>
					<td class="tdcon">类别</td>
					<td><input class="stext" type="text" name="bclass"
						id="passWord" value="" />
						<div class="tipinfo"></div></td>
				</tr>
				<tr>
					<td class="tdcon">出版社：</td>
					<td><input class="stext" type='text' name="bookpress"
						id="corpName" value="" />
						<div class="tipinfo"></div></td>
				</tr>
				<tr>
					<td class="tdcon">简介：</td>
					<td><input class="stext" type='text' name="bookintoduction"
						id="corpName" value="" />
						<div class="tipinfo"></div></td>
				</tr>
				<tr>
					<td class="tdcon">开始：</td>
					<td><input class="stext" type='date' name="begin" id="sms"
						value="" />
						<div class="tipinfo"></div></td>
				</tr>
				<tr>
					<td class="tdcon">结束：</td>
					<td><input class="stext" type="date" name="end" id="email"
						value="" />
						<div class="tipinfo"></div></td>
				</tr>


				<tr>
					<td class="tdcon">上传图片：</td>
					<td><input class="stext" type="file" name="image" id="email"
						value="请选择书籍图片。。" />
						<div class="tipinfo"></div></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button name="Submit" type="submit"
							class="Button BlueButton Button18">发 布</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>