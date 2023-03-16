package tw.taipei.gc.borrowing.usecase.user.register;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface RegisterUserUseCaseOutput extends UseCaseOutput {
    void setID(String ID);
    void setName(String name);
    String getID();
    String getName();
}
