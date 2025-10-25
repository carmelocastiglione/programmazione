#include <stdio.h>

int main() {
  const int total_numbers = 10;
  int max = 0, x;
  
  for (int i = 0; i < total_numbers; i++) {
    printf("Inserisci un numero (%d/%d): ", i + 1, total_numbers);
    scanf("%d", &x);
    if (x > max) {
      max = x;
    }
  }

  printf("Il massimo tra i numeri inseriti e': %d\n", max);

  return 0;
}