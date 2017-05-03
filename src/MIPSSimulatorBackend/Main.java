package MIPSSimulatorBackend;

public class Main {

	
	public static void main(String args[]) {
		
		String instruction = "00000000010000110000100000100000"; //add r1 r2 r3
		
		R_TypeInstruction r_inst = new R_TypeInstruction();
		I_TypeInstruction i_inst = new I_TypeInstruction();
		
		Instruction inst;
		
		inst = Instruction.decodeInstruction(instruction);

		if(inst instanceof R_TypeInstruction) {
			r_inst = (R_TypeInstruction)inst;
			System.out.println("Instruction: " + instruction);
			System.out.println("Opcode: " + r_inst.getOpcodeInt());
			System.out.println("rs: " + r_inst.getRsInt());
			System.out.println("rt: " + r_inst.getRtInt());
			System.out.println("rd: " + r_inst.getRdInt());
			System.out.println("Shift: " + r_inst.getShiftInt());
			System.out.println("Funct: " + r_inst.getFunctInt());
		} else {
			i_inst = (I_TypeInstruction)inst;
			System.out.println("Instruction: " + instruction);
			System.out.println("Opcode: " + i_inst.getOpcodeInt());
			System.out.println("rs: " + i_inst.getRsInt());
			System.out.println("rt: " + i_inst.getRtInt());
			System.out.println("rd: " + i_inst.getImmInt());
		}
		
		
	}
}
