# Dizionario annidato che rappresenta una classe con materie, insegnanti e studenti
classe = {
    "matematica": {
        "insegnante": "Rossi", 
        "studenti": ["Luca", "Marco", "Anna"]
    },
    "storia": {
        "insegnante": "Bianchi", 
        "studenti": ["Sara", "Paolo", "Giulia"]
    },
    "informatica": {
        "insegnante": "Verdi", 
        "studenti": ["Elena", "Francesco", "Marta"]
    }   
}

# Accesso ai dati nel dizionario annidato
print(classe["matematica"]["insegnante"])  # Output: Rossi
print(classe["storia"]["studenti"])        # Output: ['Sara', 'Paolo', 'Giulia']

# Ciclo attraverso le materie e i loro dettagli
for materia, dettagli in classe.items():
    print(f"Materia: {materia}")
    print(f" Insegnante: {dettagli['insegnante']}")
    print(f" Studenti: {', '.join(dettagli['studenti'])}")