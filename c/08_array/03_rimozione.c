#include <stdio.h>

void init(int v[], int size);
void print(int v[], int size);
void remove(int v[], int size, int index);

int main() {
    const int SIZE = 5;
    int v[SIZE];
    init(v, SIZE);
    print(v, SIZE);
    add(v, SIZE, 0, 99);
    add(v, SIZE, 1, 88);
    add(v, SIZE, 2, 77);
    add(v, SIZE, 3, 66);
    add(v, SIZE, 4, 55);
    print(v, SIZE);
    remove(v, SIZE, 2);
    print(v, SIZE);
    return 0;
}

void init(int v[], int size) {
    for (int i = 0; i < size; i++) {
        v[i] = 0;
    }
}

void print(int v[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", v[i]);
    }
    printf("\n");
}

void remove(int v[], int size, int index) {
    if (index < 0 || index >= size) {
        printf("Index out of bounds\n");
        return;
    }
    for (int i = index; i < size - 1; i++) {
        v[i] = v[i + 1];
    }
    v[size - 1] = 0; // Optional: clear the last element
}