
package mypackage.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "empleados")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByApellido", query = "SELECT e FROM Empleado e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Empleado.findByEdad", query = "SELECT e FROM Empleado e WHERE e.edad = :edad"),
    @NamedQuery(name = "Empleado.findByGenero", query = "SELECT e FROM Empleado e WHERE e.genero = :genero"),
    @NamedQuery(name = "Empleado.findByTipoDocumento", query = "SELECT e FROM Empleado e WHERE e.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Empleado.findByNumeroDocumento", query = "SELECT e FROM Empleado e WHERE e.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Empleado.findByCorreoElectronico", query = "SELECT e FROM Empleado e WHERE e.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Empleado.findByNumeroTelefono", query = "SELECT e FROM Empleado e WHERE e.numeroTelefono = :numeroTelefono"),
    @NamedQuery(name = "Empleado.findByFechaInicio", query = "SELECT e FROM Empleado e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Empleado.findByCantidadHsSemanales", query = "SELECT e FROM Empleado e WHERE e.cantidadHsSemanales = :cantidadHsSemanales"),
    @NamedQuery(name = "Empleado.findBySueldo", query = "SELECT e FROM Empleado e WHERE e.sueldo = :sueldo")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "numero_telefono")
    private String numeroTelefono;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "cantidad_hs_semanales")
    private int cantidadHsSemanales;
    @Basic(optional = false)
    @Column(name = "sueldo")
    private float sueldo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idEmpleados")
    private Desarrollador desarrollador;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idEmpleados")
    private SoporteTecnico soporteTecnico;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idEmpleados")
    private Gerente gerente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idEmpleados")
    private Administracion administracion;
    public Empleado() {
    }
    public Empleado(Integer id) {
        this.id = id;
    }
    
    public Empleado(String nombre, String apellido, int edad, String genero, String tipoDocumento, String numeroDocumento, String correoElectronico, String numeroTelefono, Date fechaInicio, int cantidadHsSemanales, float sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.fechaInicio = fechaInicio;
        this.cantidadHsSemanales = cantidadHsSemanales;
        this.sueldo = sueldo;
       
    }
    
    public Empleado(Integer id, String nombre, String apellido, int edad, String genero, String tipoDocumento, String numeroDocumento, String correoElectronico, Date fechaInicio, int cantidadHsSemanales, float sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.correoElectronico = correoElectronico;
        this.fechaInicio = fechaInicio;
        this.cantidadHsSemanales = cantidadHsSemanales;
        this.sueldo = sueldo;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public int getCantidadHsSemanales() {
        return cantidadHsSemanales;
    }
    public void setCantidadHsSemanales(int cantidadHsSemanales) {
        this.cantidadHsSemanales = cantidadHsSemanales;
    }
    public float getSueldo() {
        return sueldo;
    }
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    public Desarrollador getDesarrollador() {
        return desarrollador;
    }
    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }
    public SoporteTecnico getSoporteTecnico() {
        return soporteTecnico;
    }
    public void setSoporteTecnico(SoporteTecnico soporteTecnico) {
        this.soporteTecnico = soporteTecnico;
    }
    public Gerente getGerente() {
        return gerente;
    }
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    public Administracion getAdministracion() {
        return administracion;
    }
    public void setAdministracion(Administracion administracion) {
        this.administracion = administracion;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", correoElectronico=" + correoElectronico + ", numeroTelefono=" + numeroTelefono + ", fechaInicio=" + fechaInicio + ", cantidadHsSemanales=" + cantidadHsSemanales + ", sueldo=" + sueldo + '}';
    }

    
    

}
