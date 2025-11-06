#include <stdio.h>

float areaTriangolo(int altezza, int base);

int main() {
    float area;
    int altezza1 = 5, base1 = 10;
    int altezza2 = 7, base2 = 12;
    area = areaTriangolo(altezza1, base1);
    printf("Area del triangolo 1: %.2f\n", area);
    area = areaTriangolo(altezza2, base2);
    printf("Area del triangolo 2: %.2f\n", area);
}

float areaTriangolo(int altezza, int base) {
    return (altezza * base) / 2.0;
}