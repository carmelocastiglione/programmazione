#include <stdio.h>

int main() {
  int i = 1, stop;

  printf("Da 1 a 100 dimmi quando mi devo fermare: ");
  scanf("%d", &stop);

  while (i <= 100) {
    if (i > stop) {
      break;
    }
    printf("%d\n", i++);
  }

  return 0;
}