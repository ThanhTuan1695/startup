package model.bean;

public class Category {
	
	private int ID_cat;
	private String tenDM;

	public Category() {
	}

	public Category(int iD_cat, String tenDM) {
		ID_cat = iD_cat;
		this.tenDM = tenDM;
	}

	public int getID_cat() {
		return ID_cat;
	}

	public void setID_cat(int iD_cat) {
		ID_cat = iD_cat;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}

}
