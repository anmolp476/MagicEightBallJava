/** MagicEightBall class
  * Run the code and the GUI
  * Date Created:  11/04/2020
  * Created by: P. Anmol
  */ 

import javax.swing.*;

public class MagicEightBall
{
  public static void main (String [] args)
  {
    MagicEightBallModel game = new MagicEightBallModel();          //The game model
    MagicEightBallGUI mainScreen = new MagicEightBallGUI(game);  //The game view
    
    //Initialize the Frame
    JFrame f = new JFrame("Magic 8 Ball");
    f.setSize(250,200);
    f.setLocation(300,200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(mainScreen);
    f.setVisible(true);
  }
}