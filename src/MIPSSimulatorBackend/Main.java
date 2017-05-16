package MIPSSimulatorBackend;

public class Main {

	
	public static void main(String args[]) {
		
		String instruction = "00000000010000110000100000100000"; //add r1 r2 r3
		
		Instruction inst = new Instruction(instruction);
		inst.decodeInstruction();

		System.out.println("Instruction: " + instruction);
		System.out.println("Opcode: " + inst.getOpcodeInt());
		System.out.println("rs: " + inst.getRsInt());
		System.out.println("rt: " + inst.getRtInt());
		System.out.println("rd: " + inst.getRdInt());
		System.out.println("Funct: " + inst.getFunctInt());
		
		
	}
}
