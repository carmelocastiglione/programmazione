# Creare una nuova stringa dove tutte le vocali sono sostituite da *.
testo = input("Inserisci una frase: ")
vocali = "aeiouAEIOU"
nuovo_testo = ""

for c in testo:
    if c in vocali:
        nuovo_testo += "*"
    else:
        nuovo_testo += c

print("Frase modificata:", nuovo_testo)
