package tw.taipei.gc.borrowing.adapter.custodian.presenter.register;

import tw.taipei.gc.borrowing.adapter.Presenter;
import tw.taipei.gc.borrowing.usecase.custodian.register.RegisterCustodianUseCaseOutput;

public class RegisterCustodianPresenter implements RegisterCustodianUseCaseOutput, Presenter<CustodianViewModel> {

    private String custodianID;
    private String name;

    @Override
    public void setCustodianID(String custodianID) {
        this.custodianID = custodianID;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCustodianID() {
        return this.custodianID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public CustodianViewModel viewModel() {
        return new CustodianViewModel(this.custodianID, this.name);
    }
}
