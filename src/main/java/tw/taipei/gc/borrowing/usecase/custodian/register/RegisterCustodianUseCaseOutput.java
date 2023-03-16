package tw.taipei.gc.borrowing.usecase.custodian.register;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface RegisterCustodianUseCaseOutput extends UseCaseOutput {
    void setID(String ID);
    void setName(String name);
    String getID();
    String getName();
}
