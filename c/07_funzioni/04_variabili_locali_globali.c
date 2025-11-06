#include <stdio.h>

void funzione();

int main() {
    int numero = 10; // Variabile locale a main
    printf("Valore di numero in main: %d\n", numero); 
    {
        int numero = 20; // Variabile locale al blocco interno
        printf("Valore di numero nel blocco interno: %d\n", numero);
    }
    printf("Valore di numero in main dopo il blocco interno: %d\n", numero);
    funzione();
    printf("Valore di numero in main dopo il blocco interno: %d\n", numero);
    return 0;
}

void funzione() {
    int numero = 30; // Variabile locale a funzione
    printf("Valore di numero in funzione: %d\n", numero);
}   