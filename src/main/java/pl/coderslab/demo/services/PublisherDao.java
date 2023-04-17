package pl.coderslab.demo.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.coderslab.demo.entities.Publisher;

import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void savePublisher(Publisher publisher) {
        entityManager.persist(publisher);
    }
    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }
    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }
    public void delete(Publisher publisher){
        entityManager.remove(entityManager.contains(publisher)
                ? publisher : entityManager.merge(publisher));
    }
    public List<Publisher> findAllPublishers() {
        Query query = entityManager.createQuery("select p from Publisher p");
        return query.getResultList();
    }
}
