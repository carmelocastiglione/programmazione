/* 
Malloc: se voglio allocare dinamicamente una variabile di un certo tipo, posso usare malloc. La sintassi è la seguente:
malloc(sizeof(tipo));
dove tipo è il tipo della variabile che voglio allocare. La funzione malloc restituisce un puntatore al blocco di memoria allocato, che deve essere convertito al tipo desiderato usando un cast. 
Se malloc restituisce NULL, significa che lo spazio in memoria è insufficiente per allocare la variabile richiesta. In questo caso, è importante gestire l'errore in modo appropriato, ad esempio stampando un messaggio di errore e terminando il programma.
È importante ricordare che la memoria allocata con malloc deve essere liberata manualmente usando la funzione free quando non è più necessaria, altrimenti si rischia di causare perdite di memoria (memory leak).
In generale, l'allocazione dinamica di memoria è utile quando non si conosce a priori la quantità di memoria necessaria per una variabile o quando si vuole creare variabili che possono essere condivise tra diverse funzioni o moduli del programma. Tuttavia, è importante usare l'allocazione dinamica con cautela e assicurarsi di gestire correttamente la memoria allocata per evitare problemi di prestazioni e stabilità del programma.
*/

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
    // Mostro l'indirizzo di memoria allocato
    printf("Indirizzo di memoria allocato: %p\n", pInt);
    *pInt = 33;
    num1 = 66;
    num2 = *pInt + num1;
    printf("Valore variabili: *pi = %d, num1 = %d, num2 = %d\n", *pInt, num1, num2);
    free(pInt);
    return 0;
}