package hibernate.jpa.spring.quickstart.service;

import hibernate.jpa.spring.quickstart.dao.PersonDAO;
import hibernate.jpa.spring.quickstart.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonDAO personDAO;

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional
    public void addPerson(Person p) {
        this.personDAO.addPerson(p);
    }

    @Transactional
    public void updatePerson(Person p) {
        this.personDAO.updatePerson(p);
    }

    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }

    @Transactional
    public Person getPersonById(int id) {
        return this.personDAO.getPersonById(id);
    }

    @Transactional
    public void removePerson(int id) {
        this.personDAO.removePerson(id);
    }
}
