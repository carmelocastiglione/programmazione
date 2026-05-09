/* 
Calloc è una funzione della libreria standard di C che viene utilizzata per allocare dinamicamente memoria per un certo numero di elementi di una certa dimensione. La sintassi di calloc è la seguente:
void *calloc(size_t num, size_t size);
dove num è il numero di elementi da allocare e size è la dimensione di ciascun elemento in byte. La funzione restituisce un puntatore al blocco di memoria allocato, inizializzato a zero, o NULL se l'allocazione fallisce.
La differenza principale tra malloc e calloc è che malloc non inizializza la memoria allocata, mentre calloc inizializza la memoria a zero. Inoltre, malloc prende come argomento la dimensione totale della memoria da allocare (in byte), mentre calloc prende come argomenti il numero di elementi e la dimensione di ciascun elemento (in byte). Pertanto, calloc è più conveniente quando si vuole allocare memoria per un certo numero di elementi di una certa dimensione, poiché evita di dover calcolare manualmente la dimensione totale della memoria da allocare.
Calloc è particolarmente utile quando si vuole allocare memoria per un array di elementi, poiché garantisce che tutti gli elementi dell'array siano inizializzati a zero, evitando così problemi di valori non inizializzati. Tuttavia, è importante ricordare che calloc può essere più lento di malloc, poiché deve inizializzare la memoria allocata a zero. Pertanto, è consigliabile utilizzare calloc solo quando è necessario inizializzare la memoria a zero, altrimenti è preferibile utilizzare malloc per ottenere prestazioni migliori.
Per riallocare un blocco di memoria allocato con calloc, si può utilizzare la funzione realloc, che funziona allo stesso modo sia per i blocchi di memoria allocati con malloc che per quelli allocati con calloc. Tuttavia, è importante ricordare che realloc non inizializza la memoria allocata a zero, quindi se si rialloca un blocco di memoria allocato con calloc, è necessario inizializzare manualmente la nuova memoria allocata a zero se si desidera mantenere la stessa funzionalità di calloc.
*/

#include <stdio.h>
#include <stdlib.h>

int main() {
    // Allocazione di un array di 5 interi (array[5]) usando calloc
    int dim = 5;
    int * pArray;
    pArray = (int *) calloc(dim, sizeof(int));
    if (pArray == NULL) {
        printf("Spazio in memoria insufficiente\n");
        return 1;
    }
    // La memoria allocata da calloc è inizializzata a zero, quindi tutti gli elementi dell'array sono inizialmente uguali a zero
    for (int i = 0; i < dim; i++) {
        printf("array[%d]: %d\n", i, *(pArray+i));
    }
    free(pArray);
    return 0;
}