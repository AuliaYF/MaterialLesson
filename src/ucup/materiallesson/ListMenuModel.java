package ucup.materiallesson;

public class ListMenuModel {

	private String title;
	private String desc;
	private int icon;

	public ListMenuModel(){}
	
	public ListMenuModel(String title, int icon){
		this.title = title;
		this.icon = icon;
	}
	
	public ListMenuModel(String title, String description){
		this.title = title;
		this.desc = description;
	}
	
	public ListMenuModel(String title, String description, int icon){
		this.title = title;
		this.desc = description;
		this.icon = icon;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	public int getIcon(){
		return this.icon;
	}

	public void setTitle(String title){
		this.title = title;
	}
	
	public void setDesc(String description){
		this.desc = description;
	}

	public void setIcon(int icon){
		this.icon = icon;
	}
}