#include <stdio.h>
#include <stdlib.h>

int main() {
  FILE *fp;

  // Apri il file in modalità lettura
  fp = fopen("numeri.txt", "r");
  if (fp == NULL) {
    perror("Errore apertura file"); // o usare printf
    return 1;
  }
  printf("File aperto in modalita' lettura con successo\n");
  fclose(fp);

  // Apri il file in modalità scrittura
  fp = fopen("touch.txt", "w");
  if (fp == NULL) {
    perror("Errore apertura file in scrittura");
    return 1;
  }
  printf("File aperto in modalita' scrittura con successo\n");
  fclose(fp);

  // Apri il file in modalità scrittura/lettura
  fp = fopen("log.txt", "a+");
  if (fp == NULL) {
    perror("Errore apertura file in scrittura/lettura");
    return 1;
  }
  printf("File aperto in modalita' scrittura/lettura con successo\n");
  fclose(fp);

  return 0;
}