
public class Avenger implements Comparable <Avenger>{

	// TODO: Implement the Avenger Class
	
	@Override
	public int compareTo(Avenger o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public Avenger() {}
	
	private String heroName;
	private String heroAlias;
	private int frequency;
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public String getHeroName() {return heroName;}
	public String getHeroAlias() {return heroAlias;}
	public int getFrequency() {return frequency;}
	
	public Avenger (String heroName, String heroAlias, int frequency) {
		this.heroName = heroName;
		this.heroAlias = heroAlias;
		this.frequency = frequency;
	}
	
	public String toString() {
		return heroAlias + " aka " + heroName + " mentioned " + frequency + " time(s)";
	}
	
	public boolean equals(String heroAlias, String heroName) { // not working 
		if (this.heroName.toLowerCase().equals(heroName) & this.heroAlias.toLowerCase().equals(heroAlias)) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
