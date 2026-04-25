/*
Puntatori a puntatori (Double Pointers): sono variabili che contengono l'indirizzo di memoria di un puntatore.
Utili per modificare il valore di un puntatore all'interno di una funzione.
*/

#include <stdio.h>

int main() {
    int num = 50;
    int *pNum;       // Puntatore a intero
    int **ppNum;     // Puntatore a puntatore (double pointer)

    // Assegnazione
    pNum = &num;
    ppNum = &pNum;   // Assegno l'indirizzo del puntatore pNum al puntatore a puntatore ppNum

    // Dimostrazione delle dimensioni
    printf("Dimensione di un intero: %d byte\n", sizeof(int));
    printf("Dimensione di un puntatore: %d byte\n", sizeof(int *));
    printf("Dimensione di un puntatore a puntatore: %d byte\n", sizeof(int **));
    printf("------------------------------\n");

    // Indirizzi
    printf("Indirizzo di num: %p\n", &num);
    printf("Indirizzo di pNum (contenuto in ppNum): %p\n", &pNum);
    printf("Indirizzo di ppNum: %p\n", &ppNum);
    printf("------------------------------\n");

    // Valori
    printf("Valore di num: %d\n", num);
    printf("Valore di pNum (indirizzo di num): %p\n", pNum);
    printf("Valore di ppNum (indirizzo di pNum): %p\n", ppNum);
    printf("------------------------------\n");

    // Dereferenziazione
    printf("*pNum (valore a cui punta pNum): %d\n", *pNum);
    printf("**ppNum (valore a cui punta pNum, che e' puntato da ppNum): %d\n", **ppNum);
    printf("------------------------------\n");

    // Modifica di valore tramite double pointer
    **ppNum = 100;
    printf("Dopo **ppNum = 100:\n");
    printf("num = %d\n", num);
    printf("*pNum = %d\n", *pNum);
    printf("**ppNum = %d\n", **ppNum);

    return 0;
}
