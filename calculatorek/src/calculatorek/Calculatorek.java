package calculatorek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculatorek implements ActionListener{

	JFrame frame;
	JTextField text;
	JButton[] num = new JButton[10];
	JButton[] func = new JButton[9];
	JButton add, sub, mul, div;
	JButton dec, equ, del, clr, neg;
	JPanel panel;
	JPanel panel_s;
	
	Font font = new Font("Ink Free", Font.BOLD, 30);
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculatorek() {
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(415, 600);
		frame.setLayout(null);
		
		text = new JTextField();
		text.setBounds(25, 25, 350, 50);
		text.setFont(font);
		text.setEditable(false);
		
		add = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("*");
		div = new JButton(":");
		dec = new JButton(".");
		equ = new JButton("=");
		del = new JButton("del");
		clr = new JButton("clear");
		neg = new JButton("(-)");
		func[0] = add;
		func[1] = sub;
		func[2] = mul;
		func[3] = div;
		func[4] = dec;
		func[5] = equ;
		func[6] = clr;
		func[7] = del;
		func[8] = neg;
		for(int i = 0; i < 9; i++) {
			func[i].addActionListener(this);
			func[i].setFont(font);
			func[i].setFocusable(false);
		}
		for(int i = 0; i < 10; i++) {
			num[i] = new JButton(String.valueOf(i));
			num[i].addActionListener(this);
			num[i].setFont(font);
			num[i].setFocusable(false);
		}
		clr.setBounds(25, 450, 175, 87);
		
		panel_s = new JPanel();
		panel_s.setBounds(200, 450, 175, 87);
		panel_s.setLayout(new GridLayout(1, 2, 0, 0));
		panel_s.add(del);
		panel_s.add(neg);
		
		panel = new JPanel();
		panel.setBounds(25, 100, 350, 350);
		panel.setLayout(new GridLayout(4, 4, 0, 0));
		panel.add(num[1]);
		panel.add(num[2]);
		panel.add(num[3]);
		panel.add(add);
		panel.add(num[4]);
		panel.add(num[5]);
		panel.add(num[6]);
		panel.add(sub);
		panel.add(num[7]);
		panel.add(num[8]);
		panel.add(num[9]);
		panel.add(mul);
		panel.add(dec);
		panel.add(num[0]);
		panel.add(equ);
		panel.add(div);
		
		frame.add(panel);
		frame.add(panel_s);
		frame.add(clr);
		frame.add(text);
		
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == num[i]) {
				text.setText(text.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == dec) {
			text.setText(text.getText().concat("."));
		}
		if(e.getSource() == add) {
			num1 = Double.parseDouble(text.getText());
			operator = '+';
			text.setText("");
		}
		if(e.getSource() == sub) {
			num1 = Double.parseDouble(text.getText());
			operator = '-';
			text.setText("");
		}
		if(e.getSource() == mul) {
			num1 = Double.parseDouble(text.getText());
			operator = '*';
			text.setText("");
		}
		if(e.getSource() == div) {
			num1 = Double.parseDouble(text.getText());
			operator = ':';
			text.setText("");
		}
		if(e.getSource() == equ) {
			num2 = Double.parseDouble(text.getText());
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case ':':
				result = num1 / num2;
				break;
			}
			text.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clr) {
			text.setText("");
		}
		if(e.getSource() == del) {
			String string = text.getText();
			text.setText(""); //usuwamy wszystkie znaki
			for(int i = 0; i < string.length() - 1; i++) {
				text.setText(text.getText()+string.charAt(i)); //dodawanie kolejnych znaków ¿eby uzyskaæ o jeden mniej ni¿ wczeœniej
			}
		}
		if(e.getSource() == neg) {
			double temp = Double.parseDouble(text.getText());
			temp = temp * (-1);
			text.setText(String.valueOf(temp));
		}
		
	}

	

}
