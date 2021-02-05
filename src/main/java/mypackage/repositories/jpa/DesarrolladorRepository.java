
package mypackage.repositories.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mypackage.entities.Desarrollador;
import mypackage.repositories.interfaces.I_DesarrolladorRepository;


public class DesarrolladorRepository implements I_DesarrolladorRepository {

    private EntityManagerFactory entityManagerFactory;
    
    
    public DesarrolladorRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    
    
    
    @Override
    public void save(Desarrollador desarrollador) {
    
        if(desarrollador == null){
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(desarrollador);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();

    }
    @Override
    public void remove(Desarrollador desarrollador) {
        
        if(desarrollador == null){
            return;
        }
    
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.remove(entityManager.merge(desarrollador));
        
        entityManager.getTransaction().commit();
        
        entityManager.close();

        
    }
    @Override
    public void update(Desarrollador desarrollador) {
        
        if(desarrollador == null){
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(entityManager.merge(desarrollador));
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
    }
    @Override
    public List<Desarrollador> getAll() {
    
        
        List<Desarrollador> listaDesarrolladores=new ArrayList<>();
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        listaDesarrolladores=(List<Desarrollador>)entityManager.createNamedQuery("Desarrollador.findAll").getResultList();
        
       entityManager.close();
       
       return listaDesarrolladores;
    }

}
