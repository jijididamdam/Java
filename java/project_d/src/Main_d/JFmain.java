package Main_d;

import java.awt.Color;
//import java.awt.Container;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Guard.guardDAO;
import Guard.guardDTO;
import Organ.organDAO;
import Organ.organDTO;
import Person.personDAO;
import Person.personDTO;

public class JFmain extends JFrame implements ActionListener, ItemListener {

	personDAO pdao = new personDAO();
	guardDAO gdao = new guardDAO();
	organDAO odao = new organDAO();
	
	//Image photo = new ImageIcon(JFmain.class.getResource("C:\\Users\\human\\Pictures\\���� ����")).getImage();
	
	JScrollPane sp;

	String[] phone = { "02", "051", "053", "032", "062", "042", "052", "044", "031", "033", "043", "041", "063", "061",
			"054", "055", "064" };
	
	JComboBox<String> jbox = new JComboBox<String>(phone);
	JFileChooser fileChooser = new JFileChooser("C:\\Users\\human\\Pictures\\���� ����");
	
	// ����Ʈ ����
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
	JComboBox<Object> jboxP = new JComboBox<Object>();

	// ��
	JLabel titleLB = new JLabel("���� �Ƶ� ã�� ����");
	JLabel wriLB = new JLabel("���� �Ƶ� ã�� ���� ��ȭ 0182");

	// ��� ���� ����
	JLabel pidLB = new JLabel("���� �Ƶ� ��Ϲ�ȣ ");
	JLabel spidLB = new JLabel("���� �Ƶ� ��Ϲ�ȣ ");
	JLabel pnameLB = new JLabel("���� �Ƶ� ���� ");
	JLabel pdtLB = new JLabel("�� ��  �� �� ");
	JLabel paddrLB = new JLabel("�� ��  �� �� ");
	JLabel ppcLB = new JLabel("�� ü  Ư ¡ ");
	JLabel pcloLB = new JLabel("�� ��  �� �� ");
	JLabel prsnLB = new JLabel("�� ��  �� �� ");
	JLabel centerTpim = new JLabel("");

	// ��ȣ�� ���� ����
	JLabel gidLB = new JLabel("��ȣ�� ��Ϲ�ȣ ");
	JLabel sgidLB = new JLabel("��ȣ�� ��Ϲ�ȣ ");
	JLabel gnameLB = new JLabel("��ȣ�� ���� ");
	// +pidLB �����پ���
	JLabel grelLB = new JLabel("���� �Ƶ����� ���� ");
	JLabel gaddrLB = new JLabel("��ȣ���� ������ ");
	JLabel gdtLB = new JLabel("�� �� �� �� ");
	JLabel gtelLB = new JLabel("�� ȭ �� ȣ");

	// ��Ȱ��� ���� ����
	JLabel onoLB = new JLabel("���� ��� ��� ��ȣ");
	JLabel sonoLB = new JLabel("���� ��� ��� ��ȣ");
	JLabel onameLB = new JLabel("���� ����� ");
	JLabel otelLB = new JLabel("�� ȭ �� ȣ ");
	// +pid,gid �����پ���

	// ��¥ �Է�
	JLabel ydtLB = new JLabel("��");
	JLabel mdtLB = new JLabel("��");
	JLabel ddtLB = new JLabel("��");
	JLabel hdtLB = new JLabel("��");

	// ��ȭ��ȣ �Է�
	JLabel dLB = new JLabel("-");
	JLabel aLB = new JLabel("-");
	JLabel sLB = new JLabel("-");
	JLabel iLB = new JLabel("-");
	
	// ���� ����
	JLabel jlb = new JLabel(" ");

	// �ؽ�Ʈ
	// ��� ���� ����
	JTextField textPid = new JTextField(10);
	JTextField textsPid = new JTextField(10);
	JTextField textPname = new JTextField(10);
	JTextField textPdtY = new JTextField(5);
	JTextField textPdtM = new JTextField(5);
	JTextField textPdtD = new JTextField(5);
	JTextField textPdtH = new JTextField(5);
	JTextField textPaddr = new JTextField(10);
	JTextField textPpc = new JTextField(10);
	JTextField textPclo = new JTextField(10);
	JTextField textPrsn = new JTextField(10);

	// ��ȣ�� ���� ����
	JTextField textGid = new JTextField(10);
	JTextField textsGid = new JTextField(10);
	JTextField textGname = new JTextField(10);
	JTextField textGrel = new JTextField(10);
	// JTextField textGpid = new JTextField(20);
	// JTextField textGpname = new JTextField(20);
	JTextField textGaddr = new JTextField(10);
	JTextField textGdt = new JTextField(10);

	// ���� ��� ���� ����
	JTextField textOno = new JTextField(10);
	JTextField textsOno = new JTextField(10);
	JTextField textOname = new JTextField(10);
	JTextField textOtel = new JTextField(10);

	// ��ȭ��ȣ ����
	JTextField textBtel = new JTextField(4);
	JTextField textAtel = new JTextField(4);
	JTextField textFcal = new JTextField("010");
	JTextField textBcal = new JTextField(4);
	JTextField textAcal = new JTextField(4);

	// ��ư
	// �˻��ϱ� �˻� ��ư
	JButton searchBtn = new JButton("�˻��ϱ�");
	JButton gsearchBtn = new JButton("�˻��ϱ�");
	JButton osearchBtn = new JButton("�˻��ϱ�");
	// ���� �˻� ��ư
	JButton mpBtn = new JButton("�˻��ϱ�");
	JButton mgBtn = new JButton("�˻��ϱ�");
	JButton moBtn = new JButton("�˻��ϱ�");
	
	// ��������
	JButton putBtn = new JButton("���� ����");
	JButton addBtn = new JButton("�ű� ���� ����");
	JButton addPbtn = new JButton("���� �Ƶ� ���� ����");
	JButton addGbtn = new JButton("��ȣ�� ���� ����");
	JButton addObtn = new JButton("��� ���� ����");
	JButton addSaveP = new JButton("�����ϱ�");
	JButton addSaveG = new JButton("�����ϱ�");
	JButton addSaveO = new JButton("�����ϱ�");
	JButton photoput = new JButton("���� �߰�");	
	//JButton photoshow = new JButton("����");
	//JButton photoadd = new JButton("����");

	// ��������
	JButton delBtn = new JButton("���� ����");
	JButton delPbtn = new JButton("���� �Ƶ� ���� ����");
	JButton delGbtn = new JButton("��ȣ�� ���� ����");
	JButton delObtn = new JButton("��� ���� ����");
	JButton delEndP = new JButton("�����ϱ�");
	JButton delEndG = new JButton("�����ϱ�");
	JButton delEndO = new JButton("�����ϱ�");

	// �������� - ��ü���� , �κа˻�
	JButton watBtn = new JButton("���� ����");
	JButton schBtn = new JButton("���� �˻�");
	JButton schPbtn = new JButton("���� �Ƶ� ���� �˻�");
	JButton schGbtn = new JButton("��ȣ�� ���� �˻�");
	JButton schObtn = new JButton("��� ���� �˻�");
	JButton prtBtn = new JButton("���� ��ü ����");
	JButton prtPbtn = new JButton("���� �Ƶ� ���� ��ü����");
	JButton prtGbtn = new JButton("��ȣ�� ���� ��ü����");
	JButton prtObtn = new JButton("��� ���� ��ü����");

	// ���� ����
	JButton modBtn = new JButton("���� ���� ����");
	JButton modPbtn = new JButton("���� �Ƶ� ���� ����");
	JButton modGbtn = new JButton("��ȣ�� ���� ����");
	JButton modObtn = new JButton("��� ���� ����");
	JButton modEndP = new JButton("�����ϱ�");
	JButton modEndG = new JButton("�����ϱ�");
	JButton modEndO = new JButton("�����ϱ�");
	
	// �г�
	// �� �г�
	JPanel northP = new JPanel();
	JPanel northP0 = new JPanel();
	JPanel northP1 = new JPanel();
	JPanel northP2 = new JPanel();
	JPanel northP3 = new JPanel();
	JPanel northP4 = new JPanel();
	JPanel northP5 = new JPanel();
	JPanel northP6 = new JPanel();
	

	JPanel northPtitle = new JPanel();
	JPanel northPmbtn = new JPanel();
	
	JPanel northPsbtn0 = new JPanel();
	JPanel northPsbtn1 = new JPanel();
	JPanel northPsbtn2 = new JPanel();
	JPanel northPsbtn3 = new JPanel();
	JPanel northPsbtn4 = new JPanel();
	JPanel northPsbtn5 = new JPanel();
	JPanel northPsbtn6 = new JPanel();
	

	// �߾� �г�
	// ���� �г�
	JPanel centerP = new JPanel();
	JPanel centerPg = new JPanel();
	JPanel centerPo = new JPanel();
	JPanel centerPm = new JPanel();
	JPanel centerEm = new JPanel();

	// ���� �г�
	JPanel centerDp = new JPanel();
	JPanel centerDpu = new JPanel();
	JPanel centerDpd = new JPanel();
	JPanel centerDg = new JPanel();
	JPanel centerDgu = new JPanel();
	JPanel centerDgd = new JPanel();	
	JPanel centerDo = new JPanel();
	JPanel centerDou = new JPanel();
	JPanel centerDod = new JPanel();


	// ���� �г�
	JPanel centerMp = new JPanel();	
	JPanel centerMpo = new JPanel();
	JPanel centerMpu = new JPanel();
	JPanel centerMpe = new JPanel();
	JPanel centerMg = new JPanel();
	JPanel centerMgo = new JPanel();
	JPanel centerMgu = new JPanel();
	JPanel centerMge = new JPanel();
	JPanel centerMo = new JPanel();
	JPanel centerMoo = new JPanel();
	JPanel centerMou = new JPanel();
	JPanel centerMoe = new JPanel();
	
	
	// �˻� �г�
	JPanel centerSp = new JPanel();
	JPanel centerSpu = new JPanel();
	JPanel centerSpd = new JPanel();
	JPanel centerSg = new JPanel();
	JPanel centerSgu = new JPanel();
	JPanel centerSgd = new JPanel();	
	JPanel centerSo = new JPanel();
	JPanel centerSou = new JPanel();
	JPanel centerSod = new JPanel();
	
	// ��ü ���� �г�
	JPanel centerTp = new JPanel();
	//JPanel centerTpim = new JPanel();
	JPanel centerTg = new JPanel();
	JPanel centerTo = new JPanel();
	
	
	// ��ȭ ��ȣ �г�
	JPanel centerPtel = new JPanel();
	JPanel centerPcal = new JPanel();
	

	
	ImageIcon photo = new ImageIcon();
	//Image photo = new Image(new ImageIcon().getImage());

	public void JFmain() {
		// ó�� ������ ����
		this.setBounds(100, 100, 1000, 800);

		// northP.setBackground(Color.yellow);
		centerP.setBackground(Color.LIGHT_GRAY);
		northP.setLayout(new GridLayout(3, 1));
		northP0.setLayout(new GridLayout(3, 1));
		northP1.setLayout(new GridLayout(3, 1));
		northP2.setLayout(new GridLayout(3, 1));
		northP3.setLayout(new GridLayout(3, 1));
		northP4.setLayout(new GridLayout(3, 1));
		northP5.setLayout(new GridLayout(3, 1));
		northP6.setLayout(new GridLayout(3, 1));

		northPtitle.add(titleLB);
		northP.add(northPtitle);

		northPmbtn.add(putBtn);
		northPmbtn.add(delBtn);
		northPmbtn.add(watBtn);
		northP.add(northPmbtn);
		
		// ���� ���� ��ư ���� ��
		northPsbtn0.add(addBtn);
		northPsbtn0.add(modBtn);
		
		centerTp.setLayout(new GridLayout(2,2));
		
		centerTp.add(persList);
		centerTp.add(persinfo);
		centerTpim.setIcon(photo);
		centerTp.add(centerTpim);
		

		// ���� �߰� ��ư ���� �� add
		northPsbtn1.add(addPbtn);
		northPsbtn1.add(addGbtn);
		northPsbtn1.add(addObtn);

		// ���� ���� ��ư ���� �� add
		northPsbtn2.add(delPbtn);
		northPsbtn2.add(delGbtn);
		northPsbtn2.add(delObtn);

		// ���� ���� ��ư ���� �� add
		northPsbtn3.add(prtBtn);
		northPsbtn3.add(schBtn);

		northPsbtn4.add(prtPbtn);
		northPsbtn4.add(prtGbtn);
		northPsbtn4.add(prtObtn);

		northPsbtn5.add(schPbtn);
		northPsbtn5.add(schGbtn);
		northPsbtn5.add(schObtn);
		
		// ���� ���� ��ư ���� �� add
		northPsbtn6.add(modPbtn);
		northPsbtn6.add(modGbtn);
		northPsbtn6.add(modObtn);

		// ��ȭ��ȣ �г� ����
		// centerPtel.setLayout(new GridLayout(1,2));

		centerPtel.add(jbox);
		centerPtel.add(dLB);
		centerPtel.add(textBtel);
		centerPtel.add(aLB);
		centerPtel.add(textAtel);

		centerPcal.add(textFcal);
		centerPcal.add(sLB);
		centerPcal.add(textBcal);
		centerPcal.add(iLB);
		centerPcal.add(textAcal);
		
		// ���� ����
		//getContentPane().setLayout(new FlowLayout());
		//add(photoadd);
		//add(photoshow);
		///add(jlb);
		
		//fileChooser.setFileFilter(new FileNameExtensionFilter("txt","txt"));
		fileChooser.setMultiSelectionEnabled(false); // ���� ���� �Ұ�
		//photoadd.addActionListener(this);
		//photoshow.addActionListener(this);
		
		
		
		// �˻��ϱ�
		centerSp.setLayout(new GridLayout(2,1));	
		centerSg.setLayout(new GridLayout(2,1));	
		centerSo.setLayout(new GridLayout(2,1));	
		
		//�����ϱ�
		centerMp.setLayout(new GridLayout(9,2));
		centerTpim.setHorizontalAlignment(JLabel.CENTER);
		this.getContentPane().add(centerTpim);
		
		this.add(northP, "North");
		this.add(centerP, "Center");
		this.add(wriLB, "South");
		
		putBtn.addActionListener(this);

		addBtn.addActionListener(this);
		addPbtn.addActionListener(this);
		addGbtn.addActionListener(this);
		addObtn.addActionListener(this);
		addSaveP.addActionListener(this);
		addSaveG.addActionListener(this);
		addSaveO.addActionListener(this);
		photoput.addActionListener(this);
		
		searchBtn.addActionListener(this);
		gsearchBtn.addActionListener(this);
		osearchBtn.addActionListener(this);
		
		delBtn.addActionListener(this);
		delPbtn.addActionListener(this);
		delGbtn.addActionListener(this);
		delObtn.addActionListener(this);
		delEndP.addActionListener(this);
		delEndO.addActionListener(this);
		delEndG.addActionListener(this);

		watBtn.addActionListener(this);
		schBtn.addActionListener(this);
		schPbtn.addActionListener(this);
		schGbtn.addActionListener(this);
		schObtn.addActionListener(this);

		prtBtn.addActionListener(this);
		prtPbtn.addActionListener(this);
		prtGbtn.addActionListener(this);
		prtObtn.addActionListener(this);
		
		modBtn.addActionListener(this);
		modPbtn.addActionListener(this);
		modGbtn.addActionListener(this);
		modObtn.addActionListener(this);
		
		mpBtn.addActionListener(this);
		mgBtn.addActionListener(this);
		moBtn.addActionListener(this);
		
		modEndP.addActionListener(this);
		modEndG.addActionListener(this);
		modEndO.addActionListener(this);
		
		
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
		Object ob = e.getSource();
		if (ob.equals(putBtn)) {
			this.remove(northP);
			this.remove(northP1);
			this.remove(northP2);
			this.remove(northP3);
			this.remove(northP4);
			this.remove(northP5);
			this.remove(northP6);
			northP0.add(northPtitle);
			northP0.add(northPmbtn);
			northP0.add(northPsbtn0);
			this.add(northP0,"North");
			this.repaint();
			this.setVisible(true);			
		} else if (ob.equals(addBtn)) {
			// ���� �߰� ��ư ���� �� add
			this.remove(northP0);
			this.remove(northP);
			this.remove(northP2);
			this.remove(northP3);
			this.remove(northP4);
			this.remove(northP5);
			this.remove(northP6);
			northP1.add(northPtitle);
			northP1.add(northPmbtn);
			northP1.add(northPsbtn1);
			this.add(northP1, "North");
			this.repaint();
			this.setVisible(true);
		} else if (ob.equals(modBtn)) {
			this.remove(northP0);
			this.remove(northP);
			this.remove(northP1);
			this.remove(northP2);
			this.remove(northP3);
			this.remove(northP4);
			this.remove(northP5);
			northP6.add(northPtitle);
			northP6.add(northPmbtn);
			northP6.add(northPsbtn6);
			this.add(northP6, "North");
			this.repaint();
			this.setVisible(true);

		} else if (ob.equals(delBtn)) {
			// ���� ���� ��ư ���� �� add
			this.remove(northP0);
			this.remove(northP);
			this.remove(northP1);
			this.remove(northP3);
			this.remove(northP4);
			this.remove(northP5);
			this.remove(northP6);
			northP2.add(northPtitle);
			northP2.add(northPmbtn);

			northP2.add(northPsbtn2);
			this.add(northP2, "North");
			this.repaint();
			this.setVisible(true);

		} else if (ob.equals(watBtn)) {
			// ���� ���� ��ư ���� �� add
			this.remove(northP0);
			this.remove(northP);
			this.remove(northP1);
			this.remove(northP2);
			this.remove(northP4);
			this.remove(northP5);
			this.remove(northP6);
			northP3.add(northPtitle);
			northP3.add(northPmbtn);
			northP3.add(northPsbtn3);
			this.add(northP3, "North");
			this.repaint();
			this.setVisible(true);

		} else if (ob.equals(prtBtn)) {
			// ���� ��ü ����
			this.remove(northP3);
			this.remove(northP5);
			northP4.add(northPtitle);
			northP4.add(northPmbtn);
			northP4.add(northPsbtn4);
			this.add(northP4, "North");
			this.repaint();
			this.setVisible(true);
		} else if (ob.equals(schBtn)) {
			// ���� �κ� �˻�
			this.remove(northP3);
			this.remove(northP4);
			northP5.add(northPtitle);
			northP5.add(northPmbtn);
			northP5.add(northPsbtn5);
			this.add(northP5, "North");
			this.repaint();
			this.setVisible(true);
		} else if (ob.equals(addPbtn)) {
			// ��� ���� ����
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);

			centerP.setLayout(new GridLayout(8, 2));
			centerP.add(pidLB);
			centerP.add(textPid);
			centerP.add(pnameLB);
			centerP.add(textPname);
			centerP.add(pdtLB);

			centerPm.setLayout(new GridLayout(4, 1));
			centerPm.add(textPdtY);
			centerPm.add(ydtLB);
			centerPm.add(textPdtM);
			centerPm.add(mdtLB);
			centerPm.add(textPdtD);
			centerPm.add(ddtLB);
			centerPm.add(textPdtH);
			centerPm.add(hdtLB);

			centerP.add(centerPm);

			centerP.add(paddrLB);
			centerP.add(textPaddr);
			centerP.add(ppcLB);
			centerP.add(textPpc);
			centerP.add(pcloLB);
			centerP.add(textPclo);
			centerP.add(prsnLB);
			centerP.add(textPrsn);
			centerP.add(addSaveP);
			centerP.add(photoput);

			this.add(centerP, "Center");

			this.repaint(); // �Ŀ��ٰ� ȭ���� �ٽ� �׷���
			this.setVisible(true);

		} else if (ob.equals(addSaveP)) {

			String id = textPid.getText().toString().trim();
			int pid = Integer.parseInt(id);

			String pname = textPname.getText();

			String Y = textPdtY.getText().toString().trim();
			int pdtY = Integer.parseInt(Y);

			String M = textPdtM.getText().toString().trim();
			int pdtM = Integer.parseInt(M);

			String D = textPdtD.getText().toString().trim();
			int pdtD = Integer.parseInt(D);

			String H = textPdtH.getText().toString().trim();
			int pdtH = Integer.parseInt(H);

			String paddr = textPaddr.getText();
			String ppc = textPpc.getText();
			String pclo = textPclo.getText();
			String prsn = textPrsn.getText();
			
			String photo = jlb.getText();
			
			personDTO newPers = new personDTO();
			newPers.setPid(pid);
			newPers.setPname(pname);
			newPers.setPdtY(pdtY);
			newPers.setPdtM(pdtM);
			newPers.setPdtD(pdtD);
			newPers.setPdtH(pdtH);
			newPers.setPaddr(paddr);
			newPers.setPpc(ppc);
			newPers.setPclo(pclo);
			newPers.setPrsn(prsn);
			newPers.setPhoto(photo);

			pdao.insertP(newPers);

			this.repaint(); // �Ŀ��ٰ� ȭ���� �ٽ� �׷���
			this.setVisible(true);

		} else if (ob.equals(addGbtn)) {
			//JOptionPane.showMessageDialog(this, "��츦 �ٽ� �����Ͻʽÿ�.");
			// ��ȣ�� ���� ����
			this.remove(centerP);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);

			centerPg.setLayout(new GridLayout(7, 2));
			centerPg.add(gidLB);
			centerPg.add(textGid);
			centerPg.add(gnameLB);
			centerPg.add(textGname);
			centerPg.add(pidLB);
			centerPg.add(textPid);
			centerPg.add(grelLB);
			centerPg.add(textGrel);
			centerPg.add(gaddrLB);
			centerPg.add(textGaddr);
			centerPg.add(gtelLB);
			centerPg.add(centerPcal);

			centerPg.add(addSaveG);

			this.add(centerPg, "Center");

			this.repaint();
			this.setVisible(true);

		} else if (ob.equals(addSaveG)) {
			String id = textGid.getText().toString().trim();
			int gid = Integer.parseInt(id);

			String gname = textGname.getText();

			String ppid = textPid.getText().toString().trim();
			int pid = Integer.parseInt(ppid);

			String grel = textGrel.getText();

			String gaddr = textGaddr.getText();

			String gtel = textFcal.getText() + "-" + textBcal.getText() + "-" + textAcal.getText();

			guardDTO newG = new guardDTO();
			newG.setGid(gid);
			newG.setGname(gname);
			newG.setPid(pid);
			newG.setGrel(grel);
			newG.setGaddr(gaddr);
			newG.setGtel(gtel);

			gdao.insertG(newG);

			this.repaint();
			this.setVisible(true);

		} else if (ob.equals(addObtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);

			centerPo.setLayout(new GridLayout(5, 2));
			centerPo.add(onameLB);
			centerPo.add(textOname);
			centerPo.add(otelLB);
			centerPo.add(centerPtel);
			centerPo.add(pidLB);
			centerPo.add(textPid);
			centerPo.add(gidLB);
			centerPo.add(textGid);

			centerPo.add(addSaveO);

			this.add(centerPo, "Center");

			this.repaint();
			this.setVisible(true);
		} else if (ob.equals(addSaveO)) {
			String oname = textOname.getText().toString().trim();

			String otel = jbox.getSelectedItem() + "-" + textBtel.getText() + "-" + textAtel.getText();

			String id = textPid.getText().toString().trim();
			int pid = Integer.parseInt(id);

			String idd = textGid.getText().toString().trim();
			int gid = Integer.parseInt(idd);

			organDTO newO = new organDTO();
			newO.setOname(oname);
			newO.setOtel(otel);
			newO.setPid(pid);
			newO.setGid(gid);

			odao.insertO(newO);

			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(prtPbtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTg);
			this.remove(centerTo);
			
			ArrayList<personDTO> pList = pdao.allP();
			persList.removeAll();
			
			for(personDTO p : pList) {
				String to = Integer.toString(p.getPid());
				persList.add(to);
			}
			
			centerTp.add(centerTpim);
			this.add(centerTp,"Center");
			
			this.repaint();
			this.setVisible(true);
			
		} else if(ob.equals(prtGbtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);
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
			
		} else if(ob.equals(prtObtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);
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
		} else if(ob.equals(schPbtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);			
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
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);			
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
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);			
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
		} else if(ob.equals(delPbtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);
			
			centerDp.setLayout(new GridLayout(2,1));
			
			textPid.setText("");
			centerDpu.add(pidLB);
			centerDpu.add(textPid);
			centerDpu.add(delEndP);
			centerDp.add(centerDpu);
			centerDpd.add(persList);
			centerDpd.add(persinfo);
			centerDp.add(centerDpd);
			ArrayList<personDTO> pList = pdao.allP();
			persList.removeAll();
			
			for(personDTO p : pList) {
				String to = Integer.toString(p.getPid());
				persList.add(to);
			}
			
			this.add(centerDp,"Center");
			this.repaint();
			this.setVisible(true);	
			
		} else if(ob.equals(delEndP)) {
			pdao.delP(textPid);
			JOptionPane.showMessageDialog(this, "������ �Ϸ��߽��ϴ�.");
			
		} else if(ob.equals(delGbtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);
			
			centerDg.setLayout(new GridLayout(2,1));
			
			textGid.setText("");
			centerDgu.add(gidLB);
			centerDgu.add(textGid);
			centerDgu.add(delEndG);
			centerDg.add(centerDgu);
			centerDgd.add(guardList);
			
			centerDgd.add(guardinfo);
			centerDg.add(centerDgd);
			ArrayList<guardDTO> gList = gdao.allG();
			guardList.removeAll();
			
			for(guardDTO g : gList) {
				String to = Integer.toString(g.getGid());
				guardList.add(to);
			}
			
			this.add(centerDg,"Center");
			this.repaint();
			this.setVisible(true);	
			
		} else if(ob.equals(delEndG)) {
			gdao.delG(textGid);
			JOptionPane.showMessageDialog(this, "������ �Ϸ��߽��ϴ�.");
		} else if(ob.equals(delObtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerMo);
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);
			
			centerDo.setLayout(new GridLayout(2,1));
			
			textOno.setText("");
			centerDou.add(onoLB);
			centerDou.add(textOno);
			centerDou.add(delEndO);
			centerDo.add(centerDou);
			centerDod.add(organList);
			centerDod.add(organinfo);
			centerDo.add(centerDod);
			ArrayList<organDTO> oList = odao.allO();
			organList.removeAll();
			
			for(organDTO o : oList) {
				String to = Integer.toString(o.getOno());
				organList.add(to);
			}
			
			this.add(centerDo,"Center");
			this.repaint();
			this.setVisible(true);	
			
		} else if(ob.equals(delEndO)) {
			odao.delO(textOno);
			JOptionPane.showMessageDialog(this, "������ �Ϸ��߽��ϴ�.");
		} else if(ob.equals(modPbtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMg);
			this.remove(centerMo);
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);
			
			centerMpo.add(spidLB);
			centerMpo.add(textsPid);
			centerMpo.add(mpBtn);
			centerMp.add(centerMpo);
			centerMp.add(centerMpe);
			this.add(centerMp,"Center");
			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(mpBtn)) {
			String sid = textsPid.getText();
			personDTO p = pdao.selectOneP(sid);			
			centerMp.add(pidLB);
			String mid = Integer.toString(p.getPid());
			textPid.setText(mid);
			centerMp.add(textPid);
			centerMp.add(pnameLB);
			textPname.setText(p.getPname());
			centerMp.add(textPname);
			centerMp.add(pdtLB);
			
			centerMpu.setLayout(new GridLayout(4, 1));
			String my = p.getPdt().substring(0,4);
			String mm = p.getPdt().substring(5,7);
			String md = p.getPdt().substring(8,11);
			String mh = p.getPdt().substring(12,13);
			textPdtY.setText(my);
			textPdtM.setText(mm);
			textPdtD.setText(md);
			textPdtH.setText(mh);
			centerMpu.add(textPdtY);
			centerMpu.add(ydtLB);
			centerMpu.add(textPdtM);
			centerMpu.add(mdtLB);
			centerMpu.add(textPdtD);
			centerMpu.add(ddtLB);
			centerMpu.add(textPdtH);
			centerMpu.add(hdtLB);

			centerMp.add(centerMpu);

			centerMp.add(paddrLB);
			textPaddr.setText(p.getPaddr());
			centerMp.add(textPaddr);
			centerMp.add(ppcLB);
			textPpc.setText(p.getPpc());
			centerMp.add(textPpc);
			centerMp.add(pcloLB);
			textPclo.setText(p.getPclo());
			centerMp.add(textPclo);
			centerMp.add(prsnLB);
			textPrsn.setText(p.getPrsn());
			centerMp.add(textPrsn);
			centerMp.add(modEndP);
			
			this.add(centerMp, "Center");

			this.repaint(); // �Ŀ��ٰ� ȭ���� �ٽ� �׷���
			this.setVisible(true);
		} else if(ob.equals(modEndP)) {

			String id = textPid.getText().toString().trim();
			int pid = Integer.parseInt(id);

			String pname = textPname.getText();

			String Y = textPdtY.getText().toString().trim();
			int pdtY = Integer.parseInt(Y);

			String M = textPdtM.getText().toString().trim();
			int pdtM = Integer.parseInt(M);

			String D = textPdtD.getText().toString().trim();
			int pdtD = Integer.parseInt(D);

			String H = textPdtH.getText().toString().trim();
			int pdtH = Integer.parseInt(H);

			String paddr = textPaddr.getText();
			String ppc = textPpc.getText();
			String pclo = textPclo.getText();
			String prsn = textPrsn.getText();

			personDTO newPers = new personDTO();
			newPers.setPid(pid);
			newPers.setPname(pname);
			newPers.setPdtY(pdtY);
			newPers.setPdtM(pdtM);
			newPers.setPdtD(pdtD);
			newPers.setPdtH(pdtH);
			newPers.setPaddr(paddr);
			newPers.setPpc(ppc);
			newPers.setPclo(pclo);
			newPers.setPrsn(prsn);

			pdao.modP(newPers);
			
			//JOptionPane.showMessageDialog(this, "������ �Ϸ��߽��ϴ�.");

			this.repaint(); // �Ŀ��ٰ� ȭ���� �ٽ� �׷���
			this.setVisible(true);

		} else if(ob.equals(modGbtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMo);
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);
			
			centerMg.setLayout(new GridLayout(3,1));
			
			centerMgo.add(sgidLB);
			centerMgo.add(textsGid);
			centerMgo.add(mgBtn);
			centerMg.add(centerMgo);
			//centerMg.add(centerMge);

			this.add(centerMg,"Center");
			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(mgBtn)) {
			centerMgu.setLayout(new GridLayout(7, 2));
			String sid = textsGid.getText();
			
			guardDTO g = gdao.selectOneG(sid);			
			
			centerMgu.add(gidLB);
			textGid.setText(sid);
			centerMgu.add(textGid);
			centerMgu.add(gnameLB);
			textGname.setText(g.getGname());
			centerMgu.add(textGname);
			centerMgu.add(pidLB);
			
			String mid = Integer.toString(g.getPid());
			
			textPid.setText(mid);
			centerMgu.add(textPid);
			centerMgu.add(grelLB);
			textGrel.setText(g.getGrel());
			centerMgu.add(textGrel);
			centerMgu.add(gaddrLB);
			textGaddr.setText(g.getGaddr());
			centerMgu.add(textGaddr);
			centerMgu.add(gtelLB);
			
			String bcal = g.getGtel().substring(4, 8);
			String acal = g.getGtel().substring(9);
			
			textBcal.setText(bcal);
			textAcal.setText(acal);
			centerMgu.add(centerPcal);
			
			centerMg.add(centerMgu);
			
			centerMg.add(modEndG);

			this.add(centerMg, "Center");

			this.repaint();
			this.setVisible(true);
			
		} else if(ob.equals(modEndG)) {
			String id = textGid.getText().toString().trim();
			int gid = Integer.parseInt(id);

			String gname = textGname.getText();

			String ppid = textPid.getText().toString().trim();
			int pid = Integer.parseInt(ppid);

			String grel = textGrel.getText();

			String gaddr = textGaddr.getText();

			String gtel = textFcal.getText() + "-" + textBcal.getText() + "-" + textAcal.getText();

			guardDTO newG = new guardDTO();
			newG.setGid(gid);
			newG.setGname(gname);
			newG.setPid(pid);
			newG.setGrel(grel);
			newG.setGaddr(gaddr);
			newG.setGtel(gtel);

			gdao.modG(newG);

			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(modObtn)) {
			this.remove(centerP);
			this.remove(centerPg);
			this.remove(centerPo);
			this.remove(centerDp);
			this.remove(centerDg);
			this.remove(centerDo);
			this.remove(centerMp);
			this.remove(centerMg);
			this.remove(centerSp);
			this.remove(centerSg);
			this.remove(centerSo);
			this.remove(centerTp);
			this.remove(centerTg);
			this.remove(centerTo);
			
			centerMo.setLayout(new GridLayout(5, 2));
			
			centerMoo.add(sonoLB);
			centerMoo.add(textsOno);
			centerMoo.add(moBtn);
			centerMo.add(centerMoo);
			centerMo.add(centerMoe);
			this.add(centerMo,"Center");
			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(moBtn)) {
			
			String sid = textsOno.getText();
			
			organDTO o = odao.selectOneO(sid);
			
			centerMo.add(onoLB);
			String mono = Integer.toString(o.getOno());
			textOno.setText(mono);
			centerMo.add(textOno);
			centerMo.add(onameLB);
			textOname.setText(o.getOname());
			centerMo.add(textOname);
			centerMo.add(otelLB);
			
			String mtel = o.getOtel().substring(4,8);
			String etel = o.getOtel().substring(9,13);
			
			textBtel.setText(mtel);
			textAtel.setText(etel);
			centerMo.add(centerPtel);
			centerMo.add(pidLB);
			
			String mpid = Integer.toString(o.getPid());		
			textPid.setText(mpid);
			centerMo.add(textPid);
			centerMo.add(gidLB);
			
			String mgid = Integer.toString(o.getGid());
			textGid.setText(mgid);
			centerMo.add(textGid);

			centerMo.add(modEndO);

			this.add(centerMo, "Center");

			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(modEndO)) {
			
			String no = textOno.getText().toString().trim();
			int ono = Integer.parseInt(no);
			
			String oname = textOname.getText().toString().trim();

			String otel = jbox.getSelectedItem() + "-" + textBtel.getText() + "-" + textAtel.getText();

			String id = textPid.getText().toString().trim();
			int pid = Integer.parseInt(id);

			String idd = textGid.getText().toString().trim();
			int gid = Integer.parseInt(idd);

			organDTO newO = new organDTO();
			newO.setOno(ono);
			newO.setOname(oname);
			newO.setOtel(otel);
			newO.setPid(pid);
			newO.setGid(gid);

			odao.modO(newO);

			this.repaint();
			this.setVisible(true);
		} else if(ob.equals(photoput)) {			
			if(fileChooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {
				jlb.setText(fileChooser.getSelectedFile().toString()/*+"."+fileChooser.getFileFilter().getDescription()*/);
				
			}
			

			/*
			photoput.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					JFileChooser fileChooser = new JFileChooser("C:\\Users\\human\\Pictures\\���� ����");
					fileChooser.showOpenDialog(null);
				}
			}
			);
			*/
			
		}

	} 
	/*
	public void action(ActionEvent e) {
		if(e.getSource()==photoshow) {
			if(fileChooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
				//���� â ���� Ȯ�� ��ư�� �������� Ȯ��
				jlb.setText("���� ��� : "+fileChooser.getSelectedFile().toString());
			}
		} else if(e.getSource()==photoadd) {
			if(fileChooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {
				jlb.setText("���� ��� : "+fileChooser.getSelectedFile().toString()+"."+fileChooser.getFileFilter().getDescription());
			}
		}
	}
	*/
	@Override
	public void itemStateChanged(ItemEvent e) {
		
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
			
			
			try {
				File imageFile = new File(p.getPhoto());
				BufferedImage image = ImageIO.read(imageFile);
				centerTpim = new JLabel(new ImageIcon(image));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			//photo = new ImageIcon(JFmain.class.getResource(p.getPhoto()));
			
			//centerTpim.setIcon(photo);
			
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
			
			System.out.println("???");
			
			organinfo.setText("");
			organinfo.append("��� ��ȣ : "+o.getOno()+"\n");
			organinfo.append("���� ����� : "+o.getOname()+"\n");
			organinfo.append("��� ��ȭ��ȣ : "+o.getOtel()+"\n");
			organinfo.append("���� �Ƶ� ��Ϲ�ȣ : "+o.getPid()+"\n");
			organinfo.append("��ȣ�� ��Ϲ�ȣ : "+o.getGid()+"\n"); 
			
		
		} else if(e.getSource().equals(schpersList)) {
			String sname = schpersList.getSelectedItem();
			
			ArrayList<personDTO> pli = pdao.selectTwoP(sname);
			
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

