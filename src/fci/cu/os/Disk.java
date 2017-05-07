package fci.cu.os;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//B-Tree
public class Disk {
	
	Block[] blocks; 
	List<Folder> folders ;
	List<File> files ;
	Contiguous c ;
	public Disk() {
		// TODO Auto-generated constructor stub
		folders = new ArrayList<>();
		files = new ArrayList<>();
		blocks = new Block[10];

		for(int i = 0 ; i < blocks.length;i++)
		{
				blocks[i] = new Block();
		}
		
		c = new Contiguous(blocks);
	}

	
	
	
	void DisplayStatus()
	{
		System.out.println(blocks.length);

		c.getOccupiedSpace();
		c.getEmptySpace();
		c.getEmptySlots();

		String cmd= "file.txt 1000000 VFSD:\\Folder1";
		
		c.CreateFile(cmd);
		
		
		c.DisplaySlots();
	}




	
	void DisplayTreeStructure()
	{
		
	}
	
}
