package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.WordDAO;
import dto.WordDTO;

public class Word_manager extends JFrame implements ActionListener,ItemListener{
	Scanner in = new Scanner(System.in);
	WordDAO wordDAO = new WordDAO();
	ArrayList<WordDTO> list = null;
	JLabel title_high = new JLabel("단어관리 프로그램 Ver 1.0");
	JLabel title_low = new JLabel("개발자 홍길동");
	
	JButton word_search_btn = new JButton("search"); 
	JButton word_add_btn = new JButton("단어추가"); 
	JButton word_delete_btn = new JButton("단어삭제"); 
	JButton word_list_btn = new JButton("단어보기"); 
	
	JTextField word_search_textfield = new JTextField(10);
	
	JPanel add_view = new JPanel();
	JPanel add_view_1 = new JPanel();
	JPanel add_view_2 = new JPanel();
	JPanel add_view_3 = new JPanel();
	JPanel add_view_4 = new JPanel();
	JPanel add_view_5 = new JPanel();
	
	JLabel add_label_1 = new JLabel("영문");
	JTextField add_textfield_1 = new JTextField(10);
	JLabel add_label_2 = new JLabel("한글");
	JTextField add_textfield_2 = new JTextField(10);
	JLabel add_label_3 = new JLabel("중요도");
	JTextField add_textfield_3 = new JTextField(10);
	JLabel add_label_4 = new JLabel("설명");
	JTextField add_textfield_4 = new JTextField(10);
	JButton add_btn = new JButton("저장하기");
	
	JPanel delete_view = new JPanel();
	JPanel search_view = new JPanel();
	
	JPanel list_view = new JPanel();
	List list_view_1 = new List();
	JTextArea list_view_2 = new JTextArea();
	
	JPanel high = new JPanel();
	
	JPanel main = new JPanel();
	JPanel main_1 = new JPanel();
	JPanel main_2 = new JPanel();
	
	public Word_manager() {
		this.setBounds(200,250, 300, 350);
		main.setBackground(Color.cyan);
		main_1.setBackground(Color.LIGHT_GRAY);
		main_2.setBackground(Color.darkGray);
		
		search_view.setBackground(Color.ORANGE);
		add_view.setBackground(Color.BLACK);
		delete_view.setBackground(Color.pink);
		list_view.setBackground(Color.red);
		
		main.add(title_high);
		
		main_1.add(word_search_textfield);
		main_1.add(word_search_btn);
		
		main_2.add(word_add_btn);
		main_2.add(word_delete_btn);
		main_2.add(word_list_btn);
		
		high.setLayout(new GridLayout(3,1));
		high.add(main);
		high.add(main_1);
		high.add(main_2);
		
		add_view.setLayout(new GridLayout(5,1));
		add_view_1.add(add_label_1);
		add_view_1.add(add_textfield_1);
		add_view_2.add(add_label_2);
		add_view_2.add(add_textfield_2);
		add_view_3.add(add_label_3);
		add_view_3.add(add_textfield_3);
		add_view_4.add(add_label_4);
		add_view_4.add(add_textfield_4);
		add_view_5.add(add_btn);
		add_view.add(add_view_1);
		add_view.add(add_view_2);
		add_view.add(add_view_3);
		add_view.add(add_view_4);
		add_view.add(add_view_5);
		
		list_view.setLayout(new BorderLayout());
		list_view.add(list_view_1,"West");
		list_view.add(list_view_2,"Center");
		
		
		word_search_btn.addActionListener(this);
		word_add_btn.addActionListener(this);
		word_delete_btn.addActionListener(this);
		word_list_btn.addActionListener(this);
		add_btn.addActionListener(this);
		
		list_view_1.addItemListener(this);
		
		this.add(high,"North");
		this.add(search_view,"Center");
		this.add(title_low,"South");
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if(object.equals(word_search_btn)) {
			this.remove(add_view);
			this.remove(delete_view);
			this.remove(list_view);
			this.add(search_view,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(word_add_btn)) {
			this.remove(search_view);
			this.remove(delete_view);
			this.remove(list_view);
			this.add(add_view,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(word_delete_btn)) {
			this.remove(add_view);
			this.remove(search_view);
			this.remove(list_view);
			this.add(delete_view,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(word_list_btn)) {
			list_view_1.removeAll();
			list = wordDAO.allselect();
			for(WordDTO i : list) {
				list_view_1.add(i.getEng());
			}
			this.remove(add_view);
			this.remove(delete_view);
			this.remove(search_view);
			this.add(list_view,"Center");
			this.repaint();
			this.setVisible(true);
		}else if(object.equals(add_btn)) {
			WordDTO wordDTO = new WordDTO();
			String eng = add_textfield_1.getText();
			String kor = add_textfield_2.getText();
			String impor = add_textfield_3.getText();
			String info = add_textfield_4.getText();
			System.out.println(eng+"/"+kor+"/"+impor+"/"+info);
			add_textfield_1.setText("");
			add_textfield_2.setText("");
			add_textfield_3.setText("");
			add_textfield_4.setText("");
			wordDTO.setEng(eng);
			wordDTO.setKor(kor);
			wordDTO.setImpor(impor);
			wordDTO.setInfo(info);
			insert(wordDTO);
		}
	}
	public void insert(WordDTO wordDTO) {
		wordDAO.insert_Word(wordDTO);
	}
	public void search() {
		System.out.println("단어입력");
		String input = in.nextLine();
		list = wordDAO.search(input);
		for(WordDTO wordDTO : list) {
			wordDTO.prt();
		}
	}
	public void del() {
		System.out.println("삭제할 단어 입력");
		String w = in.nextLine();
		wordDAO.delete_word(w);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(list_view_1)) {
			String selectWord = list_view_1.getSelectedItem();
			System.out.println(selectWord);
			WordDTO w = wordDAO.selectOne(selectWord);
			list_view_2.setText("");
			list_view_2.append("영문 : "+w.getEng()+"\n");
			list_view_2.append("한글 : "+w.getKor()+"\n");
			list_view_2.append("중요도 : "+w.getImpor()+"\n");
			list_view_2.append("설명 : "+w.getInfo()+"\n");
		}
	}
	
}
