package tw.taipei.gc.borrowing.model.common;

import java.util.ArrayList;
import java.util.List;

import com.google.common.eventbus.EventBus;

public class DomainEventBus extends EventBus {

    public DomainEventBus() {
        super();
    }

    public void postAll(Aggregate aggregate) {
        List<DomainEvent> events = new ArrayList<>(aggregate.getDomainEvents());
        aggregate.clearDomainEvents();

        for (DomainEvent each : events) {
            post(each);
        }
        events.clear();
    }
}
