/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "notificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificacion.findAll", query = "SELECT n FROM Notificacion n")
    , @NamedQuery(name = "Notificacion.findByIdNotificacion", query = "SELECT n FROM Notificacion n WHERE n.idNotificacion = :idNotificacion")
    , @NamedQuery(name = "Notificacion.findByFechaNotifiacion", query = "SELECT n FROM Notificacion n WHERE n.fechaNotifiacion = :fechaNotifiacion")
    , @NamedQuery(name = "Notificacion.findByMensaje", query = "SELECT n FROM Notificacion n WHERE n.mensaje = :mensaje")})
public class Notificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_notificacion")
    private Integer idNotificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_notifiacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNotifiacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "mensaje")
    private String mensaje;
    @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario")
    @ManyToOne(optional = false)
    private Usuario nombreUsuario;

    public Notificacion() {
    }

    public Notificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Notificacion(Integer idNotificacion, Date fechaNotifiacion, String mensaje) {
        this.idNotificacion = idNotificacion;
        this.fechaNotifiacion = fechaNotifiacion;
        this.mensaje = mensaje;
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Date getFechaNotifiacion() {
        return fechaNotifiacion;
    }

    public void setFechaNotifiacion(Date fechaNotifiacion) {
        this.fechaNotifiacion = fechaNotifiacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(Usuario nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificacion != null ? idNotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion)) {
            return false;
        }
        Notificacion other = (Notificacion) object;
        if ((this.idNotificacion == null && other.idNotificacion != null) || (this.idNotificacion != null && !this.idNotificacion.equals(other.idNotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Notificacion[ idNotificacion=" + idNotificacion + " ]";
    }
    
}
