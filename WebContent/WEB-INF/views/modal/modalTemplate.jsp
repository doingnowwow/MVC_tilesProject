<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title"/></title>
</head>

<body>
<div id="wrapper">
	<div id="page-wrapper">
		<div class="page-content">
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</div>
	</div>
</div>
</body>
</html>