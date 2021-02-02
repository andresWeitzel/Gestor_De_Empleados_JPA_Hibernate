package mypackage.repositories.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import mypackage.entities.Empleado;
import mypackage.repositories.interfaces.I_EmpleadoRepository;

public class EmpleadoRepository implements I_EmpleadoRepository {

    private EntityManagerFactory entityManagerFactory;

    public EmpleadoRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Empleado empleado) {

        if (empleado == null) {
            return;
        }
        
        /*De aca en adelante lo que hacemos en abrir la factoria de HIBERNATE para las 
        entidades, e inicializar y cerrar las transacciones por cada vez que se invoque este metodo,
        lo mismo ocurre con el resto de los metodos
        */
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(empleado);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();

    }
    @Override
    public void remove(Empleado empleado) {

        if (empleado == null) {
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.remove(entityManager.merge(empleado));
        
        entityManager.getTransaction().commit();
        
        entityManager.close();

    }
    @Override
    public void update(Empleado empleado) {

        if (empleado == null) {
            return;
        }
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(entityManager.merge(empleado));
        
        entityManager.getTransaction().commit();
        
        entityManager.close();

    }
    @Override
    public List<Empleado> getAll() {

        List<Empleado> listaEmpleados=new ArrayList<>();
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        listaEmpleados=(List<Empleado>)entityManager.createNamedQuery("Empleado.findAll").getResultList();
        
       entityManager.close();
       
       return listaEmpleados;

}
    
}
