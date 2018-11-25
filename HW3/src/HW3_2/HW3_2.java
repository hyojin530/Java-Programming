package HW3_2;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HW3_2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();		//make a frame
	
		JPanel p1 = new JPanel();			//make a panel p1
		p1.setLayout(new GridLayout(4, 2));	//set Layout of p1 to GridLayout(4,2)
		
		//the number of Producers in a game
		JLabel label1 = new JLabel("# of Producers: ");			//make a label label1
		p1.add(label1);											//add label1 to p1
		JTextField text1 = new JTextField("enter the number");	//make a text field text1
		p1.add(text1);											//add text1 to p1
		
		//the number of Consumers in a game
		JLabel label2 = new JLabel("# of Consumers: ");			//make a label label2
		p1.add(label2);											//add label2 to p2
		JTextField text2 = new JTextField("enter the number");	//make a text field text2
		p1.add(text2);											//add text2 to p2
		
		//the number of consumption unit in a game
		JLabel label3 = new JLabel("Consumption Unit: ");		//make a label label3
		p1.add(label3);											//add label3 to p3
		JTextField text3 = new JTextField("enter the number");	//make a text field text3
		p1.add(text3);											//add text3 to p3
		
		//total number
		JLabel label4 = new JLabel("Total #: ");				//make a label label4
		p1.add(label4);											//add label4 to p4
		JTextField text4 = new JTextField("enter the number");	//make a text field text4
		p1.add(text4);											//add text4 to p4
		
		//start button
		JPanel p2 = new JPanel();								//make a panel p2
		JButton button1 = new JButton("start");					//make a button button1
		button1.addActionListener(new ActionListener() {		//make action listener on the button
					public void actionPerformed(ActionEvent e){
						String num_pro = text1.getText();	//get text of text1
						int x = Integer.parseInt(num_pro);	//change it to an int value
						
						String num_con = text2.getText();	//get text of text2
						int y = Integer.parseInt(num_con);	//change it to an int value
						
						String c_unit = text3.getText();	//get text of text3
						int m = Integer.parseInt(c_unit);	//change it to an int value
						
						String num_tot= text4.getText();	//get text of text4
						int n = Integer.parseInt(num_tot);	//change it to an int value
						
						int i;								//declare int i for for loop
						
						Bakery2 bakery = new Bakery2();		//make instance of Bakery2
						bakery.bread_at = m;				//set bakery.bread_at to m
						bakery.bread_end = n;				//set bakery.bread_at to n
						
						//make an ArrayList for Producer2
						ArrayList<Producer2> proList = new ArrayList<Producer2>();
						//make an ArrayList for Consumer2
						ArrayList<Consumer2> conList = new ArrayList<Consumer2>();
						
						for(i=0; i<x; i++) {	//make x instances of Producer2
							proList.add(new Producer2(bakery, i+1));	//using proList
						}
						for(i=0; i<y; i++) {	//make y instances of Consumer2
							conList.add(new Consumer2(bakery, i+1));	//using conList
						}
							
						for(i=0; i<x; i++) {		//let all instances of Producer2 start
							proList.get(i).start();	//using proList
						}
						for(i=0; i<y; i++) {		//let all instances of Consumer2 start
							conList.get(i).start();	//using conList
						}
					}
				});
		p2.add(button1);	//add button1 to p2
		
		frame.setLayout(new BorderLayout());	//set layout of frame to BorderLayout()
		frame.add(p1, BorderLayout.CENTER);		//add p1 to center of frame
		frame.add(p2, BorderLayout.SOUTH);		//add p2 to south of frame
		
		//set up frame
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("HW#3-2 Input Window");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}
	
}
