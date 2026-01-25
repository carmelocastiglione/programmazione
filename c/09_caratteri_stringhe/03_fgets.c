#include <stdio.h>

// scanf() legge una stringa di caratteri fino a un newline, uno spazio o EOF
// fgets() legge una riga di testo da un puntatore a un FILE e la memorizza in un array di caratteri

// Sintassi di fgets:
// char *fgets(char *str, int size, FILE *stream);

int main() {
    char stringa[100];

    printf("Inserisci una stringa (max 99 caratteri): ");
    if (fgets(stringa, sizeof(stringa), stdin) != NULL) {
        printf("La stringa inserita è: %s", stringa);
    } else {
        printf("Errore nella lettura della stringa.\n");
    }

    // Differenza con scanf:
    printf("Inserisci una stringa con scanf (max 99 caratteri): ");
    scanf("%s", stringa);
    printf("La stringa inserita con scanf è: %s\n", stringa);

    return 0;
}