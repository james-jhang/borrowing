package tw.taipei.gc.borrowing.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.item.ItemRepository;
import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCase;

@Configuration
public class BeanConfig {

    public DomainEventBus BeanDomainEventBus() {
        return new DomainEventBus();
    }

    public ItemRepository BeanItemRepository() {
        return new InMemoryItemRepository();
    }

    @Bean
    public CreateItemUseCase BeanCreateItemUseCase() {
        return new CreateItemUseCase(BeanItemRepository(), BeanDomainEventBus());
    }
}
