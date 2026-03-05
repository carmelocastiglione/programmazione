#include <stdio.h>

int main() {
    // Definisco una struttura per rappresentare un punto in un piano cartesiano
    struct Punto {
        int x;
        int y;
    };

    // Creo un'istanza della struttura Punto e la inizializzo
    struct Punto p1 = {10, 20};
    printf("Punto p1: (%d, %d)\n", p1.x, p1.y);

    // Altro esempio (più immediato) di creazione di una struttura con definizione e dichiarazione in un'unica operazione
    struct Persona {
        char nome[50];
        char cognome[50];
        int eta;
    } persona;

    printf("Inserisci il nome: ");
    scanf("%s", persona.nome);
    printf("Inserisci il cognome: ");
    scanf("%s", persona.cognome);
    printf("Inserisci l'età: ");
    scanf("%d", &persona.eta);

    printf("Persona: %s %s, Età: %d\n", persona.nome, persona.cognome, persona.eta);

    return 0;
}