#include <stdio.h>

void incrementa(int *p);

int main() {
    int a = 10;
    printf("Prima della funzione: a = %d\n", a);

    printf("Valore di a: %d\n", a);
    printf("Indirizzo di a: %p\n", &a);

    incrementa(&a);   // passiamo l’indirizzo di a

    printf("Dopo la funzione: a = %d\n", a);
    return 0;
}

void incrementa(int *p) {
    printf("Valore di p: %d\n", *p);
    printf("Indirizzo di p: %p\n", p);
    *p = *p + 1; // incrementa il valore all’indirizzo puntato da p
}
