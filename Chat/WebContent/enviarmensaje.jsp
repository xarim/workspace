<%-- 
    Document   : enviarmensaje
    Created on : 06-05-2012, 02:20:03 AM
    Author     : Leonel
--%>

<%@page import="BLL.ChatBLL"%>
<%@page import="Entidades.Mensaje"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <% 
        
        String mensaje = request.getParameter("mensaje");
        String user = request.getSession().getAttribute("userId").toString();
        
        Mensaje m = new Mensaje(mensaje,user);
        
        int res = new ChatBLL().ingresarMensaje(m);
        if(res==-1){
            out.println("Error al ingresar mensaje");
        }

%>
    </body>
</html>
