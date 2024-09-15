#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct s_squadra {
        char nome[80];
        int scudetti;
    } squadra;

int ricerca(squadra array[], int size, char nome[]);
void ordinaAlfabeticamente(squadra array[], int size);
void ordinaPerScudetti(squadra array[], int size);

int main () {
    // Dichiarazione variabili
    squadra squadra[100];
    FILE *fp;
    char filename[] = "es_01_campionati.txt";
    char siglaNonDisputato[] = "*ND*";
    char siglaNonAssegnato[] = "*NA*";
    char squadraLetta[80];
    int scudettiNonAssegnati = 0;
    int scudettiNonDisputati = 0;
    int squadreVincitrici = 0;
    int pos;
    // Lettura file
    if ((fp = fopen(filename, "r")) == NULL) {
        printf("Errore apertura file\n");
        return 1;
    }
    while (!feof(fp)) {
        fscanf(fp, "%s", squadraLetta);
        // Aggiorno scudetti non disputati o non assegnati
        if (strcmp(squadraLetta, siglaNonAssegnato) == 0) {
            scudettiNonAssegnati++;
        } else if (strcmp(squadraLetta, siglaNonDisputato) == 0) {
            scudettiNonDisputati++;
        } else {
            // Altrimenti, cerco se la squadra e' presente nella struttura
            pos = ricerca(squadra, squadreVincitrici, squadraLetta);
            // Se non la trovo, la aggiungo alla struttura
            if (pos == -1) {
                strcpy(squadra[squadreVincitrici].nome, squadraLetta);
                squadra[squadreVincitrici].scudetti = 1;
                squadreVincitrici++;
                // Ordino alfabeticamente la struttura
                ordinaAlfabeticamente(squadra, squadreVincitrici);
            } else {
                // Se la trovo, incremento gli scudetti vinti
                squadra[pos].scudetti++;
            }
        }
    }
    ordinaPerScudetti(squadra, squadreVincitrici);
    // Stampo la classifica
    printf("==============================\n");
    printf("Classifica vittorie campionato\n");
    printf("==============================\n");
    printf("Pos.\tSquadra\t\tScudetti\n");
    for (int i = 0; i < squadreVincitrici; i++) {
        printf("%d.\t%-10s\t%d\n", i+1, squadra[i].nome, squadra[i].scudetti);
    }
    printf("Non disputati:\t%d\n", scudettiNonDisputati);
    printf("Non assegnati:\t%d\n", scudettiNonAssegnati);
    return 0;
}

int ricerca(squadra array[], int size, char nome[]) {
    int low = 0;
    int high = size - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (strcmp(array[mid].nome, nome) == 0) {
            return mid;
        }
        if (strcmp(array[mid].nome, nome) < 0) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}

void ordinaAlfabeticamente(squadra array[], int size) {
  for (int i = 1; i < size; i++) {
    squadra key = array[i];
    int j = i - 1;
    while (strcmp(key.nome, array[j].nome) < 0 && j >= 0) {
        array[j + 1] = array[j];
        j--;
    }
    array[j + 1] = key; 
  }
}

void ordinaPerScudetti(squadra array[], int size) {
  for (int i = 0; i < size - 1; i++) {
    bool swapped = false;
    for (int j = 0; j < size - i - 1; j++) {
        if (array[j].scudetti < array[j + 1].scudetti) {
          squadra temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          swapped = true;
        }
    }
    if (swapped == false) {
      break;
    }
  }
}