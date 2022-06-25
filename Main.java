import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    WordList words = new WordList();
    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] lettersVis = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] guessList = {"_____", "_____", "_____", "_____", "_____"}; 
    String[][] guessResults = new String[5][5];
    for(int i = 0; i < guessResults.length; i++){
      for(int j = 0; j < guessResults[i].length; j++){
        guessResults[i][j] = "☒";
      }
   }
    String word = words.getWord().toLowerCase();
    boolean win = false;
    int guesses = 0;
    while(guesses < 5) {
      System.out.print("\033[H\033[2J"); 
      System.out.println("Make a Guess:");
      for(int i = 0; i < guessList.length; i++) {
        String str = "";
        str = str + guessList[i];
        str = str + " : ";
        for(String y : guessResults[i]) {
            str = str + y + " ";
        }
        System.out.println(str);
      }
      for(int i = 0; i < lettersVis.length; i++){
        if(i % 10 != 0) {
          System.out.print(lettersVis[i] + " ");
        } else {
          System.out.print("\n" + lettersVis[i] + " ");
        }
      }
      System.out.print("\n");
      String guess = scan.nextLine();
      if(guess.length() != 5){
        System.out.println("Not Correct Size");
      } else {
        guessList[guesses] = guess;
        guesses++;
        if(guess.equals(word) == true){
          win = true;
          break;
        }

        for(int i = 0; i < guess.length(); i++){
          if(guess.substring(i, i+1).equals(word.substring(i, i+1))) {
            guessResults[guesses-1][i] = "✅";
             for(int l = 0; l < letters.length; l++) {
                if(letters[l].equals(guess.substring(i, i+1))) {
                  lettersVis[l] = "✅";
                }
              }
          } else {
             for(int j = 0; j < word.length(); j++) {
            if(guess.substring(i, i+1).equals(word.substring(j, j+1))) {
              guessResults[guesses-1][i] = "✓";
               for(int l = 0; l < letters.length; l++) {
                if(letters[l].equals(guess.substring(i, i+1))) {
                  if(!(lettersVis[l].equals("✅"))){
                    lettersVis[l] = "✓";
                  }
                  
                }
              }
            } else {
              for(int l = 0; l < letters.length; l++) {
                if(letters[l].equals(guess.substring(i, i+1))) {
                  if(!(lettersVis[l].equals("✅")) && !(lettersVis[l].equals("✓"))){
                    lettersVis[l] = "☒";
                  }
                  
                }
            }
          }
          }
        }
        
    }
    if (win == true) {
      System.out.print("\033[H\033[2J"); 
      System.out.println("Make a Guess:");
      for(int i = 0; i < guessList.length; i++) {
        String str = "";
        str = str + guessList[i];
        str = str + " : ";
        for(String y : guessResults[i]) {
            str = str + y + " ";
        }
        System.out.println(str);
      }
      for(int i = 0; i < lettersVis.length; i++){
        if(i % 10 != 0) {
          System.out.print(lettersVis[i] + " ");
        } else {
          System.out.print("\n" + lettersVis[i] + " ");
        }
      }
      System.out.print("\n");
      System.out.println("YOU WON!");
    } else {
      System.out.print("\033[H\033[2J"); 
      System.out.println("Make a Guess:");
     for(int i = 0; i < guessList.length; i++) {
        String str = "";
        str = str + guessList[i];
        str = str + " : ";
        for(String y : guessResults[i]) {
            str = str + y + " ";
        }
        System.out.println(str);
      }
      for(int i = 0; i < lettersVis.length; i++){
        if(i % 10 != 0) {
          System.out.print(lettersVis[i] + " ");
        } else {
          System.out.print("\n" + lettersVis[i] + " ");
        }
      }
      System.out.print("\n");
      System.out.println("YOU LOST!");
      System.out.println(word);
    }
  }
}
    }}