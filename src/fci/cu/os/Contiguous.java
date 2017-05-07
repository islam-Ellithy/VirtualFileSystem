package fci.cu.os;

import java.util.Scanner;
import java.util.Vector;

public class Contiguous implements AllocationInterface {

	Block[] blocks;
	File file;
	Scanner sc;

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
		String name = cmd.substring(0, p1), path;
		int size;
		cmd = cmd.substring(p1 + 1, cmd.length());
		cmd = cmd.trim();
		p1 = cmd.indexOf(" ");
		size = Integer.parseInt(cmd.substring(0, p1));
		cmd = cmd.substring(p1 + 1, cmd.length());
		cmd = cmd.trim();
		path = cmd;
		int idx, temp = -1;
		boolean flag = true;
		int c = 0;

		if (size <= this.getEmptySpace()) {
			while (flag) {

				idx = findEmptyBlock(size);

				if (idx != -1) {

					blocks[idx].setAllocatedSize(size);

					if (temp != -1)
						blocks[temp].setNextPtr(idx);

					size = blocks[idx].getReminder();

					temp = idx;

					if (size != 0) {

					} else {
						break;
					}
				} else {
					System.out.println("There is no size in the disk");
					break;
				}
			}
		}else
		{
			System.out.println("There is no size in the disk");
		}
	}

	void DisplaySlots() {
		System.out.println("Free Allocated Reminder nextPtr");
		for (Block b : blocks) {
			System.out.println(b);
		}
	}

	int findEmptyBlock(int sz) {
		int rem = 0;
		if (sz > 100000) {
			rem = sz / 100000;
			if (rem >= 1)
				rem--;
			rem *= 100000;
			rem += sz % 100000;
			sz -= rem;
		}

		for (int i = 0; i < blocks.length; i++) {
			if (sz <= blocks[i].getSize()) {
				return i;
			}
		}
		return -1;
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
