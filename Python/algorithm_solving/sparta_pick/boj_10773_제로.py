stack =[]

t = int(input())

for i in range(t):
    num = int(input())
    if num ==0:
        stack.pop()
    else:
        stack.append(num)

print(sum(stack))