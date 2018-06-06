/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import webservices.FachadaUsuario;
import wsusuario.Usuario;

/**
 *
 * @author Juanma
 */
public class Login extends ActionSupport {
    
    String usuario;
    String password;
    String mensajeError;
    
    public Login() {
    }
    
    public String execute() throws Exception {
        boolean error = false;
        Usuario u = null;
        try{
            u = FachadaUsuario.readUsuario(usuario);
        }catch(com.sun.xml.ws.fault.ServerSOAPFaultException E){
            error = true;
            mensajeError = "No se puede conectar con la DB";
        }
        
        if(!error && u == null){
            error = true;
            mensajeError = "El usuario no existe";
        }
        
        if (error) {
            return ERROR;
        } else {
            if (password.equals(u.getPassword())) {
                return SUCCESS;
            } else {
                mensajeError = "La contraseña no coincide";
                return ERROR;
            }
        }

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
    
    
    
}
