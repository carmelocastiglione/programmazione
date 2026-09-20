import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {

        // Stampa l'ora attuale
        LocalTime now = LocalTime.now();
        System.out.println("Ora attuale " + now);

        // Creazione di un'ora specifica
        LocalTime time = LocalTime.parse("04:30");
        System.out.println("Ora specifica " + time);
        time = LocalTime.of(4, 30, 0);
        System.out.println("Ora specifica " + time);

        // Aggiunta di ore, minuti e secondi
        time = LocalTime.now().plusHours(2);
        System.out.println("Ora attuale + 2 ore " + time);

        // Divisione di ore, minuti e secondi
        int hour = LocalTime.now().getHour();
        int minutes = LocalTime.now().getMinute();
        int seconds = LocalTime.now().getSecond();
        System.out.println("Ora attuale " + hour + ":" + minutes + ":" + seconds);

        // Differenza tra due orari
        boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
        System.out.println("isBefore " + isbefore);
        boolean isafter = LocalTime.parse("06:30").isAfter(LocalTime.parse("07:30"));
        System.out.println("isAfter " + isafter);

        // Inizio e fine del giorno
        LocalTime maxTime = LocalTime.MAX;
        LocalTime minTime = LocalTime.MIN;
        System.out.println("Max time " + maxTime);
        System.out.println("Min time " + minTime);
    }
}
