package tw.taipei.gc.borrowing.usecase.item.create;

import tw.taipei.gc.borrowing.usecase.UseCaseInput;

public class CreateItemUseCaseInput implements UseCaseInput {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
