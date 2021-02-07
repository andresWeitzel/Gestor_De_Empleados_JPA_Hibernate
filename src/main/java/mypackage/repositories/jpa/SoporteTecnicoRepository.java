
package mypackage.repositories.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mypackage.entities.Empleado;
import mypackage.entities.SoporteTecnico;
import mypackage.repositories.interfaces.I_SoporteTecnicoRepository;


public class SoporteTecnicoRepository implements I_SoporteTecnicoRepository {
    
        private EntityManagerFactory entityManagerFactory;
   
        public SoporteTecnicoRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
        
        

    @Override
    public void save(SoporteTecnico soporteTecnico) {
        
        if (soporteTecnico == null) {
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(soporteTecnico);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();

    
    }
    @Override
    public void remove(SoporteTecnico soporteTecnico) {
if (soporteTecnico == null) {
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.remove(entityManager.merge(soporteTecnico));
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
    }
    @Override
    public void update(SoporteTecnico soporteTecnico) {
        
        if (soporteTecnico == null) {
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(entityManager.merge(soporteTecnico));
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
}
    @Override
    public List<SoporteTecnico> getAll() {
        List<SoporteTecnico> listaSoporteTecnico=new ArrayList<>();
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        listaSoporteTecnico=(List<SoporteTecnico>)entityManager.createNamedQuery("SoporteTecnico.findAll").getResultList();
        
       entityManager.close();
       
       return listaSoporteTecnico;
}

}
