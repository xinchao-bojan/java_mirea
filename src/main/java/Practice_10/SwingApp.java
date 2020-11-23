package Practice_10;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingApp extends JFrame {


	static class ImagePanel extends JComponent {
		private Image image;

		public ImagePanel(Image image) {
			this.image = image;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, this);
		}
	}


	public SwingApp() {

		try {
			BufferedImage myImage = ImageIO.read(new File("assets/back.png"));
			setContentPane(new ImagePanel(myImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("Want to calculate");
		setSize(600, 450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		JTextField num1 = new JTextField();
		JTextField num2 = new JTextField();
		JLabel answer = new JLabel();
		JLabel numA=new JLabel();
		JLabel numB=new JLabel();
		JLabel result=new JLabel();
		JButton aButton = new JButton("+");
		JButton sButton = new JButton("-");
		JButton mButton = new JButton("*");
		JButton dButton = new JButton("/");

		answer.setForeground(Color.RED);
		answer.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.GREEN), BorderFactory.createEmptyBorder()));
		numA.setForeground(Color.red);
		numB.setForeground(Color.red);
		result.setForeground(Color.WHITE);
		numA.setText("a");
		numB.setText("b");
		result.setText("result");
		num1.setBounds(120, 50, 100, 50);
		num2.setBounds(380, 50, 100, 50);
		answer.setBounds(150, 282, 300, 50);
		aButton.setBounds(120, 180, 50, 50);
		sButton.setBounds(225, 180, 50, 50);
		mButton.setBounds(325, 180, 50, 50);
		dButton.setBounds(430, 180, 50, 50);
		numA.setBounds(162,25,10,10);
		numB.setBounds(425,25,10,10);
		result.setBounds(280,260,80,15);
		num1.setHorizontalAlignment(SwingUtilities.RIGHT);
		num2.setHorizontalAlignment(SwingUtilities.RIGHT);
		answer.setHorizontalAlignment(SwingUtilities.LEFT);

		add(num1);
		add(num2);
		add(answer);
		add(aButton);
		add(sButton);
		add(mButton);
		add(dButton);
		add(numA);
		add(numB);
		add(result);

		sButton.addActionListener(action -> {
			try {
				answer.setText(String.format("%.4f", Double.parseDouble(num1.getText()) - Double.parseDouble(num2.getText())));
			} catch (Exception E) {
				JOptionPane.showMessageDialog(null, "Incorrect input");
			}
		});

		aButton.addActionListener(action -> {
			try {
				answer.setText(String.format("%.4f", Double.parseDouble(num1.getText()) + Double.parseDouble(num2.getText())));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Incorrect input");
			}
		});

		dButton.addActionListener(action -> {
			try {
				if (Double.parseDouble(num2.getText())==0)
				{
					answer.setText("Error");
					JOptionPane.showMessageDialog(null, "It is impossible");
				}
				else
					answer.setText(String.format("%.4f", Double.parseDouble(num1.getText()) / Double.parseDouble(num2.getText())));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Incorrect input");
			}
		});

		mButton.addActionListener(action -> {
			try {
				answer.setText(String.format("%.4f", Double.parseDouble(num1.getText()) * Double.parseDouble(num2.getText())));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Incorrect input");
			}
		});

	}
}
