
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
	
	public boolean equals(Object avenger) {
        if (this == avenger) 
        	return true;
        if (avenger == null || getClass() != avenger.getClass()) 
        	return false;
        Avenger other = (Avenger) avenger;
        return heroName.equals(other.heroName) && heroAlias.equals(other.heroAlias);
    }

}
