import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;


public class WordCount 
{
	private static Hashtable<String, Integer> wordcount = new Hashtable<String, Integer>();	//hashtable for storing the wordCounts
	
	public static void count(File file) throws FileNotFoundException	
	{
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext())	//search for words in file
		{
			String word = scanner.next();	
			if(wordcount.containsKey(word))		//increment count by 1 if word is already in the hashtable
			{
				wordcount.put(word, wordcount.get(word) + 1);
			}
			else	//add word to hashtable if not already in it
			{
				wordcount.put(word, 1);
			}
		}
	}
	public static void main(String[] args) throws IOException
	{
		//files created by adding words from a dictionary from public github repository
		//link to github: https://github.com/dwyl/english-words
		File file1 = new File("file1.txt");
		File file2 = new File("file2.txt");
		File file3 = new File("file3.txt");
		Scanner scanner = new Scanner(file1);
		long startTime = System.currentTimeMillis();	//start timer in milliseconds
		count(file1);
		count(file2);
		count(file3);
		long stopTime = System.currentTimeMillis();	//end timer
		long finalTime = stopTime - startTime;
		String count = "The word count is: " + wordcount.toString();
		String output = "WordCount without MapReduce: " + finalTime + "ms";
		System.out.println(output);
		FileWriter fw = new FileWriter("output.txt");
		fw.write(count);
		fw.write(output);
		fw.close();
	}
}
