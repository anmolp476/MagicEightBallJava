/** MagicEightBallController class
  * The controller for the JTextField, where the user
  * will input their question
  * Date Created:  11/04/2020
  * Created by: P. Anmol
  */ 

import java.lang.Math;
import java.awt.event.*;

public class MagicEightBallController implements ActionListener
{
  private MagicEightBallModel game;            //The Model used to describe the game
  
  /** Default constructor
    * Links the component to the Model
    * @param aGame          The Model describing game behaviour
    */ 
  public MagicEightBallController(MagicEightBallModel aGame)
  {
    this.game = aGame;
  }
  
  /** Chooses a random value using math.random(), then passes that value
    * into the method, questionAnswered(int). This will determine a random 
    * string to display in the JLabel as an output.
    * @param e      The event sent from the textbox component
    */ 
  public void actionPerformed(ActionEvent e)
  {
     int randomInt = 1 + (int)(Math.random()*3);
     this.game.questionAnswered(randomInt);
  }
}
