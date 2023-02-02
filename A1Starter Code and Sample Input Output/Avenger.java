
public class Avenger implements Comparable <Avenger>{

	// TODO: Implement the Avenger Class
	
	@Override
	public int compareTo(Avenger o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	{
		private String heroName;
		private String heroAlias;
		private int frequency;
		public String getHeroName() {return heroName;}
		public String getHeroAlias() {return heroAlias;}
		public int getFrequency() {return frequency;}
		
		public Avenger (String heroName, String heroAlias, int frequency) {
			this.heroName = heroName;
			this.heroAlias = heroAlias;
			this.frequency = frequency;
		}
	}

}
