package Med;

public class Med_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���α׷��� ����");
		Med_2 m= new Med_2();
		System.out.println(m.point);
		System.out.println(m.pwd);
		m.a(); // ���Ͼ��� �޼���
		m.aa("kkk"); // �޼���ȣ���  kkk�� ��µ� ~ ���ϰ��� �ִµ� ȣ��ο��� �� ���ϰ��� ������
		int aaa = m.aa("abfa"); // ���ϰ��� �޾Ƽ� aaa ���� ~ ����� abfa�� ���� 
		/*System.out.println(aaa); ~ �� �ڵ�� ���Ͽ� return ���� 1�� ���� ~ 
								     id�� String������ aa()�޼���� int Ÿ���̿��� return���� 1�� �������־��� ������ 1�� ���� */
		m.aa("-----");
		m.aaa();
		System.out.println("���α׷��� ����");
	}

}
