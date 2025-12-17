#include <stdio.h>

int main() {
    // Dichiarazione e inizializzazione di un array di interi
    int arr[] = {10, 20, 30, 40, 50};
    int new_arr[3];

    // Stampo gli elementi dell'array
    for(int i = 0; i < 5; i++) {
        printf("Element at index %d: %d\n", i, arr[i]);
    }

    // Modifico un elemento dell'array
    arr[2] = 99;
    printf("After modification, element at index 2: %d\n", arr[2]);

    return 0;
}