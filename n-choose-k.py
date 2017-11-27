tiles=['a','b','c','d','e','f']
count=0
combinations=[]

#Implement n choose 3 to find all possible subsets of size 3
for i in range(len(tiles)):
    for j in range((i+1),len(tiles)):
        for k in range((j+1), len(tiles)):
            print(tiles[i], tiles[j], tiles[k])
            combinations.append([tiles[i], tiles[j], tiles[k]])
            count+=1
print('\nCount =',count)

def areCombinationsDistinct(combinations):
    for i in range(len(combinations)):
        for j in range((i+1), len(combinations)):
            if (combinations[i][0] in combinations[j]) and (combinations[i][1] in combinations[j]) and (combinations[i][2] in combinations[j]):
                return False
    return True

#combinations.append(['c', 'd', 'e'])
print(areCombinationsDistinct(combinations))