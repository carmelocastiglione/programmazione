#include <stdio.h>
#include <stdlib.h>

int main()
{
  FILE *fp;
  fp = fopen("stampa.txt", "w");
  if (fp == NULL) {
    perror("Errore apertura file in scrittura");
    return 1;
  }
  fprintf(fp, "Ciao, questo e' un file di testo creato con fprintf!\n");
  for (int i = 1; i <= 20; i++){
    fprintf(fp, "%d\n", i);
  }

  fclose(fp);

  return 0;
}