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
	
	// ��
	JLabel titleLB = new JLabel("���� �Ƶ� ã�� ����");
	JLabel wriLB = new JLabel("���� �Ƶ� ã�� ���� ��ȭ 0182");
	
	JLabel pnameLB = new JLabel("���� �Ƶ� ���� ");
	JLabel gnameLB = new JLabel("��ȣ�� ���� ");
	JLabel onameLB = new JLabel("���� ����� ");
	
	// �ؽ�Ʈ
	JTextField textPname = new JTextField(10);
	JTextField textGname = new JTextField(10);
	JTextField textOname = new JTextField(10);
	
	//��ư
	JButton searchBtn = new JButton("�˻��ϱ�");
	JButton gsearchBtn = new JButton("�˻��ϱ�");
	JButton osearchBtn = new JButton("�˻��ϱ�");
	
	JButton watBtn = new JButton("���� ����");
	JButton schBtn = new JButton("���� �˻�");
	JButton schPbtn = new JButton("���� �Ƶ� ���� �˻�");
	JButton schGbtn = new JButton("��ȣ�� ���� �˻�");
	JButton schObtn = new JButton("��� ���� �˻�");
	JButton prtBtn = new JButton("���� ��ü ����");
	JButton prtPbtn = new JButton("���� �Ƶ� ���� ��ü����");
	JButton prtGbtn = new JButton("��ȣ�� ���� ��ü����");
	JButton prtObtn = new JButton("��� ���� ��ü����");
	
	//�г�
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
			persinfo.append("��Ϲ�ȣ : "+p.getPid()+"\n");
			persinfo.append("���� �Ƶ� �̸� : "+p.getPname()+"\n");
			persinfo.append("�������� : "+p.getPdt()+"\n");
			persinfo.append("�������� : "+p.getPaddr()+"\n");
			persinfo.append("��üƯ¡ : "+p.getPpc()+"\n");
			persinfo.append("���ǻ��� : "+p.getPclo()+"\n");
			persinfo.append("�߻����� : "+p.getPrsn()+"\n");
			
			//jboxP.addItem(sList.get(i).getPid());
			
		} else if(e.getSource().equals(guardList)) {
			String sgid = guardList.getSelectedItem();
			
			guardDTO g = gdao.selectOneG(sgid);
			
			guardinfo.setText("");
			guardinfo.append("��Ϲ�ȣ : "+g.getGid()+"\n");
			guardinfo.append("��ȣ�� ���� : "+g.getGname()+"\n");
			guardinfo.append("���� �Ƶ� ��Ϲ�ȣ : "+g.getPid()+"\n");
			guardinfo.append("���� �Ƶ����� ���� : "+g.getGrel()+"\n");
			guardinfo.append("��ȣ���� ������ : "+g.getGaddr()+"\n");
			guardinfo.append("������� : "+g.getGdt()+"\n");
			guardinfo.append("��ȭ��ȣ : "+g.getGtel()+"\n");
			
			
		} else if(e.getSource().equals(organList)) {
			String sono = organList.getSelectedItem();
			
			organDTO o = odao.selectOneO(sono);
			
			organinfo.setText("");
			organinfo.append("��� ��ȣ : "+o.getOno()+"\n");
			organinfo.append("���� ����� : "+o.getOname()+"\n");
			organinfo.append("��� ��ȭ��ȣ : "+o.getOtel()+"\n");
			organinfo.append("���� �Ƶ� ��Ϲ�ȣ : "+o.getPid()+"\n");
			organinfo.append("��ȣ�� ��Ϲ�ȣ : "+o.getGid()+"\n");
		
		} else if(e.getSource().equals(schpersList)) {
			String sname = schpersList.getSelectedItem();
			
			ArrayList<personDTO> pli = pdao.schP(sname);
			
			for(personDTO p : pli) {
			
			schpersinfo.setText("");					
			schpersinfo.append("��Ϲ�ȣ : "+p.getPid()+"\n");
			schpersinfo.append("���� �Ƶ� �̸� : "+p.getPname()+"\n");
			schpersinfo.append("�������� : "+p.getPdt()+"\n");
			schpersinfo.append("�������� : "+p.getPaddr()+"\n");
			schpersinfo.append("��üƯ¡ : "+p.getPpc()+"\n");
			schpersinfo.append("���ǻ��� : "+p.getPclo()+"\n");
			schpersinfo.append("�߻����� : "+p.getPrsn()+"\n");
			
			}
			
		} else if(e.getSource().equals(schguardList)) {
			String sname = schguardList.getSelectedItem();
			
			ArrayList<guardDTO> gli = gdao.schG(sname);
			
			for(guardDTO g : gli) {
				
				schguardinfo.setText("");
				schguardinfo.append("��Ϲ�ȣ : "+g.getGid()+"\n");
				schguardinfo.append("��ȣ�� ���� : "+g.getGname()+"\n");
				schguardinfo.append("���� �Ƶ� ��Ϲ�ȣ : "+g.getPid()+"\n");
				schguardinfo.append("���� �Ƶ����� ���� : "+g.getGrel()+"\n");
				schguardinfo.append("��ȣ���� ������ : "+g.getGaddr()+"\n");
				schguardinfo.append("������� : "+g.getGdt()+"\n");
				schguardinfo.append("��ȭ��ȣ : "+g.getGtel()+"\n");
				
			}
		} else if(e.getSource().equals(schorganList)) {
			
			String sname = schorganList.getSelectedItem();
			
			ArrayList<organDTO> oli = odao.schO(sname);
			
			for(organDTO o : oli) {
				schorganinfo.setText("");
				schorganinfo.append("��� ��ȣ : "+o.getOno()+"\n");
				schorganinfo.append("���� ����� : "+o.getOname()+"\n");
				schorganinfo.append("��� ��ȭ��ȣ : "+o.getOtel()+"\n");
				schorganinfo.append("���� �Ƶ� ��Ϲ�ȣ : "+o.getPid()+"\n");
				schorganinfo.append("��ȣ�� ��Ϲ�ȣ : "+o.getGid()+"\n");
			}
		}
		

	}
		
		
		
		



}
