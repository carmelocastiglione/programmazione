#include <stdio.h>
#include <time.h>
#include <sys/time.h>
#include <stdlib.h>
#include <stdbool.h>

// Imposta questi parametri a piacere
#define ARRAY_LENGTH 10000
#define MAX_NUMBER 100
// Richiesti dalla funzione insertionSort
#define SORT_ASC 0
#define SORT_DES 1

void printArray(int array[], int size);
void generateArray(int array[], int size);
void insertionSort(int array[], int size, int mode);
void selectionSort(int array[], int size, int mode);
void bubbleSort(int array[], int size, int mode);
void bubbleSortOpt(int array[], int size, int mode);
void copyArray(int destination[], int source[], int size);
float time_diff(struct timeval *start, struct timeval *end);

int main() {
    struct timeval start;
    struct timeval end;
    int data[ARRAY_LENGTH], dataSorted[ARRAY_LENGTH];
    int size = sizeof(data)/sizeof(data[0]);
    srand(time(NULL));
    generateArray(data, size);
    printf("Vettore ordinato con insertion sort:\n");
    copyArray(dataSorted, data, size);
    gettimeofday(&start, NULL);
    insertionSort(dataSorted, size, SORT_ASC);
    gettimeofday(&end, NULL);
    printf("Insertion sort: %f sec\n", time_diff(&start, &end));
    copyArray(dataSorted, data, size);
    gettimeofday(&start, NULL);
    selectionSort(dataSorted, size, SORT_ASC);
    gettimeofday(&end, NULL);
    printf("Selection sort: %f sec\n", time_diff(&start, &end));
    copyArray(dataSorted, data, size);
    gettimeofday(&start, NULL);
    bubbleSort(dataSorted, size, SORT_ASC);
    gettimeofday(&end, NULL);
    printf("Bubble sort: %f sec\n", time_diff(&start, &end));
    copyArray(dataSorted, data, size);
    gettimeofday(&start, NULL);
    bubbleSortOpt(dataSorted, size, SORT_ASC);
    gettimeofday(&end, NULL);
    printf("Bubble sort ottimizzato: %f sec\n", time_diff(&start, &end));
    return 0;
}

float time_diff(struct timeval *start, struct timeval *end) {
  return (end->tv_sec - start->tv_sec) + 1e-6 * (end->tv_usec - start->tv_usec);
}

// Copio un vettore 
void copyArray(int destination[], int source[], int size) {
    for (int i = 0; i < size; i++) {
        destination[i] = source[i];
    }
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

// Bubble sort
void bubbleSort(int array[], int size, int mode) {
  for (int i = 0; i < size - 1; i++) {
    for (int j = 0; j < size - i - 1; j++) {
      if (mode == SORT_ASC) {
        // Scambio gli elementi adiacenti se non sono in ordine
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      } else if (mode == SORT_DES) {
        if (array[j] < array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        } 
      } else {
        printf("Parametro di ordinamento errato\n");
        return;
      }
    }
    // Togliere i commenti per visualizzare tutti i passaggi
    // printf("Passo %d: confronto %d\n", i, array[i]);
    // printArray(array, size);
  }
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