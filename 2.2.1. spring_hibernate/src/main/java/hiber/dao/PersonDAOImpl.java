package hiber.dao;


import hiber.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class PersonDAOImpl implements PersonDAO {


    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    @Override
    public List<Person> index() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Transactional
    @Override
    public Person show(int id) {
        return entityManager.find(Person.class,id);
    }

    @Transactional
    @Override
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    @Override
    public void update(Person updatedPerson) {
        entityManager.merge(updatedPerson);
    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }
}