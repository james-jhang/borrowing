package tw.taipei.gc.borrowing.usecase.user.member.register;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface RegisterMemberUseCaseOutput extends UseCaseOutput {
    void setID(String ID);
    void setName(String name);
    String getID();
    String getName();
}
