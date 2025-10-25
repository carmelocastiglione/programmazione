#include <stdio.h>
#include <stdlib.h> // Per rand() e srand()
#include <time.h> // Per time()

int main() {
    int numero_casuale, tentativo, tentativi_effettuati = 0;
    const int MAX_TENTATIVI = 5;

    // Inizializza il generatore di numeri casuali
    srand(time(NULL));
    numero_casuale = rand() % 100 + 1; // Numero casuale tra 1 e 100

    printf("Indovina il numero tra 1 e 100! Hai %d tentativi.\n", MAX_TENTATIVI);

    while (tentativi_effettuati < MAX_TENTATIVI) {
        printf("Inserisci il tuo tentativo: ");
        scanf("%d", &tentativo);
        tentativi_effettuati++;

        if (tentativo < numero_casuale) {
            printf("Troppo basso!\n");
        } else if (tentativo > numero_casuale) {
            printf("Troppo alto!\n");
        } else {
            printf("Congratulazioni! Hai indovinato il numero %d in %d tentativi.\n", numero_casuale, tentativi_effettuati);
            break;
        }
    }

    if (tentativi_effettuati == MAX_TENTATIVI && tentativo != numero_casuale) {
        printf("Mi dispiace, hai esaurito i tentativi. Il numero era %d.\n", numero_casuale);
    }

    return 0;
}