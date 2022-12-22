package EX1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class test1 extends JFrame implements ActionListener,ItemListener {
	// 상속은 하나만 받을 수 있지만 인터페이스는 여러개 가능하다

	//라벨
	JLabel titlelb = new JLabel("단어관리 프로그램 Ver 1.0");
	JLabel wrilb = new JLabel("개발자 홍길동");


	//버튼
	JButton schbtn = new JButton("search");
	JButton addbtn = new JButton("단어추가");
	JButton delbtn = new JButton("단어삭제");
	JButton prtbtn = new JButton("단어보기");

	//텍스트
	JTextField textput = new JTextField(10);

	//패널 먼저 만들고 시작
	JPanel northP = new JPanel();
	JPanel northUp = new JPanel();
	JPanel northDn = new JPanel();
	JPanel northCt = new JPanel();
	JPanel center = new JPanel();
	JPanel empty = new JPanel();

	//추가 삭제 보기 패널 추가
	JPanel centerP=new JPanel();  // 단어추가

	JPanel center_sub1 = new JPanel();
	JPanel center_sub2 = new JPanel();
	JPanel center_sub3 = new JPanel();
	JPanel center_sub4 = new JPanel();
	JPanel center_sub5 = new JPanel();

	JLabel engLB = new JLabel("영문");
	JLabel korLB = new JLabel("한글");
	JLabel imporLB = new JLabel("중요도");
	JLabel infoLB = new JLabel("설명");

	JTextField engW = new JTextField(10);
	JTextField korW = new JTextField(10);
	JTextField imporW = new JTextField(10);
	JTextField infoW = new JTextField(10);

	JButton saveBtn = new JButton("저장");


	// 단어보기 화면구성 선언 시작
	List wordList = new List();
	JTextArea wordinfo = new JTextArea();
	// 단어보기 화면 구성 선언 끝


	JPanel centerP1=new JPanel(); // 단어삭제
	JPanel centerP2=new JPanel(); // 단어보기

	WordDAO wdao = new WordDAO();


	test1() {
		// 사이즈 설정
		this.setBounds(100,300,300,400);

		northUp.add(titlelb);   // 플로레이아웃은 가운데에 패널이 들어감
		northP.add(northUp);

		center.setBackground(Color.LIGHT_GRAY);

		//단어 추가 패널 디자인
		centerP.setLayout(new GridLayout(5,1));
		center_sub1.add(engLB);
		center_sub1.add(engW);
		center_sub2.add(korLB);
		center_sub2.add(korW);
		center_sub3.add(imporLB);
		center_sub3.add(imporW);
		center_sub4.add(infoLB);
		center_sub4.add(infoW);
		center_sub5.add(saveBtn);

		centerP.add(center_sub1);
		centerP.add(center_sub2);
		centerP.add(center_sub3);
		centerP.add(center_sub4);
		centerP.add(center_sub5);


		//단어 보기 패널 디자인
		centerP2.setLayout(new BorderLayout());
		centerP2.add(wordList,"West");
		centerP2.add(wordinfo,"Center");



		centerP.setBackground(Color.YELLOW);
		centerP1.setBackground(Color.BLACK);
		centerP2.setBackground(Color.GREEN);
		northP.setLayout(new GridLayout(3,1));
		northCt.setLayout(new GridLayout(1,3));
		northDn.setLayout(new GridLayout(1,3));

		northCt.add(empty);		
		northCt.add(textput);
		northCt.add(schbtn);

		northP.add(northCt);

		northDn.add(addbtn);
		northDn.add(delbtn);
		northDn.add(prtbtn);

		northP.add(northDn);




		this.add(northP,"North");
		this.add(center,"Center");
		this.add(wrilb,"South");

		schbtn.addActionListener(this);
		addbtn.addActionListener(this);
		delbtn.addActionListener(this);
		prtbtn.addActionListener(this);
		saveBtn.addActionListener(this);
		
		wordList.addItemListener(this);

		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object temp = e.getSource();
		if(temp.equals(addbtn)) {
			this.remove(centerP2);
			this.remove(centerP1);
			this.remove(center);
			this.add(centerP,"Center");
			this.repaint();          // 컴에다가 화면을 다시 그려라
			this.setVisible(true);
		} else if(temp.equals(delbtn)) {
			this.remove(centerP);
			this.remove(center);
			this.remove(centerP2);

			this.add(centerP1,"Center");
			this.repaint();         // 컴에다가 화면을 다시 그려라
			this.setVisible(true);

		} else if(temp.equals(prtbtn)) {
			wordList.removeAll();

			this.remove(centerP1);
			this.remove(centerP);
			this.remove(center);
			this.add(centerP2,"Center");


			ArrayList<WordDTO> wlist = wdao.selectAll();
			wordList.removeAll();

			for(WordDTO w : wlist) {
				wordList.add(w.getEng()); // 리스트에 항목추가				
			}

			this.repaint();  // 컴에다가 화면을 다시 그려라
			this.setVisible(true);
		} else if(temp.equals(schbtn)) {
			this.remove(centerP1);
			this.remove(centerP);
			this.remove(centerP2);
			this.add(center,"Center");
			
			ArrayList<WordDTO> wlist = wdao.selectAll();
			wordList.removeAll();

			for(WordDTO w : wlist) {
				wordList.add(w.getEng()); // 리스트에 항목추가				
			}
			
			
			
			this.repaint();         // 컴에다가 화면을 다시 그려라
			this.setVisible(true);
		} else if(temp.equals(saveBtn)) {
			String eng = engW.getText();
			String kor = korW.getText();
			String impor = imporW.getText();
			String info = infoW.getText();
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(wordList)) {
			String selectWord=wordList.getSelectedItem();
			System.out.println(wordList.getSelectedItem());
			
			WordDTO w = wdao.selectOne(selectWord);
			
			
			wordinfo.setText("");
			wordinfo.append("영문 : "+w.getEng()+"\n");
			wordinfo.append("한글 : "+w.getKor()+"\n");
			wordinfo.append("중요 : "+w.getImpor()+"\n");
			wordinfo.append("설명 : "+w.getInfo()+"\n");
		}
	}



}
