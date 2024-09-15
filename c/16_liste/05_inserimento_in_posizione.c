#include <stdio.h>
#include <stdlib.h>

typedef struct s_node {
    int val;
    struct s_node * next;
} node;

node * addNodeToEnd(node * head, int val);
node * addNodeToPosition(node * head, int val, int pos);
void print(node * head);

int main() {
    node * head = NULL;
    head = addNodeToEnd(head, 1);
    head = addNodeToEnd(head, 2);
    head = addNodeToEnd(head, 3);
    head = addNodeToPosition(head, 4, 0);
    head = addNodeToPosition(head, 5, 2);
    head = addNodeToPosition(head, 6, 10);

    // Stampo la lista
    print(head);

    return 0;
}

/*
    Inserimento in testa:
    1: creo un nuovo nodo
    2: collego il primo elemento della lista come prossimo elemento del nuovo nodo
    3: assegno la testa della lista al nuovo elemento
*/ 

node * addNodeToEnd(node * head, int val) {
    node * current = head;
    node * new_node = NULL;
    // Creo il nodo
    new_node = (node *) malloc(sizeof(node));
    new_node->val = val;
    new_node->next = NULL;
    // Se la lista è vuota, lo aggiungo all'inizio
    if (head == NULL) {
        head = new_node;
    } else {
        // Cerco l'ultimo elemento della lista e aggiungo il nodo al termine
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = new_node;
    }
    return head;
}

node * addNodeToPosition(node * head, int val, int pos) {
    node * current = head;
    node * new_node = NULL;
    int i = 0;
    // Creo il nodo
    new_node = (node *) malloc(sizeof(node));
    new_node->val = val;
    new_node->next = NULL;
    // Se la lista è vuota, lo aggiungo all'inizio
    if (head == NULL) {
        head = new_node;
    } else if (pos == 0) {
        // Se pos = 0 inserisco in testa
        new_node->next = head;
        head = new_node;
    } else {
        // Cerco la posizione e aggiungo il nodo
        while (current->next != NULL) {
            if (i == pos - 1) {
                new_node->next = current->next;
                current->next = new_node;
                break;
            }
            i++;
            current = current->next;
        }
        // Se pos è maggiore della lunghezza della lista, aggiungo in coda
        current->next = new_node;
    }
    return head;
}

void print(node * head) {
    node * current = head;

    while (current != NULL) {
        printf("%d\n", current->val);
        current = current->next;
    }
}