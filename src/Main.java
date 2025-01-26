import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Boolean error = true;

        while (error){

            try{

                System.out.println("Come si chiama questo evento?");
                String title = scanner.nextLine();
    
                System.out.println("dimmi in che anno sarà");
                int year = scanner.nextInt();
    
                System.out.println("dimmi in che mese sarà");
                int month = scanner.nextInt();
    
                System.out.println("dimmi in che giorno sarà");
                int day = scanner.nextInt();
    
                System.out.println("Numero massimo di posti disponibili?");
                int totalSeats = scanner.nextInt();
    
                Event event = new Event(title, year, month, day, totalSeats);
                scanner.nextLine();
                
                error = false;
    
            } catch(IllegalArgumentException e){
                System.out.println("Purtroppo hai inserito valori non validi, riprova");
                scanner.nextLine();
            }catch(java.time.DateTimeException e){
                System.out.println("La data che hai inserito non è corretta");
                scanner.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Attento a non inserire caratteri non numerici quando ti viene richiesto un numero");
                scanner.nextLine();
            }

        }
    }
}
