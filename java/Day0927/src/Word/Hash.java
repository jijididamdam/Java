package Word;


public class Hash {
	private String word=null;
	private String comment=null;
	private String grade=null;
	
	Hash() {
		
	}

	String getWord() {
		return word;
	}
	
	String getGrade() {
		return grade;
	}
	
	String getComment() {
		return comment;
	}
	
	
	void input(String word, String comment,String grade) {
		this.word=word;
		this.comment=comment;
		this.grade=grade;
	}
	
	void prt() {
		System.out.print("¶ζ : "+word);		
		System.out.println(" ("+grade+")");
		System.out.println("Ό³Έν : "+comment);
	}

}

