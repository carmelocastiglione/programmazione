#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <stdbool.h>

// Imposta questi parametri a piacere
#define ARRAY_LENGTH 10
#define MAX_NUMBER 10

void generateArray(int array[], int size);
void printArray(int array[], int size);
int binarySearch(int array[], int size, int n);
void bubbleSort(int array[], int size);

int main() {
    int data[ARRAY_LENGTH];
    int size = sizeof(data)/sizeof(data[0]);
    int num;
    srand(time(NULL));
    generateArray(data, size);
    // Ordino il vettore
    bubbleSort(data, size);
    printf("Vettore iniziale ordinato:\n");
    printArray(data, size);
    printf("Inserisci un numero da cercare: ");
    scanf("%d", &num);
    int pos = binarySearch(data, size, num);
    if (pos == -1) {
        printf("Numero non trovato\n");
    } else {
        printf("Numero trovato alla posizione %d\n", pos);
    }

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

// Ricerca un numero n in un vettore ORDINATO array di dimensione size
// Ritorna la posizione del primo elemento trovato, o -1 se non trova nulla
int binarySearch(int array[], int size, int n) {
    int low = 0;
    int high = size - 1;
    // Cerco il numero al centro del vettore
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (array[mid] == n) {
            return mid;
        }
        if (array[mid] < n) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}

// Bubble sort
void bubbleSort(int array[], int size) {
  for (int i = 0; i < size - 1; i++) {
    for (int j = 0; j < size - i - 1; j++) {
        // Scambio gli elementi adiacenti se non sono in ordine
        if (array[j] > array[j + 1]) {
            int temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
        }
    }
  }
}