package Main_d;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	
	
	
	//라벨
	JLabel idLB = new JLabel("아이디");
	JLabel pwdLB = new JLabel("비밀번호");
	JLabel titleLB = new JLabel("실종 아동 찾기 센터");
	
	//버튼
	JButton logbtn = new JButton("로그인");
	JButton newbtn = new JButton("회원가입");
	JButton ncusbtn = new JButton("비회원 둘러보기");
	JButton putbtn = new JButton("가입하기");
	
	//패널
	JPanel centerP = new JPanel();
	JPanel centerU = new JPanel();
	JPanel centerD = new JPanel();
	JPanel southP = new JPanel();
	JPanel southPp = new JPanel();
	
	//텍스트
	JTextField textId = new JTextField(10);
	JPasswordField textPwd = new JPasswordField(10);
	
	
	 Login() {
		 this.setBounds(500, 500, 400, 300);
		 
		 centerP.setLayout(new GridLayout(2,1));
		 
		 centerU.add(idLB);
		 centerU.add(textId);
		 centerP.add(centerU);
		 
		 centerD.add(pwdLB);
		 
		 textPwd.setEchoChar('*');
		 
		 centerD.add(textPwd);		
		 centerP.add(centerD);
		 
		 southP.add(logbtn);
		 southP.add(newbtn);
		 southP.add(ncusbtn);
		 
		 southPp.add(putbtn);
		 
		 this.add(titleLB,"North");
		 this.add(centerP,"Center");
		 this.add(southP,"South");
		 
		 logbtn.addActionListener(this);
		 newbtn.addActionListener(this);
		 ncusbtn.addActionListener(this);
		 
		 this.setVisible(true);
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		MemberDTO mm = new MemberDTO();
		MemberDAO m = new MemberDAO();
		ADM adm = new ADM();
		if(ob.equals(logbtn)) {
			
			String lid = textId.getText();
			String lpwd = textPwd.getText();			
			
			if(lid.equals(adm.getId())&&lpwd.equals(adm.getPwd())) {
				adm.ADMlog(lid,lpwd);
				this.setVisible(false);
			} else {
				ArrayList<MemberDTO> mlist = m.allM();
				System.out.println(mlist.size());
				for(MemberDTO mmm : mlist) {
					if(lid.equals(mmm.getId())&&lpwd.equals(mmm.getPwd())) {
						//System.out.println("???");
						new JFmain_Member(lid,lpwd);
					}
				}
				
				this.setVisible(false);

			}
			textId.setText("");
			textPwd.setText("");
			this.repaint();
			this.setVisible(false);
		} else if(ob.equals(newbtn)) {
			this.remove(southP);
			this.add(southPp,"South");			
			//저장 버튼 추가
			this.repaint();
			this.setVisible(true);
			
		} else if(ob.equals(putbtn)) {	
			
			String nid = textId.getText();
			String npwd = textPwd.getText();
			
			mm.setId(nid);
			mm.setPwd(npwd);
			
			m.insertM(mm);
			this.repaint();
			this.setVisible(true);
			
		} else if(ob.equals(ncusbtn)) {
			new JFmain_Not();			
			this.repaint();
			this.setVisible(false);
			
		} 
		
	}
	


}
