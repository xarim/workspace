<%-- 
    Document   : verUsers
    Created on : 09-05-2012, 09:08:48 PM
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
                String img = "<img src=\"img/on.png\" />";
                if(!Sesiones.usuarios.isEmpty()){
                    for(String s:Sesiones.usuarios){
                        out.println(img+" <b>"+s+"</b><br>");
                    }
                }
                               else{
                    out.println("<b>No hay usuarios conectados.</b>");
                               }
                %>
    </body>
</html>
