package hibernate.jpa.spring.quickstart.dao;

import hibernate.jpa.spring.quickstart.model.Person;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PersonDAOTest {
    private static ClassPathXmlApplicationContext context;
    @BeforeClass
    public static void setUp(){
        context = new ClassPathXmlApplicationContext("hibernate-quickstart-beans.xml");
    }

    @AfterClass
    public static void tearDown(){
        if(context != null && context.isActive()){
            context.close();
        }
    }

}
