package fci.cu.os;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Path {

	ArrayList<Folder> folders ;
	ArrayList<File> files ;
	
	public Folder() {
		folders = new ArrayList<Folder>();
		files = new ArrayList<File>();
	}

}
