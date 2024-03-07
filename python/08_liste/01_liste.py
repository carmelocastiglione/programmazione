# List is a collection which is ordered and changeable. Allows duplicate members.
# Tuple is a collection which is ordered and unchangeable. Allows duplicate members.
# Set is a collection which is unordered, unchangeable*, and unindexed. No duplicate members.
# Dictionary is a collection which is ordered** and changeable. No duplicate members.

# Creazione di una lista
lista = ["mela", "pesca", "uva", "banana", "albicocca"]
print("Frutta:", lista)

# Elementi di una lista
lunghezza_lista = len(lista)
print("Numero di elementi:", lunghezza_lista)

# Primo e ultimo elemento
primo = lista[0]
ultimo = lista[-1]
print("Primo:", primo)
print("Ultimo", ultimo)

# Sottoinsiemi di elementi
sottoinsieme = lista[1:3]
print("Sottoinsieme:", sottoinsieme)
sottoinsieme = lista[1:]
print("Sottoinsieme:", sottoinsieme)

# Controllo se un elemento è nella lista
if "mela" in lista:
    print("La mela è nella lista")

# Aggiungere elementi alla lista in coda
lista.append("melone")
print("Frutta:", lista)

# Aggiungere elementi alla lista in una posizione
lista.insert(2, "arancia")
print("Frutta:", lista)

# Rimuovere un elemento specifico
lista.remove("banana")
print("Frutta:", lista)

# Rimuovere un elemento ad una posizione
lista.pop(2)
print("Frutta:", lista)

# Liste nei cicli
for frutta in lista:
    print(frutta)

# Ordinare una lista
lista.sort()
print("Frutta:", lista)

# Ordinare una lista in maniera decrescente
lista.sort(reverse = True)
print("Frutta:", lista)

# Copiare una lista
nuova_lista = lista.copy()
print("Nuova lista:", lista)

# Unire le liste
lista_unione = lista + nuova_lista
print("Unione: ", lista_unione)

# Svuoto la lista
lista.clear()
print("Frutta:", lista)