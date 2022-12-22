package Main_d;

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

import Guard.guardDAO;
import Guard.guardDTO;
import Organ.organDAO;
import Organ.organDTO;
import Person.personDAO;
import Person.personDTO;

public class JFmain_Not extends JFrame implements ActionListener, ItemListener {
	personDAO pdao = new personDAO();
	guardDAO gdao = new guardDAO();
	organDAO odao = new organDAO();
	
	List persList = new List();
	List guardList = new List();
	List organList = new List();
	List schpersList = new List();
	List schguardList = new List();
	List schorganList = new List();
	JTextArea persinfo = new JTextArea();
	JTextArea schpersinfo = new JTextArea();
	JTextArea guardinfo = new JTextArea();
	JTextArea schguardinfo = new JTextArea();
	JTextArea organinfo = new JTextArea();
	JTextArea schorganinfo = new JTextArea();
	
	// 라벨
	JLabel titleLB = new JLabel("실종 아동 찾기 센터");
	JLabel wriLB = new JLabel("실종 아동 찾기 센터 전화 0182");
	
	JLabel pnameLB = new JLabel("실종 아동 성함 ");
	JLabel gnameLB = new JLabel("보호자 성함 ");
	JLabel onameLB = new JLabel("관할 기관명 ");
	
	// 텍스트
	JTextField textPname = new JTextField(10);
	JTextField textGname = new JTextField(10);
	JTextField textOname = new JTextField(10);
	
	//버튼
	JButton searchBtn = new JButton("검색하기");
	JButton gsearchBtn = new JButton("검색하기");
	JButton osearchBtn = new JButton("검색하기");
	
	JButton watBtn = new JButton("정보 보기");
	JButton schBtn = new JButton("정보 검색");
	JButton schPbtn = new JButton("실종 아동 정보 검색");
	JButton schGbtn = new JButton("보호자 정보 검색");
	JButton schObtn = new JButton("기관 정보 검색");
	JButton prtBtn = new JButton("정보 전체 보기");
	JButton prtPbtn = new JButton("실종 아동 정보 전체보기");
	JButton prtGbtn = new JButton("보호자 정보 전체보기");
	JButton prtObtn = new JButton("기관 정보 전체보기");
	
	//패널
	JPanel northP3 = new JPanel();
	JPanel northP4 = new JPanel();
	JPanel northP5 = new JPanel();

	
	JPanel northP = new JPanel();
	JPanel northPu = new JPanel();
	JPanel northPs = new JPanel();
	JPanel northPp = new JPanel();
	
	JPanel centerP = new JPanel();
	JPanel centerSp = new JPanel();
	JPanel centerSg = new JPanel();
	JPanel centerSo = new JPanel();
	JPanel centerTp = new JPanel();
	JPanel centerTg = new JPanel();
	JPanel centerTo = new JPanel();
	JPanel centerSpu = new JPanel();
	JPanel centerSpd = new JPanel();
	JPanel centerSgu = new JPanel();
	JPanel centerSgd = new JPanel();
	JPanel centerSou = new JPanel();
	JPanel centerSod = new JPanel();
	
	JFmain_Not() {
		this.setBounds(500, 500, 1000, 800);
		
		northP.setLayout(new GridLayout(2,1));
		
		northP.add(watBtn);
		northPu.add(schBtn);
		northPu.add(prtBtn);
		northPs.add(schPbtn);
		northPs.add(schGbtn);
		northPs.add(schObtn);
		northPp.add(prtPbtn);
		northPp.add(prtGbtn);
		northPp.add(prtObtn);
		
		this.add(northP,"North");
		this.add(wriLB, "South");
		
		centerSp.setLayout(new GridLayout(2,1));	
		centerSg.setLayout(new GridLayout(2,1));	
		centerSo.setLayout(new GridLayout(2,1));	
		
		searchBtn.addActionListener(this);
		gsearchBtn.addActionListener(this);
		osearchBtn.addActionListener(this);
		
		watBtn.addActionListener(this);
		schBtn.addActionListener(this);
		schPbtn.addActionListener(this);
		schGbtn.addActionListener(this);
		schObtn.addActionListener(this);

		prtBtn.addActionListener(this);
		prtPbtn.addActionListener(this);
		prtGbtn.addActionListener(this);
		prtObtn.addActionListener(this);
		
		persList.addItemListener(this);
		guardList.addItemListener(this);
		organList.addItemListener(this);
		schpersList.addItemListener(this);
		schguardList.addItemListener(this);
		schorganList.addItemListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		if(ob.equals(watBtn)) {
			this.remove(northP);
			northP3.setLayout(new GridLayout(2,1));
			northP3.add(northP);
			northP3.add(northPu);
			this.add(northP3,"North");
			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(schBtn)) {
			this.remove(northP);
			this.remove(northP3);
			this.remove(northP5);
			
			northP4.setLayout(new GridLayout(3,1));
			
			northP4.add(northP);
			northP4.add(northPu);
			northP4.add(northPs);
			this.add(northP4,"North");
			this.repaint();
			this.setVisible(true);
			
		} else if(ob.equals(prtBtn)) {
			this.remove(northP);
			this.remove(northP3);
			this.remove(northP4);
			
			northP5.setLayout(new GridLayout(3,1));
			northP5.add(northP);
			northP5.add(northPu);
			northP5.add(northPp);
			this.add(northP5,"North");
			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(prtPbtn)) {
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTg);
			this.remove(centerTo);
			
			centerTp.add(persList);
			centerTp.add(persinfo);
			
			this.add(centerTp,"Center");
			ArrayList<personDTO> pList = pdao.allP();
			persList.removeAll();
			
			for(personDTO p : pList) {
				String to = Integer.toString(p.getPid());
				persList.add(to);
			}
			this.repaint();
			this.setVisible(true);
			
			
		} else if(ob.equals(prtGbtn)) {
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTo);
			
			centerTg.add(guardList);
			centerTg.add(guardinfo);
			this.add(centerTg,"Center");
			
			ArrayList<guardDTO> gList = gdao.allG();
		
			guardList.removeAll();
			
			for(guardDTO g : gList) {
				
				String to = Integer.toString(g.getGid());
				guardList.add(to);
			}

			this.repaint();
			this.setVisible(true);
		}  else if(ob.equals(prtObtn)) {
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			
			centerTo.add(organList);
			centerTo.add(organinfo);
			this.add(centerTo,"Center");
			ArrayList<organDTO> oList = odao.allO();
			organList.removeAll();
			
			for(organDTO o : oList) {
				String to = Integer.toString(o.getOno());
				organList.add(to);
			}
			this.repaint();
			this.setVisible(true);
		}  else if(ob.equals(schPbtn)) {
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);
		
			textPname.setText("");
			
			centerSpu.add(pnameLB);
			centerSpu.add(textPname);
			centerSpu.add(searchBtn);
			centerSp.add(centerSpu);
			this.add(centerSp,"Center");
			
			this.repaint();
			this.setVisible(true);
			
		} else if(ob.equals(searchBtn)) {
			centerSpd.add(schpersList);
			centerSpd.add(schpersinfo);
			centerSp.add(centerSpd);
			this.add(centerSp,"Center");
			
			String sname = textPname.getText();
			
			ArrayList<personDTO> pList = pdao.schP(sname);
			schpersList.removeAll();
			
			for(personDTO p : pList) {
				schpersList.add(p.getPname());
			}
			this.repaint();
			this.setVisible(true);	
		} else if(ob.equals(schGbtn)) {		
			this.remove(centerSp);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);
			
			textGname.setText("");

			centerSgu.add(gnameLB);
			centerSgu.add(textGname);
			centerSgu.add(gsearchBtn);
			centerSg.add(centerSgu);
			this.add(centerSg,"Center");
			
			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(gsearchBtn)) {
			
			centerSgd.add(schguardList);
			centerSgd.add(schguardinfo);
			centerSg.add(centerSgd);
			this.add(centerSg,"Center");
			
			String sname = textGname.getText();
			
			ArrayList<guardDTO> gList = gdao.schG(sname);
			schguardList.removeAll();
			
			for(guardDTO g : gList) {
				schguardList.add(g.getGname());
			}
			this.repaint();
			this.setVisible(true);		
		} else if(ob.equals(schObtn)) {
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);
			textOname.setText("");
			centerSou.add(onameLB);
			centerSou.add(textOname);
			centerSou.add(osearchBtn);
			centerSo.add(centerSou);
			this.add(centerSo,"Center");
			
			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(osearchBtn)) {
			centerSod.add(schorganList);
			centerSod.add(schorganinfo);
			centerSo.add(centerSod);
			this.add(centerSo,"Center");
			
			String sname = textOname.getText();
			
			ArrayList<organDTO> oList = odao.schO(sname);
			schorganList.removeAll();
			
			for(organDTO o : oList) {
				schorganList.add(o.getOname());
			}
			this.repaint();
			this.setVisible(true);	
		}
	} 
	
	
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(persList)) { 
			
			String selectPid = persList.getSelectedItem();

			personDTO p = pdao.selectOneP(selectPid);
	
			persinfo.setText("");					
			persinfo.append("등록번호 : "+p.getPid()+"\n");
			persinfo.append("실종 아동 이름 : "+p.getPname()+"\n");
			persinfo.append("실종일자 : "+p.getPdt()+"\n");
			persinfo.append("실종지역 : "+p.getPaddr()+"\n");
			persinfo.append("신체특징 : "+p.getPpc()+"\n");
			persinfo.append("착의사항 : "+p.getPclo()+"\n");
			persinfo.append("발생경위 : "+p.getPrsn()+"\n");
			
			//jboxP.addItem(sList.get(i).getPid());
			
		} else if(e.getSource().equals(guardList)) {
			String sgid = guardList.getSelectedItem();
			
			guardDTO g = gdao.selectOneG(sgid);
			
			guardinfo.setText("");
			guardinfo.append("등록번호 : "+g.getGid()+"\n");
			guardinfo.append("보호자 성함 : "+g.getGname()+"\n");
			guardinfo.append("실종 아동 등록번호 : "+g.getPid()+"\n");
			guardinfo.append("실종 아동과의 관계 : "+g.getGrel()+"\n");
			guardinfo.append("보호자의 거주지 : "+g.getGaddr()+"\n");
			guardinfo.append("등록일자 : "+g.getGdt()+"\n");
			guardinfo.append("전화번호 : "+g.getGtel()+"\n");
			
			
		} else if(e.getSource().equals(organList)) {
			String sono = organList.getSelectedItem();
			
			organDTO o = odao.selectOneO(sono);
			
			organinfo.setText("");
			organinfo.append("등록 번호 : "+o.getOno()+"\n");
			organinfo.append("관할 기관명 : "+o.getOname()+"\n");
			organinfo.append("기관 전화번호 : "+o.getOtel()+"\n");
			organinfo.append("실종 아동 등록번호 : "+o.getPid()+"\n");
			organinfo.append("보호자 등록번호 : "+o.getGid()+"\n");
		
		} else if(e.getSource().equals(schpersList)) {
			String sname = schpersList.getSelectedItem();
			
			ArrayList<personDTO> pli = pdao.schP(sname);
			
			for(personDTO p : pli) {
			
			schpersinfo.setText("");					
			schpersinfo.append("등록번호 : "+p.getPid()+"\n");
			schpersinfo.append("실종 아동 이름 : "+p.getPname()+"\n");
			schpersinfo.append("실종일자 : "+p.getPdt()+"\n");
			schpersinfo.append("실종지역 : "+p.getPaddr()+"\n");
			schpersinfo.append("신체특징 : "+p.getPpc()+"\n");
			schpersinfo.append("착의사항 : "+p.getPclo()+"\n");
			schpersinfo.append("발생경위 : "+p.getPrsn()+"\n");
			
			}
			
		} else if(e.getSource().equals(schguardList)) {
			String sname = schguardList.getSelectedItem();
			
			ArrayList<guardDTO> gli = gdao.schG(sname);
			
			for(guardDTO g : gli) {
				
				schguardinfo.setText("");
				schguardinfo.append("등록번호 : "+g.getGid()+"\n");
				schguardinfo.append("보호자 성함 : "+g.getGname()+"\n");
				schguardinfo.append("실종 아동 등록번호 : "+g.getPid()+"\n");
				schguardinfo.append("실종 아동과의 관계 : "+g.getGrel()+"\n");
				schguardinfo.append("보호자의 거주지 : "+g.getGaddr()+"\n");
				schguardinfo.append("등록일자 : "+g.getGdt()+"\n");
				schguardinfo.append("전화번호 : "+g.getGtel()+"\n");
				
			}
		} else if(e.getSource().equals(schorganList)) {
			
			String sname = schorganList.getSelectedItem();
			
			ArrayList<organDTO> oli = odao.schO(sname);
			
			for(organDTO o : oli) {
				schorganinfo.setText("");
				schorganinfo.append("등록 번호 : "+o.getOno()+"\n");
				schorganinfo.append("관할 기관명 : "+o.getOname()+"\n");
				schorganinfo.append("기관 전화번호 : "+o.getOtel()+"\n");
				schorganinfo.append("실종 아동 등록번호 : "+o.getPid()+"\n");
				schorganinfo.append("보호자 등록번호 : "+o.getGid()+"\n");
			}
		}
		

	}
		
		
		
		



}
