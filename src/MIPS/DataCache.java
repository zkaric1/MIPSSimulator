package MIPS;

public class DataCache {
	private Integer[] data;
	private Integer size;
	
	public DataCache(int size) {
		this.size = size;
		data = new Integer[size];
		for(int i = 0; i < size; i++)
			data[i] = 0;
	}
	
	public void write(int adress, int value) throws IllegalArgumentException {
		if(adress < 0 || adress >=size)
			throw new IllegalArgumentException("Adress out of scope");
			data[adress] = value;
	}

	public int read(int adress) throws IllegalArgumentException {
		if(adress < 0 || adress >=size)
			throw new IllegalArgumentException("Adress out of scope");
		return data[adress]; 
	}
	
}
