#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main() {
    // Inserisco numeri in un array di dimensione 2 finchè non inserisco un numero negativo
    int size = 2;
    int num_inseriti = 0;
    int * pArray;
    pArray = (int *) malloc(size*sizeof(int));
    if (pArray == NULL) {
        printf("Spazio in memoria insufficiente\n");
        return 1;
    }
    printf("Inserisci un numero (negativo per terminare):\n");
    while (true) {
        int num;
        scanf("%d", &num);
        if (num < 0) {
            break;
        }
        // Se l'array è pieno, uso la strategia di raddoppiare la dimensione dell'array
        if (num_inseriti >= size) {
            size = size * 2;
            pArray = (int *) realloc(pArray, (size)*sizeof(int));
        }
        if (pArray == NULL) {
            printf("Spazio in memoria insufficiente\n");
            return 1;
        }
        pArray[num_inseriti] = num;
        num_inseriti++;
        // Stampo l'array dopo ogni inserimento
        printf("Array (max %d): ", size);
        for (int i = 0; i < num_inseriti; i++) {
            printf("%d ", pArray[i]);
        }
        printf("\n");
    }

    free(pArray);
    return 0;
}
