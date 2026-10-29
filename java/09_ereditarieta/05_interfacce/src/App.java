public class App {
    public static void main(String[] args) throws Exception {
        // Creazione di un oggetto StrumentoMusicale non è possibile perché è un'interfaccia
        // StrumentoMusicale strumento = new StrumentoMusicale(); // Questo genererebbe un errore
        // StrumentoACorde è un'interfaccia che rappresenta strumenti musicali a corde
        // Non è possibile creare un oggetto StrumentoACorde direttamente perché è un'interfaccia
        //StrumentoACorde strumentoACorde = new StrumentoACorde(); // Questo genererebbe un errore
        Chitarra chitarra = new Chitarra();
        chitarra.suona();
        chitarra.numeroCorde();
        Pianoforte pianoforte = new Pianoforte();
        pianoforte.suona();
    }
}
