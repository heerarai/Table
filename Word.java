public class Word {
	// A string that represents a word
	private String data;

	/*
	Constructor: assigns data the value of String word

	@param   String word    the user input for the Word object
	*/
	public Word (String word) {
		data = word;
	}

	/*
	Checks if one object is the same as the other object

	@param    Object other   a object that will represent a Word object in the actual code

	output: return true if the string and the other object are equal. returns false otherwise
	*/
	public boolean equals(Object other){
		//NOT AI I PROMISE luna did
		if(other instanceof Word){
			return this.data.equals(((Word)other).data);
		}
		return false;
	}

	/*
	Iterates through each object and gets the length. Then it checks for the number of vowels by comparing it
	to a vowels array. After finding the length and the number of vowels in the Word object, the numbers are 
	multiplied and the remainder after dividing by 10 is returned as the hashcode.

	output: number of vowels multiplied by the length of the Word object divided by 10 and the remainder is 
	returned
	*/
	public int hashCode(){
		String[] vowels = {"a", "e", "i", "o", "u"};
		int len = data.length();
		int vowelCount = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < vowels.length; j++) {
				if(data.substring(i, i + 1).equals(vowels[j])) { 
					vowelCount++;
				}
			}
		}
		return (vowelCount * len) % 10;
	}

	// Data is returned
	public String toString(){
		return data;
	}
}