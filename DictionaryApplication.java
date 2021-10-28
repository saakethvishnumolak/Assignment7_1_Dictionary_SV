
public class DictionaryApplication 
{
	public static void main(String [] args)
	{
		Dictionary newDictionary = new Dictionary();
		
		//Print unsorted Arraylist
		System.out.println("Unsorted List of half dictionary");
		System.out.println("---------------------------------------");
		for(int i = 0; i < newDictionary.myDictionary.size(); i++)
		{
			keyValuePair newPair = newDictionary.myDictionary.get(i);
			System.out.println(newPair.key + "---" + newPair.value);
		}
		
		//Sorted Arraylist
		newDictionary.insertionSort();
		
		//Use add method to add other items
		for(int i = 0; i < newDictionary.unusedDictionary.size(); i++)
		{
			keyValuePair newPair = newDictionary.unusedDictionary.get(i);
			newDictionary.addKeyPair(newPair.key, newPair.value);
		}
		
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("Sorted List");
		System.out.println("---------------------------------------");
		System.out.println();

		//Print sorted list
		for(int i = 0; i < newDictionary.myDictionary.size(); i++)
		{
			keyValuePair sortedPair = newDictionary.myDictionary.get(i);
			System.out.println(sortedPair.key + "---" + sortedPair.value);
		}
	}
}
