package hibernate.jpa.spring.quickstart.dao;

import hibernate.jpa.spring.quickstart.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void addPerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Person Details="+p);
    }

    public void updatePerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Person updated successfully, Person Details="+p);
    }

    @SuppressWarnings("unchecked")
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        for(Person p : personsList){
            logger.info("Person List::"+p);
        }
        return personsList;
    }

    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = session.load(Person.class, id);
        logger.info("Person loaded successfully, Person details="+p);
        return p;
    }

    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = session.load(Person.class, id);
        if(null != p){
            session.delete(p);
        }
        logger.info("Person deleted successfully, person details="+p);
    }
}
