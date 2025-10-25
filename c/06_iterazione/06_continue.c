#include <stdio.h>

int main() {
  int i = 1, stop;

  printf("Da 1 a 100 dimmi stampa solo i pari: ");
  scanf("%d", &stop);

  while (i <= 100) {
    if (i % 2 != 0) {
      i++;
      continue;
    }
    printf("%d\n", i++);
  }

  return 0;
}