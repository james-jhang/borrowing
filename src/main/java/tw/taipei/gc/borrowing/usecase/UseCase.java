package tw.taipei.gc.borrowing.usecase;

import tw.taipei.gc.borrowing.model.common.DomainEventBus;

public abstract class UseCase<I extends UseCaseInput, O extends UseCaseOutput> {
    protected DomainEventBus eventBus;
    public UseCase() {}

    public UseCase(DomainEventBus eventBus) {
        this.eventBus = eventBus;
    }

    public abstract void execute(I input, O output);
}