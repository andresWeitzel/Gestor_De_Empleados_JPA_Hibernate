
package mypackage.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mypackage.entities.Administracion;
import mypackage.repositories.interfaces.I_AdministracionRepository;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.jpa.AdministracionRepository;
import mypackage.repositories.jpa.EmpleadoRepository;


public class TestAdministracionRepository {

    public static void main(String[] args) {
        
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mypackage_GestorEmpleadosJPAHibernate_app_jar_1.0-SNAPSHOTPU");

        I_AdministracionRepository administracionRepository = new AdministracionRepository(entityManagerFactory);
        I_EmpleadoRepository empleadoRepository = new EmpleadoRepository(entityManagerFactory);

        //--------------------------------------INSERT----------------------------------------------------
//        System.out.println("\n----------------Agregamos datos del Nuevo Administrador/a----------------------");
//
//        Administracion nuevoAdministrador
//                = new Administracion("Administrador Principal",
//                         "Organizacion, Businness, Data Science",
//                         empleadoRepository.getById(27));
//
//        administracionRepository.save(nuevoAdministrador);
//
//        System.out.println(nuevoAdministrador);

        //--------------------------------------FIN INSERT----------------------------------------------------
        //--------------------------------------UPDATE-----------------------------------------------------------
//        System.out.println("\n----------------Actualizamos el Administrador/a con el ID 2----------------------");
//        
//
//    Administracion administradorActualizado=administracionRepository.getById(2);
//        
//        if(administradorActualizado != null){
//            
//            administradorActualizado.setHabilidades("Coordinacion, Data Science");
//            
//            administracionRepository.update(administradorActualizado);
//        }
//        
//        System.out.println(administradorActualizado);
        
//--------------------------------------FIN UPDATE-----------------------------------------------------------
        //----------------------------------------DELETE----------------------------------------------------------------
//        System.out.println("\n-------------------------Eliminamos elAdministrador  con el ID 4-----------------------------");
//        administracionRepository.remove(administracionRepository.getById(4));
//        //----------------------------------------FIN DELETE----------------------------------------------------------------
//       // ---------------------------------------SELECT----------------------------------------------------------
        System.out.println("\n -------------------------Lista de Administradores---------------------------");
        administracionRepository.getAll().forEach(System.out::println);

        System.out.println("\n ------------------------- Administrador  cuyo ID sea 2---------------------------");
        System.out.println(administracionRepository.getById(2));
        
        System.out.println("\n ------------------------- Administrador  cuyo puesto sea de Ayudante ---------------------------");
        administracionRepository.getLikePuesto("Ayudante").forEach(System.out::println);

        
        System.out.println("\n ------------------------- Administrador cuya Habilidad sea de Coordinacion --------------------------");
        administracionRepository.getLikeHabilidades("Coordinacion").forEach(System.out::println);

        
        //---------------------------------------FIN SELECT----------------------------------------------------------
        
          entityManagerFactory.close();
    }
    }

