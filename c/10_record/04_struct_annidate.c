#include <stdio.h>

int main() {
    // Definisco una struttura per rappresentare una data
    typedef struct {
        int giorno;
        int mese;
        int anno;
    } data_t;

    // Definisco una struttura per rappresentare uno studente
    typedef struct {
        char nome[50];
        char cognome[50];
        data_t data_nascita;
    } studente_t;

    // Metodo alternativo: definire la struttura studente_t con la struttura data_t annidata
    /*typedef struct {
        char nome[50];  
        char cognome[50];
        struct {
            int giorno;
            int mese;
            int anno;
        } data_nascita; // Struttura annidata
    } studente_t;*/

    // Creo un array di 3 studenti
    studente_t studenti[3] = {
        {"Mario", "Rossi", {15, 5, 1990}},
        {"Luigi", "Bianchi", {20, 8, 1992}},
        {"Anna", "Verdi", {10, 12, 1991}}
    };

    // Inserisco un nuovo studente da tastiera
    printf("Inserisci nome, cognome, giorno, mese e anno di nascita dello studente:\n");
    studente_t nuovo_studente;
    scanf("%s %s %d %d %d", nuovo_studente.nome, nuovo_studente.cognome, &nuovo_studente.data_nascita.giorno, &nuovo_studente.data_nascita.mese, &nuovo_studente.data_nascita.anno);

    return 0;
}