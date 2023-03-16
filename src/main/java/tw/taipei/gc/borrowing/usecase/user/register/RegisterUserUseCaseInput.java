package tw.taipei.gc.borrowing.usecase.user.register;

import tw.taipei.gc.borrowing.usecase.UseCaseInput;

public class RegisterUserUseCaseInput implements UseCaseInput {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
