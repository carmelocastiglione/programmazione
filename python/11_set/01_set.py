# I set sono collezioni non ordinate di elementi unici. Non permettono duplicati e non sono indicizzati (non puoi accedere agli elementi tramite indice). Non è possibile modificare gli elementi di un set, ma è possibile aggiungere o rimuovere elementi.
frutti = {"apple", "banana", "cherry"}
print(frutti)

# Aggiungere un elemento ad un set
frutti.add("orange")
print(frutti)

# Rimuovere un elemento da un set tramite remove() o discard()
frutti.remove("banana") # Genera un errore se l'elemento non esiste
print(frutti)
frutti.discard("grape")  # Non genera errore se l'elemento non esiste
print(frutti)

# Controllo della presenza di un elemento in un set
print("apple" in frutti)  # Output: True
print("banana" in frutti)  # Output: False

# Accedere agli elementi di un set tramite ciclo
for frutto in frutti:
    print(frutto)

# Aggiungere più elementi ad un set
frutti.update(["kiwi", "mango"])
print(frutti)

# Svuotare un set
frutti.clear()
print(frutti)  # Output: set()
