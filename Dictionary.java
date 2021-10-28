import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary 
{
	public ArrayList<keyValuePair> myDictionary = new ArrayList<keyValuePair>();
	public ArrayList<keyValuePair> unusedDictionary = new ArrayList<keyValuePair>();
	
	//Empty Constructor
	public Dictionary()
	{
		loadDictionary();
	}
	
	/**
	 * Method that reads Key and Value text files and adds them into two separate String arrays
	 * The array is then pushed to the ArrayList
	 */
	public void loadDictionary()
	{
		int index = 0;
		
		String[] keyArray = new String[436];
		String[] valueArray = new String[436];
		
		try {
			File myDictionary = new File("Key.txt");
			Scanner scanDictionary = new Scanner(myDictionary);
			
			while(scanDictionary.hasNextLine())
			{
				keyArray[index++] = scanDictionary.nextLine();
			}
			scanDictionary.close();
			
			
			
			index = 0;
			
			myDictionary = new File("Value.txt");
			scanDictionary = new Scanner(myDictionary);
			
			while(scanDictionary.hasNextLine())
			{
				valueArray[index++] = scanDictionary.nextLine();
			}
			scanDictionary.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
		for(int i = 0; i < (keyArray.length)/2; i++)
		{
			keyValuePair newPair = new keyValuePair(keyArray[i], valueArray[i]);
			myDictionary.add(newPair);
		}
		
		for(int i = (keyArray.length)/2; i < keyArray.length; i++)
		{
			keyValuePair newPair = new keyValuePair(keyArray[i], valueArray[i]);
			unusedDictionary.add(newPair);
		}
		
	}
	
	/**
	 * Insertion sort code that sorts the ArrayList alphabetically
	 */
	public void insertionSort()
	{
		for(int i = 0; i < myDictionary.size() - 1; i++)
		{
			for(int j = i + 1; j > 0; j--)
			{
				keyValuePair current = myDictionary.get(j);
				String s1 = current.key;
				keyValuePair previousWord = myDictionary.get(j - 1);
				String s2 = previousWord.key;
				
				if(s1.toLowerCase().compareTo(s2.toLowerCase()) < 0)
				{
					keyValuePair temp = myDictionary.get(j);
					myDictionary.set(j, previousWord);
					myDictionary.set(j - 1, temp);
				}
			}
		}
	}
	
	/**
	 * Add method that takes two String parameters, key and value
	 * It allows you to add a keyValuePair object to the ArrayList
	 * @param key
	 * @param value
	 */
	public void addKeyPair(String key, String value)
	{
		boolean islocation = false;
		
		for(int i = 0; i < myDictionary.size(); i++)
		{
			keyValuePair current = myDictionary.get(i);
			String currentKey = current.key;
			if(currentKey.toLowerCase().compareTo(key) < 0)
			{
				islocation = true;
				
			}
			else
			{
				keyValuePair newPair = new keyValuePair(key, value);
				myDictionary.add(i, newPair);
				break;
			}
			if(currentKey.toLowerCase().compareTo(key) >= 0 && islocation)
			{
				keyValuePair newPair = new keyValuePair(key, value);
				myDictionary.add(i, newPair);
				break;
			}
		}
	}
	
}

