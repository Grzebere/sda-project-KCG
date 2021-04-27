import java.text.SimpleDateFormat;
import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        // wybór wyszukiwania
        System.out.println("Po czym chcesz wyszukać: 1 -> Po reginie, 2 -> Po danych geograicznych");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        // wyszukiwanie po rejonie
        if (choice == 1) {
            System.out.println("Podaj miejscowość");
            Scanner scan2 = new Scanner(System.in);
            String region = scan.nextLine();
        }
        // wyszukiwanie po danych geograficznych
        else if (choice == 2) {
            System.out.println("Podaj długość geograficzną"); //podać jak użytkownik ma podawać wartości
            Scanner scan3 = new Scanner(System.in);
            String longitude = scan3.nextLine();
            System.out.println("Podaj szerokość geograficzną");
            Scanner scan4 = new Scanner(System.in);
            String latitude = scan4.nextLine();
        }

        // inne
        else {
            System.out.println("Podana wartość jest nie poprawna");
        }

        // data
        System.out.println("Podaj date (dd, MM, yyyy)");
        Scanner input = new Scanner(System.in);
        String  date = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd, MM, yyyy");
        String date1String = date;
        System.out.println(date);
    }
}