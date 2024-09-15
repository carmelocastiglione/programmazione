#include <stdio.h>
#include <stdlib.h>

typedef struct s_alunno {
    char cognome[80];
    char nome[80];
    int classe;
    char sezione;
} alunno;

void leggi(alunno * pAlunno);

int main() {
    // Allocazione di una struttura
    alunno * pStruct;
    pStruct = (alunno *) malloc(sizeof(alunno));
    if (pStruct == NULL) {
        printf("Spazio in memoria insufficiente\n");
        return 1;
    }
    // Primo metodo (complicato)
    printf("Nome: ");
    scanf("%s", (*pStruct).nome);
    printf("Cognome: ");
    scanf("%s", (*pStruct).cognome);
    printf("Classe: ");
    scanf("%d", &(*pStruct).classe);
    while (getchar() != '\n');
    printf("Sezione: ");
    scanf("%c", &(*pStruct).sezione);
    printf("%s %s %d%c\n", 
        (*pStruct).nome,
        (*pStruct).cognome,
        (*pStruct).classe,
        (*pStruct).sezione
    );
    // Secondo metodo: (*pStruct).campo equivale a pStruct->campo
    printf("Nome: ");
    scanf("%s", pStruct->nome);
    printf("Cognome: ");
    scanf("%s", pStruct->cognome);
    printf("Classe: ");
    scanf("%d", &pStruct->classe);
    while (getchar() != '\n');
    printf("Sezione: ");
    scanf("%c", &pStruct->sezione);
    printf("%s %s %d%c\n", 
        pStruct->nome,
        pStruct->cognome,
        pStruct->classe,
        pStruct->sezione
    );
    // Terzo metodo: passaggio di struttura ad una funzione
    leggi(pStruct);
    printf("%s %s %d%c\n", 
        pStruct->nome,
        pStruct->cognome,
        pStruct->classe,
        pStruct->sezione
    );
    free(pStruct);
    return 0;
}

void leggi(alunno * pAlunno) {
    printf("Nome: ");
    scanf("%s", pAlunno->nome);
    printf("Cognome: ");
    scanf("%s", pAlunno->cognome);
    printf("Classe: ");
    scanf("%d", &pAlunno->classe);
    while (getchar() != '\n');
    printf("Sezione: ");
    scanf("%c", &pAlunno->sezione);
}