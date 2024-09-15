#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <stdbool.h>

// Imposta questi parametri a piacere
#define ARRAY_LENGTH 10
#define MAX_NUMBER 100
// Richiesti dalla funzione bubbleSortOpt
#define SORT_ASC 0
#define SORT_DES 1

void printArray(int array[], int size);
void generateArray(int array[], int size);
void bubbleSortOpt(int array[], int size, int mode);

int main() {
    int data[ARRAY_LENGTH];
    int size = sizeof(data)/sizeof(data[0]);
    srand(time(NULL));
    generateArray(data, size);
    printf("Vettore iniziale:\n");
    printArray(data, size);
    printf("Vettore ordinato in maniera ascendente:\n");
    bubbleSortOpt(data, size, SORT_ASC);
    printArray(data, size);
    printf("Vettore ordinato in maniera discendente:\n");
    bubbleSortOpt(data, size, SORT_DES);
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

// Bubble sort ottimizzato
void bubbleSortOpt(int array[], int size, int mode) {
  for (int i = 0; i < size - 1; i++) {
    bool swapped = false;
    for (int j = 0; j < size - i - 1; j++) {
      if (mode == SORT_ASC) {
        // Scambio gli elementi adiacenti se non sono in ordine
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          swapped = true;
        }
      } else if (mode == SORT_DES) {
        if (array[j] < array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          swapped = true;
        } 
      } else {
        printf("Parametro di ordinamento errato\n");
        return;
      }
    }
    // Se non ho scambiato elementi, l'array e' gia' ordinato, quindi
    // non serve andare oltre
    if (swapped == false) {
      break;
    }
    // Togliere i commenti per visualizzare tutti i passaggi
    // printf("Passo %d: confronto %d\n", i, array[i]);
    // printArray(array, size);
  }
}