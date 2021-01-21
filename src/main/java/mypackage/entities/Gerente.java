
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
@Table(name = "gerentes")
@NamedQueries({
    @NamedQuery(name = "Gerente.findAll", query = "SELECT g FROM Gerente g"),
    @NamedQuery(name = "Gerente.findById", query = "SELECT g FROM Gerente g WHERE g.id = :id"),
    @NamedQuery(name = "Gerente.findBySector", query = "SELECT g FROM Gerente g WHERE g.sector = :sector"),
    @NamedQuery(name = "Gerente.findByFormacion", query = "SELECT g FROM Gerente g WHERE g.formacion = :formacion"),
    @NamedQuery(name = "Gerente.findByAntiguedad", query = "SELECT g FROM Gerente g WHERE g.antiguedad = :antiguedad")})
public class Gerente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sector")
    private String sector;
    @Column(name = "formacion")
    private String formacion;
    @Basic(optional = false)
    @Column(name = "antiguedad")
    private int antiguedad;
    @JoinColumn(name = "id_empleados", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Empleado idEmpleados;
    public Gerente() {
    }
    public Gerente(Integer id) {
        this.id = id;
    }
    public Gerente(Integer id, String sector, int antiguedad) {
        this.id = id;
        this.sector = sector;
        this.antiguedad = antiguedad;
    }
    public Gerente(String sector, String formacion, int antiguedad, Empleado idEmpleados) {
        this.sector = sector;
        this.formacion = formacion;
        this.antiguedad = antiguedad;
        this.idEmpleados = idEmpleados;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getFormacion() {
        return formacion;
    }
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
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
        if (!(object instanceof Gerente)) {
            return false;
        }
        Gerente other = (Gerente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Gerente{" + "id=" + id + ", sector=" + sector + ", formacion=" + formacion + ", antiguedad=" + antiguedad + ", idEmpleados=" + idEmpleados + '}';
    }


}
