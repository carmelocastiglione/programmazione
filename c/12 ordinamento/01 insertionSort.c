#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#define ARRAY_LENGTH 10
#define MAX_NUMBER 100

void printArray(int array[], int size);
void generateArray(int array[], int size);
void insertionSort(int array[], int size);

int main() {
    int data[ARRAY_LENGTH];
    int size = sizeof(data)/sizeof(data[0]);
    srand(time(NULL));
    generateArray(data, size);
    printf("Vettore iniziale:\n");
    printArray(data, size);
    insertionSort(data, size);
    printf("Vettore ordinato in maniera ascendente:\n");
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
void insertionSort(int array[], int size) {
  for (int i = 1; i < size; i++) {
    int key = array[i];
    int j = i - 1;

    // Confronta key con ogni elemento alla sua sinistra finch  non si trova un elemento pi  piccolo
    // Per un ordinamento decrescente, cambiare key<array[j] con key>array[j].
    while (key < array[j] && j >= 0) {
      array[j + 1] = array[j];
      j--;
    }
    array[j + 1] = key;
    // Togliere i commenti per visualizzare tutti i passaggi
    // printf("Passo %d: confronto %d\n", i, key);
    // printArray(array, size);
  }
}