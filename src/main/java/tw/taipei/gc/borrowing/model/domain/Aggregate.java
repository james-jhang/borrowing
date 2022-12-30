package tw.taipei.gc.borrowing.model.domain;

import java.util.List;

public interface Aggregate {

    void addDomainEvent(DomainEvent event);

    List<DomainEvent> getDomainEvents();

    void clearDomainEvents();
}
