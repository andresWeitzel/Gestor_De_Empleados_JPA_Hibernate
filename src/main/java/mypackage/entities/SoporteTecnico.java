
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
@Table(name = "soporte_tecnico")
@NamedQueries({
    @NamedQuery(name = "SoporteTecnico.findAll", query = "SELECT s FROM SoporteTecnico s"),
    @NamedQuery(name = "SoporteTecnico.findById", query = "SELECT s FROM SoporteTecnico s WHERE s.id = :id"),
    @NamedQuery(name = "SoporteTecnico.findByPuesto", query = "SELECT s FROM SoporteTecnico s WHERE s.puesto = :puesto"),
    @NamedQuery(name = "SoporteTecnico.findByFormacion", query = "SELECT s FROM SoporteTecnico s WHERE s.formacion = :formacion"),
    @NamedQuery(name = "SoporteTecnico.findByCertificaciones", query = "SELECT s FROM SoporteTecnico s WHERE s.certificaciones = :certificaciones")})
public class SoporteTecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "puesto")
    private String puesto;
    @Column(name = "formacion")
    private String formacion;
    @Column(name = "certificaciones")
    private String certificaciones;
    @JoinColumn(name = "id_empleados", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Empleado idEmpleados;
    public SoporteTecnico() {
    }
    public SoporteTecnico(Integer id) {
        this.id = id;
    }
    public SoporteTecnico(String puesto, String formacion, String certificaciones, Empleado idEmpleados) {
        this.puesto = puesto;
        this.formacion = formacion;
        this.certificaciones = certificaciones;
        this.idEmpleados = idEmpleados;
    }
    public SoporteTecnico(Integer id, String puesto, String formacion, String certificaciones, Empleado idEmpleados) {
        this.id = id;
        this.puesto = puesto;
        this.formacion = formacion;
        this.certificaciones = certificaciones;
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
    public String getFormacion() {
        return formacion;
    }
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }
    public String getCertificaciones() {
        return certificaciones;
    }
    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
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
        if (!(object instanceof SoporteTecnico)) {
            return false;
        }
        SoporteTecnico other = (SoporteTecnico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "SoporteTecnico{" + "id=" + id + ", puesto=" + puesto + ", formacion=" + formacion + ", certificaciones=" + certificaciones + ", idEmpleados=" + idEmpleados + '}';
    }


}
