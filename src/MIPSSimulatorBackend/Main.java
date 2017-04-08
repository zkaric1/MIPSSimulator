package MIPSSimulatorBackend;

public class Main {

	
	public static void main(String args[]) {
		
		String instruction = "00000000010000110000100000100000"; //add r1 r2 r3
		R_TypeInstruction r_inst = (R_TypeInstruction)Instruction.decodeInstruction(instruction);
		
		System.out.println("Instruction: " + instruction);
		System.out.println("Opcode: " + r_inst.getOpcodeInt());
		System.out.println("rs: " + r_inst.getRsInt());
		System.out.println("rt: " + r_inst.getRtInt());
		System.out.println("rd: " + r_inst.getRdInt());
		System.out.println("Shift: " + r_inst.getShiftInt());
		System.out.println("Funct: " + r_inst.getFunctInt());
	}
}
