package MIPSSimulatorBackend;

public class Pipeline {

	private InstructionWrapper fetch;
	private InstructionWrapper decode;
	private InstructionWrapper execute;
	private InstructionWrapper memory;
	private InstructionWrapper writeback;
	private Integer waiting;//oznacava koja od 5 instrukcija se ceka, dok se ona ceka, instrukcije u ranijim fazama protocne se ne izvrsavaju - onHalt
	Integer brojac = 1;
	
	public Pipeline() {
		fetch = new InstructionWrapper();
		decode = new InstructionWrapper();
		execute = new InstructionWrapper();
		memory = new InstructionWrapper();
		writeback = new InstructionWrapper();
		waiting = -1;
	}
	
	private void hazardCheck() {
		/*provjeriti hazarde
		 * ukoliko neka instrukcija mora da ceka, postaviti isOnHalt na true
		 * postaviti i waiting polje na odgovarajucu vrijednost
		 */
	}
	
	
	public Integer Br() {
		return brojac;
	}
	
	public void proceed() {
		brojac++;
		
		hazardCheck();
		
		writeback.setIsEmpty(true);
		
		//ako se ne ceka instrukcija u writeback
		if(waiting != 5) {
			writeback = memory;
			memory = new InstructionWrapper();
			
		} else {
			return;
		}
		
		if(waiting != 4) {
			memory = execute;
			execute = new InstructionWrapper();
		} else {
			return;
		}
		
		if(waiting != 3) {
			execute = decode;
			decode = new InstructionWrapper();
		} else {
			return;
		}
		
		if(waiting != 2) {
			decode = fetch;
			fetch = new InstructionWrapper();
		} else {
			return;
		}
		
		
		
	}

	public Boolean isFull() {
		return !fetch.getIsEmpty();
	}

	public Boolean isEmpty() {
		return fetch.getIsEmpty() && decode.getIsEmpty() && execute.getIsEmpty() && memory.getIsEmpty() && writeback.getIsEmpty();
	}
	
	public InstructionWrapper getFetch() {
		return fetch;
	}

	public void setFetch(InstructionWrapper fetch) {
		this.fetch = fetch;
	}

	public InstructionWrapper getDecode() {
		return decode;
	}

	public void setDecode(InstructionWrapper decode) {
		this.decode = decode;
	}

	public InstructionWrapper getExecute() {
		return execute;
	}

	public void setExecute(InstructionWrapper execute) {
		this.execute = execute;
	}

	public InstructionWrapper getMemory() {
		return memory;
	}

	public void setMemory(InstructionWrapper memory) {
		this.memory = memory;
	}

	public InstructionWrapper getWriteback() {
		return writeback;
	}

	public void setWriteback(InstructionWrapper writeback) {
		this.writeback = writeback;
	}

}
