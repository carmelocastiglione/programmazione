lista = ["aaaaaaa", "bbbbbbb", "bvvosdjfisod", "anna", "anno", "be"]
contatore = 0
for stringa in lista:
    if (len(stringa) > 2) and (stringa[0] == stringa[-1]):
        contatore += 1
print(contatore)