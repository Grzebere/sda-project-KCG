import java.time.LocalDate;

public class User {
    // wybór wyszukiwania
    System.out.println("Po czym chcesz wyszukać: 1 -> Po reginie, 2 -> Po danych geograicznych");
    Scanner scan = new Scanner(System.in);
    int choice = scan.nextInt();

    // wyszukiwanie po rejonie
    if (choice == 1){
        System.out.println("Podaj miejscowość");
        Scanner scan = new Scanner(System.in);
        String region = scan.nextLine();
    }
    // wyszukiwanie po danych geograficznych
    else if (choice == 2){
        System.out.println("Podaj długość geograficzną");
        Scanner scan = new Scanner(System.in);
        String longitude = scan.nextLine();
        System.out.println("Podaj szerokość geograficzną");
        Scanner scan = new Scanner(System.in);
        String latitude = scan.nextLine();
    }

    // inne
    else{
        System.out.println("podana wartość jest nie poprawna");
    }

    // data
    System.out.println("Podaj date");
    Scanner scan = new Scanner(System.in);
    LocalDate date = scan.nextLine();
}
