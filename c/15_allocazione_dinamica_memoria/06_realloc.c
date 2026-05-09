/*
Reallocazione dinamica di memoria: se voglio modificare la dimensione di un blocco di memoria già allocato, posso usare la funzione realloc. Questa funzione prende in input un puntatore al blocco di memoria da ridimensionare e la nuova dimensione desiderata (in byte). Se la nuova dimensione è maggiore della vecchia, il contenuto del blocco viene copiato nella nuova area di memoria e il vecchio blocco viene liberato. Se la nuova dimensione è minore, il contenuto del blocco viene troncato alla nuova dimensione e il vecchio blocco viene liberato. In entrambi i casi, realloc restituisce un puntatore al nuovo blocco di memoria o NULL se l'allocazione fallisce.
Realloc è utile quando non si conosce a priori la dimensione di un blocco di memoria da allocare, ad esempio quando si vuole creare un array dinamico che può crescere o diminuire in base alle esigenze del programma. Tuttavia, è importante ricordare che realloc può essere costoso in termini di prestazioni, soprattutto se la nuova dimensione è molto diversa dalla vecchia, poiché potrebbe essere necessario copiare grandi quantità di dati. Pertanto, è consigliabile utilizzare realloc con cautela e solo quando necessario.
Inoltre, è importante gestire correttamente la memoria allocata con realloc, ad esempio assicurandosi di liberare il vecchio blocco di memoria quando non è più necessario e di verificare sempre se realloc restituisce NULL prima di utilizzare il nuovo blocco di memoria.
*/

#include <stdio.h>
#include <stdlib.h>

int main() {
    // Allocazione di un array di 5 interi (array[5])
    int dim = 5;
    int * pArray;
    pArray = (int *) malloc(dim*sizeof(int));
    if (pArray == NULL) {
        printf("Spazio in memoria insufficiente\n");
        return 1;
    }
    pArray[0] = 1;
    pArray[1] = 3;
    pArray[2] = 5;
    pArray[3] = 7;
    pArray[4] = 9;

    // Voglio inserire un ulteriore elemento: uso realloc
    pArray = (int *) realloc(pArray, (dim+1)*sizeof(int));
    if (pArray == NULL) {
        printf("Spazio in memoria insufficiente\n");
        return 1;
    }
    pArray[5] = 11;

    for (int i = 0; i < dim+1; i++) {
        printf("array[%d]: %d\n", i, *(pArray+i));
    }
    free(pArray);
    return 0;
}