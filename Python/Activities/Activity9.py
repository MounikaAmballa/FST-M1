listOne =[5,3,19,91,22,88]
listTwo =[31,14,8,15,99,7]
print("First List ", listOne)
print("Second List ", listTwo)
thirdList = []
for num in listOne:
    if (num % 2 == 0):
        thirdList.append(num)
for num in listTwo:
    if (num % 2 != 0):
        thirdList.append(num)
print("result List is:")
print(thirdList)