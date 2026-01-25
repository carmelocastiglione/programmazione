#include <stdio.h>

// fputs() scrive una stringa di caratteri su un puntatore a un FILE
// Sintassi di fputs:
// int fputs(const char *str, FILE *stream);
// a differenza di printf, fputs non formatta la stringa, ma la scrive così com'è

int main() {
    char stringa[100];

    printf("Inserisci una stringa (max 99 caratteri): ");
    if (fgets(stringa, sizeof(stringa), stdin) != NULL) {
        fputs("La stringa inserita è: ", stdout);
        fputs(stringa, stdout);
    } else {
        printf("Errore nella lettura della stringa.\n");
    }

    return 0;
}