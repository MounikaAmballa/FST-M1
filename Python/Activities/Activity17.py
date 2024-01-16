# Import pandas
import pandas

data = {
    "Usernames": ["gmail", "insta", "facebook"],
    "Passwords": ["abc@1542", "kdh@8423", "okd@8854"]
}

dataframe = pandas.DataFrame(data)

print(dataframe)

dataframe.to_csv("../resources/activity_sample.csv", index=False)