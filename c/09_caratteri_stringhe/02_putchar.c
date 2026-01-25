#include <stdio.h>

int main() {
    int c;

    printf("Inserisci un carattere: ");
    c = getchar();

    if (c != EOF) {
        putchar(c);
    } else {
        printf("Errore nella lettura del carattere.\n");
    }

    return 0;
}