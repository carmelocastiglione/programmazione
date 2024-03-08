#include <stdio.h>

#define NUM_ATLETI 5
#define SORT_ASC 0
#define SORT_DES 1

struct s_atleta {
        char nome[80];
        char cognome[80];
        int numero;
        float tempo;
    };

typedef struct s_atleta atleta;

void insertionSort(atleta array[], int size, int mode);

int main() {
    FILE *fp;
    atleta atleti[NUM_ATLETI];
    char nomeFile[] = "es_01_corsa.txt";
    if ((fp = fopen(nomeFile, "r")) == NULL) {
        printf("Errore apertura file\n");
        return 1;
    }
    for (int i=0; i<NUM_ATLETI; i++) {
        fscanf(fp, "%s %s %d %f",
            atleti[i].nome,
            atleti[i].cognome,
            &atleti[i].numero,
            &atleti[i].tempo);
    }
    if (fclose(fp) != 0) {
        return 1;
    }
    for (int i=0; i<NUM_ATLETI; i++) {
        printf("%s %s %d %.2f\n",
            atleti[i].nome,
            atleti[i].cognome,
            atleti[i].numero,
            atleti[i].tempo);
    }
    insertionSort(atleti, NUM_ATLETI, SORT_ASC);
    printf("\nAtleti in ordine\n\n");
    for (int i=0; i<NUM_ATLETI; i++) {
        printf("%s %s %d %.2f\n",
            atleti[i].nome,
            atleti[i].cognome,
            atleti[i].numero,
            atleti[i].tempo);
    }
    return 0;
}

void insertionSort(atleta array[], int size, int mode) {
  for (int i = 1; i < size; i++) {
    atleta key = array[i];
    int j = i - 1;

    // Confronta key con ogni elemento alla sua sinistra finche'  non si trova
    // un elemento piu'  piccolo o uguale
    if (mode == SORT_ASC) {
      while (key.tempo < array[j].tempo && j >= 0) {
        array[j + 1] = array[j];
        j--;
     }
    array[j + 1] = key;
    } else if (mode == SORT_DES) {
      while (key.tempo > array[j].tempo && j >= 0) {
        array[j + 1] = array[j];
        j--;
        }
      array[j + 1] = key;
    } else {
      printf("Parametro di ordinamento errato\n");
    }
  }
}
