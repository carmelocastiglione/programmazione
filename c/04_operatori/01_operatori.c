#include <stdio.h>

int main() {
  // Dichiarazione delle variabili
  int x, precedente, successivo;

  // Input dei dati
  printf("Inserisci un numero: ");
  scanf("%d", &x);

  // Elaborazione
  precedente = x - 1;
  successivo = x + 1;

  // Output dei dati
  printf("Il numero precedente e': %d\n", precedente);
  printf("Il numero successivo e': %d\n", successivo);

  // Uscita
  return 0;
}