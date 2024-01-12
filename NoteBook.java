import java.util.ArrayList;
import java.util.Scanner;

public class NoteBook extends Product implements IOperation{
    private static int id= 1;

    Scanner input = new Scanner(System.in);

    boolean isOn = true;

    private static ArrayList<NoteBook> notebooks = new ArrayList<>();


    public NoteBook( int id,String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, int memory) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, String.valueOf(memory));
    }

    public NoteBook() {

    }

    // Static block to initialize a set of default notebooks
    static {
        notebooks.add(new NoteBook(315,"Apple",25000, 0.25, 50, "M1", "8" , 13, 512));
        notebooks.add(new NoteBook(541,"MateBook",20000, 0.10, 75,  "Huawei","8" , 14, 512));
        notebooks.add(new NoteBook(112,"Nirvana",20000, 0.10, 25,  "Casper", "8", 14, 128));
    }

    // Override method to display the list of notebooks
    @Override
    public void showProductList() {
        System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s  %-6s%n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "RAM", "Stock", "Discount");

        for (NoteBook notebook : notebooks) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s  %-6s%n",
                    notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrandName(),
                    notebook.getMemory(), notebook.getScreenSize(), notebook.getRam(), notebook.getStock(),
                    notebook.getDiscountRate());
        }
    }


    @Override
    public void runMenu() {
        NoteBook noteBookManager = new NoteBook();
   while (isOn){
       System.out.println("NoteBook Yönetim Paneli");
       System.out.println("1-NoteBook ekleme  \n" +
               "2- NoteBook silme  \n"+
               "3- Idye göre filtreleme  \n" +
               "4- Markaya göre filtreleme  \n" +
               "5- INotebook listeleme  \n" +
               "0 Çıkış yap");
       System.out.print("Yapmak istediğiniz işlemi seçiniz  :  ");


       String choice = input.nextLine();

       switch (choice) {
           case "1":
               noteBookManager.addProduct();
               break;
           case "2":
               noteBookManager.deleteProduct();
               break;
           case "3":
               noteBookManager.filterByProductId();
               break;
           case "4":
               noteBookManager.filterByProductBrand();
               break;
           case "5":
               noteBookManager.showProductList();
               break;
           case "0":
               System.out.println("Returning to the main menu.");
               return;
           default:
               System.out.println("Invalid option. Please try again.");
       }
   }
    }

    // Override method to add a new notebook to the list
    @Override
    public void addProduct() {
        System.out.print("Lütfen bir ID girin:");
        int newNotebookID = input.nextInt();
        input.nextLine();

        if (findNotebookById(newNotebookID) == null) {
            System.out.print("Lütfen ürün ismi girin: ");
            String newNotebookName = input.nextLine();

            System.out.print("Lütfen bir marka girin :  ");
            String newNotebookBrand = input.nextLine();

            System.out.print("Lütfen bir fiyat girin : ");
            int newNotebookPrice = input.nextInt();

            System.out.print("Lütfen bir indirim oranı girin :  ");
            double newNotebookDiscount = input.nextDouble();

            System.out.print("Lütfen stok bilgisi girin :  ");
            int newNotebookStock = input.nextInt();

            System.out.print("Lütfen hafıza bilgisi girin :  ");
            int newNotebookMemorySize = input.nextInt();


            System.out.print("Lütfen ekran büyüklüğü girin");
            String newNotebookScreenSize = input.nextLine();
            input.nextLine();

            System.out.print("Lütfen Ram girin:  ");
            int newNotebookRam = input.nextInt();


        // notebooks.add(new NoteBook("Apple",25000, 0.25, 50, "M1", "8" , 13, "512"));




            notebooks.add(new NoteBook(newNotebookID,newNotebookName,newNotebookPrice,newNotebookDiscount,newNotebookStock,newNotebookBrand,newNotebookScreenSize,newNotebookRam,newNotebookMemorySize));

            System.out.println("Laptop eklendi.");
            System.out.println("----------------------");

        } else {
            System.out.println("Bu ürün zaten ekli");
        }
    }

    // Override method to delete a notebook from the list
    @Override
    public void deleteProduct() {
        System.out.print("Silmek istediğiniz ürünün ID'sini girin : ");
        int deleteSelection = input.nextInt();

        NoteBook notebookToDelete = findNotebookById(deleteSelection);

        if (notebookToDelete != null) {
            notebooks.remove(notebookToDelete);
            System.out.println("Ürün silindi.");
        } else {
            System.out.println("ID bulunamadı.");
        }
    }

    @Override
    public void filterByProductId() {

    }

    @Override
    public void filterByProductBrand() {

    }

    // Method to find a notebook by its ID
    private NoteBook findNotebookById(int id) {
        for (NoteBook notebook : notebooks) {
            if (notebook.getId() == id) {
                return notebook;
            }
        }
        return null;
    }
}