<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="<c:url value='/css/main.css/'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap-theme.css'/>"/>


</head>
<body bgcolor="#c0c0c0">
<div class="wrapper container">
    <tiles:insertAttribute name="header"/>
    <div class="container" id="white_main">
        <tiles:insertAttribute name="nav"/>
        <tiles:insertAttribute name="body"/>
        <tiles:insertAttribute name="footer"/>
    </div>
</div>

<script src="<c:url value='/js/jquery-2.1.1.js'/>"></script>
<script src="<c:url value='/js/bootstrap.js'/>"></script>

</body>
</html>