package fci.cu.os;

import java.util.ArrayList;


public class File extends Path {
	String type;
	int size;


	public File() {
		// TODO Auto-generated constructor stub
	}

	public File(String name, String type, String location, int size, String creationDate, String lastModificationDate) {
		super();
		this.name = name;
		this.type = type;
		this.location = location;
		this.size = size;
		this.creationDate = creationDate;
		this.lastModificationDate = lastModificationDate;
	}

}
