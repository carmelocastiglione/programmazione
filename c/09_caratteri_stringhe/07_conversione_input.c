#include <stdio.h>
#include <stdlib.h>

int main() {
    char buffer[100];
    char *endptr;
    int intero;
    float virgola;

    // Lettura di una stringa dall'input standard
    printf("Inserisci una intero: ");
    if (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        printf("Hai inserito la stringa: %s", buffer);
    } else {
        printf("Errore nella lettura della stringa.\n");
    }

    // Conversione della stringa in un numero intero
    // strtoi() converte una stringa in un intero
    // Sintassi: int strtoi(const char *str, char **endptr, int base);
    intero = strtol(buffer, &endptr, 10);
    if (*endptr == '\0' || *endptr == '\n') {
        printf("La conversione in intero è riuscita: %d\n", intero);
    } else {
        printf("La conversione in intero non è riuscita. Carattere non convertibile: '%c'\n", *endptr);
        return 1;
    }

    // Lettura di una stringa dall'input standard
    printf("Inserisci un numero con virgola: ");
    if (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        printf("Hai inserito la stringa: %s", buffer);
    } else {
        printf("Errore nella lettura della stringa.\n");
    }

    // Conversione della stringa in un numero con virgola
    // strtof() converte una stringa in un numero float
    // Sintassi: float strtof(const char *str, char **endptr);
    virgola = strtof(buffer, &endptr);
    if (*endptr == '\0' || *endptr == '\n') {
        printf("La conversione in numero con virgola è riuscita: %f\n", virgola);
    } else {
        printf("La conversione in numero con virgola non è riuscita. Carattere non convertibile: '%c'\n", *endptr);
        return 1;
    }

    return 0;
}