public class NoteBook extends Product implements IOperation{


    public NoteBook(int id, String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, String memory) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
    }

    public NoteBook() {

    }

    @Override
    public void runMenu() {

    }

    @Override
    public void showProductList() {

    }

    @Override
    public void addProduct() {

    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public void filterByProductId() {

    }

    @Override
    public void filterByProductBrand() {

    }
}
