package spring.jdbc.quickstart.service;

import org.springframework.transaction.annotation.Transactional;
import spring.jdbc.quickstart.dao.ConsumerDao;
import spring.jdbc.quickstart.model.Consumer;

public class ConsumerManager {
    private ConsumerDao consumerDao;

    public void setConsumerDao(ConsumerDao consumerDao) {
        this.consumerDao = consumerDao;
    }

    @Transactional
    public void createNewConsumer(Consumer consumer) {
        consumerDao.createConsumer(consumer);
    }

    @Transactional
    public Consumer readExistingConsumer(int consumerId){
        return consumerDao.readConsumer(consumerId);
    }
}
