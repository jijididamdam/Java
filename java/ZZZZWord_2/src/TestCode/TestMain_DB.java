package TestCode;

import wordManager.WordManager;

public class TestMain_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WordManager wm = new WordManager();
		//wm.wordManagerRun();
		//�ܾ������� ����� �̰��� �Է�
		/*String eng="cat";
		String kor="�����";
		String impor="��";
		String comment="���";
		
		WordInfoDTO w = new WordInfoDTO();
		
		���� �ܾ ��� �����Ϸ��� �Ѵ�. �� �� DAO insert�޼��� ȣ���� �ʿ��ϴ�.
		insert �޼��忡���� ������ insert into word1 values(?,?,?,?,default)
		ȣ��ο��� ? ? ? ? �� ������ �˷�����Ѵ�.
		�׷��� insert �޼���� �� ������ �Ű������� �޴´�... �׸��� �� �Ű������� DTO�� ���ǵǾ� �ִ�.
		�׷��� DTO ��ü�� ����� ������ �Է��ϰ� �Ű������� �Ѱ��ش�.
		
		
		w.setEngName(eng);
		w.setKorName(kor);
		w.setImporFlag(impor);
		w.setComment(comment);
		wdao.insertWord(w);
		*/
		WordManager mm = new WordManager();
		mm.wordManagerRun();
		
	}

}
