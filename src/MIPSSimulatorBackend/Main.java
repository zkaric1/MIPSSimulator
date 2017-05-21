package MIPSSimulatorBackend;

import MIPS.DataCache;
import MIPS.InstructionCache;
import MIPS.MIPSSim;
import MIPS.Registers;

public class Main {

	
	public static void main(String args[]) {
		
		String instruction = "00000000010000110000100000100000"; //add r1 r2 r3
		//lw r1 0x0000(r0) - 100011(lw) 00000(base - r0) 00001(r1) 0000000000000000(offset)
		//sw r1 0x0000(r0) - 101011(sw) 00000(base - r0) 00001(r1) 0000000000000000(offset)
		//add r1 r2 r3     - 000000(arith) 00010(r2) 00011(r3) 00001(r1) 00000 100000(+)
		
		InstructionCache instCache = new InstructionCache(3);
		instCache.setInstruction(0, "00000000010000110000100000100000"); //add
		instCache.setInstruction(1, "10101100000000010000000000000000"); //sw
		instCache.setInstruction(2, "10001100000001010000000000000000"); //lw
//		instCache.setInstruction(3, "00000000101000110100000000100010"); //sub
		
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
		
		dataCache = simulator.getData();
		for(int i = 0; i < 64; i++) {
			System.out.println("Mem" + i + ": " + dataCache.read(i));
		}
		
	}
}
