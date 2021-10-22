count=0

t = int(input())

for i in range(t):
    word = set()
    before_word = ""

    str = input()
    before_word = str[0]
    word.add(before_word)

    flag = True
    for a in str:

        if a is not before_word:
            before_word=a
            if a in word:
                flag = False
                break

            word.add(before_word)

    if flag:
        count+=1
print(count)