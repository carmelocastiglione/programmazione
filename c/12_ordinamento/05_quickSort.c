/* Quick sort
 La quick sort è un algoritmo di ordinamento efficiente basato sul principio del divide et impera. Sceglie un elemento come pivot e partiziona l'array in due sotto-array: uno con elementi minori del pivot e uno con elementi maggiori del pivot. Questo processo viene ripetuto ricorsivamente sui sotto-array fino a quando l'array è ordinato.
 La complessità temporale è O(n log n) nel caso medio, ma può degradare a O(n^2) nel caso peggiore se il pivot non è scelto correttamente.
 E' uno degli algoritmi di ordinamento più efficienti per grandi insiemi di dati.
*/

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

// Imposta questi parametri a piacere
#define ARRAY_LENGTH 10
#define MAX_NUMBER 100
// Richiesti dalla funzione quickSort
#define SORT_ASC 0
#define SORT_DES 1

void printArray(int array[], int size);
void generateArray(int array[], int size);
void quickSort(int array[], int size, int mode);
void quickSortHelper(int array[], int low, int high, int mode);
int partition(int array[], int low, int high, int mode);

int main() {
    int data[ARRAY_LENGTH];
    int size = sizeof(data)/sizeof(data[0]);
    srand(time(NULL));
    generateArray(data, size);
    printf("Vettore iniziale:\n");
    printArray(data, size);
    printf("Vettore ordinato in maniera ascendente:\n");
    quickSort(data, size, SORT_ASC);
    printArray(data, size);
    printf("Vettore ordinato in maniera discendente:\n");
    quickSort(data, size, SORT_DES);
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

// Quicksort - funzione principale
void quickSort(int array[], int size, int mode) {
  if (mode != SORT_ASC && mode != SORT_DES) {
    printf("Parametro di ordinamento errato\n");
    return;
  }
  quickSortHelper(array, 0, size - 1, mode);
}

// Quicksort - funzione ricorsiva helper
void quickSortHelper(int array[], int low, int high, int mode) {
  if (low < high) {
    // Partiziona l'array e ottieni l'indice del pivot
    int pi = partition(array, low, high, mode);
    
    // Ordina ricorsivamente i sottoinsiemi
    quickSortHelper(array, low, pi - 1, mode);
    quickSortHelper(array, pi + 1, high, mode);
  }
}

// Partiziona l'array attorno a un pivot
int partition(int array[], int low, int high, int mode) {
  // Scegli l'ultimo elemento come pivot
  int pivot = array[high];
  
  // Indice dell'elemento più piccolo (o più grande per discendente)
  int i = low - 1;
  
  for (int j = low; j < high; j++) {
    int swap = 0;
    
    if (mode == SORT_ASC) {
      // Per ordinamento ascendente: elementi minori del pivot a sinistra
      if (array[j] < pivot) {
        swap = 1;
      }
    } else if (mode == SORT_DES) {
      // Per ordinamento discendente: elementi maggiori del pivot a sinistra
      if (array[j] > pivot) {
        swap = 1;
      }
    }
    
    if (swap) {
      i++;
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }
  
  // Posiziona il pivot nella sua posizione corretta
  int temp = array[i + 1];
  array[i + 1] = array[high];
  array[high] = temp;
  
  return i + 1;
}

