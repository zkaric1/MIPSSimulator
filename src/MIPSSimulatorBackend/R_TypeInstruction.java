package MIPSSimulatorBackend;

public class R_TypeInstruction extends Instruction {
	
	private Boolean opcode[];
	private Boolean rs[];
	private Boolean rt[];
	private Boolean rd[];
	private Boolean shift[];
	private Boolean funct[];
	
	public R_TypeInstruction() { }
	
	public R_TypeInstruction(String instructionCode) {
		super(instructionCode);
		
		opcode = new Boolean[6];
		for(int i = 0; i < 6; i++)
			opcode[i] = this.instructionCode[i];
		
		rs = new Boolean[5];
		for(int i = 6; i < 11; i++)
			rs[i%6] = this.instructionCode[i];
		
		rt = new Boolean[5];
		for(int i = 11; i < 16; i++)
			rt[i%11] = this.instructionCode[i];
		
		rd = new Boolean[5];
		for(int i = 16; i < 21; i++)
			rd[i%16] = this.instructionCode[i];
		
		shift = new Boolean[5];
		for(int i = 21; i < 26; i++)
			shift[i%21] = this.instructionCode[i];
		
		funct = new Boolean[6];
		for(int i = 26; i < 32; i++)
			funct[i%26] = this.instructionCode[i];
		
	}
	
	public Boolean[] getOpcode() { return opcode; }
	public Boolean[] getRs() { return rs; }
	public Boolean[] getRt() { return rt; }
	public Boolean[] getRd() { return rd; }
	public Boolean[] getShift() { return shift; }
	public Boolean[] getFunct() { return funct; }
	
	public int getOpcodeInt() { return getIntFromBin(opcode); }
	public int getRsInt() { return getIntFromBin(rs); }
	public int getRtInt() { return getIntFromBin(rt); }
	public int getRdInt() { return getIntFromBin(rd); }
	public int getShiftInt() { return getIntFromBin(shift); }
	public int getFunctInt() { return getIntFromBin(funct); }
	
}