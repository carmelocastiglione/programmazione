#include <stdio.h>
#include <string.h>

int main() {
    char stringa1[100];
    char stringa2[100];

    // strlen() restituisce la lunghezza di una stringa di caratteri
    // Sintassi di strlen:
    // size_t strlen(const char *str);

    // Leggere la prima stringa
    printf("Inserisci la prima stringa (max 99 caratteri): ");
    if (fgets(stringa1, sizeof(stringa1), stdin) != NULL) {
        // Rimuovere il newline se presente
        int len = strlen(stringa1);
        if (len > 0 && stringa1[len - 1] == '\n') {
            stringa1[len - 1] = '\0';
        }
    } else {
        printf("Errore nella lettura della prima stringa.\n");
        return 1;
    }

    // Leggere la seconda stringa
    printf("Inserisci la seconda stringa (max 99 caratteri): ");
    if (fgets(stringa2, sizeof(stringa2), stdin) != NULL) {
        // Rimuovere il newline se presente
        int len = strlen(stringa2);
        if (len > 0 && stringa2[len - 1] == '\n') {
            stringa2[len - 1] = '\0';
        }
    } else {
        printf("Errore nella lettura della seconda stringa.\n");
        return 1;
    }

    // Confrontare le due stringhe usando strcmp()
    // strcmp() confronta due stringhe di caratteri
    // Sintassi di strcmp:
    // int strcmp(const char *str1, const char *str2);

    int risultato = strcmp(stringa1, stringa2);
    if (risultato == 0) {
        printf("Le due stringhe sono uguali.\n");
    } else if (risultato < 0) {
        printf("La prima stringa è minore della seconda.\n");
    } else {
        printf("La prima stringa è maggiore della seconda.\n");
    }

    // Copiare una stringa in un'altra usando strcpy()
    // Sintassi di strcpy:
    // char *strcpy(char *dest, const char *src);
    char copia[100];
    strcpy(copia, stringa1);
    printf("Copia della prima stringa: %s\n", copia);

    // Concatenare due stringhe usando strcat()
    // Sintassi di strcat:
    // char *strcat(char *dest, const char *src);
    char concatenata[200];
    strcpy(concatenata, stringa1);
    strcat(concatenata, stringa2);
    printf("Stringa concatenata: %s\n", concatenata);

    return 0;
}