<%-- 
    Document   : registrar
    Created on : 06-05-2012, 12:41:14 AM
    Author     : Leonel
--%>


<%@page import="BLL.ChatBLL"%>
<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <% String nombre = request.getParameter("nombre");
            String pass = request.getParameter("password");
            Usuario u = new Usuario(nombre,pass);
            int res = new ChatBLL().registrarUsuario(u);
            if(res == -2){
                out.println("<span style='color:red; font-size:14px;'>El Usuario con ese nombre ya existe.</span>");
            }
                       else if(res == -1){
                           out.println("<span style='color:red; font-size:14px;'>Error en la base de datos.</span>");
                       }
                       else{
                            out.println("<span style='color:blue; font-size:14px;'>Usuario ingresado éxitosamente.</span>");
                       }
            
        %>
    </body>
</html>
