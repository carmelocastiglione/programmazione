#include <stdio.h>

int main() {
    // Definisco una struttura per rappresentare un punto in un piano cartesiano
    typedef struct {
        int x;
        int y;
    } punto_t;
    punto_t punti[10]; // Creo un array di 10 punti
    // Inizializzo i punti
    for (int i = 0; i < 10; i++) {
        punti[i].x = i * 10;
        punti[i].y = i * 20;
    }
    // Stampo i punti
    for (int i = 0; i < 10; i++) {
        printf("Punto %d: (%d, %d)\n", i, punti[i].x, punti[i].y);
    }
    return 0;
}