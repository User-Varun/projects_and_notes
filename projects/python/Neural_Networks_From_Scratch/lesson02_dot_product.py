# handling multiple inputs and weights  


# inputs ( hours studied , attendence  , prev grades , sleep ) 
# weights (corresponding to the inputs)

inputs = [5, 8, 90, 2] 
weights = [8, 2, 0.1, 5] # weight for individual inputs
bias = 3
output = 0

for i in range(len(inputs)):
    output += inputs[i] * weights[i]

output += bias

print(output)