#include <stdio.h>
#include <stdlib.h>

int main() {
  FILE *fp;
  int x;

  fp = fopen("numeri.txt", "r");
  if (fp == NULL) {
    perror("Errore apertura file in lettura");
    return 1;
  }
  while (!feof(fp)) {
    fscanf(fp, "%d", &x);
    printf("%d\n", x);
  }
  fclose(fp);

  return 0;
}