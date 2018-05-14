/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")
    , @NamedQuery(name = "Usuario.findByNombreReal", query = "SELECT u FROM Usuario u WHERE u.nombreReal = :nombreReal")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")
    , @NamedQuery(name = "Usuario.findByLocalizacion", query = "SELECT u FROM Usuario u WHERE u.localizacion = :localizacion")
    , @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_real")
    private String nombreReal;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "localizacion")
    private String localizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "rol")
    private String rol;
    @OneToMany(mappedBy = "nombreUsuario")
    private Collection<Historia> historiaCollection;
    @OneToMany(mappedBy = "nombreUsuario")
    private Collection<Noticia> noticiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreUsuario")
    private Collection<Notificacion> notificacionCollection;

    public Usuario() {
    }

    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario(String nombreUsuario, String password, String nombreReal, String email, String localizacion, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.nombreReal = nombreReal;
        this.email = email;
        this.localizacion = localizacion;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @XmlTransient
    public Collection<Historia> getHistoriaCollection() {
        return historiaCollection;
    }

    public void setHistoriaCollection(Collection<Historia> historiaCollection) {
        this.historiaCollection = historiaCollection;
    }

    @XmlTransient
    public Collection<Noticia> getNoticiaCollection() {
        return noticiaCollection;
    }

    public void setNoticiaCollection(Collection<Noticia> noticiaCollection) {
        this.noticiaCollection = noticiaCollection;
    }

    @XmlTransient
    public Collection<Notificacion> getNotificacionCollection() {
        return notificacionCollection;
    }

    public void setNotificacionCollection(Collection<Notificacion> notificacionCollection) {
        this.notificacionCollection = notificacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nombreUsuario == null && other.nombreUsuario != null) || (this.nombreUsuario != null && !this.nombreUsuario.equals(other.nombreUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Usuario[ nombreUsuario=" + nombreUsuario + " ]";
    }
    
}
