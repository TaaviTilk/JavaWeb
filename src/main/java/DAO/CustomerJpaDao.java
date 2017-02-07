package DAO;

import model.Vorm;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerJpaDao implements  CustomerDao {


    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Vorm vorm) {
        if (vorm.getId() == null) {
            em.persist(vorm);
        } else {
            em.merge(vorm);
        }
    }

    public List<Vorm> findAll() {
        return em.createQuery("SELECT p FROM Vorm p", Vorm.class)
                .getResultList();
    }

    @Transactional
    public void delete(int id) {
        em.createQuery("DELETE FROM Vorm p WHERE p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void deleteAll() {
        em.createQuery("DELETE FROM Vorm p")
                .executeUpdate();
    }

    public Vorm findById(int id) {
        return em.createQuery("SELECT p FROM Vorm p WHERE id = :id", Vorm.class)
                .setParameter("id", id)
                .getSingleResult();

    }


    public List<Vorm> findByKey(String key) {
        TypedQuery<Vorm> vorm = em.createQuery("SELECT p FROM Vorm p WHERE (LOWER(p.firstName) LIKE LOWER(:key) OR LOWER(p.lastName) LIKE LOWER(:key)", Vorm.class);
        vorm.setParameter("key", '%'+key+'%');
        return vorm.getResultList();
    }



}
