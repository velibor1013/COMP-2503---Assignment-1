
public class Avenger implements Comparable <Avenger>{

	// TODO: Implement the Avenger Class
	private String heroName;
	private String heroAlias;
	private int frequency;
	public static boolean sortByFrequency = false;
	
	public Avenger() {}
	
	@Override
	public int compareTo(Avenger o) {
		// TODO Auto-generated method stub
		if (sortByFrequency) {
            return Integer.compare(this.frequency, o.frequency);
        }
		return this.heroAlias.compareTo(o.heroAlias);
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	public String getHeroName() {return heroName;}
	public String getHeroAlias() {return heroAlias;}
	public int getFrequency() {return frequency;}
	
	public Avenger (String heroAlias, String heroName, int frequency) {
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
