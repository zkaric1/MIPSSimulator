package MIPS;

public class Registers {
	
	Integer regs[];
	
	public Registers() {
		regs = new Integer[32];
		for(int i = 0; i < 32; i++)
			regs[i] = 0;
			
	}
	
	public void write(int adress, int value) throws IllegalArgumentException {
		if(adress < 0 || adress >=32)
			throw new IllegalArgumentException("Register not found");
		if(adress != 0)
			regs[adress] = value;
	}

	public int read(int adress) throws IllegalArgumentException {
		if(adress < 0 || adress >=32)
			throw new IllegalArgumentException("Register not found");
		return regs[adress]; 
	}
	
}
