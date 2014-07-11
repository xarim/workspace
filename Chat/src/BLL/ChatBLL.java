/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BD;
import Entidades.Mensaje;
import Entidades.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Leonel
 */
public class ChatBLL {
    private BD bd;
    
   public ChatBLL(){
       bd = new BD("root","");
   }
   
   public int registrarUsuario(Usuario u){
       for(Usuario user:this.verUsuarios()){
           if(user.getNombre().toUpperCase().equals(u.getNombre().toUpperCase())){
               return -2;
           }
       }
       return bd.registrarUsuario(u);
   }
   
   public int ingresarMensaje(Mensaje m){
       return bd.agregarMensaje(m);
   }
   
   public ArrayList<Usuario> verUsuarios(){
       return bd.verUsuarios();
   }
   
   public ArrayList<Mensaje> verMensajes(){
       return bd.verMensajes();
   }
   
   public Usuario ingresarUser(String nombre,String pass){
       return bd.ingresarBD(nombre, pass);
   }
}
