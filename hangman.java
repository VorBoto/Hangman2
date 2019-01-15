import java.util.Scanner;
import java.util.Random;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
    
public class hangman{
    public static void main (String[] args){

	int wrongGuesses = 0;
	String guessedLetters = "";
	Random rand = new Random();
	String[] words = new String[172819];
	Scanner keyb = new Scanner(System.in);

	// import words from file wordlist.txt
	Scanner inputFile = null;
	try{
	    inputFile = new Scanner(new FileInputStream("wordlist.txt"));
//	    // Read in wordlist
//	    while(inputFile.hasNext()){
//		for(int i=0;i<words.length-1;i++){
//		    words[i] = inputFile.nextLine();
//		}
//	    }
	} catch (FileNotFoundException e){
	    System.out.println("Problem opening file, it wasn't found.");
	    System.exit(0);
	}	

	// Read in wordlist
        int i = 0;
	while(inputFile.hasNext() && i < 172819){
	    words[i] = inputFile.nextLine();
	    i++;	    
	}


	//close file
	inputFile.close();

	//select random word and generate secretWord object
	//String randomWord = words[rand.nextInt(172819)+1];
	secretWord theWord = new secretWord(words);
	
	// Introduction of game
	System.out.println("Welcome to a game of Hangman!");
	System.out.println("You get 6 wrong guesses.");
	System.out.println("Repeated letters do not count against you.\n");
	System.out.println("The word has already been selected.");

	System.out.println("This is the current state of affairs,");
	System.out.println("the man is not uppon the gallows and safe.");
	displayStatus(wrongGuesses);
	
	System.out.println("Here is the letterless word:");
	theWord.displayHiddenWord();

	while(theWord.hiddenWord.indexOf("_")!=-1 && wrongGuesses<6){
	    System.out.print("Enter your guess: ");
	    char letter = keyb.next().charAt(0);
	    letter = Character.toUpperCase(letter);
	    if(guessedLetters.indexOf(letter)==-1)
		guessedLetters += letter;
	    System.out.print("\n");

	    if(theWord.isLetterIn(letter)){
		System.out.println("Congrats "+letter+" is in the word!");
		theWord.updateHiddenWord(letter);
	    }else{
		System.out.println("Oh no "+letter+" is not in the word!");
		wrongGuesses += 1;
	    }

	    System.out.println("\n\n=======================================\n\n");
	    System.out.println("Status update");
	    displayStatus(wrongGuesses);
	    theWord.displayHiddenWord();
	    System.out.println("Used letters: "+guessedLetters);
	    System.out.println("\n");
	}

	if(wrongGuesses==6)
	    displayStatus(++wrongGuesses);
	return;
	
    }

    public static void displayStatus(int wGuesses){
	switch (wGuesses){
	case 0: System.out.println(" /-----\\ ");
	    System.out.println(" |     | ");
	    System.out.println(" |     | ");
	    System.out.println(" |     0 ");
	    System.out.println(" |       ");
	    System.out.println(" |       ");
	    System.out.println(" |       ");
	    System.out.println("_|_______");
	    System.out.println("=========");
	    break;
	case 1: System.out.println(" /-----\\ ");
	    System.out.println(" |     | ");
	    System.out.println(" |     | ");
	    System.out.println(" |    (_)");
	    System.out.println(" |       ");
	    System.out.println(" |       ");
	    System.out.println(" |       ");
	    System.out.println("_|_______");
	    System.out.println("=========");
	    break;
	case 2: System.out.println(" /-----\\ ");
	    System.out.println(" |     | ");
	    System.out.println(" |     | ");
	    System.out.println(" |    (_)");
	    System.out.println(" |     | ");
	    System.out.println(" |     |  ");
	    System.out.println(" |       ");
	    System.out.println("_|_______");
	    System.out.println("=========");
	    break;
	case 3: System.out.println(" /-----\\ ");
	    System.out.println(" |     | ");
	    System.out.println(" |     | ");
	    System.out.println(" |    (_)");
	    System.out.println(" |    \\| ");
	    System.out.println(" |     |  ");
	    System.out.println(" |       ");
	    System.out.println("_|_______");
	    System.out.println("=========");
	    break;
	case 4: System.out.println(" /-----\\ ");
	    System.out.println(" |     | ");
	    System.out.println(" |     | ");
	    System.out.println(" |    (_)");
	    System.out.println(" |    \\|/");
	    System.out.println(" |     |  ");
	    System.out.println(" |       ");
	    System.out.println("_|_______");
	    System.out.println("=========");
	    break;
	case 5: System.out.println(" /-----\\ ");
	    System.out.println(" |     | ");
	    System.out.println(" |     | ");
	    System.out.println(" |    (_)");
	    System.out.println(" |    \\|/");
	    System.out.println(" |     |  ");
	    System.out.println(" |    /  ");
	    System.out.println("_|_______");
	    System.out.println("=========");
	    break;
	case 6: System.out.println(" /-----\\ ");
	    System.out.println(" |     | ");
	    System.out.println(" |     | ");
	    System.out.println(" |    (_)");
	    System.out.println(" |    \\|/");
	    System.out.println(" |     |  ");
	    System.out.println(" |    / \\");
	    System.out.println("_|_______");
	    System.out.println("=========");
	    break;
	case 7: System.out.println("YOU KILLED THEM!!");
	    System.out.println(" /-----\\ ");
	    System.out.println(" |     | ");
	    System.out.println(" |     | ");
	    System.out.println(" |    (@)");
	    System.out.println(" |    \\|/");
	    System.out.println(" |     |  ");
	    System.out.println(" |    / \\");
	    System.out.println("_|_______");
	    System.out.println("=========");
	    break;
	}
	return;
    }
}
