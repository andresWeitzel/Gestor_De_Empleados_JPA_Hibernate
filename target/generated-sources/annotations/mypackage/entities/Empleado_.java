package mypackage.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-06T21:16:45")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> tipoDocumento;
    public static volatile SingularAttribute<Empleado, Date> fechaInicio;
    public static volatile SingularAttribute<Empleado, String> apellido;
    public static volatile SingularAttribute<Empleado, String> genero;
    public static volatile SingularAttribute<Empleado, Float> sueldo;
    public static volatile SingularAttribute<Empleado, Integer> id;
    public static volatile SingularAttribute<Empleado, String> numeroDocumento;
    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile SingularAttribute<Empleado, Integer> edad;
    public static volatile SingularAttribute<Empleado, String> correoElectronico;
    public static volatile SingularAttribute<Empleado, String> numeroTelefono;
    public static volatile SingularAttribute<Empleado, Integer> cantidadHsSemanales;

}