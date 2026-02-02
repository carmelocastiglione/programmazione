#include <stdio.h>
#include <ctype.h>

int main() {
    char carattere;
    printf("Inserisci un carattere: ");
    carattere = getchar();
    // Utilizzo di alcune funzioni della libreria ctype.h
    // isalpha() verifica se il carattere è una lettera dell'alfabeto
    if (isalpha(carattere)) {
        printf("'%c' e' una lettera dell'alfabeto.\n", carattere);
    } 
    // isdigit() verifica se il carattere è una cifra decimale
    if (isdigit(carattere)) {
        printf("'%c' e' una cifra decimale.\n", carattere);
    } 
    // islower() verifica se il carattere è una lettera minuscola
    if (islower(carattere)) {
        printf("'%c' e' una lettera minuscola.\n", carattere);
    } 
    // isupper() verifica se il carattere è una lettera maiuscola
    if (isupper(carattere)) {
        printf("'%c' e' una lettera maiuscola.\n", carattere);
    } 
    // isspace() verifica se il carattere è uno spazio bianco
    if (isspace(carattere)) {
        printf("'%c' e' uno spazio bianco.\n", carattere);
    }
    // ispunct() verifica se il carattere è un carattere di punteggiatura
    if (ispunct(carattere)) {
        printf("'%c' e' un carattere di punteggiatura.\n", carattere);
    }
    // isalnum() verifica se il carattere è alfanumerico
    if (isalnum(carattere)) {
        printf("'%c' e' un carattere alfanumerico.\n", carattere);
    }
    // isprint() verifica se il carattere è stampabile (inclusi gli spazi)
    if (isprint(carattere)) {
        printf("'%c' e' un carattere stampabile.\n", carattere);
    }
    // iscntrl() verifica se il carattere è un carattere di controllo (\n, \t, ecc.)
    if (iscntrl(carattere)) {
        printf("'%c' e' un carattere di controllo.\n", carattere);
    }
    // isxdigit() verifica se il carattere è una cifra esadecimale
    if (isxdigit(carattere)) {
        printf("'%c' e' una cifra esadecimale.\n", carattere);
    }

    // Conversione tra maiuscole e minuscole
    if (isalpha(carattere)) {
        // toupper() converte una lettera minuscola in maiuscola
        char maiuscola = toupper(carattere);
        printf("La versione maiuscola di '%c' e' '%c'.\n", carattere, maiuscola);
        // tolower() converte una lettera maiuscola in minuscola
        char minuscola = tolower(carattere);
        printf("La versione minuscola di '%c' e' '%c'.\n", carattere, minuscola);
    }

    return 0;
}