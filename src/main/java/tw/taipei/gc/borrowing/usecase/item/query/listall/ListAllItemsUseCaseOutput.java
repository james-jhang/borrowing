package tw.taipei.gc.borrowing.usecase.item.query.listall;

import tw.taipei.gc.borrowing.usecase.UseCaseOutput;

import java.util.List;

public interface ListAllItemsUseCaseOutput extends UseCaseOutput {
    public void addItem(String ID, String name);

    public List<ItemViewObject> results();

    public static class ItemViewObject {
        private String ID;
        private String name;

        public ItemViewObject(String ID, String name) {
            this.ID = ID;
            this.name = name;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getID() {
            return this.ID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}