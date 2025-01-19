print("Hello world")

# Stampare una variabile
s = "Bob"
print(s)

# Stampare più variabili contemporaneamente tramite la virgola
s = "Alice"
age = 25
city = "New York"
print(s, age, city)

# Stampare più variabili contemporaneamente tramite il +
print(s + " " + str(age) + " " + city)

# Attenzione! Uso del + con i numeri
x = 5
y = 7
print(x + y)
print(str(x) + str(y))


# Formattare una variabile
totale = 150.75
print("Totale: {:.2f}€".format(totale))

# Parametro end
print("Questo testo", end=" ")
print("non va a capo")

# Togliere lo spazio tra le stringhe
print("G", "F", "G", sep="")

# Come formattare una stringa
print('09', '12', '2016', sep='/')

# Utilizzo di f-string
name = 'Tushar'
age = 23
print(f"Hello, My name is {name} and I'm {age} years old.")