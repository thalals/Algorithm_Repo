self_number = []

# main
for i in range(1, 10001):
    self_number.append(int(i))

for num in self_number:
    # 생성자
    print(num)

    while num < 10000:
        num_digit = str(num)
        for i in num_digit:
            num = num + int(i)

        if num in self_number:
            self_number.remove(num)