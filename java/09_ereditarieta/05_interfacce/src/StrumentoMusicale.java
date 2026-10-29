/**
 * StrumentoMusicale
 */

/*
 * Come le classi astratte, le interfacce non possono essere utilizzate per creare oggetti (nell'esempio precedente, non è possibile creare un oggetto "Animal" nella classe MyMainClass).
 * I metodi di un'interfaccia non hanno un corpo: il corpo viene fornito dalla classe che implementa l'interfaccia.
 * Quando implementi un'interfaccia, devi sovrascriverne tutti i metodi.
 * Per impostazione predefinita, i metodi di un'interfaccia sono abstract e public.
 * Gli attributi di un'interfaccia sono, per impostazione predefinita, public, static e final.
 * Un'interfaccia non può contenere un costruttore (perché non può essere utilizzata per creare oggetti).
 * Perché e quando usare le interfacce?
 * 1) Per ottenere una maggiore sicurezza: nascondere alcuni dettagli e mostrare solo quelli importanti di un oggetto tramite l'interfaccia.
 * 2) Java non supporta l'ereditarietà multipla (una classe può ereditare da una sola classe). È però possibile ottenere un risultato simile con le interfacce, perché una classe può implementarne più di una. 
 */
public interface StrumentoMusicale {

    // Le interfacce non possono avere costruttori, quindi non è possibile creare oggetti direttamente da esse.

    // Tutti i metodi di un'interfaccia sono implicitamente abstract e public.
    void suona();
}
