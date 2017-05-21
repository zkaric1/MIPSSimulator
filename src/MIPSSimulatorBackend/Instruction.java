package MIPSSimulatorBackend;

import javax.swing.JOptionPane;

public class Instruction {
	protected Boolean[] instructionCode;
	
	private Boolean opcode[];
	private Boolean rs[];
	private Boolean rt[];
	private Boolean rd[];
	private Boolean funct[];
	
	private Boolean imm[];
	
	public Instruction() { }
	
	public Instruction(String instructionCode) throws IllegalArgumentException {
		if(instructionCode.length() != 32) 
			JOptionPane.showMessageDialog(null,"Instruction must be 32-bit long");
			
		
		this.instructionCode = new Boolean[32];
		fillArrayFromString(this.instructionCode, instructionCode);
	}
	
	public void decodeInstruction() {
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
		
		funct = new Boolean[11];
		for(int i = 21; i < 32; i++)
			funct[i%21] = this.instructionCode[i];
		
		imm = new Boolean[16];
		for(int i = 16; i < 32; i++)
			imm[i%16] = this.instructionCode[i];
		
	}
	
	public int getIntFromBin(Boolean[] arr) {
		int n = 0, l = arr.length;
		for (int i = 0; i < l; ++i) {
		    n = (n << 1) + (arr[i] ? 1 : 0);
		}
		return n;
	}
	
	private void fillArrayFromString(Boolean[] arr, String str) {
		for(int i = 0; i < 32; i++)
			if(str.charAt(i) == '1')
				arr[i] = true;
			else if(str.charAt(i) == '0')
				arr[i] = false;
			else
				JOptionPane.showMessageDialog(null,"Instruction contains character other than 0/1");
				
	}
	
	public Boolean[] getOpcode() { return opcode; }
	public Boolean[] getRs() { return rs; }
	public Boolean[] getRt() { return rt; }
	public Boolean[] getRd() { return rd; }
	public Boolean[] getFunct() { return funct; }
	public Boolean[] getImm() { return imm; }
	
	public int getOpcodeInt() { return getIntFromBin(opcode); }
	public int getRsInt() { return getIntFromBin(rs); }
	public int getRtInt() { return getIntFromBin(rt); }
	public int getRdInt() { return getIntFromBin(rd); }
	public int getFunctInt() { return getIntFromBin(funct); }
	public int getImmInt() { return getIntFromBin(imm); }
}
