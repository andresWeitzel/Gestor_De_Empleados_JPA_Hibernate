
package mypackage.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mypackage.entities.Gerente;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.interfaces.I_GerenteRepository;
import mypackage.repositories.jpa.EmpleadoRepository;
import mypackage.repositories.jpa.GerenteRepository;


public class TestGerenteRepository {
    
    public static void main(String[] args) {
        
          EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mypackage_GestorEmpleadosJPAHibernate_app_jar_1.0-SNAPSHOTPU");

               I_GerenteRepository gerenteRepository= new GerenteRepository(entityManagerFactory);

        I_EmpleadoRepository empleadoRepository = new EmpleadoRepository(entityManagerFactory);

        //--------------------------------------INSERT----------------------------------------------------

//        Gerente nuevoGerente=new Gerente("Soporte Tecnico", "Master en Coordinacion y Planificacion", 2, empleadoRepository.getById(26));
//       
//        gerenteRepository.save(nuevoGerente);
//        
//        System.out.println(nuevoGerente);
//        
        //--------------------------------------FIN INSERT----------------------------------------------------
        
                //--------------------------------------UPDATE-----------------------------------------------------------

     //   System.out.println("\n------------------------------Actualizamos el Gerente con el ID 3----------------------");
        
//
//    Gerente gerenteActualizado=gerenteRepository.getById(3);
//        
//        if(gerenteActualizado != null){
//            gerenteActualizado.setAntiguedad(3);
//            gerenteRepository.update(gerenteActualizado);
//        }
//        
//        System.out.println(gerenteActualizado);
            
        //--------------------------------------FIN UPDATE-----------------------------------------------------------
        
        //----------------------------------------DELETE----------------------------------------------------------------
        System.out.println("\n-------------------------Eliminamos el Gerente con el ID 5-----------------------------");
        gerenteRepository.remove(gerenteRepository.getById(5));
        
        //----------------------------------------FIN DELETE----------------------------------------------------------------
     
        //---------------------------------------SELECT----------------------------------------------------------
        System.out.println("\n -------------------------Lista de Gerente---------------------------");
        gerenteRepository.getAll().forEach(System.out::println);

        System.out.println("\n ------------------------- Gerente cuyo ID sea 4---------------------------");
        System.out.println(gerenteRepository.getById(4));

        System.out.println("\n -------------------------Gerente/s cuyo sector  sea el de  Administracion---------------------------");
        gerenteRepository.getLikeSector("Administracion").forEach(System.out::println);

        
        System.out.println("\n -------------------------Gerente/s cuya formacion   sea la de Doctorado---------------------------");
        gerenteRepository.getLikeFormacion("Dr").forEach(System.out::println);

        
        System.out.println("\n -------------------------Gerente/s cuyos años de Antiguedad sean 1 ---------------------------");
        gerenteRepository.getByAntiguedad(1).forEach(System.out::println);

        //---------------------------------------FIN SELECT-----------------------------------------------------
        
          entityManagerFactory.close();
        
    }

}
