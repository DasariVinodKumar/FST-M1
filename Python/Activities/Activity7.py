num = list(input("Enter a list of numbers: ").split(", "))
sum = 0

for num in num:
  sum += int(num)

print(sum)