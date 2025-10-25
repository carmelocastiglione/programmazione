#include <stdio.h>

int main() {
  const int numeri_da_sommare = 5;
  int i = 1, numero, somma = 0;

  while (i <= numeri_da_sommare) {
    printf("Inserisci un numero: ");
    scanf("%d", &numero);
    somma = somma + numero;
    i++;
  }

  printf("La somma dei numeri e': %d\n", somma);

  return 0;
}