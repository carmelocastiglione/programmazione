/*
Relazione tra puntatori e array:
- Un nome di array è un puntatore costante al primo elemento
- Sintassi array[] è equivalente a utilizzare puntatori
- Passare array a funzioni significa passare puntatori
*/

#include <stdio.h>

int main() {
    int numeri[5] = {10, 20, 30, 40, 50};
    int *pNum;

    // Array e puntatori sono strettamente correlati
    printf("=== EQUIVALENZA ARRAY E PUNTATORI ===\n");
    pNum = &numeri[0];  // Puntatore al primo elemento
    printf("numeri (nome array): %p\n", numeri);
    printf("pNum (puntatore): %p\n", pNum);
    printf("&numeri[0] (indirizzo primo elemento): %p\n", &numeri[0]);
    printf("Sono equivalenti: %s\n", numeri == pNum ? "SI" : "NO");

    // Accesso tramite puntatore
    printf("\n=== ACCESSO CON PUNTATORI ===\n");
    pNum = numeri;  // Assegno il nome dell'array al puntatore
    printf("numeri[0] = %d\n", numeri[0]);
    printf("*pNum = %d\n", *pNum);
    printf("*(numeri) = %d\n", *(numeri));

    printf("\nnumeri[2] = %d\n", numeri[2]);
    printf("*(pNum + 2) = %d\n", *(pNum + 2));
    printf("*(numeri + 2) = %d\n", *(numeri + 2));

    // Utilizzo della notazione pNum[i] (equivalente a *(pNum+i))
    printf("\n=== NOTAZIONE pNum[i] ===\n");
    pNum = numeri;
    printf("Elementi tramite pNum[i]:\n");
    for (int i = 0; i < 5; i++) {
        printf("pNum[%d] = %d\n", i, pNum[i]);
    }

    // Iterazione su array tramite puntatore
    printf("\n=== ITERAZIONE CON PUNTATORI ===\n");
    printf("Elementi tramite incremento:\n");
    pNum = numeri;
    for (int i = 0; i < 5; i++) {
        printf("Elemento %d: %d\n", i, *(pNum+i));
    }

    // Array di puntatori
    printf("\n=== ARRAY DI PUNTATORI ===\n");
    int a = 100, b = 200, c = 300;
    int *puntatori[3] = {&a, &b, &c};  // Array di 3 puntatori

    printf("Array di puntatori:\n");
    for (int i = 0; i < 3; i++) {
        printf("puntatori[%d] punta a: %d\n", i, *puntatori[i]);
    }

    // Confronto: array di valori vs array di puntatori
    printf("\n=== DIFFERENZA: ARRAY DI VALORI VS ARRAY DI PUNTATORI ===\n");
    int valori[3] = {10, 20, 30};  // Array di interi
    printf("Dimensione di valori[]: %d byte\n", (int)sizeof(valori));
    printf("Dimensione di puntatori[]: %d byte\n", (int)sizeof(puntatori));

    return 0;
}
