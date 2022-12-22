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
   JLabel titleLB = new JLabel("휴먼 프로그램");  // 컴포넌트
   JButton btn = new JButton("Login"); // 컴포넌트
   JButton close= new JButton("Exit"); // 컴포넌트
   JButton newjoin= new JButton("Join"); // 컴포넌트
   JLabel idLB = new JLabel("아이디"); // 컴포넌트
   JLabel passLB = new JLabel("비     번"); // 컴포넌트
   JTextField idInput = new JTextField(10); // 컴포넌트
   JTextField pwdnput = new JTextField(10); // 컴포넌트
   //JTextArea inputBody = new JTextArea(3, 10);
   JPanel centerP  = new JPanel();    // 컴포넌트. 컨테이너
   JPanel centerPN = new JPanel();   // 컴포넌트. 컨테이너
   JPanel centerPS = new JPanel();   // 컴포넌트. 컨테이너
   JPanel southP = new JPanel();   // 컴포넌트. 컨테이너
   
   Test2 t2 = new Test2();
   
   public Test1(){
      System.out.println("프로그램이 시작되었습니다.");
      this.setBounds(100, 300, 250, 150);  // 사이즈 설정..
      centerP.setBackground(Color.cyan);
      centerPN.setBackground(Color.GREEN);
      centerPS.setBackground(Color.LIGHT_GRAY);
      centerP.setLayout(new GridLayout(2, 1));  // layout 컴포넌트를 배치시킨다. 
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
      btn.addActionListener(this);  // btn 컴포넌트의 이벤트(클릭 등)를 처리하겠다. this가 참조하는 객체가 이를 처리해 주는 
                                     // 인터페이스를 구현 받았다.
      close.addActionListener(this);
      newjoin.addActionListener(this);
      // this에 컴포넌트를 배치시킨다.. 기본은 보더레이아웃
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
      System.out.println("이벤트 처리");
      Object temp = e.getSource();   // 다형성
      if(temp.equals(btn)) {
         System.out.println("버튼 클릭");
         String id = idInput.getText();
         titleLB.setText(id);
      }else if(temp.equals(close)) {
         System.out.println("프로그램종료");
         System.exit(0);
      }else if(temp.equals(newjoin)) {
         // Test2라는 객체가 조인버튼 누를때마다 객체가 생성된다면.. 이 객체 관리..
         t2.viewFrame();
      }
      
   }

}
