package tw.taipei.gc.borrowing.usecase.custodian.register;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

public interface RegisterCustodianUseCaseOutput extends UseCaseOutput {
    void setCustodianID(String custodianID);
    void setName(String name);
    String getCustodianID();
    String getName();
}
