#include <stdio.h>
#include <time.h>
#include <stdlib.h>

// Imposta questi parametri a piacere
#define ARRAY_LENGTH 10
#define MAX_NUMBER 100
// Richiesti dalla funzione insertionSort
#define SORT_ASC 0
#define SORT_DES 1

void printArray(int array[], int size);
void generateArray(int array[], int size);
void insertionSort(int array[], int size, int mode);

int main() {
    int data[ARRAY_LENGTH];
    int size = sizeof(data)/sizeof(data[0]);
    srand(time(NULL));
    generateArray(data, size);
    printf("Vettore iniziale:\n");
    printArray(data, size);
    printf("Vettore ordinato in maniera ascendente:\n");
    insertionSort(data, size, SORT_ASC);
    printArray(data, size);
    printf("Vettore ordinato in maniera discendente:\n");
    insertionSort(data, size, SORT_DES);
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

// Insertion sort
void insertionSort(int array[], int size, int mode) {
  for (int i = 1; i < size; i++) {
    int key = array[i];
    int j = i - 1;

    // Confronta key con ogni elemento alla sua sinistra finche'  non si trova 
    // un elemento piu'  piccolo o uguale
    if (mode == SORT_ASC) {
      while (key < array[j] && j >= 0) {
        array[j + 1] = array[j];
        j--;
     }
    array[j + 1] = key;
    } else if (mode == SORT_DES) {
      while (key > array[j] && j >= 0) {
        array[j + 1] = array[j];
        j--;
        }
      array[j + 1] = key;
    } else {
      printf("Parametro di ordinamento errato\n");
    }
    // Togliere i commenti per visualizzare tutti i passaggi
    // printf("Passo %d: confronto %d\n", i, key);
    // printArray(array, size);
  }
}