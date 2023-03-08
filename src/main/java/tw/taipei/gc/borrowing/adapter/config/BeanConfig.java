package tw.taipei.gc.borrowing.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;
import tw.taipei.gc.borrowing.usecase.item.ItemRepository;
import tw.taipei.gc.borrowing.adapter.item.repository.InMemoryItemRepository;
import tw.taipei.gc.borrowing.usecase.item.create.CreateItemUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.listall.ListAllItemsUseCase;
import tw.taipei.gc.borrowing.usecase.item.query.byid.QueryItemByIDUseCase;

@Configuration
public class BeanConfig {

    @Bean
    public DomainEventBus BeanDomainEventBus() {
        return new DomainEventBus();
    }

    @Bean
    public ItemRepository BeanItemRepository() {
        return new InMemoryItemRepository();
    }

    @Bean
    public CreateItemUseCase BeanCreateItemUseCase() {
        return new CreateItemUseCase(BeanItemRepository(), BeanDomainEventBus());
    }

    @Bean
    public ListAllItemsUseCase BeanFindAllItemsUseCase() {
        return new ListAllItemsUseCase(BeanItemRepository(), BeanDomainEventBus());
    }

    @Bean
    public QueryItemByIDUseCase BeanQueryItemByIDUseCase() {
        return new QueryItemByIDUseCase(BeanItemRepository(), BeanDomainEventBus());
    }
}
