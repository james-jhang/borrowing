package tw.taipei.gc.borrowing.usecase.custodian.register;

import tw.taipei.gc.borrowing.usecase.UseCaseInput;

public class RegisterCustodianUseCaseInput implements UseCaseInput {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
