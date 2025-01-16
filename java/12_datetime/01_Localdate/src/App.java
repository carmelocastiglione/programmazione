import java.time.DayOfWeek;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        // Leggo la data dal sistema nel formato yyyy-mm-dd
        LocalDate localDate = LocalDate.now();
        System.out.println("Data corrente: " + localDate);
        // Creo la data per domani
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println("Data corrente: " + tomorrow);
        // Creo una data specifica
        localDate = LocalDate.of(2015, 02, 20);
        System.out.println("Data corrente: " + localDate);
        localDate = LocalDate.parse("2015-02-20");
        System.out.println("Data corrente: " + localDate);

        // Parsing della data
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        int dayNum = LocalDate.now().getDayOfMonth();
        int monthNum = LocalDate.now().getMonthValue();
        int yearNum = LocalDate.now().getYear();
        System.out.println("Data corrente: " + day + " " + dayNum + "/" + monthNum + "/" + yearNum);

        // Controllo se l'anno è bisestile
        boolean leapYear = LocalDate.now().isLeapYear();
        System.out.println("Anno bisestile: " + leapYear);

        // Controllo se una data è prima o dopo un'altra
        boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
        boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));
        System.out.println("Data non prima: " + notBefore);
        System.out.println("Data dopo: " + isAfter);
    }
}
