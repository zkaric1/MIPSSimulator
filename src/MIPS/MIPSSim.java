package MIPS;

import java.util.ArrayList;

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
	Integer brojac1= 0;
	Integer brojac2= 0;
	Integer brojac3= 0;
	Integer brojac4= 0;
	Integer brojac5= 0;
	Integer A, B, Imm;
	Integer LDM; //Load data from memory - privremeni registar u koji se upisuje ucitano iz memorije
	ArrayList<String> listModel = new ArrayList<>();
	
	public MIPSSim(InstructionCache instructions, DataCache data) {
		PC = 0;
		alu = new ALU();
		setRegisters(new Registers());
		this.instructions = instructions;
		this.data = data;
		this.pipeline = new Pipeline();
	}
	
	public ArrayList<String> vratiListu() {
		return listModel;
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
		
		while(!pipeline.isEmpty()) {
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
		vratiListu();
	}
	
	private void fetch(Integer adress) {
		pipeline.setFetch(new InstructionWrapper(instructions.getInstruction(adress)));
		PC++;
		brojac1++;
		listModel.add("IF instrukcija: "+brojac1+" ciklus: "+pipeline.Br());
	}
	
	private void decode() {
		pipeline.getDecode().getInstruction().decodeInstruction();

		A = getRegisters().read(pipeline.getDecode().getInstruction().getRsInt());
		B = getRegisters().read(pipeline.getDecode().getInstruction().getRtInt());
		Imm = pipeline.getDecode().getInstruction().getImmInt();
		brojac2++;
		listModel.add("ID instrukcija: "+brojac2+" ciklus: "+pipeline.Br());
	}
	
	private void execute() {
		if(pipeline.getExecute().getInstruction().getOpcodeInt() == 0) {
			alu.calculate(A, B, pipeline.getExecute().getInstruction().getFunctInt());
		} else {
			alu.calculate(A, Imm, 32);
		}
		brojac3++;
		listModel.add("EX instrukcija: "+brojac3+" ciklus: "+pipeline.Br());
	}
	
	private void memory() {
		if(pipeline.getMemory().getInstruction().getOpcodeInt() == 43) {
			data.write(alu.getOutput(), B);
		} else if(pipeline.getMemory().getInstruction().getOpcodeInt() == 35) {
			LDM = data.read(alu.getOutput());
		}
		brojac4++;
		listModel.add("MEM instrukcija: "+brojac4+" ciklus: "+pipeline.Br());
	}
	
	private void writeBack() {
		if(pipeline.getWriteback().getInstruction().getOpcodeInt() == 35) {
			getRegisters().write(pipeline.getWriteback().getInstruction().getRtInt(), LDM);
		} else if(pipeline.getWriteback().getInstruction().getOpcodeInt() == 0) {
			getRegisters().write(pipeline.getWriteback().getInstruction().getRdInt(), alu.getOutput());
		}
		brojac5++;
		listModel.add("WB instrukcija: "+brojac5+" ciklus: "+pipeline.Br());
		
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