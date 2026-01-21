# I dizionari sono collezioni non ordinate di coppie chiave-valore. Le chiavi devono essere uniche (non sono ammessi duplicati) e immutabili, mentre i valori possono essere di qualsiasi tipo.
persona = {"nome": "Alice", "età": 30, "città": "Roma"}
print(persona) 

# Accesso ai valori tramite le chiavi (due metodi)
nome = persona["nome"]
print(nome)  # Output: Alice
età = persona.get("età")
print(età)  # Output: 30

# Aggiungere una nuova coppia chiave-valore
persona["professione"] = "Ingegnere"
print(persona)

# Modificare il valore associato ad una chiave esistente
persona["età"] = 31
print(persona)

# Rimuovere una coppia chiave-valore tramite o pop()
persona.pop("città")  # Rimuove la chiave "città" e il suo valore
print(persona)

# Lista delle chiavi, dei valori e delle coppie chiave-valore
chiavi = persona.keys()
print(chiavi)  # Output: dict_keys(['nome', 'età', 'città', 'professione'])
valori = persona.values()
print(valori)  # Output: dict_values(['Alice', 31, 'Roma', 'Ingegnere'])

# Svuotare un dizionario
persona.clear()
print(persona)  # Output: {}

# Ciclo attraverso le coppie chiave-valore di un dizionario
persona = {"nome": "Alice", "età": 30, "città": "Roma"}
for chiave, valore in persona.items():
    print(f"{chiave}: {valore}")
