/*  
    Dopo aver definito una struttura adatta a memorizzare una data composta da
    giorno, mese(numerico), anno e un avvenimento storico, scrivere un programma che
    memorizzi un elenco di date e stampi l’elenco in ordine cronologico.
*/

#include <stdio.h>
#include <stdbool.h>

#define MAX_STR_LEN 80
#define MAX_EVENTI 1000

struct s_evento {
        struct s_data {
            int giorno;
            int mese;
            int anno;
        } data;
        char descrizione[MAX_STR_LEN];
    };
typedef struct s_evento struttura_evento;

void bubbleSort(struttura_evento array[], int size);

int main () {
    struttura_evento evento[MAX_EVENTI];
    FILE *fp;
    int numElem = 0;
    char nomefile[] = "es_03_date.txt";
    if ((fp = fopen(nomefile, "r")) == NULL) {
        printf("Errore apertura file\n");
        return -1;
    }
    while (!feof(fp)) {
        fscanf(fp, "%d", &evento[numElem].data.giorno);
        fscanf(fp, "%d", &evento[numElem].data.mese);
        fscanf(fp, "%d", &evento[numElem].data.anno);
        fscanf(fp, "%s", evento[numElem].descrizione);
        numElem++;
    }
    for (int i = 0; i < numElem; i++) {
        printf("%d)\t%d/%d/%d\t%s\n", 
            i + 1,
            evento[i].data.giorno,
            evento[i].data.mese,
            evento[i].data.anno,
            evento[i].descrizione
            );
    }

    bubbleSort(evento, numElem);

    printf("\nDate ordinate:\n");
    for (int i = 0; i < numElem; i++) {
        printf("%d)\t%d/%d/%d\t%s\n", 
            i + 1,
            evento[i].data.giorno,
            evento[i].data.mese,
            evento[i].data.anno,
            evento[i].descrizione
            );
    }
    return 0;
}

// Bubble sort ottimizzato
void bubbleSort(struttura_evento array[], int size) {
  for (int i = 0; i < size - 1; i++) {
    bool swapped = false;
    for (int j = 0; j < size - i - 1; j++) {
        // Scambio gli elementi adiacenti se non sono in ordine
        if (
            (array[j].data.anno > array[j + 1].data.anno) ||
            ((array[j].data.anno == array[j + 1].data.anno) && 
            (array[j].data.mese > array[j + 1].data.mese)) ||
            ((array[j].data.anno == array[j + 1].data.anno) && 
            (array[j].data.mese == array[j + 1].data.mese) &&
            (array[j].data.giorno > array[j + 1].data.giorno))
            ) {
            struttura_evento temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
            swapped = true;
        }  
    }
    // Se non ho scambiato elementi, l'array e' gia' ordinato, quindi
    // non serve andare oltre
    if (swapped == false) {
      break;
    }
  }
}