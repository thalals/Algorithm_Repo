num = int(input())
count = 1

def sum(a, b):
    sum = a+b
    return b*10+int(sum%10)

temp = -1
if num<10 :
    temp = sum(0,num)
else:
    temp = sum(num/10,int(num%10))


while num is not temp:
    count+=1
    if temp < 10:
        temp = sum(0, temp)
    else:
        temp = sum(temp / 10, temp % 10)

print(count)