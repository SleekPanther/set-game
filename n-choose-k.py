#Implement n choose 3 to find all possible subsets of size 3
def printCombinations(cards):
	count=0
	combinations=[]

	for i in range(len(cards)):
		for j in range((i+1),len(cards)):
			for k in range((j+1), len(cards)):
				print(cards[i], cards[j], cards[k])
				combinations.append([cards[i], cards[j], cards[k]])
				count+=1
	print('Combination Count =',count)
	return combinations

def main():
	cards=['a','b','c','d','e','f']

	combinations=printCombinations(cards)

	print("\nAre Combinations unique?", areCombinationsDistinct(combinations))
	
	combinations.append(['a', 'b', 'c'])
	print("\nAdded duplicate combination ['a', 'b', 'c'] to test uniqueness")
	print("Are Combinations unique?", areCombinationsDistinct(combinations))

#Search for duplicates to verify n choose 3 algorithm works
def areCombinationsDistinct(combinations):
	for i in range(len(combinations)):
		for j in range((i+1), len(combinations)):
			#Check if another combination contains all 3 cards that the current combination contains
			if (combinations[i][0] in combinations[j]) and (combinations[i][1] in combinations[j]) and (combinations[i][2] in combinations[j]):
				return False
	return True

main()
