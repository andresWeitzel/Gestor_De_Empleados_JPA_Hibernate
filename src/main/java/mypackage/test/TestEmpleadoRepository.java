package mypackage.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mypackage.entities.Empleado;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.jpa.EmpleadoRepository;

public class TestEmpleadoRepository {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mypackage_GestorEmpleadosJPAHibernate_app_jar_1.0-SNAPSHOTPU");

        I_EmpleadoRepository empleadoRepository = new EmpleadoRepository(entityManagerFactory);

        //--------------------------------------INSERT----------------------------------------------------
//          Date fechaActual = new Date();
//          
//        Empleado empleado=new Empleado("Romina", "Martinez", 45, "Femenino", "DNI", "5445676", "Romi876@gmail.com", "12121212",fechaActual, 53, 50000f);
//       
//        empleadoRepository.save(empleado);
//        
//        System.out.println(empleado);
//        
        //--------------------------------------FIN INSERT----------------------------------------------------
        
                //--------------------------------------UPDATE-----------------------------------------------------------

//        System.out.println("\n------------------------------Actualizamos el empleado con el ID 14----------------------");
//        
//
//    Empleado empleado=empleadoRepository.getById(14);
//        
//        if(empleado != null){
//            empleado.setApellido("Jimenilo");
//            empleadoRepository.update(empleado);
//        }
//        
//        System.out.println(empleado);
            
        //--------------------------------------FIN UPDATE-----------------------------------------------------------
        
        //----------------------------------------DELETE----------------------------------------------------------------
//        System.out.println("\n-------------------------Eliminamos el Empleado con el ID 30-----------------------------");
//        empleadoRepository.remove(empleadoRepository.getById(30));
//        
        //----------------------------------------FIN DELETE----------------------------------------------------------------
     
        //---------------------------------------SELECT----------------------------------------------------------
        System.out.println("\n -------------------------Lista de Empleados---------------------------");
        empleadoRepository.getAll().forEach(System.out::println);

        System.out.println("\n ------------------------- Empleado cuyo ID sea 12---------------------------");
        System.out.println(empleadoRepository.getById(12));

        System.out.println("\n -------------------------Empleado/s cuyo nombre sea/n Antonio---------------------------");
        empleadoRepository.getLikeNombre("Antonio").forEach(System.out::println);

        System.out.println("\n -------------------------Empleado/s cuyo apellido sea/n Marconi---------------------------");
        empleadoRepository.getLikeApellido("Martinez").forEach(System.out::println);

        System.out.println("\n -------------------------Empleado/s cuya/s edad/es sea/n 26---------------------------");
        empleadoRepository.getByEdad(26).forEach(System.out::println);

        System.out.println("\n -------------------------Empleado/s cuya/s edad/es sea/n  mayores a 32---------------------------");
        empleadoRepository.getByEdadMayorIgualQue(32).forEach(System.out::println);

        System.out.println("\n -------------------------Empleado/s cuya/s edad/es sea/n menores a 20---------------------------");
        empleadoRepository.getByEdadMenorIgualQue(20).forEach(System.out::println);

        System.out.println("\n -------------------------Empleado/s cuyo/s genero/s  sea/n Masculinos---------------------------");
        empleadoRepository.getLikeGenero("Masculino").forEach(System.out::println);

        System.out.println("\n -------------------------Empleado/s cuyo/s tipo de documento/s  sea/n DNI---------------------------");
        empleadoRepository.getLikeTipoDocumento("DNI").forEach(System.out::println);

        System.out.println("\n -------------------------Empleado/s cuyo/s nro de documento/s  empiecen con 39---------------------------");
        empleadoRepository.getLikeNumeroDocumento("39").forEach(System.out::println);

        System.out.println("\n -------------------------Empleado/s cuyo/s correo electronico  sea hotmail--------------------------");
        empleadoRepository.getLikeCorreoElectronico("hotmail").forEach(System.out::println);

        System.out.println("\n -------------------------Empleado/s cuyo/s números de telefonos  comiencen  con 15---------------------------");
        empleadoRepository.getLikeNumeroTelefono("15").forEach(System.out::println);

        System.out.println("\n -------------------------Empleado/s cuya/s fecha de Inicio  sea la de hoy---------------------------");
       
        Date data = new Date();

        empleadoRepository.getLikeFechaInicio(data).forEach(System.out::println);

           System.out.println("\n -------------------------Empleado/s cuya/s cantidad de hs semanales sean 49---------------------------");
        empleadoRepository.getByCantidadHsSemanales(49).forEach(System.out::println);

                  System.out.println("\n -------------------------Empleado/s cuyo/s sueldo sea 54000---------------------------");
        empleadoRepository.getBySueldo(54000).forEach(System.out::println);

        //---------------------------------------FIN SELECT-----------------------------------------------------
        

        
        
        entityManagerFactory.close();

    }

}
