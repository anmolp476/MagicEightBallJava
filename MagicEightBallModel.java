/** MagicEightBallModel class
  * This is where the methods for deciding the output will be created
  * Date Created:  11/04/2020
  * Created by: P. Anmol
  */ 


import java.io.*;

public class MagicEightBallModel extends Object
{
  //Variable Declarations
  private MagicEightBallGUI gameView;                 //The view for the game
  
  private String result;                              //This will hold the String output
  
  private String extraResult;                         //This will hold the extra result, for any non-yes/no questions
  
  public int rounds = 0;                              //This will count how many rounds or questions have been asked
  
  private boolean roundsDone = true;                  //This will check if the rounds reached the limit or not(limit is 10)
  
  
   
  /** Creates a default game with 10 tokens and question player going first
    */
  public MagicEightBallModel()
  {
    super();
  }
  
  /** Sets the view for the game
    * @param currentGUI        The View used to display the game
    */ 
  public void setGUI(MagicEightBallGUI currentGUI)
  {
    this.gameView = currentGUI;
  }

  //This method wil return the "result" variable that hold the string
  //value of the output, or the answer to the question
  public String resultReturned()
  {
    return this.result;
  }
  
  //return the number of rounds
  public int getRounds()
  {
    return this.rounds;
  }
  
  //return the boolean value of roundsDone
  public boolean getRoundsDone()
  {
    return this.roundsDone;
  }
  
  
  
  /** Determines the output or answer to the user's question
    * @param randomAnswer        this will determine which result or ouput String to use
    */ 
  public void questionAnswered(int randomAnswer)
  {
    //if the number of rounds is less then 10
    //then keep executing the code inside the 
    //if block
    if(rounds <= 9)
    {
      //based on the random integer chosen from 1-3
      //a case that represents that specific integer
      //will be executed
      switch(randomAnswer)
      { 
        case 1:
          this.result = "Yes";
          break;
          
        case 2:
          this.result = "No";
          break;
          
        case 3:
          this.result = "Maybe";
          break;
          
      }
      rounds++; //Increase the number of rounds by 1 each time 
    }
    
    //sets boolean value to false if number of rounds
    //is greater then 10
    else
    {
      this.roundsDone = false;   
      System.out.println(roundsDone);
    }
    
    //Run the update view method that calls the update
    //method in the View
    this.updateView(); 
  }
  
  //This method is for the buttons
  //@param whichButton    This will allow the controller to choose which code to execute in this method
  public void optionsButtons(String whichButton)
  {
    
    //if the button is the new game button
    //then execute this if block
    if(whichButton == "New Game")
    {
      this.rounds = 0;                         //set the rounds value to 0
      this.gameView.question.setEnabled(true); //enable the JTextField again
      this.gameView.question.setText("");      //Set the text to nothing
      this.gameView.questionAnswer.setText("");//set the text in the output to nothing
      this.roundsDone = true;                  //the number of rounds is less then 10
    } 
    
    //If the button is the end game button
    //then execute this block
    else if(whichButton == "End Game")
    {
      //create a new output file
      PrintWriter outputFile = getPrintWriter("output.txt");
      outputFile.print("hwy");
    }
    
  }
  
  //this method is used by the View when the user
  //enters a question that doesnt look like a yes/no question
  //it functions the same way as the questionAnswered(int) method
  //but serves a different purpose
  public String extraWords(int num)
  {
    switch(num)
    {
      case 1:
        extraResult = "a lot";
        break;
      
      case 2:
        extraResult = "a little";
        break;
        
      case 3:
        extraResult = "I don't know, ask the internet";
        break;
      
      case 4:
        extraResult = "This time you must ask the INTERNET";
        break;
    }
    return extraResult;
  }
  
  //this method is copied from the prompt class
  //and modified so it doesnt prompt
  public static PrintWriter getPrintWriter(String prompt)
  {
    
    String fileName = prompt;
    
    //Opens the output file
    File outputFile = new File(fileName);
    
    try
    {
      //constructs & returns a PrintWriter object connected to the output file 
      return new PrintWriter(outputFile);
    }
    catch (FileNotFoundException ex)
    {
      //Error occured inform user
      System.out.println(ex.getMessage());
      System.out.println("in" + System.getProperty("user.dir"));
      System.exit(1);
    }
    return null;
  }
  
  /**  Updates the view in the GUI*/
  public void updateView()
  {
    gameView.update();
  }
}
     