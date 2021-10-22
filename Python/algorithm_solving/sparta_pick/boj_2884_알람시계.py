hour, minute = input().split(' ')
hour = int(hour)
minute = int(minute)

if (minute >= 45):
    print(hour, minute - 45)
else :
    minute = 45 - minute
    minute = 60 - minute

    if(hour==0):
        hour=24
    print(hour-1,minute)
