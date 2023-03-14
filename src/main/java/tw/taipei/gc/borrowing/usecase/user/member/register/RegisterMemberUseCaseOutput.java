package tw.taipei.gc.borrowing.usecase.user.member.register;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface RegisterMemberUseCaseOutput extends UseCaseOutput {
    public void setID(String ID);
    public void setName(String name);
    public String getID();
    public String getName();
}
