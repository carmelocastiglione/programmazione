#include <stdio.h>

int main() {
    // Utilizzo di typedef per semplificare la dichiarazione di strutture
    typedef struct {
        int x;
        int y;
    } punto_t;
    // Creo un'istanza della struttura Punto e la inizializzo
    punto_t punto = {10, 20};
    printf("Punto p1: (%d, %d)\n", punto.x, punto.y);
}