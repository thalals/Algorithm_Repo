t = int(input())
result=[]

for i in range(t):
    temp = input().split()
    if temp[0]=='push':
        result.append(int(temp[1]))
    elif temp[0]=='pop':
        if len(result)==0:
            print(-1)
        else:
            print(result.pop())
    elif temp[0]=='size':
        print(len(result))
    elif temp[0]=='empty':
        if len(result)==0:
            print(1)
        else:
            print(0)
    elif temp[0]=='top':
        if len(result)==0:
            print(-1)
        else:
            print(result[-1])