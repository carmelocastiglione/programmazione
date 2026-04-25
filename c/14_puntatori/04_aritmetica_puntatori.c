/*
Aritmetica dei puntatori: operazioni matematiche su puntatori.
- Incremento/Decremento: avanza/arretra nell'indirizzo di memoria
- Addizione/Sottrazione: salta di N posizioni di memoria
- Confronto: confronta gli indirizzi
*/

#include <stdio.h>

int main() {
    int numeri[5] = {10, 20, 30, 40, 50};
    int *pNum;

    // Incremento e decremento di puntatori
    pNum = &numeri[0];  // Punta al primo elemento
    // Si può anche scrivere: pNum = numeri; poiché il nome dell'array è un puntatore al primo elemento
    printf("=== INCREMENTO/DECREMENTO ===\n");
    printf("pNum inizialmente punta a numeri[0], valore: %d\n", *pNum);
    printf("Indirizzo: %p\n", pNum);

    pNum++;  // Incremento: avanza al prossimo elemento
    printf("\nDopo pNum++:\n");
    printf("pNum punta a numeri[1], valore: %d\n", *pNum);
    printf("Indirizzo: %p\n", pNum);

    pNum++;
    printf("\nDopo un altro pNum++:\n");
    printf("pNum punta a numeri[2], valore: %d\n", *pNum);
    printf("Indirizzo: %p\n", pNum);

    pNum--;  // Decremento: arretra di un elemento
    printf("\nDopo pNum--:\n");
    printf("pNum punta a numeri[1], valore: %d\n", *pNum);
    printf("Indirizzo: %p\n", pNum);

    // Addizione e sottrazione
    printf("\n=== ADDIZIONE/SOTTRAZIONE ===\n");
    pNum = &numeri[0];
    printf("pNum inizialmente punta a numeri[0]\n");

    int *pNum2 = pNum + 3;  // Salta 3 elementi
    printf("pNum + 3 punta a numeri[3], valore: %d\n", *pNum2);

    pNum2 = pNum + 2;
    printf("pNum + 2 punta a numeri[2], valore: %d\n", *pNum2);

    pNum2 = pNum2 - 1;  // Arretra di 1 elemento
    printf("(pNum + 2) - 1 punta a numeri[1], valore: %d\n", *pNum2);

    // Sottrazione tra puntatori
    printf("\n=== SOTTRAZIONE TRA PUNTATORI ===\n");
    int *pInizio = &numeri[0];
    int *pFine = &numeri[4];
    printf("Distanza tra numeri[4] e numeri[0]: %ld elementi\n", pFine - pInizio);

    // Confronto tra puntatori
    printf("\n=== CONFRONTO TRA PUNTATORI ===\n");
    pNum = &numeri[1];
    pNum2 = &numeri[3];

    if (pNum < pNum2) {
        printf("pNum punta a un indirizzo precedente rispetto a pNum2\n");
    }

    if (pNum == &numeri[1]) {
        printf("pNum punta a numeri[1]\n");
    }

    // Utilizzo pratico: iterare su un array
    printf("\n=== ITERAZIONE SU ARRAY ===\n");
    pNum = &numeri[0];
    printf("Elementi dell'array: ");
    for (int i = 0; i < 5; i++) {
        printf("%d ", *pNum);
        pNum++;
    }
    printf("\n");

    return 0;
}
