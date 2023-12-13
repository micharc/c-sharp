import random
import pandas as pd

lst = ['robot'] * 10
lst += ['human'] * 10
random.shuffle(lst)
df = pd.DataFrame({'whoAmI':lst})

print('Dataframe using pandas.get_dummies():')
print(pd.get_dummies(df['whoAmI']))
print('==========================\n')

s=df['whoAmI']
robot_list=[]
human_list=[]
for i in s:
    if i == 'human':
        human_list += [True]
        robot_list += [False]
    else:
        human_list += [False]
        robot_list += [True]

data = { 'human': human_list, 'robot': robot_list }

df_new = pd.DataFrame(data);
print('Dataframe without pandas.get_dummies():')
print(df_new)
print('==========================\n')
