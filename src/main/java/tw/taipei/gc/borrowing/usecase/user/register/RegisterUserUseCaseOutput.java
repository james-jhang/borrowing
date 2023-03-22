package tw.taipei.gc.borrowing.usecase.user.register;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface RegisterUserUseCaseOutput extends UseCaseOutput {
    void setUserID(String userID);
    void setName(String name);
    String getUserID();
    String getName();
}
