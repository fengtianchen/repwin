<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登录注册</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="images/login.js"></script>
<link href="css/login2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function changeImg() {
		var imgSrc = $("#codes");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
	}
	//时间戳   
	//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳   
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		url = url.substring(0, 17);
		if ((url.indexOf("&") >= 0)) {
			url = url + "×tamp=" + timestamp;
		} else {
			url = url + "?timestamp=" + timestamp;
		}
		return url;
	}
</script>
</head>
<body>
	<h1>
		登录注册 <sup></sup>
	</h1>
	<c:if test="${not empty regiserMessage}">
		<center>
			<h2 style="color: red">${regiserMessage}</h2>
		</center>
	</c:if>
	<c:if test="${not empty loginMessage}">
		<center>
			<h2 style="color: red">${loginMessage}</h2>
		</center>
	</c:if>


	<div class="login" style="margin-top: 50px;">
		<div class="header">
			<div class="switch" id="switch">
				<a class="switch_btn_focus" id="switch_qlogin"
					href="javascript:void(0);" tabindex="7">快速登录</a> <a
					class="switch_btn" id="switch_login" href="javascript:void(0);"
					tabindex="8">快速注册</a>
				<div class="switch_bottom" id="switch_bottom"
					style="position: absolute; width: 64px; left: 0px;"></div>
			</div>
		</div>

		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">
			<!--登录-->
			<div class="web_login" id="web_login">
				<div class="login-box">

					<div class="login_form">
						<form action="userlogin" name="loginform" accept-charset="utf-8"
							id="login_form" class="loginForm" method="post">
							<input type="hidden" name="did" value="0" /> <input
								type="hidden" name="to" value="log" />
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="u">帐号：</label>
								<div class="inputOuter" id="uArea">
									<input type="text" id="u" name="username" class="inputstyle" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="p">密码：</label>
								<div class="inputOuter" id="pArea">

									<input type="password" id="p" name="userpass"
										class="inputstyle" />
								</div>
							</div>

							<div style="padding-left: 50px; margin-top: 20px;">
								<input type="submit" value="登 录" style="width: 150px;"
									class="button_blue" />
							</div>
						</form>
					</div>

				</div>

			</div>
			<!--登录end-->
		</div>

		<!--注册-->
		<div class="qlogin" id="qlogin" style="display: none;">

			<div class="web_login">
				<form name="form2" id="regUser" accept-charset="utf-8"
					action="register" method="post">
					<input type="hidden" name="to" value="reg" /> <input type="hidden"
						name="did" value="0" />
					<ul class="reg_form" id="reg-ul">
						<c:if test="${not empty regiterMessage}">
							<div id="userCue" class="cue">${regiterMessage}</div>
						</c:if>
						<c:if test="${empty regiterMessage}">
							<div id="userCue" class="cue">快速注册请注意格式</div>
						</c:if>
						<li><label for="user" class="input-tips2">用户名：</label>
							<div class="inputOuter2">
								<input type="text" id="user" name="username" maxlength="16"
									class="inputstyle2"/>
							</div></li>

						<li><label for="passwd" class="input-tips2">密码：</label>
							<div class="inputOuter2">
								<input type="password" id="passwd" name="userpass"
									maxlength="16" class="inputstyle2" />
							</div></li>
						<li><label for="passwd2" class="input-tips2">确认密码：</label>
							<div class="inputOuter2">
								<input type="password" id="passwd2" name="" maxlength="16"
									class="inputstyle2" />
							</div></li>

						<li><label for="qq" class="input-tips2">电话：</label>
							<div class="inputOuter2">

								<input type="text" id="qq" name="userphone" maxlength="10"
									class="inputstyle2" />
							</div></li>
						<li><label for="code" class="input-tips2">验证码：</label>
							<div class="inputOuter3">
								<img src="code" alt="验证码" id="codes" class="inputstyle2"
									name="code" /> <a style="float: right" href="#"
									onclick="changeImg()">换一张</a>
							</div></li>
						<li><label for="qq" class="input-tips2">验证码：</label>
							<div class="inputOuter2">
								<input type="text" id="qq" name="code" maxlength="10"
									class="inputstyle2" />
							</div></li>

						<li>
							<div class="inputArea">
								<input type="button" id="reg"
									style="margin-top: 10px; margin-left: 85px;"
									class="button_blue" value="同意协议并注册" /> <a href="#"
									class="zcxy" target="_blank">注册协议</a>
							</div>
						</li>
						<div class="cl"></div>
					</ul>
				</form>

			</div>

		</div>
		<!--注册end-->
	</div>
	<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body>
</html>