package MIPS;

public class ALU {
	Integer A,B;
	Integer output;
	Boolean condition;
	
	public ALU() { }
	
	public Integer calculate(Integer A, Integer B, Integer function) {
		this.A = A; this.B = B;
		
		//TODO: Dodati slucajeve
		switch(function) {
			case 32 :
				output = A + B;
				condition = false;
				break;
			case 34 :
				output = A - B;
				condition = false;
				break;
			case 36 :
				output = (Integer)A & B;
				condition = false;
				break;
			case 37 :
				output = (Integer)A | B;
				condition = false;
				break;
			default :
				return -1;
		}
		
		return output;
	}
	
	public Integer getOutput() { return output; }
	
	public Boolean getCondition() { return condition; }
}
