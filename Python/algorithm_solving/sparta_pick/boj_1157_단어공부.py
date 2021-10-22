def result(max_num) :
    count = 0
    for a in alpha_list:
        if a==max_num :
            count+=1
        if count>1:
            return print("?")

    idx = alpha_list.index(max_num)
    return print(chr(idx+ord('A')))


str =input().upper()
alpha_list = [0]*26

for temp in str:
    alpha_list[ord(temp)-ord('A')]+=1

max_num = max(alpha_list)
result(max_num)