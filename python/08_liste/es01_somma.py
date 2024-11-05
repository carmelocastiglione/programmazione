lista = []
somma = 0
for i in range(5):
    num = int(input(str(i) + " Inserisci un numero: "))
    lista.append(num)
print(lista)
for numero in lista:
    somma = somma + numero
print(somma)
