package tw.taipei.gc.borrowing.model.common;

import java.util.Date;

public interface DomainEvent {
    int eventVersion();

    Date occurredOn();

    String detail();

    String getSourceID();

    String getSourceName();
}
