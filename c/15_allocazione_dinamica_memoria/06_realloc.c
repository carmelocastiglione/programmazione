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
    pArray[5] = 11;

    for (int i = 0; i < dim+1; i++) {
        printf("array[%d]: %d\n", i, *(pArray+i));
    }
    free(pArray);
    return 0;
}