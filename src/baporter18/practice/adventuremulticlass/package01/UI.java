package baporter18.practice.adventuremulticlass.package01;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import baporter18.practice.adventuremulticlass.package01.Game.ChoiceHandler;

public class UI {

	JFrame window;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel;
	JButton startButton, choiceButton1, choiceButton2, choiceButton3, choiceButton4;
	JTextArea mainTextArea;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
	
	public void createUI(ChoiceHandler choiceHandler) {
		
		// WINDOW
		window = new JFrame();
		window.setSize(800,  600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		// TITLE SCREEN
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 500);;
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(choiceHandler);
		startButton.setActionCommand("start");
		
		// GAME SCREEN
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		
		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 375, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		
		choiceButton1 = new JButton();
		choiceButton1.setBackground(Color.black);
		choiceButton1.setForeground(Color.white);
		choiceButton1.setFont(normalFont);
		choiceButton1.setFocusPainted(false);
		choiceButton1.addActionListener(choiceHandler);
		choiceButton1.setActionCommand("c1");
		
		choiceButton2 = new JButton();
		choiceButton2.setBackground(Color.black);
		choiceButton2.setForeground(Color.white);
		choiceButton2.setFont(normalFont);
		choiceButton2.setFocusPainted(false);
		choiceButton2.addActionListener(choiceHandler);
		choiceButton2.setActionCommand("c2");
		
		choiceButton3 = new JButton();
		choiceButton3.setBackground(Color.black);
		choiceButton3.setForeground(Color.white);
		choiceButton3.setFont(normalFont);
		choiceButton3.setFocusPainted(false);
		choiceButton3.addActionListener(choiceHandler);
		choiceButton3.setActionCommand("c3");
		
		choiceButton4 = new JButton();
		choiceButton4.setBackground(Color.black);
		choiceButton4.setForeground(Color.white);
		choiceButton4.setFont(normalFont);
		choiceButton4.setFocusPainted(false);
		choiceButton4.addActionListener(choiceHandler);
		choiceButton4.setActionCommand("c4");
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);

		hpNumberLabel = new JLabel();
		hpNumberLabel.setFont(normalFont);
		hpNumberLabel.setForeground(Color.white);
		
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);

		weaponNameLabel = new JLabel();
		weaponNameLabel.setFont(normalFont);
		weaponNameLabel.setForeground(Color.white);
		
		// Assemble UI
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel.add(choiceButton1);
		choiceButtonPanel.add(choiceButton2);
		choiceButtonPanel.add(choiceButton3);
		choiceButtonPanel.add(choiceButton4);
		
		playerPanel.add(hpLabel);
		playerPanel.add(hpNumberLabel);
		playerPanel.add(weaponLabel);
		playerPanel.add(weaponNameLabel);
		
		window.add(playerPanel);
		window.add(mainTextPanel);
		window.add(choiceButtonPanel);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		
		window.setVisible(true);
	}
}
