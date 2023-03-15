package tw.taipei.gc.borrowing.adapter.user.presenter.custodian.register;

public class CustodianViewModel {
    private String ID;
    private String name;

    public CustodianViewModel(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
