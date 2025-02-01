import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;


public final class Utility {
    
    public static  String askEventName(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Come si chiama questo evento?");
        String title = scanner.nextLine();
        return title;
    }


    public static LocalDate askDate(){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{

                System.out.println("In che data si terrà l'evento? (Usa questo formato: dd/mm/yyyy)");
                String date = scanner.nextLine();
                String[] dateParts = date.split("/");

                LocalDate finalDate = LocalDate.of(
                    Integer.parseInt(dateParts[2]),
                    Integer.parseInt(dateParts[1]),
                    Integer.parseInt(dateParts[0])
                );

                if(isPast(finalDate)){
                    System.out.println("Per favore inserisci una data futura");
                }else{
                    return finalDate;
                }

            }catch(DateTimeException e){
            System.out.println("Per favore inserisci una data valida.");
            }catch(Exception e){
                System.out.println("Per favore utilizza il formato corretto.");
            }
        }   
    }


    public static int askTotalSeats(){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
                System.out.println("Numero massimo di posti disponibili?");
                int totalSeats = scanner.nextInt();
                scanner.nextLine();
                if (totalSeats > 0) {
                    return totalSeats;
                }else{
                    System.out.println("Il numero di posti deve essere maaggiore di 0");
                }
            }catch(Exception e){
                System.out.println("Per favore inserisci un valore valido.");
                scanner.nextLine();
            }
        }
    }


    public static LocalTime askHours(){

        Scanner scanner = new Scanner(System.in);

        while (true) {

            try{
                System.out.println("A che ora si svolgerà il concerto? (usa questo formato: hh:mm)");
                String hour = scanner.nextLine();
    
                LocalTime finalHour = LocalTime.parse(hour, DateTimeFormatter.ofPattern("H:mm"));
                
                return finalHour;
            }catch(Exception e){
                System.out.println("Per favore inserisci un orario valido.");
            }
        }
    }


    public static double askPrice(){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            try{
                System.out.print("Quanto costa il biglietto?");
                double price = scanner.nextDouble();
                scanner.nextLine();
                price = Math.round(price * 100.0) / 100.0;
                if (price > 0) {
                    return price;
                }else{
                    System.out.println("Il prezzo del biglietto deve essere maggiore di 0.");
                }
            }catch(Exception e){
                System.out.println("Per favore inserisci un prezzo valido");
                scanner.nextLine();
            }
        }
    }


    public static void askToBook(Event event){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
                System.out.println("Quanti posti vuoi prenotare?");
                int seatsToBook = scanner.nextInt();
                scanner.nextLine();
    
                if (seatsToBook < 1) {
                    System.out.println("Il numero di posti da prenotare deve essere maggiore di 0.");
                }else if (seatsToBook <= event.getAvailableSeats()) {
                    event.book(seatsToBook);
                    break;
                }else{
                    System.out.println("Purtroppo il numero massimo di posti disponibili è " + event.getAvailableSeats());
                }
            }catch(Exception e){
                System.out.println("per favore inserisci un valore valido.");
                scanner.nextLine();
            }
            

        }
    }


    public static void askToUnbook(Event event){

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
                System.out.println("Quanti posti vuoi disdire?");
                int seatsToUnook = scanner.nextInt();
                scanner.nextLine();

                if (seatsToUnook < 1) {
                    System.out.println("Il numero di posti da disdire deve essere maggiore di 0.");
                }else if (seatsToUnook <= event.getBookedSeats()) {
                    event.unbook(seatsToUnook);
                    break;
                }else{
                    System.out.println("Purtroppo il numero massimo di posti che si possono disdire è " + event.getBookedSeats());
                }
            }catch(Exception e){
                System.out.println("per favore inserisci un valore valido.");
                scanner.nextLine();
            }
            

        }
    }


    public static boolean isPast (LocalDate date){
        LocalDate today = LocalDate.now();
        return today.isAfter(date);
    }
}
