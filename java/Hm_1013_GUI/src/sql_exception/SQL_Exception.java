package sql_exception;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SQL_Exception extends JFrame{
	JLabel exception = new JLabel("�̹� ����� �ܾ��Դϴ�.");
	public SQL_Exception() {
		this.setBounds(270, 350, 200, 100);
		this.add(exception,"Center");
		this.setVisible(true);
	}
}
