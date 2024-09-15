#include <stdio.h>
#include <stdlib.h>

typedef struct s_node {
    int val;
    struct s_node * next;
} node;

node * addNodeToStart(node * head, int val);
node * removeNodeFromEnd(node * head);
void print(node * head);

int main() {
    node * head = NULL;
    head = addNodeToStart(head, 1);
    head = addNodeToStart(head, 2);
    head = addNodeToStart(head, 3);
    head = removeNodeFromEnd(head);

    // Stampo la lista
    print(head);

    return 0;
}

/*
    Rimozione dalla testa:
    1: salvo il nodo successivo al nodo in testa
    2: libero la testa
    3: assegno come testa l'elemento salvato precedentemente
*/ 

node * removeNodeFromEnd(node * head) {
    // se la lista è vuota, ritorno NULL 
    if (head == NULL) {
        return NULL;
    }
    // se c'è un solo elemento nella lista, lo elimino
    if (head->next == NULL) {
        free(head);
        return NULL;
    }

    // cerco il penultimo elemento della lista 
    node * current = head;
    while (current->next->next != NULL) {
        current = current->next;
    }

    // rimuovo current->next che è l'ultimo elemento in lista
    free(current->next);
    current->next = NULL;
    return head;
}

node * addNodeToStart(node * head, int val) {
    node * new_node;
    new_node = (node *) malloc(sizeof(node));

    new_node->val = val;
    new_node->next = head;
    head = new_node;

    return head;
}

void print(node * head) {
    node * current = head;

    while (current != NULL) {
        printf("%d\n", current->val);
        current = current->next;
    }
}