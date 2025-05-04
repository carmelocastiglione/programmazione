#Contare quante vocali ci sono in una stringa.
testo = input("Inserisci una frase: ")
vocali = "aeiouAEIOU"
conteggio = 0

for lettera in testo:
    if lettera in vocali:
        conteggio += 1

print("Numero di vocali:", conteggio)
