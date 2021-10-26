t = int(input())

tlist=[]
for i in range(t):
    temp = list(map(int,input().split()))
    tlist.append(temp)

tlist =[(1,2),[0,2]]


c = sorted(tlist, key = lambda x : (x[1],x[0]))

for i in range(t):
    result = c[i]
    print(result[0],result[1])
