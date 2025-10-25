#include <stdio.h>

int main() {
  int count = 0, numero;

  printf("Inserisci un numero per volta, confermandolo con invio. Scrivi 0 per terminare\n");

  do {
    scanf("%d", &numero);
    count++;
  } while (numero != 0);

  printf("Hai inserito %d numeri", --count);

  return 0;
}