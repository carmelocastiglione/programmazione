#include <stdio.h>

int main() {
    int a;
    float b;

    scanf("%d", &a);
    scanf("%f", &b);

    printf("You entered integer: %d\n", a);
    printf("You entered float: %.2f\n", b);

    return 0;
}