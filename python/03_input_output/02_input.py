name = input("Enter your name: ")
print("Hello, " + name + "! Welcome!")

# Trasformazione in interi e float
print(type(name))
n = int(input("How many roses?: "))
print(n)
print(type(n))

price = float(input("Price of each rose?: "))
print(price)
print(type(price))

# Due input contemporaneamente
x, y = input("Enter two values: ").split()
x = int(x)
y = int(y)
print("Number of boys: ", x)
print("Number of girls: ", y)
print(type(x))
print(type(y))