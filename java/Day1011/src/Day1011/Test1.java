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

public class Test1 extends JFrame implements ActionListener {  // 컨테이너  
	


	// 밑에 선언문이 컴포넌트
	JLabel titleLB = new JLabel("휴먼프로그램");
	JButton btn = new JButton("Login");
	JButton cbtn = new JButton("회원가입");
	JButton close = new JButton("Exit");
	JLabel idLB = new JLabel("아이디");
	JLabel passLB = new JLabel("비 번");
	//JTextField idInput = new JTextField(4);    // 가로크기 4 라는 의미
	//JTextArea inputBody = new JTextArea(3,10);
	JTextField idInput = new JTextField(10); 
	JTextField pwdInput = new JTextField(10); 
	JPanel centerP = new JPanel();         // 패널의 기본레이아웃은 플로우레이아웃  
										   //   > 보더로 변경원한다면 centerP.setLayout(new BorderLayout());
	
	JPanel centerPN = new JPanel();
	JPanel centerPS = new JPanel();
	JPanel southP = new JPanel();
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("이벤트처리");
		Object temp = e.getSource();   // 다형성
		if(temp.equals(btn)) {
			System.out.println("버튼 클릭");
			String id = idInput.getText();
			titleLB.setText(id);
		} else if(temp.equals(close)) {
			System.out.println("프로그램 종료");
			System.exit(0);
		} else if(temp.equals(cbtn)) {
			Test2 t2 = new Test2();
			t2.Test2run();
		}
	}
	
	// GridLayout(2,1)  -> 가로가 2 세로가 1  >  2 * 1 이라는 의미
	
	public Test1() {
		this.setBounds(100, 300, 200, 150);   // 사이즈 설정   x, y , width, height     
											  // JFrame에서 제공된 자원을 가져와서 사용
		
		//GridLayout 사용해보기
		centerP.setBackground(Color.cyan);
		centerPN.setBackground(Color.GREEN);
		centerPS.setBackground(Color.LIGHT_GRAY);
		
		centerP.setLayout(new GridLayout(2,1));
		centerPN.setLayout(new FlowLayout());
		centerPS.setLayout(new FlowLayout());
		centerPN.add(idLB);
		centerPN.add(idInput);
		centerPS.add(passLB);		
		centerPS.add(pwdInput);
		centerP.add(centerPN);
		centerP.add(centerPS);
		
		southP.setLayout(new GridLayout(1,3));
		southP.add(btn);
		southP.add(cbtn);
		southP.add(close);
		
		btn.addActionListener(this); // btn 컴포넌트의 이벤트(클릭 등)를 처리하겠다.
									//  this가 참조하는 객체가 이를 처리해주는 인터페이스를 구현받았다.
		
		
		cbtn.addActionListener(this);
		close.addActionListener(this);
		
		
		
		/*
		centerP.setBackground(Color.cyan);
		centerP.add(idLB);
		centerP.add(idInput);
		centerP.add(passLB);
		centerP.add(pwdInput);
		*/
		
		this.add(titleLB,"North");
		this.add(centerP,"Center");
		//this.add(btn,"South");
		this.add(southP,"South");
		
		
		//멋을 더하다
		//inputBody.setBackground(Color.yellow);
		btn.setBackground(Color.red);
		
		//FlowLayout
		/*
		this.setLayout(new FlowLayout());
		this.add(titleLB);
		this.add(btn);
		this.add(mainLB);
		this.add(inputBody);
		this.add(idInput);
		*/
		
		//this에 컴포넌트를 배치시킨다...기본은 보더레이아웃
		/*
		this.add(titleLB,"North");
		this.add(btn,"East");
		this.add(mainLB,"West");
		this.add(inputBody,"Center");
		this.add(idInput,"South");
		*/
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);   // 창 x 버튼 누르면 자동으로 종료된다.
		
	}

}
