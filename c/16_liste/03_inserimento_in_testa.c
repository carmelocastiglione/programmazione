#include <stdio.h>
#include <stdlib.h>

typedef struct s_node {
    int val;
    struct s_node * next;
} node;

node * addNodeToStart(node * head, int val);
void print(node * head);

int main() {
    node * head = NULL;
    head = addNodeToStart(head, 1);
    head = addNodeToStart(head, 2);
    head = addNodeToStart(head, 3);

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