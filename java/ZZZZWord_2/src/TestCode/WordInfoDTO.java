package TestCode;

public class WordInfoDTO {
	private String engName=null;
	private String korName=null;
	private String imporFlag=null;
	private String comment=null;
	// �ֱ� 3�� �������� ������ ����
	private int[] checkFlag = new int[3];
	private int missCnt=0;
	
	
	public void prt() {
		System.out.println("����ܾ� : "+engName);
		System.out.println("�ѱ��ǹ� : "+korName);
		System.out.println("�߿䵵 : "+imporFlag);
		System.out.println("���� : "+comment);
		System.out.println("Ʋ�� �� : "+missCnt);
	}
	
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	
	public String getKorName() {
		return korName;
	}
	public void setKorName(String korName) {
		this.korName = korName;
	}
	public String getImporFlag() {
		return imporFlag;
	}
	public void setImporFlag(String imporFlag) {
		this.imporFlag = imporFlag;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getMissCnt() {
		return missCnt;
	}
	public void setMissCnt(int missCnt) {
		this.missCnt = missCnt;
	}

}
