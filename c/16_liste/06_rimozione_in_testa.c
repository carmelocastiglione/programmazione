#include <stdio.h>
#include <stdlib.h>

typedef struct s_node {
    int val;
    struct s_node * next;
} node;

node * addNodeToStart(node * head, int val);
node * removeNodeFromStart(node * head);
void print(node * head);

int main() {
    node * head = NULL;
    head = addNodeToStart(head, 1);
    head = addNodeToStart(head, 2);
    head = addNodeToStart(head, 3);
    head = removeNodeFromStart(head);

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

node * removeNodeFromStart(node * head) {
    node * next_node = NULL;

    if (head == NULL) {
        return NULL;
    }

    next_node = head->next;
    free(head);
    head = next_node;

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