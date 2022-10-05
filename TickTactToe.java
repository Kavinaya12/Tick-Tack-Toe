
//E/17/159

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TickTactToe implements ActionListener{

	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn ;
	int win;
	int count;

	TickTactToe(){
		//create frame 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,400);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		//text area for title panel
		textfield.setForeground(new Color(0,50,100));
		textfield.setFont(new Font("Purisa",Font.BOLD,40));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
			
		//title panel 
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(600,150,80,80);
		
		//button panel 
		button_panel.setLayout(new GridLayout(3,3));
		//button_panel.setBackground(new Color(0,50,100));
		button_panel.setBackground(Color.gray);
		for(int i=0;i<9;i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("TimesRoman",Font.BOLD,90));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);  //add text for title
		frame.add(title_panel,BorderLayout.EAST);  
		frame.add(button_panel);
		player1_turn = true;
		win = 0;
		count = 0;
	}

	
	public void actionPerformed(ActionEvent e) {
		count++;
		int i; 
		for(i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {    //if it is a turn of a palyer 1
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));  //color for player 1
						buttons[i].setText("1");                       //set text in button as 1
                        player1_turn=false;							
						textfield.setText("Player 2 turn");           //print as player 2's 
						CheckWin();									//check for win criteria
					}
				}
				else {					//if it is a turn of a palyer 2
					if(buttons[i].getText()=="") {	
						buttons[i].setForeground(new Color(0,0,255));   //color for player 1
						buttons[i].setText("2");						//set text in button as 2
                        player1_turn=true;
						textfield.setText("Player 1 turn");				//print as player 1's 
						CheckWin();										//check for win criteria
					}
				}
			}
						
		}
		if(count==9){              //if all the buttons are pressed then check for draw
			CheckDraw();
		}
		
	}
	


	
	public void CheckWin() {
		//check palyer 2 win conditions
		if((buttons[0].getText()=="2") && (buttons[1].getText()=="2") &&(buttons[2].getText()=="2")) {
            Player2Wins(0,1,2);
        }
        
		if((buttons[3].getText()=="2") && (buttons[4].getText()=="2") && (buttons[5].getText()=="2")) {
			Player2Wins(3,4,5);
        }
        
		if((buttons[6].getText()=="2") && (buttons[7].getText()=="2") && (buttons[8].getText()=="2")) {
			Player2Wins(6,7,8);
        }
        
		if((buttons[0].getText()=="2") && (buttons[3].getText()=="2") && (buttons[6].getText()=="2")) {
			Player2Wins(0,3,6);
        }
        
		if((buttons[1].getText()=="2") && (buttons[4].getText()=="2") && (buttons[7].getText()=="2")) {
			Player2Wins(1,4,7);
        }
        
		if((buttons[2].getText()=="2") && (buttons[5].getText()=="2") && (buttons[8].getText()=="2")) {
			Player2Wins(2,5,8);
        }        
		if((buttons[0].getText()=="2") && (buttons[4].getText()=="2") && (buttons[8].getText()=="2")) {
			Player2Wins(0,4,8);
        }
        
		if((buttons[2].getText()=="2") && (buttons[4].getText()=="2") && (buttons[6].getText()=="2")) {
			Player2Wins(2,4,6);
        }
        
		//check player 1 win conditions
		if((buttons[0].getText()=="1") && (buttons[1].getText()=="1") && (buttons[2].getText()=="1")) {
			Player1Wins(0,1,2);
        }
        
		if((buttons[3].getText()=="1") && (buttons[4].getText()=="1") && (buttons[5].getText()=="1")) {
			Player1Wins(3,4,5);
        }
        
		if((buttons[6].getText()=="1") && (buttons[7].getText()=="1") && (buttons[8].getText()=="1")) {
			Player1Wins(6,7,8);
        }
        
		if((buttons[0].getText()=="1") && (buttons[3].getText()=="1") && (buttons[6].getText()=="1")) {
			Player1Wins(0,3,6);
        }
        
		if((buttons[1].getText()=="1") && (buttons[4].getText()=="1") && (buttons[7].getText()=="1")) {
			Player1Wins(1,4,7);
        }
        
		if((buttons[2].getText()=="1") && (buttons[5].getText()=="1") && (buttons[8].getText()=="1")) {
			Player1Wins(2,5,8);
        }
        
		if((buttons[0].getText()=="1") && (buttons[4].getText()=="1") && (buttons[8].getText()=="1")) {
			Player1Wins(0,4,8);
        }
        
		if((buttons[2].getText()=="1") && (buttons[4].getText()=="1") && (buttons[6].getText()=="1")) {
			Player1Wins(2,4,6);
		}
		
	}
	


	public void Player1Wins(int a,int b,int c) {  //method call for player 1 wins
		buttons[a].setBackground(Color.yellow);  //if player 1 wins then change button color
		buttons[b].setBackground(Color.yellow);
		buttons[c].setBackground(Color.yellow);
		
		for(int i=0;i<9;i++) {                  //set the button disable
			buttons[i].setEnabled(false);
		}
		
		
		Result(1);      		//call the result class to print the result
		win = 1;							//change win as 1
	}


	
	public void Player2Wins(int a,int b,int c) {	//method call for player 2 wins
		buttons[a].setBackground(Color.yellow);		//if player 1 wins then change button color
		buttons[b].setBackground(Color.yellow);
		buttons[c].setBackground(Color.yellow);
		
		for(int i=0;i<9;i++) {					//set the button disable
			buttons[i].setEnabled(false);
		}
		
		
		 Result(2);				//call the result obj to print the result with 2 input
		win = 2;								//change win as 1
	}



	public void CheckDraw(){             //method for check the draw condition      
		if(win==0 && count == 9){
			for(int i=0;i<9;i++) {
				buttons[i].setEnabled(false); //make all the buttons disable
			}
		
		Result(0);       //call the result obj with 0 input
		}
	}


	

	public void Result(int x){                  //constructor

		JFrame frame2 = new JFrame();      //create frame
    	JLabel textfield2 = new JLabel();
    
        
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //frame
		frame2.setSize(300,300);
		frame2.setLayout(new BorderLayout());
		frame2.setVisible(true);
        
		if(x==0){                         //if 0 print the text as draw
            textfield2.setText("It's a draw");
        }
        else{                               //else print the winner's name
            textfield2.setText("Player "+ x +" wins");
        }

		textfield2.setForeground(Color.RED);
		textfield2.setFont(new Font("Purisa",Font.BOLD,40));
        textfield2.setHorizontalAlignment(JLabel.CENTER);
        
        textfield2.setOpaque(true);
        frame2.add(textfield2);
	}
	

}
