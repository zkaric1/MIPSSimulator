package MIPS;


import com.sun.javafx.collections.MappingChange.Map;

import MIPSSimulatorBackend.*;

public class MIPSSim {
	
	//public static final Map<Integer, String> OPCODES[] = 

	private InstructionCache instructions;
	private int PC;
	private Boolean condition;
	private Instruction activeInstruction;
	
	public MIPSSim(InstructionCache instructions) {
		PC = 0;
		condition = false;
		this.instructions = instructions;
	}
	
	public void start() {
		for(int i = 0; i < instructions.getNumberOfInstructions(); i++) {
			fetch(i);
		}
	}
	
	private void fetch(Integer adress) {
		activeInstruction = new Instruction(instructions.getInstruction(adress));
	}
	
}
