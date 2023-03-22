package tw.taipei.gc.borrowing.adapter.custodian.presenter.register;

public class CustodianViewModel {
    private String custodianID;
    private String name;

    public CustodianViewModel(String custodianID, String name) {
        this.custodianID = custodianID;
        this.name = name;
    }

    public String getCustodianID() {
        return custodianID;
    }

    public void setCustodianID(String ID) {
        this.custodianID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
