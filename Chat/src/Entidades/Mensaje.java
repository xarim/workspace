package Entidades;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonel
 */
public class Mensaje {
    
    private int idMsj;
    private String mensaje;
    private String usuario;

    public Mensaje() {
    }
    
    public Mensaje(String mensaje, String usuario){
        this.mensaje=mensaje;
        this.usuario=usuario;
    }

    public Mensaje(int idMsj, String mensaje, String u) {
        this.idMsj = idMsj;
        this.mensaje = mensaje;
        this.usuario = usuario;
    }

    public int getIdMsj() {
        return idMsj;
    }

    public void setIdMsj(int idMsj) {
        this.idMsj = idMsj;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
}
