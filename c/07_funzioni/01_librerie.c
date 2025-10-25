#include <stdio.h>
#include <math.h>

int main() {
    int numero;
    float radice;

    printf("Inserisci un numero: ");
    scanf("%d", &numero);

    if (numero < 0) {
        printf("Errore: non è possibile calcolare la radice quadrata di un numero negativo.\n");
    } else {
        radice = sqrt(numero);
        printf("La radice quadrata di %d è %.2f\n", numero, radice);
    }

    return 0;
}