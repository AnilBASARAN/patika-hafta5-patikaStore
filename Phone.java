import java.util.Scanner;
import java.util.ArrayList;
public class Phone extends Product implements IOperation{
    private int camera;
    private int batteryCapacity;
    private String color;

    private static Scanner input = new Scanner(System.in);   // Scanner object for user input
    static ArrayList<Phone> phones = new ArrayList<>();

    public Phone(int id, String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, String memory, int camera, int batteryCapacity, String color) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
        this.camera = camera;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }



    public Phone() {

    }
    static {
        phones.add(new Phone(123,"iPhone 13",35000,0.3,55,"Apple","6.2",32,"512",3,4000,"Red"));
        phones.add(new Phone(343,"Galaxy Mega",25000,0.4,15,"Samsung","7.2",32,"128",2,5000,"Black"));
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Scanner getInput() {
        return input;
    }

    public static void setInput(Scanner input) {
        Phone.input = input;
    }

    public static ArrayList<Phone> getPhones() {
        return phones;
    }

    public static void setPhones(ArrayList<Phone> phones) {
        Phone.phones = phones;
    }

    // Override method to display the list of mobile phones
    @Override
    public void showProductList() {
        System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                "ID", "Ürün ismi", "Fiyat", "Marka", "Hafıza", "Ekran", "RAM", "Batarya", "Renk", "Stok", "İndirim");

        for (Phone phone : phones) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    phone.getId(), phone.getName(), phone.getPrice(), phone.getBrandName(), phone.getMemory(),
                    phone.getScreenSize(), phone.getRam(), phone.getMemory(), phone.getCamera(),
                    phone.getStock(), phone.getDiscountRate());
        }
    }

    // Override method to run the menu for mobile phone management
    @Override
    public void runMenu() {
        Phone mobilePhoneManager = new Phone();

        while (true) {
            System.out.println("\nCep Telefonu Yönetim Paneli");
            System.out.println("1- Cep telefonlarını listeleyin");
            System.out.println("2- Bir cep telefonu ekleyin");
            System.out.println("3- Cep telefonu silin");
            System.out.println("4-  ID ile filtrele");
            System.out.println("5- Marka ile filtrele");
            System.out.println("0- Ana Menu");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    mobilePhoneManager.showProductList();
                    break;
                case "2":
                    mobilePhoneManager.addProduct();
                    break;
                case "3":
                    mobilePhoneManager.deleteProduct();
                    break;
                case "4":
                    System.out.println("Bir ID numarası giriniz");
                    int deletingId = input.nextInt();
                    mobilePhoneManager.findPhoneById(deletingId);
                    break;
                case "5":
                    mobilePhoneManager.filterByProductBrand();
                    break;
                case "0":
                    System.out.println("Ana menüye yönlendiriliyorsunuz.");
                    return;
                default:
                    System.out.println("Hatalı bir değer girildi.");
            }
        }
    }

    // Override method to filter mobile phones by brand
    @Override
    public void filterByProductBrand() {
        System.out.println("Filtrelemek istediğiniz markayı giriniz:");
        String filterBrand = input.next();

        System.out.println("Sonuçlar filtreleniyor:");
        for (Phone phone : phones) {
            if (phone.getBrandName().equalsIgnoreCase(filterBrand)) {
                System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                        phone.getId(), phone.getName(), phone.getPrice(), phone.getBrandName(),
                        phone.getMemory(), phone.getScreenSize(), phone.getRam(), phone.getBatteryCapacity(),
                        phone.getColor(), phone.getStock(), phone.getDiscountRate());
            }
        }
    }

    // Override method to add a new mobile phone to the list
    @Override
    public void addProduct() {
        //1
        System.out.print("Lütfen bir ID girin :  ");
        int newPhoneID = input.nextInt();
        input.nextLine();

        if (findPhoneById(newPhoneID) == null) {

            //2
            System.out.print("Lütfen ürün ismi girin: ");
            String newPhoneName = input.nextLine();
            //3
            System.out.print("Lütfen bir fiyat girin : ");
            int newPhonePrice = input.nextInt();
            //4
            System.out.print("Lütfen bir indirim oranı girin :  ");
            double newPhoneDiscount = input.nextDouble();
            //5
            System.out.print("Lütfen stok bilgisi girin :  ");
            int newPhoneStock = input.nextInt();
            //6
            System.out.print("Lütfen bir marka girin :  ");
            String newPhoneBrand = input.nextLine();
            input.nextLine();
            //7
            System.out.print("Lütfen ekran büyüklüğü girin");
            String newPhoneScreenSize = input.nextLine();


            //8
            System.out.print("Lütfen Ram girin:  ");
            int newPhoneRam = input.nextInt();

            //9
            System.out.print("Lütfen hafıza bilgisi girin :  ");
            String newPhoneMemory = input.nextLine();
            input.nextLine();

            //10
            System.out.print("Lütfen kamera sayısını girin :  ");
            int newPhoneCamNumber = input.nextInt();
            //11
            System.out.print("Lütfen batarya bilgisi girin :  ");
            int newPhoneBatterySize = input.nextInt();
            //12
            System.out.print("Lütfen bir renk girin :  ");
            String newPhoneColor = input.nextLine();


            phones.add(new Phone(newPhoneID, newPhoneName, newPhonePrice, newPhoneDiscount, newPhoneStock, newPhoneBrand,
                    newPhoneScreenSize, newPhoneRam, newPhoneMemory, newPhoneCamNumber, newPhoneBatterySize, newPhoneColor));

            System.out.println("Cep telefonu eklendi.");
            System.out.println("----------------------");

        } else {
            System.out.println("Bu ürün listede zaten var.");
        }
    }


    @Override
    public void deleteProduct() {
        System.out.print("Silmek istediğiniz ürünün ID'sini girin : ");
        int deleteSelection = input.nextInt();

        Phone phoneToDelete = findPhoneById(deleteSelection);

        if (phoneToDelete != null) {
            phones.remove(phoneToDelete);
            System.out.println("Ürün silindi.");

        } else {
            System.out.println("ID bulunamadı");
        }
    }



    // Override method to filter mobile phones by ID
    @Override
    public void filterByProductId() {
        System.out.println("Enter the ID you want to filter:");
        int filterID = input.nextInt();

        Phone filteredPhone = findPhoneById(filterID);

        if (filteredPhone != null) {
            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s%n",
                    "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "RAM", "Battery", "Color", "Stock", "Discount");

            System.out.printf("%-8s %-22s %-12s %-16s %-10s %-6s %-6s %-6s %-6s %-6s %-6s%n",
                    filteredPhone.getId(), filteredPhone.getName(), filteredPhone.getPrice(),
                    filteredPhone.getBrandName(), filteredPhone.getMemory(), filteredPhone.getScreenSize(),
                    filteredPhone.getRam(), filteredPhone.getBatteryCapacity(), filteredPhone.getColor(),
                    filteredPhone.getStock(), filteredPhone.getDiscountRate());
        } else {
            System.out.println("No product found by ID.");
        }
    }

    // Method to find a mobile phone by its ID
    private Phone findPhoneById(int id) {
        for (Phone phone : phones) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }
}