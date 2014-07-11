<%-- 
    Document   : login
    Created on : 06-05-2012, 12:10:26 AM
    Author     : Leonel
--%>


<%@page import="Entidades.Usuario"%>
<%@page import="BLL.ChatBLL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <%
            String nombre = request.getParameter("nombre");
            String pass = request.getParameter("password");
            try{
                Usuario u = new ChatBLL().ingresarUser(nombre, pass);
                if(!u.getNombre().equals(null)){
                out.println("<span style='color:blue; font-size:14px;'>Ingreso con éxito, regresarás en 3 segundos.</span>");
                request.getSession().setAttribute("userId", u.getNombre());
                out.println("<script type='text/javascript'>setInterval(function(){window.location='index.jsp'},3000);</script>");
         
                               }
                               else{
                               
                                out.println("<span style='color:red; font-size:14px;'>El Usuario ingresado no existe.</span>");
                               }
            }
            catch(NullPointerException e){
                out.println("<span style='color:red; font-size:14px;'>Usuario no válido.</span>");
            }   
            
                                  
        %>
    </body>
</html>
