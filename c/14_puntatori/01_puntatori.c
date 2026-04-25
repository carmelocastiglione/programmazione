/* 
Puntatori: sono variabili che contengono l'indirizzo di memoria di un'altra variabile.
*/

#include <stdio.h>

int main() {
    // Dimostrazione delle dimensioni e degli indirizzi in memoria di variabili e puntatori
    // Dichiarazione di variabile
    int num1;
    int num2;
    int num3;
    // Dichiarazione di puntatore (crea un puntatore ad interi di nome pNum1)
    int *pNum1;
    // Dimensioni
    // Un intero è su 4 byte, un puntatore è su 8 byte (su sistemi a 64 bit) Nota: la dimensione di un puntatore dipende dall'architettura del sistema (32 bit o 64 bit)
    printf("Dimensione di un intero in byte: %d\n", sizeof(int));
    printf("Dimensione di un puntatore in byte: %d\n", sizeof(int *));
    printf("------------------------------\n");
    // Indirizzi in memoria
    printf("num1: %p\n", &num1);
    printf("num2: %p\n", &num2);
    printf("num3: %p\n", &num3);
    printf("pNum1: %p\n", &pNum1);
    // Dichiaro un altro intero
    int num4;
    printf("num4: %p\n", &num4);
    // Assegnazione: assegnare un valore ad una variabile, assegnare un indirizzo ad un puntatore
    num1 = 20;
    pNum1 = &num1; 
    // &num1 è l'indirizzo di memoria della variabile num1, che viene assegnato al puntatore pNum1. Ora pNum1 punta a (contiene l'indirizzo di) num1.
    printf("L'indirizzo in memoria della variabile num1 e': %p\n", &num1);  
    printf("L'indirizzo in memoria puntato dal puntatore e': %p\n", pNum1);
    // Dereferenziazione: accedere al valore a cui punta il puntatore
    num2 = *pNum1;
    // *pNum1 accede al valore a cui punta pNum1, che è num1. Quindi num2 ora contiene il valore di num1 (20).
    printf("La variabile num2 vale: %d", num2);
    return 0;
}