package tw.taipei.gc.borrowing.model.common;

import java.util.List;

public interface Aggregate {

    void addDomainEvent(DomainEvent event);

    List<DomainEvent> getDomainEvents();

    void clearDomainEvents();
}
