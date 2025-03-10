n = 4
for i in range(0, n):
    print(i)

n = 100
for number in range(n):
    if number % 10 == 0:
        continue
    print(number)

for number in range(n):
    if number % 10 == 0:
        break
    print(number)
