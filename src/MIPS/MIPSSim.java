package MIPS;

import MIPSSimulatorBackend.*;

public class MIPSSim {
	
	//LW 100011 - 35
	//SW 101011 - 43
	//ADD SUB AND 000000
	
	
	private InstructionCache instructions;
	private DataCache data;
	private int PC;
	private ALU alu;
	private Registers registers;
	Integer A, B, Imm;
	Integer LDM; //Load data from memory - privremeni registar u koji se upisuje ucitano iz memorije
	public MIPSSim(InstructionCache instructions, DataCache data) {
		PC = 0;
		alu = new ALU();
		setRegisters(new Registers());
		this.instructions = instructions;
		this.data = data;
	}
	
	public void start() {
		for(int i = 0; i < instructions.getNumberOfInstructions(); i++) {
			fetch(i);
		}
	}
	
	private void fetch(Integer adress) {
		Instruction inst = new Instruction(instructions.getInstruction(adress));
		decode(inst);
	}
	
	private void decode(Instruction instruction) {
		instruction.decodeInstruction();
		A = getRegisters().read(instruction.getRsInt());
		B = getRegisters().read(instruction.getRtInt());
		Imm = instruction.getImmInt();
		execute(instruction);
	}
	
	private void execute(Instruction instruction) {
		if(instruction.getOpcodeInt() == 0) {
			alu.calculate(A, B, instruction.getFunctInt());
		} else {
			alu.calculate(A, Imm, 32);
		}
		memory(instruction);
	}
	
	private void memory(Instruction instruction) {
		if(instruction.getOpcodeInt() == 43) {
			data.write(alu.getOutput(), B);
		} else if(instruction.getOpcodeInt() == 35) {
			LDM = data.read(alu.getOutput());
		}
		writeBack(instruction);
	}
	
	private void writeBack(Instruction instruction) {
		if(instruction.getOpcodeInt() == 35) {
			getRegisters().write(instruction.getRtInt(), LDM);
		} else if(instruction.getOpcodeInt() == 0) {
			getRegisters().write(instruction.getRdInt(), alu.getOutput());
		}
	}

	public Registers getRegisters() {
		return registers;
	}

	public void setRegisters(Registers registers) {
		this.registers = registers;
	}
	
	public DataCache getData() {
		return data;
	}

	public void setData(DataCache data) {
		this.data = data;
	}
	
}
