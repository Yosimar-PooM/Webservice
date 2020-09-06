<%-- 
    Document   : jspejemplo
    Created on : 20/03/2019, 16:20:43
    Author     : Genesis
--%>

<%@page import="Constructor.imagenes"%>
<%@page import="Constructor.consContacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="<%=request.getContextPath()%>/imagenes?id=1" style="width: 100px;"/>
    </body>
</html>
