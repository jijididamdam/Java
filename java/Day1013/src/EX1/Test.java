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
   // 제목
   JPanel ti = new JPanel();
   JLabel title = new JLabel("단어관리 프로그램 Ver 1.0");
   JLabel title2 = new JLabel("개발자 김은수");
   // 필드 //검색 버튼
   JPanel main = new JPanel();
   JTextField search = new JTextField(10);
   JButton searchB = new JButton("검 색");
   // 단어추가 단어보기 단어삭제 검색버튼
   JPanel word = new JPanel();
   JButton add = new JButton("단어 추가");
   JButton look = new JButton("단어 보기");
   JButton delete = new JButton("단어 삭제");
   // center패널
   JPanel center = new JPanel();// 센터
   JPanel centerP = new JPanel();// 추가
   JPanel centerP1 = new JPanel();// 보기
   JPanel centerP2 = new JPanel();// 삭제
   //단어추가 center. label field button 구성시작
   JPanel center_add1= new JPanel();
   JPanel center_add2= new JPanel();
   JPanel center_add3= new JPanel();
   JPanel center_add4= new JPanel();
   JPanel center_add5= new JPanel();
   
   JLabel enLB = new JLabel("영문");
   JLabel koLB = new JLabel("한글");
   JLabel imporLB = new JLabel("중요도");
   JLabel infoLB = new JLabel("설명");
   
   JTextField enFL = new JTextField(10);
   JTextField koFL = new JTextField(10);
   JTextField imporFL = new JTextField(10);
   JTextField infoFL = new JTextField(10);
   
   JButton saveBtn = new JButton("저장하기");
   //=========================== 구성 끝
   //단어 보기 화면 구성
   List wordList = new List(10);
   JTextArea wordinfo = new JTextArea(10,3);
   //단어보기 화면 구성 선언 끝
   
   WordDAO wdao = new WordDAO();
   
   
   
   
   public Test() {
      this.setBounds(200, 300, 300, 400);
      ma.setBackground(Color.CYAN);
      ti.setBackground(Color.YELLOW);
      main.setBackground(Color.green);
      word.setBackground(Color.gray);
      // 샌터 판넬 색

      centerP.setBackground(Color.cyan);
      centerP1.setBackground(Color.green);
      centerP2.setBackground(Color.black);
      //단어추가관련
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
      //끝
      //단어보기 패널 디자인
      centerP1.setLayout(new BorderLayout());
      centerP1.add(wordList,"West");
      centerP1.add(wordinfo,"Center");
      // 끝
      
      
      
      //
      // 판넬
      ma.add(ti);
      ma.add(main);
      ma.add(word);
      ma.setLayout(new GridLayout(3, 1));
      // 기능
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
      //단어저장버튼
      saveBtn.addActionListener(this);
      //단어추가버튼
      add.addActionListener(this);
      //단어보기버튼
      look.addActionListener(this);
      //단어삭제버튼
      delete.addActionListener(this);
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object o = e.getSource();
      if (o.equals(delete)) { // 단어 삭제 화면전환 기능
         this.remove(centerP);
         this.remove(centerP1);
         this.add(centerP2, "Center");
         this.repaint(); // 램에다가 화면을 다시 그려라
         this.setVisible(true);
      } else if (o.equals(look)) {// 단어 보기 화면전환 기능
         this.remove(centerP);
         this.remove(centerP2);
         this.add(centerP1, "Center");
         ArrayList<WordDTO> wlist = wdao.selectAll();
         wordList.removeAll();// 리스트 지우기
         for(WordDTO w : wlist){
            wordList.add(w.getEng());// 리스트에 항목추가
         }
         
         this.repaint();
         this.setVisible(true);
      } else if (o.equals(add)) {// 단어 추가 화면전환 기능
         this.remove(centerP1);
         this.remove(centerP2);
         this.add(centerP, "Center");
         this.repaint();
         this.setVisible(true);
      }else if(o.equals(saveBtn)) {//단어 추가에서 저장버튼 기능
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
