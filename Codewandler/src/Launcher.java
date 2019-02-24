import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Launcher implements ActionListener{

	public static JFrame frame;
	public static JPanel panel;
	public static JTextArea textarea;
	public static JScrollPane scrollpane;
	public static JTextField textfield;
	public static JButton button;
	public static JLabel label;
	
	public static JCheckBox checkbox;
	
	public static int coulmns = 8;
	
	private boolean skip = false;
	
	public static void main(String[] args) {
		initFrame();
	}
	
	public static Launcher instance = new Launcher();
	
	public static void initFrame() {
		frame = new JFrame("Codewandler");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setMaximumSize(new Dimension(800, 600));
		panel.setMinimumSize(new Dimension(800, 600));
		
		panel.setLayout(null);
		
		label = new JLabel("Anzahl der Eingangsvariablen:");
		label.setBounds(50, 55, 400, 20);
		
		textfield = new JTextField("8");
		textfield.setBounds(270, 55, 30, 20);
		textfield.addActionListener(instance);
		
		button = new JButton("Generieren");
		button.setBounds(400, 55, 100, 20);
		button.addActionListener(instance);
		
		checkbox = new JCheckBox("Nur 0/1 kodieren");
		checkbox.setBounds(600, 50, 200, 30);
		
		textarea = new JTextArea();

		scrollpane = new JScrollPane(textarea);
		scrollpane.setBounds(50, 100, 700, 450);
		
		panel.add(label);
		panel.add(textfield);
		panel.add(button);
		panel.add(checkbox);
		panel.add(scrollpane);
		frame.getContentPane().add(panel);
		
		frame.add(panel);
//		frame.pack();
		frame.setVisible(true);;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == textarea) {
			try {
				coulmns = Integer.parseInt(textarea.getText());
			} catch (Exception e2) {
				textarea.setText("Bitte gültige Anzahl an Eingangsvariablen eingaben!");
			}
		}
		if (e.getSource() == button) {
			if (checkbox.isSelected()) {
				skip = true;
			} else {
				skip = false;
			}
			
			
			try {
				coulmns = Integer.parseInt(textfield.getText());
				
				Codewandler.initRowsAndCoulmns(coulmns);
				Codewandler.linkeSeite();
				StringBuffer temp = Codewandler.getStringBuffer(coulmns, (int) Math.pow(2, coulmns), skip);
				textarea.setText("" + temp);
			} catch (Exception e2) {
				textarea.setText("Bitte gültige Anzahl an Eingangsvariablen eingaben!");
			}
		}
	}
}
