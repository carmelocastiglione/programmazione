#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define DIM 80

typedef struct alunno {
    char cognome[DIM];
    char nome[DIM];
    int classe;
    char sezione;
} alunno_t;

void leggi(alunno_t * pAlunno);

int main() {
    char buffer[DIM];
    // Allocazione di una struttura
    alunno_t * pStruct;
    pStruct = (alunno_t *) malloc(sizeof(alunno_t));
    if (pStruct == NULL) {
        printf("Spazio in memoria insufficiente\n");
        return 1;
    }
    // Primo metodo (complicato)
    printf("Nome: ");
    fgets((*pStruct).nome, DIM, stdin);
    (*pStruct).nome[strlen((*pStruct).nome) - 1] = '\0';
    printf("Cognome: ");
    fgets((*pStruct).cognome, DIM, stdin);
    (*pStruct).cognome[strlen((*pStruct).cognome) - 1] = '\0';
    printf("Classe: ");
    fgets(buffer, DIM, stdin);
    // Converto la stringa letta in un intero
    (*pStruct).classe = atoi(buffer);
    printf("Sezione: ");
    fgets(buffer, DIM, stdin);
    (*pStruct).sezione = buffer[0];
    printf("%s %s %d%c\n", 
        (*pStruct).nome,
        (*pStruct).cognome,
        (*pStruct).classe,
        (*pStruct).sezione
    );
    // Secondo metodo: (*pStruct).campo equivale a pStruct->campo
    printf("Nome: ");
    fgets(pStruct->nome, DIM, stdin);
    pStruct->nome[strlen(pStruct->nome) - 1] = '\0';
    printf("Cognome: ");
    fgets(pStruct->cognome, DIM, stdin);
    pStruct->cognome[strlen(pStruct->cognome) - 1] = '\0';
    printf("Classe: ");
    fgets(buffer, DIM, stdin);
    // Converto la stringa letta in un intero
    pStruct->classe = atoi(buffer);
    printf("Sezione: ");
    fgets(buffer, DIM, stdin);
    pStruct->sezione = buffer[0];
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

void leggi(alunno_t * pAlunno) {
    char buffer[DIM];
    printf("Nome: ");
    fgets(pAlunno->nome, DIM, stdin);
    pAlunno->nome[strlen(pAlunno->nome) - 1] = '\0';
    printf("Cognome: ");
    fgets(pAlunno->cognome, DIM, stdin);
    pAlunno->cognome[strlen(pAlunno->cognome) - 1] = '\0';
    printf("Classe: ");
    fgets(buffer, DIM, stdin);
    // Converto la stringa letta in un intero
    pAlunno->classe = atoi(buffer);
    printf("Sezione: ");
    fgets(buffer, DIM, stdin);
    pAlunno->sezione = buffer[0];
}