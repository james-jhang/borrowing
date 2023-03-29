package tw.taipei.gc.borrowing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tw.taipei.gc.borrowing.adapter.custodian.repository.InMemoryCustodianRepository;
import tw.taipei.gc.borrowing.adapter.custodian.repository.MySQLCustodianRepository;
import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;
import tw.taipei.gc.borrowing.adapter.item.repository.MySQLItemRepository;
import tw.taipei.gc.borrowing.adapter.user.repository.InMemoryUserRepository;
import tw.taipei.gc.borrowing.adapter.user.repository.MySQLUserRepository;
import tw.taipei.gc.borrowing.usecase.custodian.repository.CustodianRepository;
import tw.taipei.gc.borrowing.usecase.item.repository.ItemRepository;
import tw.taipei.gc.borrowing.usecase.user.repository.UserRepository;


@Configuration
public class RepositoryFactory {

    Logger logger = LoggerFactory.getLogger(RepositoryFactory.class);

    @Value("${borrowing.db.mode:InMemory}")
    private String DBMode;

    @Bean
    public ItemRepository getItemRepository() {
        if (DBMode.equals("MySQL")) {
            logger.info("Init MySQL item repository.");
            return new MySQLItemRepository();
        } else {
            logger.info("Init in-memory item repository.");
            return new InMemoryItemRepository();
        }
    }

    @Bean
    public UserRepository getUserRepository() {
        if (DBMode.equals("MySQL")) {
            logger.info("Init MySQL user repository.");
            return new MySQLUserRepository();
        } else {
            logger.info("Init in-memory user repository.");
            return new InMemoryUserRepository();
        }
    }

    @Bean
    public CustodianRepository getCustodianRepository() {
        if (DBMode.equals("MySQL")) {
            logger.info("Init MySQL custodian repository.");
            return new MySQLCustodianRepository();
        } else {
            logger.info("Init in-memory custodian repository.");
            return new InMemoryCustodianRepository();
        }
    }
}
