package ex;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Test2 extends JFrame implements ActionListener {
   JLabel jlb = new JLabel("�ű԰���");

   // �Ķ����г�
   JPanel blueP = new JPanel();
   // �����г�
   JPanel blueP1 = new JPanel();
   JLabel id = new JLabel("���̵�");
   JTextField inputId = new JTextField(10);

   JPanel blueP2 = new JPanel();
   JLabel name = new JLabel("�̸�");
   JTextField inputName = new JTextField(10);

   JPanel blueP3 = new JPanel();
   JLabel pass = new JLabel("���");
   JTextField inputPass = new JTextField(10);

   JPanel blueP4 = new JPanel();
   JLabel tel = new JLabel("��ȭ��ȣ");
   JTextField inputTel = new JTextField(10);

   // ����г�
   JPanel yellowP = new JPanel();
   JButton save = new JButton("save");
   JButton clear = new JButton("clear");
   JButton exit = new JButton("exit");

   MemberDAO mdao = new MemberDAO();
   public Test2() {
      this.setBounds(100, 100, 250, 250);
      // �����г�1�� ������Ʈ �߰�
      blueP1.add(id);
      blueP1.add(inputId);
      // �����г�2�� ������Ʈ �߰�
      blueP2.add(name);
      blueP2.add(inputName);
      // �����г�3�� ������Ʈ �߰�
      blueP3.add(pass);
      blueP3.add(inputPass);
      // �����г�4�� ������Ʈ �߰�
      blueP4.add(tel);
      blueP4.add(inputTel);
      // �Ķ����гο� �����гκ�ġ
      blueP.setLayout(new GridLayout(4, 1));
      blueP.add(blueP1);
      blueP.add(blueP2);
      blueP.add(blueP3);
      blueP.add(blueP4);

      // ��� �гο��� ������Ʈ �߰�
      yellowP.add(save);
      yellowP.add(clear);
      yellowP.add(exit);

      save.addActionListener(this);
      clear.addActionListener(this);
      exit.addActionListener(this);
      
      this.add(jlb, "North");
      this.add(blueP, "Center");
      this.add(yellowP, "South");

      //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   
   public void viewFrame() {
      this.setVisible(true);
   }
   public void closeFrame() {
      this.setVisible(false);
   }
   
   public int checkTel(String tel) {
      
      //������
      return 0;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      Object nowO = e.getSource();
      if(nowO.equals(save)) {
         String id = inputId.getText();
         String name = inputName.getText();
         String pass = inputPass.getText();
         String tel = inputTel.getText();
         
         MemberDTO mdto = new MemberDTO();
         mdto.setId(id);
         mdto.setName(name);
         mdto.setPass(pass);
         mdto.setTel(tel);
         
         mdao.insertWord(mdto);
         jlb.setText(id+"/"+name+"/"+pass+"/"+tel);
      /*   if(checkTel(tel)==1) {
            jlb.setText(id+"/"+name+"/"+pass+"/"+tel);
            
         //   Dto dto =new Dto();
         //   dao.insert(dto);
         }else {
            JOptionPane.showMessageDialog(null, "��ȭ��ȣ ���� Ȯ�� �ϼ���");
         }*/
         
      }else if(nowO.equals(clear)) {
         inputId.setText("");
         inputName.setText("");
         inputPass.setText("");
         inputTel.setText("");
      }else if(nowO.equals(exit)) {
         closeFrame();
      }
      
   }

}
