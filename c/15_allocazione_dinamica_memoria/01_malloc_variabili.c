#include <stdio.h>
#include <stdlib.h>

int main() {
    int * pInt;
    int num1, num2;
    // Allocazione di una variabile di tipo int
    pInt = (int *) malloc(sizeof(int));
    if (pInt == NULL) {
        printf("Spazio in memoria insufficiente\n");
        return 1;
    }
    *pInt = 33;
    num1 = 66;
    num2 = *pInt + num1;
    printf("Valore variabili: *pi = %d, num1 = %d, num2 = %d\n", *pInt, num1, num2);
    free(pInt);
    return 0;
}