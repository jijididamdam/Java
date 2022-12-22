package Person;

public class personDTO {
	
	public personDTO() {
		
	}
	
	private int pid=0;
	private String pname=null;
	private String Pdt = null;
	private int pdtY = 0;
	private int pdtM = 0;
	private int pdtD = 0;
	private int pdtH = 0;
	private String paddr=null;
	private String ppc=null;
	private String pclo=null;
	private String prsn=null;
	private String photo=null;
	
	
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPdt() {
		return Pdt;
	}
	public void setPdt(String pdt) {
		Pdt = pdt;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public int getPdtY() {
		return pdtY;
	}
	public void setPdtY(int pdtY) {
		this.pdtY = pdtY;
	}
	public int getPdtM() {
		return pdtM;
	}
	public void setPdtM(int pdtM) {
		this.pdtM = pdtM;
	}
	public int getPdtD() {
		return pdtD;
	}
	public void setPdtD(int pdtD) {
		this.pdtD = pdtD;
	}
	public int getPdtH() {
		return pdtH;
	}
	public void setPdtH(int pdtH) {
		this.pdtH = pdtH;
	}
	
	public String getPaddr() {
		return paddr;
	}
	public void setPaddr(String paddr) {
		this.paddr = paddr;
	}
	public String getPpc() {
		return ppc;
	}
	public void setPpc(String ppc) {
		this.ppc = ppc;
	}
	public String getPclo() {
		return pclo;
	}
	public void setPclo(String pclo) {
		this.pclo = pclo;
	}
	public String getPrsn() {
		return prsn;
	}
	public void setPrsn(String prsn) {
		this.prsn = prsn;
	}
	

}
