package MIPSSimulatorBackend;

public abstract class Instruction {
	protected Boolean[] instructionCode;
	
	public Instruction(String instructionCode) throws IllegalArgumentException {
		if(instructionCode.length() != 32)
			throw new IllegalArgumentException("Instruction must be 32-bit long");
		
		this.instructionCode = new Boolean[32];
		fillArrayFromString(this.instructionCode, instructionCode);
	}
	
	public static Instruction decodeInstruction(String instructionString) {
		//odredjivanje tipa instrukcije da bi se odlucilo koju vratiti
		//mi koristimo samo r tip pa nema potrebe da se provjerava
		return new R_TypeInstruction(instructionString);
	}
	
	private void fillArrayFromString(Boolean[] arr, String str) {
		for(int i = 0; i < 32; i++)
			if(str.charAt(i) == '1')
				arr[i] = true;
			else if(str.charAt(i) == '0')
				arr[i] = false;
			else
				throw new IllegalArgumentException("Instruction contains character other than 0/1");
	}
}
