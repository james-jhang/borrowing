package tw.taipei.gc.borrowing.adapter.user.presenter.register;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.user.register.RegisterUserUseCaseOutput;

public class RegisterUserPresenter implements RegisterUserUseCaseOutput, Presenter<UserViewModel> {
    private String userID;
    private String name;

    @Override
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUserID() {
        return this.userID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public UserViewModel viewModel() {
        return new UserViewModel(userID, name);
    }
}
