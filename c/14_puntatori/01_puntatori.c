#include <stdio.h>

int main() {
    // Dichiarazione di variabile
    int num1;
    int num2;
    int num3;
    // Dichiarazione di puntatore (crea un puntatore ad interi di nome pNum1)
    int * pNum1;
    // Dimensioni
    printf("Dimensione di un intero in byte: %d\n", sizeof(int));
    printf("Dimensione di un puntatore in byte: %d\n", sizeof(pNum1));
    // Indirizzi in memoria
    printf("L'indirizzo in memoria della variabile e': %x\n", &num1);
    printf("L'indirizzo in memoria della variabile e': %x\n", &num2);
    printf("L'indirizzo in memoria della variabile e': %x\n", &num3);
    // Assegnazione
    num1 = 20;
    pNum1 = &num1;   
    printf("L'indirizzo in memoria puntato dal puntatore e': %x\n", pNum1);
    num2 = *pNum1;
    printf("La variabile vale: %d", num2);
    return 0;
}