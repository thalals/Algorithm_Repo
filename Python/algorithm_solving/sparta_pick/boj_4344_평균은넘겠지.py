t = int(input())

while t>0 :
    t-=1
    student = list(map(int,input().split(' ')))
    stu_sum = sum(student) - student[0]
    avg = int(stu_sum/student[0])


    count=0
    for i in student[1:]:
        if i > avg :
            count+=1
    print(f'{(count/student[0])*100:.3f}%')

