package tw.taipei.gc.borrowing.usecase.item.create;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface CreateItemUseCaseOutput extends UseCaseOutput {

    void setID(String ID);

    String getID();

    void setName(String name);

    String getName();
}
