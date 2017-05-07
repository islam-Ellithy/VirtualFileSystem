package fci.cu.os;

public class Block {
	int size ;
	int allocatedSize ;
	int nextPtr ;
	Block()
	{
		size = 100000;
		allocatedSize = 0 ;
		nextPtr = -1 ;
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
		if(sz<=size)
		{
			this.allocatedSize = sz;	
			this.size -= sz ;
		}
		else
		{
			System.out.println("Excuse me there is not size in that block");
		}
	}
	public int getNextPtr() {
		return nextPtr;
	}
	public void setNextPtr(int nextPtr) {
		this.nextPtr = nextPtr;
	}
	@Override
	public String toString() {
		return String.format("%d %d %d\t", size,allocatedSize,nextPtr);
	}
}
