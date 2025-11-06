#include <stdio.h>

int fibonacci(int n);

int main() {
  int numero;
  printf("Inserisci il numero (intero) fino al quale contare la successione di Fibonacci: ");
  scanf("%d", &numero);
  if (numero < 0) {
    printf("Il numero deve essere maggiore o uguale a zero\n");
  } else {
    printf("Il numero di Fibonacci alla posizione %d e': %d\n", numero, fibonacci(numero));
  }
    return 0;
}

int fibonacci(int n) {
  if (n == 0) {
    return 0;
  } else if (n == 1) {
    return 1;
  } else {
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}
