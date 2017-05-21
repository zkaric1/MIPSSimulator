package MIPS;

import javax.swing.JOptionPane;

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
			JOptionPane.showMessageDialog(null,"Adress out of scope");
			
		instructions[adress] = instruction;
	}
	
	public String getInstruction(int adress) {
		return instructions[adress]; 
	}
	
	public Integer getNumberOfInstructions() { return instructions.length; }
}
