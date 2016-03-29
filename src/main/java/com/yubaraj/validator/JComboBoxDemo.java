package com.yubaraj.validator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class JComboBoxDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Combo Box demo.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new FlowLayout());
		JLabel label = new JLabel("Choose Question: ");
		panel.add(label);

		JComboBox<String> jComboBox = new JComboBox<>();
		jComboBox.addItem("Security questions");
		jComboBox.addItem("Question 1");
		jComboBox.addItem("Question 2");
		jComboBox.addItem("Question 3");
		jComboBox.addItem("Question 4");
		jComboBox.setSize(50, 10);

		panel.add(jComboBox);

		JLabel label1 = new JLabel("Answer: ");

		panel.add(label1);

		JTextArea textArea = new JTextArea(5, 15);

		panel.add(textArea);

		JButton button = new JButton("Save");

		panel.add(new JLabel());
		panel.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
					Validator validator = validatorFactory.getValidator();

					String value = jComboBox.getSelectedItem().toString();
					MyModel model = new MyModel(value,textArea.getText());

					Set<ConstraintViolation<MyModel>> constraintViolations = validator.validate(model);

					if (!constraintViolations.isEmpty()) {
						String error = "";
						for (ConstraintViolation<MyModel> constraintViolation : constraintViolations) {
							error += constraintViolation.getMessage();
							JOptionPane.showMessageDialog(null, error);
						}
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}
		});

		frame.add(panel);
		frame.setSize(300, 400);
		frame.setVisible(true);
	}
}