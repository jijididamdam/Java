package ex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test1 extends JFrame implements ActionListener{
   JLabel titleLB = new JLabel("�޸� ���α׷�");  // ������Ʈ
   JButton btn = new JButton("Login"); // ������Ʈ
   JButton close= new JButton("Exit"); // ������Ʈ
   JButton newjoin= new JButton("Join"); // ������Ʈ
   JLabel idLB = new JLabel("���̵�"); // ������Ʈ
   JLabel passLB = new JLabel("��     ��"); // ������Ʈ
   JTextField idInput = new JTextField(10); // ������Ʈ
   JTextField pwdnput = new JTextField(10); // ������Ʈ
   //JTextArea inputBody = new JTextArea(3, 10);
   JPanel centerP  = new JPanel();    // ������Ʈ. �����̳�
   JPanel centerPN = new JPanel();   // ������Ʈ. �����̳�
   JPanel centerPS = new JPanel();   // ������Ʈ. �����̳�
   JPanel southP = new JPanel();   // ������Ʈ. �����̳�
   
   Test2 t2 = new Test2();
   
   public Test1(){
      System.out.println("���α׷��� ���۵Ǿ����ϴ�.");
      this.setBounds(100, 300, 250, 150);  // ������ ����..
      centerP.setBackground(Color.cyan);
      centerPN.setBackground(Color.GREEN);
      centerPS.setBackground(Color.LIGHT_GRAY);
      centerP.setLayout(new GridLayout(2, 1));  // layout ������Ʈ�� ��ġ��Ų��. 
      centerPN.setLayout(new FlowLayout());
      centerPS.setLayout(new FlowLayout());
      centerPN.add(idLB);
      centerPN.add(idInput);
      centerPS.add(passLB);
      centerPS.add(pwdnput);
      centerP.add(centerPN);
      centerP.add(centerPS);
      southP.add(btn);
      southP.add(newjoin);
      southP.add(close);
      btn.addActionListener(this);  // btn ������Ʈ�� �̺�Ʈ(Ŭ�� ��)�� ó���ϰڴ�. this�� �����ϴ� ��ü�� �̸� ó���� �ִ� 
                                     // �������̽��� ���� �޾Ҵ�.
      close.addActionListener(this);
      newjoin.addActionListener(this);
      // this�� ������Ʈ�� ��ġ��Ų��.. �⺻�� �������̾ƿ�
      this.add(titleLB,"North");
      //this.add(btn,"East");
      //this.add(mainLB,"West");
      this.add(centerP,"Center");
      this.add(southP,"South");
      
      
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println("�̺�Ʈ ó��");
      Object temp = e.getSource();   // ������
      if(temp.equals(btn)) {
         System.out.println("��ư Ŭ��");
         String id = idInput.getText();
         titleLB.setText(id);
      }else if(temp.equals(close)) {
         System.out.println("���α׷�����");
         System.exit(0);
      }else if(temp.equals(newjoin)) {
         // Test2��� ��ü�� ���ι�ư ���������� ��ü�� �����ȴٸ�.. �� ��ü ����..
         t2.viewFrame();
      }
      
   }

}
