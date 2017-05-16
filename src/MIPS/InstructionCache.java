package MIPS;


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
	
	public String getInstruction(int adress) {
		return instructions[adress]; //adress/4 ako se uzimaju adrese kao 0,4,8...
	}
	
	public Integer getNumberOfInstructions() { return instructions.length; }
}
