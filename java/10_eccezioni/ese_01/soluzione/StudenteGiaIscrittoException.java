/**
 * Eccezione lanciata quando uno studente è già iscritto a un corso.
 */
public class StudenteGiaIscrittoException extends Exception {
    public StudenteGiaIscrittoException(String messaggio) {
        super(messaggio);
    }
}
