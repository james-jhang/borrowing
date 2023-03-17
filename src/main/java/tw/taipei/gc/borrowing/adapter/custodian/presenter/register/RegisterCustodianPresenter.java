package tw.taipei.gc.borrowing.adapter.custodian.presenter.register;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.custodian.register.RegisterCustodianUseCaseOutput;

public class RegisterCustodianPresenter implements RegisterCustodianUseCaseOutput, Presenter<CustodianViewModel> {

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
    public CustodianViewModel viewModel() {
        return new CustodianViewModel(this.ID, this.name);
    }
}
