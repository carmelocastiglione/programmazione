#include <stdio.h>

int main() {
  printf("- Le variabili in C: occupazione della memoria in byte -\n\n");
  printf("char:\t%d byte\n", sizeof(char));
  printf("short:\t%d byte\n", sizeof(short));
  printf("int:\t%d byte\n", sizeof(int));
  printf("float:\t%d byte\n", sizeof(float));
  printf("long:\t%d byte\n", sizeof(long));
  printf("double:\t%d byte\n", sizeof(double));

  return 0;
}