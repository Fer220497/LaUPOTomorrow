/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import WS.UsuarioWS;
import clases.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;

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
        UsuarioWS ur = new UsuarioWS();
        GenericType<Usuario> gt = new GenericType<Usuario>() {
        };
        Usuario u1 = new Usuario(nombre_usuario, password, nombre_real, email, localizacion, "lector");
        Usuario u2 = null;
        //Primero hay que ver si no existe el usuario ya
        try {
            u2 = ur.find_XML(gt, nombre_usuario);
        } catch (javax.ws.rs.NotFoundException E) {
            error = true;
            mensajeError = "No se puede conectar con la DB";
        } catch (javax.ws.rs.BadRequestException E) {
            error = true;
            mensajeError = "Bad Request, contact with webadmin";
        }

        if (u2 != null) {
            error = true;
            mensajeError = "Ese usuario ya existe";
        }

        if (error) {
            
            return ERROR;
            
        } else {

            try {
                ur.create_XML(u1);
            } catch (javax.ws.rs.NotFoundException E) {
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
