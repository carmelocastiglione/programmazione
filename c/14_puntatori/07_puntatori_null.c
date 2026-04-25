/*
Puntatori NULL e validazione:
- NULL: costante che rappresenta un indirizzo non valido (tipicamente 0)
- Sempre verificare che un puntatore sia valido prima di dereferenziarlo
- Buone pratiche: inizializzare a NULL, controllare prima dell'uso
*/

#include <stdio.h>
#include <stdlib.h>

// Funzione che restituisce un puntatore (che potrebbe essere NULL)
int* cercaValore(int *array, int lunghezza, int valore) {
    for (int i = 0; i < lunghezza; i++) {
        if (array[i] == valore) {
            return &array[i];
        }
    }
    return NULL;  // Restituisce NULL se il valore non è trovato
}

// Funzione con validazione di puntatori
void stampaConValidazione(int *pNum) {
    if (pNum == NULL) {
        printf("ERRORE: Puntatore NULL, non posso accedere al valore\n");
        return;
    }
    printf("Valore: %d\n", *pNum);
}

int main() {
    // Dichiarazione e inizializzazione di puntatori
    printf("=== DICHIARAZIONE E INIZIALIZZAZIONE ===\n");
    int *pNum = NULL;  // Buona pratica: inizializzare a NULL
    printf("pNum inizializzato a NULL: %p\n", (void*)pNum);

    // Verifica se un puntatore è NULL
    printf("\n=== VERIFICA DI NULL ===\n");
    if (pNum == NULL) {
        printf("pNum è NULL (non è sicuro dereferenziarlo)\n");
    }

    // Dereferenziamento solo dopo assegnazione valida
    int numero = 42;
    pNum = &numero;  // Ora pNum punta a un indirizzo valido

    if (pNum != NULL) {
        printf("pNum non è NULL, posso accedere al valore: %d\n", *pNum);
    }

    // Uso di funzioni che restituiscono NULL
    printf("\n=== GESTIONE DI PUNTATORI RESTITUITI ===\n");
    int numeri[5] = {10, 20, 30, 40, 50};

    // Ricerca di un valore presente
    int *risultato = cercaValore(numeri, 5, 30);
    if (risultato != NULL) {
        printf("Valore 30 trovato: %d\n", *risultato);
    } else {
        printf("Valore 30 non trovato\n");
    }

    // Ricerca di un valore non presente
    risultato = cercaValore(numeri, 5, 99);
    if (risultato != NULL) {
        printf("Valore 99 trovato: %d\n", *risultato);
    } else {
        printf("Valore 99 non trovato\n");
    }

    // Stampa con validazione
    printf("\n=== STAMPA CON VALIDAZIONE ===\n");
    printf("Stampa di pNum (non NULL):\n  ");
    stampaConValidazione(pNum);

    printf("Stampa di NULL:\n  ");
    int *pNull = NULL;
    stampaConValidazione(pNull);

    // Evitare l'uso di puntatori non inizializzati
    printf("\n=== IMPORTANZA DELL'INIZIALIZZAZIONE ===\n");
    int *pNonInizializzato;  // ATTENZIONE: contiene un valore casuale
    printf("Puntatore non inizializzato contiene: %p (valore casuale!)\n", (void*)pNonInizializzato);
    printf("Dereferenziarlo causerebbe undefined behavior!\n");

    // Buona pratica
    int *pInizializzato = NULL;  // Inizializzato correttamente
    printf("Puntatore inizializzato a NULL: %p\n", (void*)pInizializzato);
    if (pInizializzato == NULL) {
        printf("Posso verificare che è NULL prima di usarlo\n");
    }

    // Impostare a NULL dopo aver liberato memoria
    printf("\n=== IMPOSTARE A NULL DOPO LA LIBERAZIONE ===\n");
    int *pDinamico = (int*)malloc(sizeof(int));  // Alloca memoria
    printf("Memoria allocata: %p\n", (void*)pDinamico);

    if (pDinamico != NULL) {
        *pDinamico = 100;
        printf("Valore assegnato: %d\n", *pDinamico);
    }

    free(pDinamico);  // Libera memoria
    pDinamico = NULL;  // Buona pratica: imposta a NULL dopo free()
    printf("Dopo free(): pDinamico = %p\n", (void*)pDinamico);

    if (pDinamico == NULL) {
        printf("Posso verificare che non è più valido\n");
    }

    return 0;
}
