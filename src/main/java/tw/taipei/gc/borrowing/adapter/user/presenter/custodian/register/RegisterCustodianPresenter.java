package tw.taipei.gc.borrowing.adapter.user.presenter.custodian.register;

import tw.taipei.gc.borrowing.usecase.user.custodian.register.RegisterCustodianUseCaseOutput;

public class RegisterCustodianPresenter implements RegisterCustodianUseCaseOutput {

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

    public CustodianViewModel viewModel() {
        return new CustodianViewModel(this.ID, this.name);
    }
}
