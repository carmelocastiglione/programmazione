#include <stdio.h>

int fattoriale(int n);

int main() {
  int numero;
  printf("Inserisci il numero (intero) del fattoriale: ");
  scanf("%d", &numero);
  if (numero < 0) {
    printf("Il numero deve essere maggiore o uguale a zero\n");
  } else {
    printf("Il fattoriale di %d e': %d\n", numero, fattoriale(numero));
  }
  return 0;
}

int fattoriale(int n) {
  if (n == 0) {
    return 1;
  } else {
    return n * fattoriale(n - 1);
  }
}
