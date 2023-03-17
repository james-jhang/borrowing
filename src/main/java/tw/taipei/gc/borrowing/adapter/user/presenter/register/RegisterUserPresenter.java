package tw.taipei.gc.borrowing.adapter.user.presenter.register;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.user.register.RegisterUserUseCaseOutput;

public class RegisterUserPresenter implements RegisterUserUseCaseOutput, Presenter<UserViewModel> {
    private String ID;
    private String name;

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public UserViewModel viewModel() {
        return new UserViewModel(ID, name);
    }
}
