package tw.taipei.gc.borrowing.adapter.user.presenter.register;

public class UserViewModel {
    private final String ID;
    private final String name;

    public UserViewModel(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }
}
