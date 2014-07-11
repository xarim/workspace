/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entidades.Mensaje;
import Entidades.Usuario;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Leonel
 */
public class BD {
    
    Conectar c;

    public BD(String user, String pw) {
        c= new Conectar("chat",user,pw);
    }
    
    public int registrarUsuario(Usuario u){
        try{
            PreparedStatement ps = c.crearQuery("insert into usuarios values(?,?)");
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getPassword());
            return ps.executeUpdate();
        }
        catch(SQLException e){
            return -1;
        }
    }
    
    public ArrayList<Usuario> verUsuarios(){
        try{
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        PreparedStatement ps = c.crearQuery("select * from usuarios");
        ResultSet r = ps.executeQuery();
        while(r.next()){
            Usuario u = new Usuario();
            u.setNombre(r.getString(1));
            u.setPassword(r.getString(2));
            usuarios.add(u);
        }
        return usuarios;
        }catch(SQLException e){
            return null;
        }
        
        
    }
    
    public int agregarMensaje(Mensaje m){
        try{
            PreparedStatement ps = c.crearQuery("insert into mensajes(nickUser,mensaje) values(?,?)");
            ps.setString(1, m.getUsuario());
            ps.setString(2, m.getMensaje());
            return ps.executeUpdate();
        }
        catch(SQLException e){
            return -1;
        }
    }
    
    public ArrayList<Mensaje> verMensajes(){
        try{
        ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
        PreparedStatement ps = c.crearQuery("select * from mensajes");
        ResultSet r = ps.executeQuery();
        while(r.next()){
            Mensaje m = new Mensaje();
            m.setIdMsj(r.getInt(1));
            m.setUsuario(r.getString(2));
            m.setMensaje(r.getString(3));
            mensajes.add(m);
        }
        return mensajes;
        }
        catch(SQLException e){
            return null;
        }
        
    }
    
    public Usuario ingresarBD(String nombre, String pass){
        try{
            Usuario u = new Usuario();
            PreparedStatement ps = c.crearQuery("select * from usuarios where nickUser=? AND password=?");
            ps.setString(1, nombre);
            ps.setString(2, pass);
            ResultSet r = ps.executeQuery();
            while(r.next()){
            u.setNombre(r.getString(1));
            u.setPassword(r.getString(2));           
            }
            
            return u;
        }
        catch(NullPointerException ex){
            return null;
        }
        catch(SQLException e){
            return null;
        }
        
    }
    
    
    
}
