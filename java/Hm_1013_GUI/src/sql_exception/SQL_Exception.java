package sql_exception;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SQL_Exception extends JFrame{
	JLabel exception = new JLabel("이미 저장된 단어입니다.");
	public SQL_Exception() {
		this.setBounds(270, 350, 200, 100);
		this.add(exception,"Center");
		this.setVisible(true);
	}
}
