package mypackage.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mypackage.entities.SoporteTecnico;
import mypackage.repositories.interfaces.I_EmpleadoRepository;
import mypackage.repositories.interfaces.I_SoporteTecnicoRepository;
import mypackage.repositories.jpa.EmpleadoRepository;
import mypackage.repositories.jpa.SoporteTecnicoRepository;

public class TestSoporteTecnicoRepository {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mypackage_GestorEmpleadosJPAHibernate_app_jar_1.0-SNAPSHOTPU");

        I_SoporteTecnicoRepository soporteTecnicoRepository = new SoporteTecnicoRepository(entityManagerFactory);
        I_EmpleadoRepository empleadoRepository = new EmpleadoRepository(entityManagerFactory);

        //--------------------------------------INSERT----------------------------------------------------
//        System.out.println("\n----------------Agregamos datos del Nuevo Soporte Tecnico----------------------");
//
//        SoporteTecnico nuevoSoporteTecnico
//                = new SoporteTecnico("Ayudante Networking Enginner",
//                         "Tecnico Superior en Redes Informáticas",
//                         "Cisco Admin Advanced, ISP Protection",
//                         empleadoRepository.getById(29));
//
//        soporteTecnicoRepository.save(nuevoSoporteTecnico);
//
//        System.out.println(nuevoSoporteTecnico);

        //--------------------------------------FIN INSERT----------------------------------------------------
        //--------------------------------------UPDATE-----------------------------------------------------------
//        System.out.println("\n----------------Actualizamos el Soporte Tecnico con el ID 11----------------------");
//        
//
//    SoporteTecnico soporteTecnicoActualizado=soporteTecnicoRepository.getById(11);
//        
//        if(soporteTecnicoActualizado != null){
//            
//            soporteTecnicoActualizado.setFormacion("Técnico en Telecomunicaciones");
//            
//            soporteTecnicoRepository.update(soporteTecnicoActualizado);
//        }
//        
//        System.out.println(soporteTecnicoActualizado);
//        
//--------------------------------------FIN UPDATE-----------------------------------------------------------
        //----------------------------------------DELETE----------------------------------------------------------------
//        System.out.println("\n-------------------------Eliminamos el Soporte Tecnico  con el ID 5-----------------------------");
//        soporteTecnicoRepository.remove(soporteTecnicoRepository.getById(5));
//        //----------------------------------------FIN DELETE----------------------------------------------------------------
//       // ---------------------------------------SELECT----------------------------------------------------------
        System.out.println("\n -------------------------Lista de Soporte Tecnico---------------------------");
        soporteTecnicoRepository.getAll().forEach(System.out::println);

        System.out.println("\n ------------------------- Soporte Tecnico  cuyo ID sea 2---------------------------");
        System.out.println(soporteTecnicoRepository.getById(2));
        
        System.out.println("\n ------------------------- Soporte Tecnico cuyo puesto sea Ayudante Networking ---------------------------");
        soporteTecnicoRepository.getLikePuesto("Ayudante Networking").forEach(System.out::println);

        
        System.out.println("\n ------------------------- Soporte Tecnico cuya formacion sea de Licenciado --------------------------");
        soporteTecnicoRepository.getLikeFormacion("Licenciatura").forEach(System.out::println);

        
        System.out.println("\n ------------------------- Soporte Tecnico cuya certificacion sea de Cisco Academy--------------------------");
        soporteTecnicoRepository.getLikeCertificaciones("Cisco Academy").forEach(System.out::println);

        
        //---------------------------------------FIN SELECT----------------------------------------------------------
    }
}
