#include <stdio.h>
#include <string.h>

#define MAX_LEN 80

void selectionSort(char array[][MAX_LEN], int size);

int main() {
    char v[][MAX_LEN] = {
        "hello",
        "salut",
        "heil",
        "halo",
        "hello",
        "ciao",
        "buongiorno"
    };
        
    printf("Vettore originario:\n");
    for (int i = 0; i < 7; i++) {
        printf("%s\n", v[i]);
    }

    selectionSort(v, 7);

    printf("\n\nVettore ordinato:\n");
    for (int i = 0; i < 7; i++) {
        printf("%s\n", v[i]);
    }
    return 0;
}

void selectionSort(char array[][MAX_LEN], int size) {
    for (int i = 0; i < size; i++) {
        int min_index = i;
        char temp[MAX_LEN];
        for (int j = i + 1; j < size; j++) {
            if (strcmp(array[j], array[min_index]) < 0) {
                min_index = j;
            }
        }
        strcpy(temp, array[min_index]);
        strcpy(array[min_index], array[i]);
        strcpy(array[i], temp);
    }
}