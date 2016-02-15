package spring.jdbc.quickstart.service;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import spring.jdbc.quickstart.model.Address;
import spring.jdbc.quickstart.model.Consumer;

public class ConsumerManagerTest {

    private static ClassPathXmlApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring-jdbc-quickstart-beans.xml");
    }

    @AfterClass
    public static void afterClass(){
        if(context != null && context.isActive()){
            context.close();
        }
    }

    @Test
    public void testConsumerManager(){
        ConsumerManager consumerManager = context.getBean("consumerManager", ConsumerManager.class);

        Consumer consumer = createTestConsumer(1, "Fizz", "US", "FizzBuzz");
        consumerManager.createNewConsumer(consumer);

        Consumer savedConsumer = consumerManager.readExistingConsumer(2);
        Assert.assertNotNull(savedConsumer);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testConsumerManagerRollback(){
        ConsumerManager consumerManager = context.getBean("consumerManager", ConsumerManager.class);

        Consumer consumer = createTestConsumer(3, "Fizz", "US", "FizzBuzz, FizzBuzz2, FizzBuzz3, FizzBuzz4");
        consumerManager.createNewConsumer(consumer);
    }

    private static Consumer createTestConsumer(final int id, final String name, final String country, final String addressLine) {
        return new Consumer(){{
            setId(id);
            setName(name);
            setAddress(new Address(){{
                setId(id);
                setCountry(country);
                setAddress(addressLine);
            }});
        }};
    }
}
