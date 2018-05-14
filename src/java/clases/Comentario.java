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
import javax.persistence.Lob;
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
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c")
    , @NamedQuery(name = "Comentario.findByIdComentario", query = "SELECT c FROM Comentario c WHERE c.idComentario = :idComentario")
    , @NamedQuery(name = "Comentario.findByNombreUsuario", query = "SELECT c FROM Comentario c WHERE c.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "Comentario.findByIdPadre", query = "SELECT c FROM Comentario c WHERE c.idPadre = :idPadre")
    , @NamedQuery(name = "Comentario.findByFechaComentario", query = "SELECT c FROM Comentario c WHERE c.fechaComentario = :fechaComentario")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario")
    private Integer idComentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "id_padre")
    private Integer idPadre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_comentario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaComentario;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "mensaje")
    private String mensaje;
    @JoinColumn(name = "id_noticia", referencedColumnName = "id_noticia")
    @ManyToOne(optional = false)
    private Noticia idNoticia;

    public Comentario() {
    }

    public Comentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Comentario(Integer idComentario, String nombreUsuario, Date fechaComentario, String mensaje) {
        this.idComentario = idComentario;
        this.nombreUsuario = nombreUsuario;
        this.fechaComentario = fechaComentario;
        this.mensaje = mensaje;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Noticia getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Noticia idNoticia) {
        this.idNoticia = idNoticia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Comentario[ idComentario=" + idComentario + " ]";
    }
    
}
