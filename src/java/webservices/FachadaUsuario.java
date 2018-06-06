/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import wsusuario.Usuario;

/**
 *
 * @author Juanma
 */
public class FachadaUsuario {

    public static void addUsuario(wsusuario.Usuario arg0) {
        wsusuario.WsUsuario_Service service = new wsusuario.WsUsuario_Service();
        wsusuario.WsUsuario port = service.getWsUsuarioPort();
        port.addUsuario(arg0);
    }

    public static void deleteUsuario(wsusuario.Usuario arg0) {
        wsusuario.WsUsuario_Service service = new wsusuario.WsUsuario_Service();
        wsusuario.WsUsuario port = service.getWsUsuarioPort();
        port.deleteUsuario(arg0);
    }

    public static java.util.List<wsusuario.Usuario> listUsuario() {
        wsusuario.WsUsuario_Service service = new wsusuario.WsUsuario_Service();
        wsusuario.WsUsuario port = service.getWsUsuarioPort();
        return port.listUsuario();
    }

    public static Usuario readUsuario(java.lang.String arg0) {
        wsusuario.WsUsuario_Service service = new wsusuario.WsUsuario_Service();
        wsusuario.WsUsuario port = service.getWsUsuarioPort();
        return port.readUsuario(arg0);
    }

    public static void updateUsuario(wsusuario.Usuario arg0) {
        wsusuario.WsUsuario_Service service = new wsusuario.WsUsuario_Service();
        wsusuario.WsUsuario port = service.getWsUsuarioPort();
        port.updateUsuario(arg0);
    }

}
