package tw.taipei.gc.borrowing.adapter.user.presenter.register;

public class UserViewModel {
    private final String userID;
    private final String name;

    public UserViewModel(String userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getName() {
        return this.name;
    }
}
