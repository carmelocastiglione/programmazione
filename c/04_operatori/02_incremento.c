#include <stdio.h>

int main() {
  int x, y, z;

  // x = 9
  x = 9;

  // y = 9, x = 10
  y = x++;

  // y = 10, z = 10
  z = ++y;

  printf("Il valore di x e': %d\n", x);
  printf("Il valore di y e': %d\n", y);
  printf("Il valore di z e': %d\n", z);

  return 0;
}