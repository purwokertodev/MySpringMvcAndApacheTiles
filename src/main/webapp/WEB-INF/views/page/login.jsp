<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/views/layout/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<!-- start: Meta -->
<meta charset="utf-8">
<title>Value Quest Web Mon Admin Login</title>
<meta name="description" content="Bootstrap Metro Dashboard">
<meta name="author" content="Dennis Ji">
<meta name="keyword"
	content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<!-- end: Meta -->

<!-- start: Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- end: Mobile Specific -->

<!-- start: CSS -->
<%@include file="/WEB-INF/views/layout/css_includes.jsp"%>

<!-- end: CSS -->


<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->

<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->

<!-- start: Favicon -->
<link rel="shortcut icon" href="img/favicon.ico">
<!-- end: Favicon -->

<style type="text/css">
body {
	background: url(resources/img/bg-login.jpg) !important;
}
</style>

</head>

<body>
	<div class="container-fluid-full">
		<div class="row-fluid">

			<div class="row-fluid">
				<div class="login-box">
					<div class="icons">
						<a href="?language=en"><i class="">En</i></a> <a href="?language=in_ID"><i
							class="">In</i></a>
					</div>
					<h2><spring:message code="login.title"/></h2>
					<form class="form-horizontal" action="j_spring_security_check"
						method="post">
						<fieldset>

							<div class="input-prepend" title="Username">
								<span class="add-on"><i class="halflings-icon user"></i></span>
								<input class="input-large span10" name="j_username"
									id="username" type="text" placeholder="type username" />
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend" title="Password">
								<span class="add-on"><i class="halflings-icon lock"></i></span>
								<input class="input-large span10" name="j_password"
									id="password" type="password" placeholder="type password" />
							</div>
							<div class="clearfix"></div>

							<label class="remember" for="remember"><input
								type="checkbox" id="remember" /><spring:message code="login.rememberme"/></label>

							<div class="button-login">
								<button type="submit" class="btn btn-primary"><spring:message code="login.button.title"/></button>
							</div>
							<div class="clearfix"></div>
					</form>
					<hr>
					<c:if test="${success eq false }">
						<h3><spring:message code="login.fail.message"/></h3>
					</c:if>
				</div>
				<!--/span-->
			</div>
			<!--/row-->


		</div>
		<!--/.fluid-container-->

	</div>
	<!--/fluid-row-->

	<!-- start: JavaScript-->
	<%@include file="/WEB-INF/views/layout/js_includes.jsp"%>
	<!-- end: JavaScript-->

</body>
</html>
