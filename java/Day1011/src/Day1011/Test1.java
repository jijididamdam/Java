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

public class Test1 extends JFrame implements ActionListener {  // �����̳�  
	


	// �ؿ� ������ ������Ʈ
	JLabel titleLB = new JLabel("�޸����α׷�");
	JButton btn = new JButton("Login");
	JButton cbtn = new JButton("ȸ������");
	JButton close = new JButton("Exit");
	JLabel idLB = new JLabel("���̵�");
	JLabel passLB = new JLabel("�� ��");
	//JTextField idInput = new JTextField(4);    // ����ũ�� 4 ��� �ǹ�
	//JTextArea inputBody = new JTextArea(3,10);
	JTextField idInput = new JTextField(10); 
	JTextField pwdInput = new JTextField(10); 
	JPanel centerP = new JPanel();         // �г��� �⺻���̾ƿ��� �÷ο췹�̾ƿ�  
										   //   > ������ ������Ѵٸ� centerP.setLayout(new BorderLayout());
	
	JPanel centerPN = new JPanel();
	JPanel centerPS = new JPanel();
	JPanel southP = new JPanel();
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("�̺�Ʈó��");
		Object temp = e.getSource();   // ������
		if(temp.equals(btn)) {
			System.out.println("��ư Ŭ��");
			String id = idInput.getText();
			titleLB.setText(id);
		} else if(temp.equals(close)) {
			System.out.println("���α׷� ����");
			System.exit(0);
		} else if(temp.equals(cbtn)) {
			Test2 t2 = new Test2();
			t2.Test2run();
		}
	}
	
	// GridLayout(2,1)  -> ���ΰ� 2 ���ΰ� 1  >  2 * 1 �̶�� �ǹ�
	
	public Test1() {
		this.setBounds(100, 300, 200, 150);   // ������ ����   x, y , width, height     
											  // JFrame���� ������ �ڿ��� �����ͼ� ���
		
		//GridLayout ����غ���
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
		
		btn.addActionListener(this); // btn ������Ʈ�� �̺�Ʈ(Ŭ�� ��)�� ó���ϰڴ�.
									//  this�� �����ϴ� ��ü�� �̸� ó�����ִ� �������̽��� �����޾Ҵ�.
		
		
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
		
		
		//���� ���ϴ�
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
		
		//this�� ������Ʈ�� ��ġ��Ų��...�⺻�� �������̾ƿ�
		/*
		this.add(titleLB,"North");
		this.add(btn,"East");
		this.add(mainLB,"West");
		this.add(inputBody,"Center");
		this.add(idInput,"South");
		*/
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);   // â x ��ư ������ �ڵ����� ����ȴ�.
		
	}

}
