package MIPSSimulatorBackend;

import MIPS.DataCache;
import MIPS.InstructionCache;
import MIPS.MIPSSim;
import MIPS.Registers;

public class Main {

	
	public static void main(String args[]) {
		
		String instruction = "00000000010000110000100000100000"; //add r1 r2 r3
		
		InstructionCache instCache = new InstructionCache(1);
		instCache.setInstruction(0, instruction);
		
		DataCache dataCache = new DataCache(64);
		
		MIPSSim simulator = new MIPSSim(instCache, dataCache);
		
		Registers registers = new Registers();
		registers.write(2, 5);
		registers.write(3, 6);
		
		simulator.setRegisters(registers);
		
		simulator.start();
		registers = simulator.getRegisters();
		
		for(int i = 0; i < 32; i++) {
			System.out.println("R" + i + ": " + registers.read(i));

		}
		
	}
}
