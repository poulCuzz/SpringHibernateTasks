package pl.coderslab.demo.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.coderslab.demo.entities.Author;
import pl.coderslab.demo.entities.Book;
import pl.coderslab.demo.entities.Publisher;

import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {

        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }
    public List<Book> findAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }
    public List<Book> findAllByRating(int rating) {
        Query query = entityManager.createQuery("select b from Book b where b.rating = " + rating);
        return query.getResultList();
    }
    public List<Book> findWithPublisher() {
        Query query = entityManager.createQuery("SELECT b FROM Book b where b.publisher IS NOT null");
        return query.getResultList();
    }
    public List<Book> findByPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("select b from Book b where b.publisher = :publisher");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }
    public List<Book> findByAuthor(Author author) {
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.authors a WHERE a = :author");
        query.setParameter("author", author);
        return query.getResultList();
    }

}
