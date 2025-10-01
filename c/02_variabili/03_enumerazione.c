#include <stdio.h>

int main() {
  enum mesi {
    gennaio = 1,
    febbraio,
    marzo,
    aprile,
    maggio,
    giugno,
    luglio,
    agosto,
    settembre,
    ottobre,
    novembre,
    dicembre
  };
  printf("L'ultimo mese dell'anno e': %d\n", dicembre);
  return 0;
}