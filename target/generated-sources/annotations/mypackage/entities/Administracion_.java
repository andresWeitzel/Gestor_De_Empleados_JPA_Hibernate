package mypackage.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mypackage.entities.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-29T17:35:39")
@StaticMetamodel(Administracion.class)
public class Administracion_ { 

    public static volatile SingularAttribute<Administracion, String> puesto;
    public static volatile SingularAttribute<Administracion, Integer> id;
    public static volatile SingularAttribute<Administracion, Empleado> idEmpleados;
    public static volatile SingularAttribute<Administracion, String> habilidades;

}