#include <stdio.h>
#include <stdlib.h>

typedef struct s_node {
    int val;
    struct s_node * next; // puntatore al prossimo elemento
} node;

void print(node * head);

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
    print(head);

    return 0;
}

void print(node * head) {
    node * current = head;

    while (current != NULL) {
        printf("%d\n", current->val);
        current = current->next;
    }
}