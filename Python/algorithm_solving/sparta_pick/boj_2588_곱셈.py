a = int(input())
b = map(int,input())

num = list(b)

for item in num[::-1]:
    print(a*item)

print(a*num[0]*100+a*num[1]*10+a*num[2])
