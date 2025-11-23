// Sam and Suhani
import java.io.FileReader;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.util.ArrayList;


public class Table {
	//Array of ArrayLists that h the values from the file
	private static ArrayList[] table = new ArrayList[10];

	/*
	Constructor: Initializes the Array of Arraylists so it is no longer null
	*/
	public Table () {
		for(int i = 0; i < 10; i++){
			table[i] = new ArrayList();
		}
	}

	/*
	This method reads in the file given in CLI and initializes a table based
	the words in the file and then removes all the duplicates in the table and 
	then prints out. 

	@param  String[] args   Command line input

	pre: args.length > 0
	post: Makes table based on the words in file from CLI
	exception: if filename is not found, the user is told and prompted to give a different name next
	time
	*/
	public static void main (String[] args) {
		String filename = args[0];
		Table myTable = new Table();
		try{
        	FileReader file = new FileReader(filename);
        	Scanner message = new Scanner(file);
        	while (message.hasNextLine()){
        		String data = message.nextLine();
        		Word newWord = new Word(data);
        		myTable.add(newWord);
        	}
        	message.close();
        } catch(FileNotFoundException e){
        	System.out.println("Your file was not found! Please enter a valid file next time!");
        }
        myTable.removeDoubles();
		System.out.println(myTable);
	}

	/*
	This method accesses the method hashCode from class Word to calculate the index the Word that add 
	is getting called on will be added to in table.

	@param Word listWord    Object Word in table
	
	pre: File given is not empty
	post: Adds the Word listword to the table at the index calculated using hashCode.
	*/
	public void add(Word listWord) {
		int ind = listWord.hashCode();
		if(!table[ind].contains(listWord)){
			table[ind].add((Word)listWord);
		}
	}

	/*
	This method access equal from the Word class to see if the Word in table 
	equals another Word and if it does removes it from table. 

	pre: all values from file are added to table 
	post: Removes the duplicates of Word in table
	*/
	public void removeDoubles() {
		for (int i = 0; i < 10; i++) {
			if (table[i].size() > 1) {
				for(int j = 0; j < table[i].size() - 1; j++){
					if(table[i].get(j).equals(table[i].get(j + 1))){
						System.out.println("HI");
						table[i].remove(j);
						j--;
					}
				}
			}
		}
	}

	//Returns string representation of table
	public String toString() {
		String finalMessage = "";
		for (int i = 0; i < 10; i++) {
			finalMessage += (i + ": ");
			for (int j = 0; j < table[i].size(); j++) {
				finalMessage += (table[i].get(j) + " ");
			}
			finalMessage += "\n";
		}
		return finalMessage;
	}
}




