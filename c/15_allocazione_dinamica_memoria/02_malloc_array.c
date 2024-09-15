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
    // pArray è un puntatore al primo elemento di un vettore 
    // il nome di un vettore è un puntatore COSTANTE al primo elemento
    // pArray è uguale a &pArray[0]
    // pArray+x è uguale a &pArray[x]
    // *pArray è uguale a pArray[0]
    // *(pArray+x) è uguale a pArray[x] 
    *(pArray+4) = -11;

    for (int i = 0; i < dim; i++) {
        printf("array[%d]: %d\n", i, *(pArray+i));
    }
    free(pArray);
    return 0;
}