package mypackage.test;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mypackage.entities.Empleado;

public class TestJPAHibernate {

    public static void main(String[] args) {

        //persistence unit name dentro del persistence.xml en Other Sources
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mypackage_GestorEmpleadosJPAHibernate_app_jar_1.0-SNAPSHOTPU");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Porque hay un campo de nuestra db que esta como type DATE
        Date fechaActual = new Date();

        Empleado empleado01 = new Empleado("Juan", "Marconi", 26, "Masculino", "Pasaporte", "34343434", " asda@gmail.com", "23232323", fechaActual, 48, 54000f);

        //Hibernate para las operaciones CRUD de DB trabaja con transacciones
        entityManager.getTransaction().begin();

        //El metodo persist guarda cualquier entidad mapeable y esta registrada en la unidad de persistencia 
        entityManager.persist(empleado01);

        System.out.println("\n-------------------------------------------TOTAL DE EMPLEADOS---------------------------------------------\n");
        //Aplicamos los NamedQuery junto con los metodos e imprimimos la lista
        entityManager.createNamedQuery("Empleado.findAll").getResultList().forEach(System.out::println);

        System.out.println("\n------------------------------------------- EMPLEADOS CUYO APELLIDO SEA MARCONI---------------------------------------------\n");
        //Con el setParameter hay que indicarle el nombre del campo y el valor
        entityManager.createNamedQuery("Empleado.findByApellido").setParameter("apellido", "Marconi").getResultList().forEach(System.out::println);

        //Terminamos la transaccion
        entityManager.getTransaction().commit();

        //Visualizamos nuestro objeto
        System.out.println(empleado01);

        //Cerramos el manager
        entityManager.close();

        //Cerramos nuestra Factoria
        entityManagerFactory.close();

    }
}
