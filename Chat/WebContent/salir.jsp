<%-- 
    Document   : Salir
    Created on : 06-05-2012, 12:23:27 AM
    Author     : Leonel
--%>


<%@page import="Sesion.Sesiones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <%
        String s = request.getSession().getAttribute("userId").toString();
        if(!s.equals("Invitado"))
        Sesiones.eliminarUser(s);
request.getSession().setAttribute("userId", "Invitado");
out.println("<meta http-equiv='Refresh' content='0;url=index.jsp'>");
%>
    </body>
</html>
