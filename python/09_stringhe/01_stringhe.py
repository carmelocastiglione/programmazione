# Creazione di una stringa con apici o doppi apici
s = 'Questa è una stringa'
s2 = "Anche questa è una stringa"
print(s)
print(s2)

# Accesses first character
print(s[0])  
# Accesses 5th character
print(s[4]) 
# Accesses 3rd character
print(s[-10])  
# Accesses 5th character from end
print(s[-5]) 


# Retrieves characters from index 1 to 3:
print(s[1:4])  
# Retrieves characters from beginning to index 2: 
print(s[:3])   
# Retrieves characters from index 3 to the end:
print(s[3:])   
# Reverse a string
print(s[::-1])

# Strings in Python are immutable. 
# This means that they cannot be changed after they are created. 
# Trying to change the first character raises an error
#s[0] = 'I'  # Uncommenting this line will cause a TypeError

# Instead, create a new string
s = "G" + s[1:]
print(s)

# Replace a character in the string
s = s.replace("G", "Q")  # Replace 'G' with 'Q'
print(s)

# Length of the string
print(len(s))

# Maiuscolo e minuscolo
print(s.upper())   
print(s.lower())   

# Togliere gli spazi
print(s.strip()) 

# Concatena due stringhe
s1 = "Hello"
s2 = "World"
s3 = s1 + " " + s2
print(s3)

# Trasformare una stringa in una lista
parole = s.split(" ")
print(parole)