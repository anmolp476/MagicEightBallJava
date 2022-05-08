/** MagicEightBallGUI class
  * This class will create the actual GUI of the program
  * it will also register the controllers, and answer questions
  * by changing the text of the JLabel or the output
  * Date Created:  11/04/2020
  * Created by: P. Anmol
  */ 

import javax.swing.*;
import java.lang.Math;
import java.awt.*;

public class MagicEightBallGUI extends JComponent
{
  //Instance Variables
  private MagicEightBallModel game;                        //The game Model
  
  public JTextField question = new JTextField(10);         //The text field where the user will input an answer
  
  public JLabel questionAnswer = new JLabel();             //The label where the anwer to the question will be outputted
  
  private JPanel questionAnswerPanel = new JPanel();       //The JPanel that will hold questionAnswer JLabel
  
  public String x = this.question.getText();               //This string variable will hold the text entered into the JTextField question
  
  //the buttons for ending the game, or creating new game
  public JButton endGame = new JButton("End Game");        //This will end the game and create an output file
  public JButton newGame = new JButton("New Game");        //This will restart the game
  
  /** Default constructor for the GUI.  Assigns Model and View, identifies controllers
    * and draws the layout
    * @param newGame        The Model for the game
    */ 
  public MagicEightBallGUI(MagicEightBallModel newGame)
  {
    super();
    this.game = newGame;
    this.game.setGUI(this);
    this.layoutView();
    this.registerControllers();
    this.update();
  }
  
  /** Draws the initial layout for the game board
    */ 
  private void layoutView()
  {
    
    //The JPanel that holds the JTextField, where the user will input a question
    JPanel questionPanel = new JPanel();
    questionPanel.add(this.question);
    questionPanel.setBorder(BorderFactory.createTitledBorder("Ask a question"));
    
    //The JPanel that holds the outputLabel, where the program will present an output
    questionAnswerPanel = new JPanel();
    questionAnswerPanel.add (this.questionAnswer);
    questionAnswerPanel.setBorder(BorderFactory.createTitledBorder("Prediction"));
    
    //The JPanel that will hold the buttons
    //The end game button and the new game button
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(newGame);
    buttonPanel.add(endGame);
    buttonPanel.setLayout(new GridLayout(1,2));
    buttonPanel.setBorder(BorderFactory.createTitledBorder("Options"));
    
    //The JPanel that holds the question JPanel so it can be centered
    JPanel center = new JPanel();
    center.setLayout(new BorderLayout());
    center.add(questionPanel, BorderLayout.CENTER);
    
    //The complete layout
    this.setLayout(new BorderLayout());
    this.add(center, BorderLayout.NORTH);
    this.add(questionAnswerPanel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.SOUTH);
  }
  
  /**Assigns the controllers to the user input text field.
    */ 
  private void registerControllers()
  {
    //the controller for the JTextField (question)
    MagicEightBallController questionController = new MagicEightBallController(this.game);
    this.question.addActionListener(questionController);
    
    //The controller for the new game button
    MagicEightBallButtonsController newGameController = new MagicEightBallButtonsController(this.game);
    this.newGame.addActionListener(newGameController);
    
    //The controller for the end game button
    MagicEightBallButtonsController endGameController = new MagicEightBallButtonsController(this.game);
    this.endGame.addActionListener(endGameController);
    
  }
 
  
  /** Redraws the game board according to the current game situation. Requires data
    * from the Model.
    */ 
  public void update()
  {
    
    x.trim();
    
    //This will use the method in the model called getRoundsDone()
    //this if statement will check if the rounds has reached the limit of 10 rounds or not
    //if the method getRoundsDone() returns false, then disable the JTextField
    if(this.game.getRoundsDone() == false)
    {
      this.question.setEnabled(false);
    }
    
    //All the "else if" statments will check whether the question asked will contain words that do not represent a yes/no question
    //If the question does, then it will execute code from another method in the model called extraWords(int)
    else if(x.contains("how much") || x.contains("How much") || x.contains("How many") || x.contains("how many") || x.contains("how can") || x.contains("How can"))
    {
      
      this.questionAnswerPanel.setBackground(Color.BLUE);
      this.questionAnswer.setOpaque(true);
      this.questionAnswer.setBackground(Color.BLUE);
      this.questionAnswer.setForeground(Color.WHITE);
      
      this.questionAnswer.setText(this.game.extraWords(1 + (int)(Math.random()*2)));
    }

    else if(x.contains("how do") || x.contains("how does") || x.contains("How do") || x.contains("How does"))
    {
      this.questionAnswer.setText(this.game.extraWords(3));
      
      questionAnswerPanel.setBackground(Color.BLUE);
      questionAnswer.setOpaque(true);
      questionAnswer.setBackground(Color.BLUE);
      questionAnswer.setForeground(Color.WHITE);
      
    }
    
    else if(x.contains("what is") || x.contains("What is"))
    {
      this.questionAnswer.setText(this.game.extraWords(4));
      
      questionAnswerPanel.setBackground(Color.BLUE);
      questionAnswer.setOpaque(true);
      questionAnswer.setBackground(Color.BLUE);
      questionAnswer.setForeground(Color.WHITE);
      
    }
    
    //This will execute if the user asked a yes/no question
    else
    {
      this.questionAnswer.setText(this.game.resultReturned());
      
      questionAnswerPanel.setBackground(Color.BLUE);
      questionAnswer.setOpaque(true);
      questionAnswer.setBackground(Color.BLUE);
      questionAnswer.setForeground(Color.WHITE);
      
    }
    
  }//end of method update()
}//end of class