import java.time.LocalDateTime;
import java.time.Month;

public class App {
    public static void main(String[] args) throws Exception {

        // Recupero la data e l'ora del sistema
        LocalDateTime datetime = LocalDateTime.now();
        System.out.println("Data e ora attuale: " + datetime);

        // Creo una data e un'ora specifica
        datetime = LocalDateTime.of(2015, 2, 20, 06, 30);
        System.out.println("Data e ora impostata: " + datetime);
        datetime = LocalDateTime.parse("2015-02-20T06:30:00");
        System.out.println("Data e ora impostata: " + datetime);

        // Modifico la data e l'ora
        datetime = LocalDateTime.now().plusDays(1);
        System.out.println("Data e ora di domani: " + datetime);
        datetime = LocalDateTime.now().minusHours(2);
        System.out.println("Data e ora di due ore fa: " + datetime);

        int day = LocalDateTime.now().getDayOfMonth();
        int month = LocalDateTime.now().getMonthValue();
        int year = LocalDateTime.now().getYear();
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();
        int second = LocalDateTime.now().getSecond();
        System.out.println("Oggi è il " + day + "/" + month + "/" + year + " e sono le " + hour + ":" + minute + ":" + second);
    }
}
