/*
Passaggio di puntatori a funzioni:
- Passaggio per valore: modifica della copia non influenza l'originale
- Passaggio per riferimento (tramite puntatori): modifica l'originale
- Funzioni che restituiscono puntatori
*/

#include <stdio.h>

// Funzione che modifica per valore (non modifica l'originale)
void incrementaPerValore(int numero) {
    numero++;
    printf("  Dentro incrementaPerValore: numero = %d\n", numero);
}

// Funzione che modifica per riferimento (modifica l'originale tramite puntatore)
void incrementaPerRiferimento(int *pNumero) {
    (*pNumero)++;
    printf("  Dentro incrementaPerRiferimento: *pNumero = %d\n", *pNumero);
}

// Funzione che scambia due valori tramite puntatori
void scambia(int *pA, int *pB) {
    int temp = *pA;
    *pA = *pB;
    *pB = temp;
}

// Funzione che restituisce un puntatore
int* trovaMax(int *numeri, int lunghezza) {
    int *pMax = &numeri[0];
    for (int i = 1; i < lunghezza; i++) {
        if (numeri[i] > *pMax) {
            pMax = &numeri[i];
        }
    }
    return pMax;
}

// Funzione che accetta un array (puntatore)
void stampaArray(int *array, int lunghezza) {
    printf("  Array: ");
    for (int i = 0; i < lunghezza; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}

int main() {
    // Passaggio per valore vs per riferimento
    printf("=== PASSAGGIO PER VALORE VS PER RIFERIMENTO ===\n");
    int num = 10;
    printf("Valore iniziale: num = %d\n", num);

    printf("\nChiamata incrementaPerValore(num):\n");
    incrementaPerValore(num);
    printf("  Dopo la funzione: num = %d (NON è cambiato)\n", num);

    printf("\nChiamata incrementaPerRiferimento(&num):\n");
    incrementaPerRiferimento(&num);
    printf("  Dopo la funzione: num = %d (È CAMBIATO)\n", num);

    // Funzione che scambia tramite puntatori
    printf("\n=== FUNZIONE CHE SCAMBIA ===\n");
    int a = 5, b = 15;
    printf("Prima dello scambio: a = %d, b = %d\n", a, b);
    scambia(&a, &b);
    printf("Dopo lo scambio: a = %d, b = %d\n", a, b);

    // Funzione che restituisce un puntatore
    printf("\n=== FUNZIONE CHE RESTITUISCE UN PUNTATORE ===\n");
    int numeri[5] = {3, 7, 2, 9, 4};
    printf("Array: ");
    for (int i = 0; i < 5; i++) {
        printf("%d ", numeri[i]);
    }
    printf("\n");

    int *pMax = trovaMax(numeri, 5);
    printf("Elemento massimo: %d\n", *pMax);

    // Passaggio di array a funzioni (array decays a puntatore)
    printf("\n=== PASSAGGIO DI ARRAY A FUNZIONI ===\n");
    printf("Stampa dell'array tramite funzione:\n");
    stampaArray(numeri, 5);

    // Modifica di array tramite funzione
    printf("\nModifica array tramite funzione:\n");
    stampaArray(numeri, 5);
    for (int i = 0; i < 5; i++) {
        numeri[i] *= 2;  // Raddoppia ogni elemento
    }
    printf("Dopo raddoppio:\n");
    stampaArray(numeri, 5);

    return 0;
}
