
package mypackage.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mypackage.entities.Desarrollador;
import mypackage.repositories.interfaces.I_DesarrolladorRepository;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.jpa.DesarrolladorRepository;
import mypackage.repositories.jpa.EmpleadoRepository;


public class TestDesarrolladorRepository {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("mypackage_GestorEmpleadosJPAHibernate_app_jar_1.0-SNAPSHOTPU");
        
        I_DesarrolladorRepository desarrolladorRepository=new DesarrolladorRepository(entityManagerFactory);
         I_EmpleadoRepository empleadoRepository=new EmpleadoRepository(entityManagerFactory);
        
        
        //--------------------------------------INSERT----------------------------------------------------
//            System.out.println("\n----------------Agregamos un Nuevo Desarrollador ----------------------");       
//          
//        Desarrollador nuevoDesarrollador=new Desarrollador("Back End Dev","DataBase Manager","Infraestructura, Gestión",1,empleadoRepository.getById(4));
//       
//        desarrolladorRepository.save(nuevoDesarrollador);
//        
//        System.out.println(nuevoDesarrollador);
        
        //--------------------------------------FIN INSERT----------------------------------------------------
        
                        //--------------------------------------UPDATE-----------------------------------------------------------

//        System.out.println("\n----------------Actualizamos el desarrollador con el ID 4----------------------");
//        
//
//    Desarrollador desarrolladorActualizado=desarrolladorRepository.getById(4);
//        
//        if(desarrolladorActualizado != null){
//            
//            desarrolladorActualizado.setProyectosEnProduccion(2);
//            
//            desarrolladorRepository.update(desarrolladorActualizado);
//        }
//        
//        System.out.println(desarrolladorActualizado);
            
        //--------------------------------------FIN UPDATE-----------------------------------------------------------
        
        //----------------------------------------DELETE----------------------------------------------------------------
//        System.out.println("\n-------------------------Eliminamos el Desarrollador con el ID 4-----------------------------");
//        desarrolladorRepository.remove(desarrolladorRepository.getById(3));
        
        //----------------------------------------FIN DELETE----------------------------------------------------------------
     
        
        //---------------------------------------SELECT----------------------------------------------------------
        System.out.println("\n -------------------------Lista de Desarrolladores---------------------------");
        desarrolladorRepository.getAll().forEach(System.out::println);

        System.out.println("\n ------------------------- Desarrollador cuyo ID sea 2---------------------------");
        System.out.println(desarrolladorRepository.getById(2));

        System.out.println("\n -------------------------Desarrollador/es cuyo puesto sea Front End Dev---------------------------");
        desarrolladorRepository.getLikePuesto("Front End Dev").forEach(System.out::println);
    
            System.out.println("\n -------------------------Desarrollador/es cuya certificacion sea Web Service it---------------------------");
        desarrolladorRepository.getLikeCertificaciones("Web Service it").forEach(System.out::println);
   
                 System.out.println("\n -------------------------Desarrollador/es cuya habilidad sea Autodidacta---------------------------");
        desarrolladorRepository.getLikeHabilidades("autodidacta").forEach(System.out::println);
        
                 System.out.println("\n -------------------------Desarrollador/es que tengan 1 proyecto en producción---------------------------");
        desarrolladorRepository.getByProyectosEnProduccion(1).forEach(System.out::println);
 
                        System.out.println("\n -------------------------Desarrollador/es que tengan mas de 2 proyectos en producción---------------------------");
        desarrolladorRepository.getByProyectosEnProduccionMayorQue(2).forEach(System.out::println);
        
        //---------------------------------------FIN SELECT----------------------------------------------------------

          entityManagerFactory.close();
        
        
        
        
    }

}
