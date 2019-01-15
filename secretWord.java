import java.util.Random;

public class secretWord{

    /**
     * General variables usesdd to help keep track of things
     **/
    public String sWord;
    public String hiddenWord;
    
    /**
     * General constructor for secret word
     * @param words Array of words to pick from
     * @return a filled sWord variable
     */
    public secretWord(String[] words){

	Random rand = new Random();
	int randNum = rand.nextInt(words.length);
	
        this.sWord = words[randNum].toUpperCase();
	this.hiddenWord =createHiddenWord(this.sWord);
	
	return;
    }

    /**
     * Method to check is ther guessed letter is in the word
     */
    public boolean isLetterIn(char letter){
	
	// Check and possibly convedrt letter to uppercase
	letter = (Character.isLowerCase(letter)) ? Character.toUpperCase(letter): letter;
	int index = this.sWord.indexOf(letter);
	if (index == -1)
	    return false;
	else
	    return true;
    }

    private String createHiddenWord(String word){

	String hWord="";
	int lenWord = word.length();

	for(int i=0; i<lenWord;i++){
	    if(i==lenWord-1){
		hWord+="_";
	    }else{
		hWord+="_ ";
	    }
	}
	return hWord;
    }
	
    /** 
     * Update the hidden work to show the revealed letters
     * Prereq: letter must have already been check to be in word and is capital
     */
    public void updateHiddenWord(char letter){
	int indexL = this.sWord.indexOf(letter);

	while(indexL != -1){
	    if(indexL==0){
		this.hiddenWord = letter+this.hiddenWord.substring(1);
	    }else if(indexL == this.sWord.length()){
		this.hiddenWord = this.hiddenWord.substring(0,this.hiddenWord.length()-2)+letter;
	    }else{
		int hIndexL = indexL*2;
		String beg = this.hiddenWord.substring(0,hIndexL);
		String end = this.hiddenWord.substring(hIndexL+1);
		this.hiddenWord = beg+letter+end;
	    }
	    indexL = sWord.indexOf(letter,indexL+1);
	}
	return;
    }


    public void displayHiddenWord(){
	System.out.println(this.hiddenWord);
	return;
    }
}
