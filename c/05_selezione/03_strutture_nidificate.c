#include <stdio.h>

int main() {
  int voto;
  printf("Inserisci il tuo voto: ");
  scanf("%d", &voto);
  if (voto < 1 || voto > 10) {
    printf("Il voto deve essere compreso tra 1 e 10");
  } else {
    if (voto < 6) {
      printf("INSUFFICIENTE");
    } else if (voto == 6) {
      printf("SUFFICIENTE");
    } else if (voto == 7) {
      printf("DISCRETO");
    } else if (voto == 8) {
      printf("BUONO");
    } else if (voto == 9) {
      printf("OTTIMO");
    } else if (voto == 10) {
      printf("ECCELLENTE");
    }
  }
  return 0;
}