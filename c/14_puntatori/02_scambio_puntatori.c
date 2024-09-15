#include <stdio.h>

int main() {
    int num1 = 10;
    int num2 = 20;
    int temp;
    int * pNum1;
    int * pNum2;

    // Scambio tramite variabili
    temp = num1;
    num1 = num2;
    num2 = temp;
    printf("num1 = %d \t num2 = %d\n", num1, num2);

    // Scambio tramite puntatori
    pNum1 = &num1;
    pNum2 = &num2;
    temp = *pNum1;
    *pNum1 = *pNum2;
    *pNum2 = temp;
    printf("num1 = %d \t num2 = %d\n", num1, num2);

    return 0;
}