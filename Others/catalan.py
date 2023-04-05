# Backtracking
def catalan(num):
    if num == 0 or num == 1:
        return 1
    cat = 0
    for i in range (0,num):
        cat += catalan(i)*catalan(num-i-1)
    return cat

# Dynamic Programming
def catalanDP(num):
    cat = []
    for i in range (0,num+1):
        if i == 0 or i == 1:
            currentCat = 1
        else:
            currentCat = 0
            for j in range(0,i):
                currentCat += cat[j]*cat[i-j-1]
        cat.append(currentCat)
    return cat[num]



num = int(input('Enter number: '))
for i in range (0,num+1):
    print('Catlan of {} is {}'.format(
        i,
        catalanDP(i)
    ))
