package mypackage.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mypackage.entities.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-01T22:57:45")
@StaticMetamodel(Desarrollador.class)
public class Desarrollador_ { 

    public static volatile SingularAttribute<Desarrollador, String> puesto;
    public static volatile SingularAttribute<Desarrollador, String> certificaciones;
    public static volatile SingularAttribute<Desarrollador, Integer> id;
    public static volatile SingularAttribute<Desarrollador, Empleado> idEmpleados;
    public static volatile SingularAttribute<Desarrollador, String> habilidades;
    public static volatile SingularAttribute<Desarrollador, Integer> proyectosEnProduccion;

}