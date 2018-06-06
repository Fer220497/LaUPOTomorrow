/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
import webservices.FachadaUsuario;
import wsusuario.Usuario;

/**
 *
 * @author Juanma
 */
public class Registro extends ActionSupport {

    String nombre_usuario;
    String password;
    String email;
    String nombre_real;
    String localizacion;
    String mensajeError;

    public Registro() {

    }

    public String execute() throws Exception {
        boolean error = false;
        Usuario u1 = new Usuario();
        u1.setNombreUsuario(nombre_usuario);
        u1.setPassword(password);
        u1.setNombreReal(nombre_real);
        u1.setEmail(email);
        u1.setLocalizacion(localizacion);
        u1.setRol("lector");
        Usuario u2 = null;
        //Primero hay que ver si no existe el usuario ya
        try{
            u2 = FachadaUsuario.readUsuario(nombre_usuario);
        }catch(com.sun.xml.ws.fault.ServerSOAPFaultException E){
            error = true;
            mensajeError = "No se puede conectar con la DB";
        }

        if (u2 != null) {
            error = true;
            mensajeError = "Ese usuario ya existe";
        }

        if (error) {
            
            return ERROR;
            
        } else {

            try {
                FachadaUsuario.addUsuario(u1);
            } catch (com.sun.xml.ws.fault.ServerSOAPFaultException E) {
                error = true;
                mensajeError = "No se puede conectar con la DB";
            } catch (javax.ws.rs.BadRequestException E) {
                error = true;
                mensajeError = "No puede dejar los campos en blanco";
            }
            
            if(!error){
                return SUCCESS;
            }else{
                return ERROR;
            }

        }

    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre_real() {
        return nombre_real;
    }

    public void setNombre_real(String nombre_real) {
        this.nombre_real = nombre_real;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
   

}
