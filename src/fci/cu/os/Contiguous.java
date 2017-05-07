package fci.cu.os;

import java.util.Scanner;
import java.util.Vector;

public class Contiguous implements AllocationInterface {

	Block[] blocks;
	File file ;
	Scanner sc ;
	Contiguous(Block[] blocks) {
		this.blocks = blocks;
	}

	int getOccupiedSpace() {
		int size = 0;
		for (Block b : blocks) {
			size += b.getAllocatedSize();
		}
		System.out.println("Allocated space = " + size);

		return size;
	}

	int getEmptySpace() {
		int size = 0;
		for (Block b : blocks) {
			size += b.getSize();
		}
		System.out.println("Empty space = " + size);
		return size;
	}

	Vector<Integer> getEmptySlots() {
		Vector<Integer> slots = new Vector<>();
		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i].getAllocatedSize() == 0)
				slots.add(i);
		}
		System.out.println("Empty slots are");

		for (Integer e : slots) {
			System.out.print(e + " ");
		}
		System.out.println();

		return slots;
	}

	@Override
	public void Save() {
		// TODO Auto-generated method stub
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void CreateFile(String cmd) {
		// TODO Auto-generated method stub
		cmd = cmd.trim();
		int p1 = cmd.indexOf(" ");
		String name = cmd.substring(0,p1),path;
		int size ;
		cmd = cmd.substring(p1+1,cmd.length());
		cmd = cmd.trim();
		p1 = cmd.indexOf(" ");
		size = Integer.parseInt(cmd.substring(0,p1));
		cmd = cmd.substring(p1+1,cmd.length());
		cmd = cmd.trim();
		path = cmd ;
		System.out.println(name);
		System.out.println(size);
		System.out.println(path);
		
		int idx = findEmptyBlock(size);
		
		System.out.println(idx);
		if(idx!=-1)
		{
			blocks[idx].setAllocatedSize(size) ;
		}

	}

	void DisplaySlots()
	{
		for(Block b : blocks)
		{
			System.out.println(b);
		}
	}
	int findEmptyBlock(int sz)
	{
		for(int i = 0 ;i<blocks.length;i++)
		{
			if(sz <= blocks[i].getSize())
			{
				return i ;
			}
		}
		return -1 ;
	}
	
	@Override
	public void CreateFolder(String cmd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteFolder(String cmd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteFile(String cmd) {
		// TODO Auto-generated method stub
		
	}

}
