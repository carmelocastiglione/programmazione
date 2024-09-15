#include <stdio.h>
#include <stdlib.h>

int main() {
    // Allocazione di una matrice 3x5
    // Notazione per vettori:
    // int vet[] equivale a int * vet
    // Notazione per matrici:
    // int mat[][] equivale a int ** mat
    int row = 3, col = 5;
    int ** pMatrix;
    // Alloco il vettore delle righe
    pMatrix = (int **) malloc(row*sizeof(int));
    if (pMatrix == NULL) {
        printf("Spazio in memoria insufficiente\n");
        return 1;
    }
    // Per ogni riga, alloco una colonna composta da interi
    for (int i = 0; i < row; i++) {
        pMatrix[i] = (int *) malloc(col*sizeof(int));
    }

    // Scrivo e stampo la matrice
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            pMatrix[i][j] = i * j;
        }
    }
    // Scrivo e stampo la matrice
    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            printf("%d ", pMatrix[i][j]);
        }
        printf("\n");
    }
    
    free(pMatrix);
    return 0;
}