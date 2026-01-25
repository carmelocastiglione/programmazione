#include <stdio.h>

int main() {
    int c; 
    // getchar() restituisce un int per poter rappresentare EOF
    // in realtà in C un carattere è rappresentato da un int
    // perché il tipo char è un tipo intero di dimensione ridotta
    char stringa[100];
    // Le stringhe in C sono array di caratteri terminati dal carattere null '\0'
    int i = 0;

    printf("Inserisci un carattere: ");
    c = getchar();

    if (c != EOF) {
        printf("Hai inserito il carattere: '%c' con codice ASCII: %d\n", c, c);
    } else {
        printf("Errore nella lettura del carattere.\n");
    }

    while (getchar() != '\n'); // Pulire il buffer di input

    // Leggere una stringa di caratteri fino a EOF
    printf("Inserisci una stringa (termina con EOF): ");
    while ((c = getchar()) != '\n') {
        stringa[i] = c;
        i++;
    }
    stringa[i] = '\0'; // Terminare la stringa con il carattere null

    printf("La stringa inserita è: %s\n", stringa);

    return 0;
}