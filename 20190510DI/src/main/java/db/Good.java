package db;

import lombok.Data;

@Data
public class Good{

	
	
	public Good() {
		super();
	}
	public Good(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	private int num;
	private String name;
	

	
	@Override
	public String toString() {
		return "Good [num=" + num + ", name=" + name + "]";
	}
	
	
	
}