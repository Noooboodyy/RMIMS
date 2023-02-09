package restaurantManagementSystem;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import modifiedComponents.ComboBox;

public class InvalidInputs {
	public void InputRequiredMessage(JTextField Input, JLabel message){
		if(Input.getText().isBlank()) {
			Input.setBorder(new LineBorder(Color.RED, 1, true));
			message.setText("This Field is Required");
		}else {
			message.setText(null);
			Input.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		}
	}
	public void InvalidInput(JTextField Input, JLabel message, String regex) {
		if(!Input.getText().matches(regex)) {
			Input.setBorder(new LineBorder(Color.RED, 1, true));
			message.setText("Invalid Input");
		}else {
			message.setText(null);
			Input.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
		}
	}
	public boolean checkExistingData(ArrayList <String> list, JTextField Input, JLabel message) {
		if(list.contains(Input.getText())) {
			return true;
		}else {
			message.setText(null);
			Input.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
			return false;
		}
		
	}
	public void InvalidSelection(ComboBox combobox, String category, JLabel message, String invalid,String messagedis) {
		if(category.equals(invalid)) {
			combobox.setBorder(new LineBorder(Color.RED, 1, true));
			message.setText(messagedis);
		}else {
			combobox.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true));
			message.setText(null);
			
		}
	}
	
}
