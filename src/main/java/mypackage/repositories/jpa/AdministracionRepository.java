
package mypackage.repositories.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mypackage.entities.Administracion;
import mypackage.entities.Desarrollador;
import mypackage.repositories.interfaces.I_AdministracionRepository;


public class AdministracionRepository implements I_AdministracionRepository {

    
    private EntityManagerFactory entityManagerFactory;
    
    
    public AdministracionRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    
    
    
    @Override
    public void save(Administracion administracion) {
    
        if(administracion == null){
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(administracion);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();

    }
    @Override
    public void remove(Administracion administracion) {
        
        if(administracion == null){
            return;
        }
    
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.remove(entityManager.merge(administracion));
        
        entityManager.getTransaction().commit();
        
        entityManager.close();

        
    }
    @Override
    public void update(Administracion administracion) {
        
        if(administracion == null){
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(entityManager.merge(administracion));
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
    }
    @Override
    public List<Administracion> getAll() {
    
        
        List<Administracion> listaAdministradores=new ArrayList<>();
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        listaAdministradores=(List<Administracion>)entityManager.createNamedQuery("Administracion.findAll").getResultList();
        
       entityManager.close();
       
       return listaAdministradores;
    }
}
