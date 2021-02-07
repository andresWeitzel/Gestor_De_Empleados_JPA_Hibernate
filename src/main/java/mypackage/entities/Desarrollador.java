
package mypackage.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "desarrolladores")
@NamedQueries({
    @NamedQuery(name = "Desarrollador.findAll", query = "SELECT d FROM Desarrollador d"),
    @NamedQuery(name = "Desarrollador.findById", query = "SELECT d FROM Desarrollador d WHERE d.id = :id"),
    @NamedQuery(name = "Desarrollador.findByPuesto", query = "SELECT d FROM Desarrollador d WHERE d.puesto = :puesto"),
    @NamedQuery(name = "Desarrollador.findByCertificaciones", query = "SELECT d FROM Desarrollador d WHERE d.certificaciones = :certificaciones"),
    @NamedQuery(name = "Desarrollador.findByHabilidades", query = "SELECT d FROM Desarrollador d WHERE d.habilidades = :habilidades"),
    @NamedQuery(name = "Desarrollador.findByProyectosEnProduccion", query = "SELECT d FROM Desarrollador d WHERE d.proyectosEnProduccion = :proyectosEnProduccion")})
public class Desarrollador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "puesto")
    private String puesto;
    @Column(name = "certificaciones")
    private String certificaciones;
    @Basic(optional = false)
    @Column(name = "habilidades")
    private String habilidades;
    @Column(name = "proyectos_en_produccion")
    private Integer proyectosEnProduccion;
    
    public Desarrollador() {
    }
    public Desarrollador(Integer id) {
        this.id = id;
    }
    public Desarrollador(String puesto, String certificaciones, String habilidades, Integer proyectosEnProduccion) {
        this.puesto = puesto;
        this.certificaciones = certificaciones;
        this.habilidades = habilidades;
        this.proyectosEnProduccion = proyectosEnProduccion;
       
    }
    public Desarrollador(Integer id, String puesto, String certificaciones, String habilidades, Integer proyectosEnProduccion) {
        this.id = id;
        this.puesto = puesto;
        this.certificaciones = certificaciones;
        this.habilidades = habilidades;
        this.proyectosEnProduccion = proyectosEnProduccion;
        
    }
    
 
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getCertificaciones() {
        return certificaciones;
    }
    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
    }
    public String getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }
    public Integer getProyectosEnProduccion() {
        return proyectosEnProduccion;
    }
    public void setProyectosEnProduccion(Integer proyectosEnProduccion) {
        this.proyectosEnProduccion = proyectosEnProduccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desarrollador)) {
            return false;
        }
        Desarrollador other = (Desarrollador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Desarrollador{" + "id=" 
                + id + ", puesto=" 
                + puesto
                + ", certificaciones=" 
                + certificaciones
                + ", habilidades=" 
                + habilidades 
                + ", proyectosEnProduccion=" 
                + proyectosEnProduccion
                + '}';
    }


}
