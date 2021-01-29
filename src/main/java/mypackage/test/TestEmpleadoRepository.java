
package mypackage.test;

import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mypackage.entities.Empleado;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.jpa.EmpleadoRepository;


public class TestEmpleadoRepository {
    
    public static void main(String[] args) {
        
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("mypackage_GestorEmpleadosJPAHibernate_app_jar_1.0-SNAPSHOTPU");

        I_EmpleadoRepository empleadoRepository=new EmpleadoRepository(entityManagerFactory);
        
          Date fechaActual = new Date();
          
        Empleado empleado=new Empleado("Romina", "Martinez", 45, "Femenino", "DNI", "5445676", "Romi876@gmail.com", "12121212",fechaActual, 53, 50000f);
       
        empleadoRepository.save(empleado);
        
        System.out.println(empleado);
        
        entityManagerFactory.close();

    }

}
