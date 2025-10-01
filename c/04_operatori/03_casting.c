#include <stdio.h>

int main() {
  int a;
  float b = 5.5;

  a = b;

  // Output: 5
  printf("Il valore di a e': %d\n", a);

  // Output: 5.50
  printf("Il valore di b e': %.2f\n", b);

  int c = 7, d = 2;
  float e;

  e = c / d;

  // Output: 3.00
  printf("Il valore di e e': %.2f\n", e);

  e = (float)c / d;

  // Output: 3.50
  printf("Il valore di e e': %.2f\n", e);

  return 0;
}