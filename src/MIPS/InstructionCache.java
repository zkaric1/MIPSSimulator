package MIPS;

import MIPSSimulatorBackend.Instruction;

public class InstructionCache {
	private String instructions[];
	
	public InstructionCache(int size) {
		instructions = new String[size];
	}
	
	public InstructionCache(String instructions[]) {
		fillInstructions(instructions);
	}
	
	public void fillInstructions(String instructions[]) {
		this.instructions = instructions;
	}
	
	public void setInstruction(int adress, String instruction) throws IllegalArgumentException {
		if(adress < 0 || adress >= instructions.length)
			throw new IllegalArgumentException("Adress out of scope");
		instructions[adress] = instruction;
	}
	
	public String getInstruction(int adress) {
		return instructions[adress]; //adress/4 ako se uzimaju adrese kao 0,4,8...
	}
	
	public Integer getNumberOfInstructions() { return instructions.length; }
}
