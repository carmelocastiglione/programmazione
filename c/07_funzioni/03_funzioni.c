#include <stdio.h>

void inizio();
void fine();
void calcolaPerimetroQuadrato();

int main() {
    inizio();
    calcolaPerimetroQuadrato();
    fine();
    return 0;
}

void inizio() {
  printf("***** B E N V E N U T I *****\n");
}

void fine() {
  printf("***** A R R I V E D E R C I *****\n");
}

void calcolaPerimetroQuadrato() {
    float lato, perimetro;
    printf("Inserisci la lunghezza del lato del quadrato: ");
    scanf("%f", &lato);
    perimetro = 4 * lato;
    printf("Il perimetro del quadrato è: %.2f\n", perimetro);
}