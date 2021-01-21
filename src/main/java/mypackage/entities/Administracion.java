
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
@Table(name = "administracion")
@NamedQueries({
    @NamedQuery(name = "Administracion.findAll", query = "SELECT a FROM Administracion a"),
    @NamedQuery(name = "Administracion.findById", query = "SELECT a FROM Administracion a WHERE a.id = :id"),
    @NamedQuery(name = "Administracion.findByPuesto", query = "SELECT a FROM Administracion a WHERE a.puesto = :puesto"),
    @NamedQuery(name = "Administracion.findByHabilidades", query = "SELECT a FROM Administracion a WHERE a.habilidades = :habilidades")})
public class Administracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "puesto")
    private String puesto;
    @Basic(optional = false)
    @Column(name = "habilidades")
    private String habilidades;
    @JoinColumn(name = "id_empleados", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Empleado idEmpleados;
    public Administracion() {
    }
    public Administracion(Integer id) {
        this.id = id;
    }
    public Administracion(String puesto, String habilidades, Empleado idEmpleados) {
        this.puesto = puesto;
        this.habilidades = habilidades;
        this.idEmpleados = idEmpleados;
    }
    public Administracion(Integer id, String puesto, String habilidades, Empleado idEmpleados) {
        this.id = id;
        this.puesto = puesto;
        this.habilidades = habilidades;
        this.idEmpleados = idEmpleados;
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
    public String getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }
    public Empleado getIdEmpleados() {
        return idEmpleados;
    }
    public void setIdEmpleados(Empleado idEmpleados) {
        this.idEmpleados = idEmpleados;
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
        if (!(object instanceof Administracion)) {
            return false;
        }
        Administracion other = (Administracion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Administracion{" + "id=" + id + ", puesto=" + puesto + ", habilidades=" + habilidades + ", idEmpleados=" + idEmpleados + '}';
    }
  

}
