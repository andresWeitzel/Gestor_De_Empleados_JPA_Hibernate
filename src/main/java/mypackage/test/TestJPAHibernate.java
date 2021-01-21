
package mypackage.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestJPAHibernate {
    public static void main(String[] args) {
        
        //persistence unit name dentro del persistence.xml
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("mypackage_GestorEmpleadosJPAHibernate_app_jar_1.0-SNAPSHOTPU");
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManagerFactory.close();
    
    }
}
