# Verificare se due stringhe inserite sono uguali (case insensitive).
s1 = input("Inserisci la prima stringa: ")
s2 = input("Inserisci la seconda stringa: ")

if s1.lower() == s2.lower():
    print("Le stringhe sono uguali (ignorando maiuscole/minuscole).")
else:
    print("Le stringhe sono diverse.")
