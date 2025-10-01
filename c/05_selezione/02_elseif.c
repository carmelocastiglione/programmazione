/*
 * Programma che calcola il maggiore tra due numeri
 */

#include <stdio.h>

int main() {
  int a, b;
  printf("Inserisci il primo numero: ");
  scanf("%d", &a);
  printf("Inserisci il secondo numero: ");
  scanf("%d", &b);
  if (a > b) {
    printf("Il primo numero e' maggiore del secondo");
  } else if (a < b) {
    printf("Il secondo numero e' maggiore del primo");
  } else {
    printf("I due numeri sono uguali");
  }

  return 0;
}