from collections import deque
import sys

queue = deque()

t = int(sys.stdin.readline())


for i in range(t):
    temp =  sys.stdin.readline().split()
    if temp[0]=='push':
        queue.append(int(temp[1]))
    elif temp[0]=='pop':
        if len(queue)==0:
            print(-1)
        else:
            print(queue.popleft())
    elif temp[0]=='size':
        print(len(queue))
    elif temp[0]=='empty':
        if len(queue)==0:
            print(1)
        else:
            print(0)
    elif temp[0]=='front':
        if len(queue) == 0:
            print(-1)
        else:
            print(queue[0])
    elif temp[0]=='back':
        if len(queue)==0:
            print(-1)
        else:
            print(queue[-1])
