#include <stdio.h>

int main() {
  int voto;

  printf("Inserisci il tuo voto: ");
  scanf("%d", &voto);

  switch (voto) {
  case 1:
  case 2:
  case 3:
  case 4:
  case 5:
    printf("INSUFFICIENTE");
    break;
  case 6:
    printf("SUFFICIENTE");
    break;
  case 7:
    printf("DISCRETO");
    break;
  case 8:
    printf("BUONO");
    break;
  case 9:
    printf("OTTIMO");
    break;
  case 10:
    printf("ECCELLENTE");
    break;
  default:
    printf("Il voto deve essere compreso tra 1 e 10");
    break;
  }

  return 0;
}