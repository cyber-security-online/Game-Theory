/**
 * Represents a political party.
 * 
 * @author André Dalwigk
 *
 */
public class PoliticalParty {
	
	/**
	 * Name of the party.
	 */
	private final String name;
	
	/**
	 * Vote power of the party.
	 */
	private double votes;
	
	/**
	 * Number of coalition for this political party is critical.
	 */
	private double critical_coalitions = 0;
	
	/**
	 * Custom Ctor.
	 * @param name Name of the party.
	 */
	public PoliticalParty(final String name){
		this.name = name;
	}
	
	/**
	 * Custom Ctor.
	 * @param name Name of the party.
	 * @param votes Vote power (votes or percentage) of the party.
	 */
	public PoliticalParty(final String name, double votes){
		this.name = name;
		this.votes = votes;
	}
	
	/**
	 * Sets the vote power (votes or percentage).
	 * @param votes Vote power to set.
	 */
	public void set_votes(final double votes){
		this.votes = votes;
	}
	
	/**
	 * Increments the critical coalition counter.
	 */
	public void increment_critical(){
		critical_coalitions++;
	}
	
	/**
	 * Gets the name of the political party.
	 * @return name of the political party.
	 */
	public String get_name(){
		return name;
	}
	
	/**
	 * Gets the vote power of the political party.
	 * @return
	 */
	public double get_votes(){
		return votes;
	}
	
	/**
	 * Gets the number of coalitions this political party is critical to.
	 * @return Number of coalitions this political party is critical to.
	 */
	public double get_critical_coalitions(){
		return critical_coalitions;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
}
