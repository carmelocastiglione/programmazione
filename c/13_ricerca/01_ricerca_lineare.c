#include <stdio.h>
#include <time.h>
#include <stdlib.h>

// Imposta questi parametri a piacere
#define ARRAY_LENGTH 10
#define MAX_NUMBER 10

void generateArray(int array[], int size);
void printArray(int array[], int size);
int linearSearch(int array[], int size, int n);

int main() {
    int data[ARRAY_LENGTH];
    int size = sizeof(data)/sizeof(data[0]);
    int num;
    srand(time(NULL));
    generateArray(data, size);
    printf("Vettore iniziale:\n");
    printArray(data, size);
    printf("Inserisci un numero da cercare: ");
    scanf("%d", &num);
    int pos = linearSearch(data, size, num);
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

// Ricerca un numero n in un vettore array di dimensione size
// Ritorna la posizione del primo elemento trovato, o -1 se non trova nulla
int linearSearch(int array[], int size, int n) {
    for (int i = 0; i < size; i++) {
        if (array[i] == n) {
            return i;
        }
    }
    return -1;
}