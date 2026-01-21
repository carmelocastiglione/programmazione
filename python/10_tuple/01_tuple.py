# Le tuple sono simili alle liste, ma sono immutabili (non possono essere modificate dopo la creazione).
frutta = ("apple", "banana", "cherry")
print(frutta)

# Gli elementi di una tupla possono essere ripetuti
numeri = (1, 2, 3, 2, 4, 3, 5)
print(numeri)

# Accesso agli elementi di una tupla tramite indice
print(frutta[0])  # Output: apple

# Si possono inserire indici negativi per accedere agli elementi dalla fine
print(frutta[-1])  # Output: cherry

# Le tuple supportano lo slicing
print(frutta[1:3])  # Output: ('banana', 'cherry')
print(numeri[:4])  # Output: (1, 2, 3, 2)
print(numeri[2:])  # Output: (3, 2, 4, 3, 5)

# Controllo della presenza di un elemento in una tupla
print("banana" in frutta)  # Output: True

# Aggiungere una elemento ad una tupla non è possibile, ma si può creare una nuova tupla concatenando due tuple
nuova_frutta = frutta + ("orange",)
print(nuova_frutta)  # Output: ('apple', 'banana', 'cherry', 'orange')

# Unpacking di una tupla
a, b, c = frutta
print(a)  # Output: apple

# Lunghezza di una tupla
print(len(frutta))  # Output: 3

# Ciclo attraverso gli elementi di una tupla
for item in frutta:
    print(item)