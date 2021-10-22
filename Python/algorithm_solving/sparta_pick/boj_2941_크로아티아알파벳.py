croatia = ['dz=','lj','nj','c=','c-','d-','s=','z=']

temp = input()

for cro in croatia:
    if cro in temp:
        temp = temp.replace(cro,"a")

print(len(temp))