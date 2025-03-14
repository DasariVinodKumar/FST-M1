# Import pandas
import pandas

# Create a Dictionary that will hold our data
data = {
  "Usernames": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}

# Create a DataFrame using that data
dataframe = pandas.DataFrame(data)

# Print the DataFrame
print(dataframe)

dataframe.to_csv("sample.csv", index=False)

# Read the CSV file and store it into a DataFrame
dataframe = pandas.read_csv("sample.csv")

# Print the values in the Usernames column only
print("Usernames:")
print(dataframe["Usernames"])

# Print the username and password of the second row
print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])

#Sort the Usernames column in ascending order
print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('Usernames'))

#Sort the Passwords column in descending order
print("Data sorted in descending Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))