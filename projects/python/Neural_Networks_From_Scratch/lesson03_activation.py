
def step(x):
    if(x > 0):
        return 1
    else:
        return 0



inputs = [5, 8 , 90 , 20]
weights = [3 ,3 ,4 ,20]
bais = -8
output = 0

for i in range(len(inputs)):
    output += inputs[i] * weights[i]

output += bais

print("before activation ", output)
print("after activation" , step(output))