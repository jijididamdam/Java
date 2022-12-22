package EX1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import dao.WordDAO;
//import dto.WordDTO;




public class Test extends JFrame implements ActionListener,ListSelectionListener {
   JPanel ma = new JPanel();
   // ����
   JPanel ti = new JPanel();
   JLabel title = new JLabel("�ܾ���� ���α׷� Ver 1.0");
   JLabel title2 = new JLabel("������ ������");
   // �ʵ� //�˻� ��ư
   JPanel main = new JPanel();
   JTextField search = new JTextField(10);
   JButton searchB = new JButton("�� ��");
   // �ܾ��߰� �ܾ�� �ܾ���� �˻���ư
   JPanel word = new JPanel();
   JButton add = new JButton("�ܾ� �߰�");
   JButton look = new JButton("�ܾ� ����");
   JButton delete = new JButton("�ܾ� ����");
   // center�г�
   JPanel center = new JPanel();// ����
   JPanel centerP = new JPanel();// �߰�
   JPanel centerP1 = new JPanel();// ����
   JPanel centerP2 = new JPanel();// ����
   //�ܾ��߰� center. label field button ��������
   JPanel center_add1= new JPanel();
   JPanel center_add2= new JPanel();
   JPanel center_add3= new JPanel();
   JPanel center_add4= new JPanel();
   JPanel center_add5= new JPanel();
   
   JLabel enLB = new JLabel("����");
   JLabel koLB = new JLabel("�ѱ�");
   JLabel imporLB = new JLabel("�߿䵵");
   JLabel infoLB = new JLabel("����");
   
   JTextField enFL = new JTextField(10);
   JTextField koFL = new JTextField(10);
   JTextField imporFL = new JTextField(10);
   JTextField infoFL = new JTextField(10);
   
   JButton saveBtn = new JButton("�����ϱ�");
   //=========================== ���� ��
   //�ܾ� ���� ȭ�� ����
   List wordList = new List(10);
   JTextArea wordinfo = new JTextArea(10,3);
   //�ܾ�� ȭ�� ���� ���� ��
   
   WordDAO wdao = new WordDAO();
   
   
   
   
   public Test() {
      this.setBounds(200, 300, 300, 400);
      ma.setBackground(Color.CYAN);
      ti.setBackground(Color.YELLOW);
      main.setBackground(Color.green);
      word.setBackground(Color.gray);
      // ���� �ǳ� ��

      centerP.setBackground(Color.cyan);
      centerP1.setBackground(Color.green);
      centerP2.setBackground(Color.black);
      //�ܾ��߰�����
      centerP.setLayout(new GridLayout(5,1));
      center_add1.add(enLB);
      center_add1.add(enFL);
      center_add2.add(koLB);
      center_add2.add(koFL);
      center_add3.add(imporLB);
      center_add3.add(imporFL);
      center_add4.add(infoLB);
      center_add4.add(infoFL);
      center_add5.add(saveBtn);
      centerP.add(center_add1);
      centerP.add(center_add2);
      centerP.add(center_add3);
      centerP.add(center_add4);
      centerP.add(center_add5);
      //��
      //�ܾ�� �г� ������
      centerP1.setLayout(new BorderLayout());
      centerP1.add(wordList,"West");
      centerP1.add(wordinfo,"Center");
      // ��
      
      
      
      //
      // �ǳ�
      ma.add(ti);
      ma.add(main);
      ma.add(word);
      ma.setLayout(new GridLayout(3, 1));
      // ���
      ti.add(title);
      main.add(search);
      main.add(searchB);

      word.add(add);
      word.add(look);
      word.add(delete);
      
      //wordList.addItemListener(this);//

      this.add(ma, "North");
      this.add(centerP, "Center");
      this.add(title2, "South");
      //�ܾ������ư
      saveBtn.addActionListener(this);
      //�ܾ��߰���ư
      add.addActionListener(this);
      //�ܾ���ư
      look.addActionListener(this);
      //�ܾ������ư
      delete.addActionListener(this);
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object o = e.getSource();
      if (o.equals(delete)) { // �ܾ� ���� ȭ����ȯ ���
         this.remove(centerP);
         this.remove(centerP1);
         this.add(centerP2, "Center");
         this.repaint(); // �����ٰ� ȭ���� �ٽ� �׷���
         this.setVisible(true);
      } else if (o.equals(look)) {// �ܾ� ���� ȭ����ȯ ���
         this.remove(centerP);
         this.remove(centerP2);
         this.add(centerP1, "Center");
         ArrayList<WordDTO> wlist = wdao.selectAll();
         wordList.removeAll();// ����Ʈ �����
         for(WordDTO w : wlist){
            wordList.add(w.getEng());// ����Ʈ�� �׸��߰�
         }
         
         this.repaint();
         this.setVisible(true);
      } else if (o.equals(add)) {// �ܾ� �߰� ȭ����ȯ ���
         this.remove(centerP1);
         this.remove(centerP2);
         this.add(centerP, "Center");
         this.repaint();
         this.setVisible(true);
      }else if(o.equals(saveBtn)) {//�ܾ� �߰����� �����ư ���
         String eng=enFL.getText();
         String kor=koFL.getText();
         String impor=imporFL.getText();
         String info=infoFL.getText();
         System.out.println(eng+"/"+kor+"/"+impor+"/"+info);
         
         WordDTO newWord = new WordDTO();
         newWord.setEng(eng);
         newWord.setKor(kor);
         newWord.setImpor(impor);
         newWord.setInfo(info);
         
         wdao.insert(newWord);
      }

   }

   @Override
   public void valueChanged(ListSelectionEvent e) {
      
      
   }

}
