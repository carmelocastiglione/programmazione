#include <stdio.h>
#include <stdlib.h>

typedef struct s_node {
    int val;
    struct s_node * next; // puntatore al prossimo elemento
} node;

int main() {
    // Definisco la testa della lista
    node * head = NULL;
    head = (node *) malloc(sizeof(node));
    if (head == NULL) {
        return 1;
    }
    // Inserisco dei valori
    head->val = 1;
    head->next = NULL;

    // Creo un altro elemento
    node * elem = NULL;
    elem = (node *) malloc(sizeof(node));
    if (head == NULL) {
        return 1;
    }
    // Inserisco dei valori
    elem->val = 2;
    elem->next = NULL;
    // Collego i due elementi
    head->next = elem;

    // Stampo la lista
    printf("%d ", head->val);
    printf("%d", head->next->val);

    return 0;
}