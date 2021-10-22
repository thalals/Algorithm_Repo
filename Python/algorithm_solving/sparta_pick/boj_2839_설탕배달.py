# 3kg 5kg

sugar = int(input())

count = 0
while True:
    if sugar % 5 == 0:
        count += sugar // 5
        print(count)
        break

    sugar -= 3
    count+=1

    if sugar<0:
        print(-1)
        break