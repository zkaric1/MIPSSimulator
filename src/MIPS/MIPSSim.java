package MIPS;

import MIPSSimulatorBackend.*;

public class MIPSSim {
	
	//LW 100011 - 35
	//SW 101011 - 43
	//ADD SUB AND 000000
	
	
	private Pipeline pipeline;
	
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
		this.pipeline = new Pipeline();
	}
	
	public void start() {
		for(int i = 0; i < instructions.getNumberOfInstructions(); i++) {
			if(pipeline.isFull()) {
				i--;
			} else {
				fetch(i);
			}
			if(!pipeline.getDecode().getIsEmpty() && !pipeline.getDecode().getIsOnHalt())
				decode();
			if(!pipeline.getExecute().getIsEmpty() && !pipeline.getExecute().getIsOnHalt())
				execute();
			if(!pipeline.getMemory().getIsEmpty() && !pipeline.getMemory().getIsOnHalt())
				memory();
			if(!pipeline.getWriteback().getIsEmpty() && !pipeline.getWriteback().getIsOnHalt())
				writeBack();
			pipeline.proceed();
		}
	}
	
	private void fetch(Integer adress) {
		pipeline.setFetch(new InstructionWrapper(instructions.getInstruction(adress)));
	}
	
	private void decode() {
		pipeline.getDecode().getInstruction().decodeInstruction();

		A = getRegisters().read(pipeline.getDecode().getInstruction().getRsInt());
		B = getRegisters().read(pipeline.getDecode().getInstruction().getRtInt());
		Imm = pipeline.getDecode().getInstruction().getImmInt();
	}
	
	private void execute() {
		if(pipeline.getExecute().getInstruction().getOpcodeInt() == 0) {
			alu.calculate(A, B, pipeline.getExecute().getInstruction().getFunctInt());
		} else {
			alu.calculate(A, Imm, 32);
		}
		
	}
	
	private void memory() {
		if(pipeline.getMemory().getInstruction().getOpcodeInt() == 43) {
			data.write(alu.getOutput(), B);
		} else if(pipeline.getMemory().getInstruction().getOpcodeInt() == 35) {
			LDM = data.read(alu.getOutput());
		}
	}
	
	private void writeBack() {
		if(pipeline.getWriteback().getInstruction().getOpcodeInt() == 35) {
			getRegisters().write(pipeline.getWriteback().getInstruction().getRtInt(), LDM);
		} else if(pipeline.getWriteback().getInstruction().getOpcodeInt() == 0) {
			getRegisters().write(pipeline.getWriteback().getInstruction().getRdInt(), alu.getOutput());
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
