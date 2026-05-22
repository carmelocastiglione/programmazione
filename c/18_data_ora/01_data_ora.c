/* 
   Programma per stampare la data e l'ora corrente
   Utilizza la libreria time.h per ottenere e formattare la data e l'ora
   Utilizza la struttura tm per accedere ai componenti della data e dell'ora
   La funzione time() ottiene il tempo corrente in secondi dal 1 gennaio 1970
   La funzione localtime() converte il tempo in una struttura tm con l'ora locale
*/

#include <stdio.h>
#include <time.h>

int main() {
    time_t current_time;
    struct tm *local_time;

    // Ottieni l'ora corrente
    time(&current_time);
    local_time = localtime(&current_time);

    // Stampa l'ora corrente
    printf("Ora corrente: %02d:%02d:%02d\n",
           local_time->tm_hour,
           local_time->tm_min,
           local_time->tm_sec);

    // Stampa la data corrente
    printf("Data corrente: %02d/%02d/%04d\n",
           local_time->tm_mday,
           local_time->tm_mon + 1, // I mesi vanno da 0 a 11
           local_time->tm_year + 1900); // Gli anni partono da 1900

    return 0;
}