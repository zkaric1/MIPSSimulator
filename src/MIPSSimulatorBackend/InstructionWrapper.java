package MIPSSimulatorBackend;

public class InstructionWrapper {
	
	private Instruction instruction;
	private Boolean isOnHalt;
	private Boolean isEmpty;
	
	public Boolean getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(Boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public InstructionWrapper() { isOnHalt = true; isEmpty = true; }
	
	public InstructionWrapper(String instruction) { this.instruction = new Instruction(instruction); this.isEmpty = false; this.isOnHalt = false; }

	public Instruction getInstruction() {
		return instruction;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

	public Boolean getIsOnHalt() {
		return isOnHalt;
	}

	public void setIsOnHalt(Boolean isOnHalt) {
		this.isOnHalt = isOnHalt;
	}
	
	

}
