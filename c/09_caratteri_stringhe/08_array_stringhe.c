#include <stdio.h>
#include <string.h>

int main() {
    // Dichiarazione e inizializzazione di un array di stringhe
    char names[3][20];
    for (int i = 0; i < 3; i++) {
        printf("Inserisci un nome: ");
        fgets(names[i], sizeof(names[i]), stdin);
        // Rimuove il carattere di nuova linea aggiunto da fgets
        names[i][strcspn(names[i], "\n")] = '\0';
    }
    // Stampa delle stringhe
    for(int i = 0; i < 3; i++) {
        printf("%s\n", names[i]);
    }
    return 0;
}