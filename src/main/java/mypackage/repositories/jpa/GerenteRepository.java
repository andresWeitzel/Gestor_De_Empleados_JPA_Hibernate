
package mypackage.repositories.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mypackage.entities.Gerente;
import mypackage.entities.SoporteTecnico;
import mypackage.repositories.interfaces.I_GerenteRepository;


public class GerenteRepository implements I_GerenteRepository {
    
    
        private EntityManagerFactory entityManagerFactory;
   
        public GerenteRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
        
        

    @Override
    public void save(Gerente gerente) {
        
        if (gerente == null) {
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(gerente);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();

    
    }
    @Override
    public void remove(Gerente gerente) {
if (gerente == null) {
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.remove(entityManager.merge(gerente));
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
    }
    @Override
    public void update(Gerente gerente) {
        
        if (gerente == null) {
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(entityManager.merge(gerente));
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
}
    @Override
    public List<Gerente> getAll() {
        List<Gerente> listaGerente=new ArrayList<>();
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        listaGerente=(List<Gerente>)entityManager.createNamedQuery("Gerente.findAll").getResultList();
        
       entityManager.close();
       
       return listaGerente;
}


}
