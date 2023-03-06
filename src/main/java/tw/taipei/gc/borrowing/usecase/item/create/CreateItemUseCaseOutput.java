package tw.taipei.gc.borrowing.usecase.item.create;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface CreateItemUseCaseOutput extends UseCaseOutput {

    public void setID(String ID);

    public String getID();

    public void setName(String name);

    public String getName();
}
