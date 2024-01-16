import pandas

dataframe = pandas.read_excel('../resources/activity_excel.xlsx')

print(dataframe)

print("====================================")
print("Number of rows and columns:", dataframe.shape)

print("====================================")
print("Emails:")
print(dataframe['Email'])

print("====================================")
print("Sorted data:")
print(dataframe.sort_values('FirstName'))