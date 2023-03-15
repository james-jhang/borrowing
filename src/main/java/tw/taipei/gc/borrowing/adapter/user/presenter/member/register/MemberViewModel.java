package tw.taipei.gc.borrowing.adapter.user.presenter.member.register;

public class MemberViewModel {
    private final String ID;
    private final String name;

    public MemberViewModel(String ID, String name) {
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
