package Day1011;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test2 extends JFrame implements ActionListener {
	
	
	JLabel title = new JLabel("회원가입");
	JLabel idlb = new JLabel("아 이 디");
	JLabel namelb = new JLabel("이    름");
	JLabel pwlb = new JLabel("비밀번호");
	JLabel callb = new JLabel("전화번호");
	
	JButton gbtn = new JButton("가입");
	JButton chbtn = new JButton("초기화");
	JButton jbtn = new JButton("종료");
	
	JTextField idput = new JTextField(10);
	JTextField nameput = new JTextField(10);
	JTextField pwput = new JTextField(10);
	JTextField calput = new JTextField(10);
	
	JPanel centerP = new JPanel();
	JPanel centerId = new JPanel();
	JPanel centerName = new JPanel();
	JPanel centerPw = new JPanel();
	JPanel centerCal = new JPanel();
	JPanel southP = new JPanel();
	
	
	public Test2() {
		this.setBounds(100,300,250,350);
		
		//centerP.setBackground(Color.cyan);
		
		
		
		southP.setLayout(new GridLayout(1,3));
		southP.add(gbtn);
		southP.add(chbtn);
		southP.add(jbtn);
		
		gbtn.addActionListener(this);
		chbtn.addActionListener(this);
		jbtn.addActionListener(this);
		
		this.add(title,"North");
		//this.add(centerP,"Center");
		this.add(southP,"South");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	public void Test2run() {
		this.setBounds(100,300,250,350);

		
		centerP.setLayout(new GridLayout(4,1));
		centerId.setLayout(new FlowLayout());
		centerName.setLayout(new FlowLayout());
		centerPw.setLayout(new FlowLayout());
		centerCal.setLayout(new FlowLayout());
		
		centerId.add(idlb);
		centerId.add(idput);
		centerName.add(namelb);
		centerName.add(nameput);
		centerPw.add(pwlb);
		centerPw.add(pwput);
		centerCal.add(callb);
		centerCal.add(calput);
		centerP.add(centerId);
		centerP.add(centerName);
		centerP.add(centerPw);
		centerP.add(centerCal);
		
		
		southP.setLayout(new GridLayout(1,3));
		southP.add(gbtn);
		southP.add(chbtn);
		southP.add(jbtn);
		
		gbtn.addActionListener(this);
		chbtn.addActionListener(this);
		jbtn.addActionListener(this);
		
		this.add(title,"North");
		this.add(centerP,"Center");
		this.add(southP,"South");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("가입을 클릭하시오");
		Object temp = e.getSource();
		if(temp.equals(gbtn)) {
			
			Test2run();			
			
			/*
			String id = idput.getText();
			String name = nameput.getText();
			String pw = pwput.getText();
			String cal = calput.getText();
			*/
			
		} else if (temp.equals(chbtn)) {
			System.out.println("초기화");
			idput.setText(null);
			nameput.setText(null);
			pwput.setText(null);
			calput.setText(null);	
			
		} else if (temp.equals(jbtn)) {
			System.out.println("프로그램 종료");
			System.exit(0);
		}
		
	}
	
	
	

}
