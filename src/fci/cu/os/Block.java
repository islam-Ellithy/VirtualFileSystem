package fci.cu.os;

public class Block {
	int size;
	int allocatedSize;
	int nextPtr;
	int reminder;

	Block() {
		size = 100000;
		allocatedSize = 0;
		nextPtr = -1;
		reminder = 0;
	}

	public int getReminder() {
		return reminder;
	}

	public void setReminder(int reminder) {
		this.reminder = reminder;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getAllocatedSize() {
		return allocatedSize;
	}

	public void setAllocatedSize(int sz) {

		int rem = 0;
		if (sz > 100000) {
			rem = sz / 100000;
			if(rem>=1)
				rem--;
			rem *= 100000;
			rem += sz%100000;
			this.reminder = rem ;
			sz -= reminder ;
			this.allocatedSize = sz ;;
		}
		
		this.allocatedSize = sz;

		this.size -= this.allocatedSize;
	}

	public int getNextPtr() {
		return nextPtr;
	}

	public void setNextPtr(int nextPtr) {
		this.nextPtr = nextPtr;
	}

	@Override
	public String toString() {
		return String.format("%d %d %d %d \t", size, allocatedSize,reminder, nextPtr);
	}
}
