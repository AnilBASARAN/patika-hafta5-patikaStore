import java.util.Scanner;

public class PatikaStore {
    Scanner input = new Scanner(System.in);

    boolean isRunning = true;
    public void run(){
        while (isRunning){
            System.out.println("Patika Store Yönetim Paneli");
            System.out.println("1-NoteBook işlemleri  \n" +
                    "2- Cep telefonu işlemleri  \n"+
                    "3- Markaları listeleme  \n" +
                    "0 Çıkış yap");
            System.out.print("Yapmak istediğiniz işlemi seçiniz  :  ");

            String selection = input.nextLine();

            switch (selection){
                case "1":
                    NoteBook noteBook = new NoteBook();
                    noteBook.runMenu();
                    break;
                case "2":
                    Phone phone = new Phone();
                    phone.runMenu();
                    break;
                case "3":
                    Brand brand = new Brand();
                     brand.printBrand();
                    break;
                case "0":
                    System.out.println("Çıkış yapıldı");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Hatalı değer girdiniz");
            }
        }
    }
}
