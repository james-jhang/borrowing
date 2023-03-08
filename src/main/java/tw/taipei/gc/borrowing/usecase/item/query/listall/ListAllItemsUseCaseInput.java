package tw.taipei.gc.borrowing.usecase.item.query.listall;

import tw.taipei.gc.borrowing.usecase.UseCaseInput;

public class ListAllItemsUseCaseInput implements UseCaseInput {
    private String id;

    public String getID() {
        return this.id;
    }
}
