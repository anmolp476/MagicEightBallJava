/** MagicEightBallButtonsController class
  * The controller for the new game and end game buttons
  * Date Created:  11/04/2020
  * Created by: P. Anmol
  */ 

import java.awt.event.*;

public class MagicEightBallButtonsController implements ActionListener
{
  private MagicEightBallModel game;            //The Model used to describe the game
  
  /** Default constructor
    * @param aGame          The Model describing game behaviour
    */ 
  public MagicEightBallButtonsController(MagicEightBallModel aGame)
  {
    this.game = aGame;
  }
  
  /**determines which buttons are pressed and passes the appropriate value 
    * into the method, optionsButtons()
    * @param e      The event sent from the textbox component
    */ 
  public void actionPerformed(ActionEvent e)
  {
    //if the getActionCommand() returns "New Game"
    //meaning the New game buttons was pressed, execute this code
    if(e.getActionCommand() == "New Game")
    {
      this.game.optionsButtons(e.getActionCommand());           
    }
    
    //If it returned "End Game", meaning the end game button was pressed
    //execute this code
    else if(e.getActionCommand() == "End Game")
    {
      this.game.optionsButtons(e.getActionCommand());
      
    }

  }
}
