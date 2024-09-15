#include <stdio.h>
#include <stdlib.h>

int main() {
    // Allocazione di una stringa di lunghezza 80
    const int DIM = 80;
    char * pString;
    pString = (char *) malloc(DIM*sizeof(char));
    if (pString == NULL) {
        printf("Spazio in memoria insufficiente\n");
        return 1;
    }
    printf("Inserisci una stringa: ");
    scanf("%s", pString);
    printf("Stringa inserita: %s", pString);
    free(pString);
    return 0;
}