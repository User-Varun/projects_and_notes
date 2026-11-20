import math

def sigmoid(x):
    return 1 / (1 + math.exp(-x))

numbers = [-10, -5, -2, -1, 0, 1, 2, 5, 10]

for n in numbers:
    print(f"{n:>3} -> {sigmoid(n):.6f}")