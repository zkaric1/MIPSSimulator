package MIPSSimulatorBackend;

public class I_TypeInstruction extends Instruction {

	private Boolean opcode[];
	private Boolean rs[];
	private Boolean rt[];
	private Boolean imm[];
	
	public I_TypeInstruction() {
		super();
	}
	
	public I_TypeInstruction(String instructionCode) {
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
		
		imm = new Boolean[16];
		for(int i = 16; i < 32; i++)
			imm[i%16] = this.instructionCode[i];
		
	}
	
	public Boolean[] getOpcode() { return opcode; }
	public Boolean[] getRs() { return rs; }
	public Boolean[] getRt() { return rt; }
	public Boolean[] getImm() { return imm; }
	
	
	public int getOpcodeInt() { return getIntFromBin(opcode); }
	public int getRsInt() { return getIntFromBin(rs); }
	public int getRtInt() { return getIntFromBin(rt); }
	public int getImmInt() { return getIntFromBin(imm); }
	
	
	
}
