/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferna
 */
@Entity
@Table(name = "historia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historia.findAll", query = "SELECT h FROM Historia h")
    , @NamedQuery(name = "Historia.findByIdHistoria", query = "SELECT h FROM Historia h WHERE h.idHistoria = :idHistoria")
    , @NamedQuery(name = "Historia.findByFechaHistoria", query = "SELECT h FROM Historia h WHERE h.fechaHistoria = :fechaHistoria")})
public class Historia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historia")
    private Integer idHistoria;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "titulo_historia")
    private String tituloHistoria;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "subtitulo_historia")
    private String subtituloHistoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_historia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHistoria;
    @JoinTable(name = "rel_historia_noticia", joinColumns = {
        @JoinColumn(name = "id_historia", referencedColumnName = "id_historia")}, inverseJoinColumns = {
        @JoinColumn(name = "id_noticia", referencedColumnName = "id_noticia")})
    @ManyToMany
    private Collection<Noticia> noticiaCollection;
    @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario")
    @ManyToOne
    private Usuario nombreUsuario;

    public Historia() {
    }

    public Historia(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Historia(Integer idHistoria, String tituloHistoria, String subtituloHistoria, Date fechaHistoria) {
        this.idHistoria = idHistoria;
        this.tituloHistoria = tituloHistoria;
        this.subtituloHistoria = subtituloHistoria;
        this.fechaHistoria = fechaHistoria;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getTituloHistoria() {
        return tituloHistoria;
    }

    public void setTituloHistoria(String tituloHistoria) {
        this.tituloHistoria = tituloHistoria;
    }

    public String getSubtituloHistoria() {
        return subtituloHistoria;
    }

    public void setSubtituloHistoria(String subtituloHistoria) {
        this.subtituloHistoria = subtituloHistoria;
    }

    public Date getFechaHistoria() {
        return fechaHistoria;
    }

    public void setFechaHistoria(Date fechaHistoria) {
        this.fechaHistoria = fechaHistoria;
    }

    @XmlTransient
    public Collection<Noticia> getNoticiaCollection() {
        return noticiaCollection;
    }

    public void setNoticiaCollection(Collection<Noticia> noticiaCollection) {
        this.noticiaCollection = noticiaCollection;
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
        hash += (idHistoria != null ? idHistoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historia)) {
            return false;
        }
        Historia other = (Historia) object;
        if ((this.idHistoria == null && other.idHistoria != null) || (this.idHistoria != null && !this.idHistoria.equals(other.idHistoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Historia[ idHistoria=" + idHistoria + " ]";
    }
    
}
