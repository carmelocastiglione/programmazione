#include <stdio.h>
#include <time.h>
#include <stdlib.h>

// Imposta questi parametri a piacere
#define ARRAY_LENGTH 10
#define MAX_NUMBER 100
// Richiesti dalla funzione selectionSort
#define SORT_ASC 0
#define SORT_DES 1

void printArray(int array[], int size);
void generateArray(int array[], int size);
void selectionSort(int array[], int size, int mode);

int main() {
    int data[ARRAY_LENGTH];
    int size = sizeof(data)/sizeof(data[0]);
    srand(time(NULL));
    generateArray(data, size);
    printf("Vettore iniziale:\n");
    printArray(data, size);
    printf("Vettore ordinato in maniera ascendente:\n");
    selectionSort(data, size, SORT_ASC);
    printArray(data, size);
    printf("Vettore ordinato in maniera discendente:\n");
    selectionSort(data, size, SORT_DES);
    printArray(data, size);
    return 0;
}

// Genera un vettore
void generateArray(int array[], int size) {
    for (int i = 0; i < size; i++) {
        array[i] = rand() % MAX_NUMBER + 1;
    }
}

// Stampa un vettore
void printArray(int array[], int size) {
  for (int i = 0; i < size; i++) {
    printf("%d ", array[i]);
  }
  printf("\n");
}

// Selection sort
void selectionSort(int array[], int size, int mode) {
  for (int i = 0; i < size - 1; i++) {
    // Cerco il minimo nel vettore 
    int min_index = i;
    int temp;
    for (int j = i + 1; j < size; j++) {
      if (mode == SORT_ASC) {
        if (array[j] < array[min_index]) {
          min_index = j;
        }
      } else if (mode == SORT_DES) {
        if (array[j] > array[min_index]) {
          min_index = j;
        } 
      } else {
        printf("Parametro di ordinamento errato\n");
        return;
      }
    }
    // Una volta che trovo il minimo, lo scambio con l'elemento selezionato
    temp = array[min_index];
    array[min_index] = array[i];
    array[i] = temp;
    // Togliere i commenti per visualizzare tutti i passaggi
    // printf("Passo %d: confronto %d\n", i, array[i]);
    // printArray(array, size);
  }
}