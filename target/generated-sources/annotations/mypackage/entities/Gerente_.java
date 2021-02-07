package mypackage.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mypackage.entities.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-06T21:16:45")
@StaticMetamodel(Gerente.class)
public class Gerente_ { 

    public static volatile SingularAttribute<Gerente, String> formacion;
    public static volatile SingularAttribute<Gerente, Integer> antiguedad;
    public static volatile SingularAttribute<Gerente, Integer> id;
    public static volatile SingularAttribute<Gerente, Empleado> idEmpleados;
    public static volatile SingularAttribute<Gerente, String> sector;

}