package mypackage.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mypackage.entities.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-06T21:16:45")
@StaticMetamodel(SoporteTecnico.class)
public class SoporteTecnico_ { 

    public static volatile SingularAttribute<SoporteTecnico, String> formacion;
    public static volatile SingularAttribute<SoporteTecnico, String> puesto;
    public static volatile SingularAttribute<SoporteTecnico, String> certificaciones;
    public static volatile SingularAttribute<SoporteTecnico, Integer> id;
    public static volatile SingularAttribute<SoporteTecnico, Empleado> idEmpleados;

}