/**
 * Interfaccia che definisce i metodi per partecipare a un corso
 * (gestione voti e iscrizioni).
 */
public interface Partecipante {
    /**
     * Iscrive il partecipante a un corso.
     * @param c Corso a cui iscriversi
     * @throws StudenteGiaIscrittoException se lo studente è già iscritto
     * @throws CapacitaCorsoEsceduriException se il corso è pieno
     */
    void iscrivi(Corso c) throws StudenteGiaIscrittoException, CapacitaCorsoEsceduriException;

    /**
     * Aggiunge un voto al partecipante.
     * @param voto Voto da aggiungere (deve essere tra 0 e 30)
     * @throws VotoNonValidoException se il voto non è valido
     */
    void valuta(int voto) throws VotoNonValidoException;

    /**
     * Restituisce l'array di voti del partecipante.
     * @return array di voti
     */
    int[] getVoti();

    /**
     * Calcola la media dei voti del partecipante.
     * @return media aritmetica dei voti (0 se nessun voto)
     */
    double getMedia();
}
