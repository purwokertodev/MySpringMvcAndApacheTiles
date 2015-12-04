<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="/WEB-INF/views/layout/includes.jsp" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- start: Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- end: Mobile Specific -->
<!-- Css Include -->
<%@include file="/WEB-INF/views/layout/css_includes.jsp" %>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container-fluid-full">
		<div class="row-fluid">
			<tiles:insertAttribute name="main_menu" />
			<tiles:insertAttribute name="body" />
		</div>
	</div>
		<div class="clearfix"></div>
	<tiles:insertAttribute name="footer" />
	<%@include file="/WEB-INF/views/layout/js_includes.jsp" %>
</body>
</html>