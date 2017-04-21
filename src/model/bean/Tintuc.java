package model.bean;

public class Tintuc {
	private int idnew;
	private int idcat;
	private String name;
	private String preview;
	private String chitiet;
	private String namecat;
	private String picture;
	
	
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Tintuc(int idnew, int idcat, String name, String preview,
			String chitiet, String namecat, String picture) {
		super();
		this.idnew = idnew;
		this.idcat = idcat;
		this.name = name;
		this.preview = preview;
		this.chitiet = chitiet;
		this.namecat = namecat;
		this.picture = picture;
	}

	public String getNamecat() {
		return namecat;
	}

	public void setNamecat(String namecat) {
		this.namecat = namecat;
	}

	public Tintuc(int idnew, int idcat, String name, String preview,
			String chitiet, String namecat) {
		super();
		this.idnew = idnew;
		this.idcat = idcat;
		this.name = name;
		this.preview = preview;
		this.chitiet = chitiet;
		this.namecat = namecat;
	}

	public Tintuc() {
	}

	public Tintuc(int idnew, int idcat, String name, String preview,
			String chitiet) {
		super();
		this.idnew = idnew;
		this.idcat = idcat;
		this.name = name;
		this.preview = preview;
		this.chitiet = chitiet;
	}

	public String getChitiet() {
		return chitiet;
	}

	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}

	public Tintuc(int idnew, int idcat, String name, String preview) {
		this.idnew = idnew;
		this.idcat = idcat;
		this.name = name;
		this.preview = preview;
	}

	public int getIdnew() {
		return idnew;
	}

	public void setIdnew(int idnew) {
		this.idnew = idnew;
	}

	public int getIdcat() {
		return idcat;
	}

	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

}
