import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents an election.
 * 
 * @author André Dalwigk
 *
 */
public class Election {
	
	/**
	 * Quorum.
	 */
	final double quorum;
	
	/**
	 * All parties participating in the election.
	 */
	final Set<PoliticalParty> parties;
	
	/**
	 * Set containing all possible coalitions.
	 */
	final Set<Set<PoliticalParty>> coalitions;
	
	/**
	 * Custom Ctor for an election.
	 * 
	 * @param quorum Quorum of the election.
	 * @param parties Participating parties.
	 */
	public Election(final double quorum, final Set<PoliticalParty> parties){
		this.quorum = quorum;
		this.parties = parties;
		// calculate all possible coalitions
		this.coalitions = possible_coalitions(parties);
		this.calculate_critical_coalitions();
	}

	/**
	 * Calculates all possible coalitions.
	 * 
	 * @param parties Parties that participate in a coalition.
	 * @return All possible coalitions.
	 */
	private <T> Set<Set<T>> possible_coalitions(Set<T> parties) {
		final Set<Set<T>> all_parties = new HashSet<Set<T>>();
		if (parties.isEmpty()) {
			all_parties.add(new HashSet<T>());
			return all_parties;
		}
		final List<T> list = new ArrayList<T>(parties);
		final T head = list.get(0);
		final Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
		for (Set<T> party : possible_coalitions(rest)) {
			final Set<T> new_coalition = new HashSet<T>();
			new_coalition.add(head);
			new_coalition.addAll(party);
			all_parties.add(new_coalition);
			all_parties.add(party);
		}
		return all_parties;
	}
	
	/**
	 * Calculates the value critical_coalition for each party.
	 */
	private void calculate_critical_coalitions(){
		for(Set<PoliticalParty> coalition : coalitions){
			// Calculate the total vote power
			double vote_power = 0;
			for(PoliticalParty party : coalition){
				vote_power += party.get_votes();
			}
			// Check for each party if it is critical.
			for(PoliticalParty party : coalition){
				if(vote_power > quorum && vote_power - party.get_votes() <= quorum){
					party.increment_critical();
				}
			}
		}
	}
	
	/**
	 * Calculates a result String containing the parties and their respective Banzhaf-power indices.
	 * @return
	 */
	public String calculate_banzhaf_power_index(){
		String result = "";
		double denom = 0;
		// Get the vote power of all parties.
		for(PoliticalParty party : parties){
			denom += party.get_critical_coalitions();
		}
		// Calculate the Banzhaf-Index for each party and construct a result-String.
		for(PoliticalParty party : parties){
			result += ("Die Partei '" + party.get_name() + "' hat einen Banzhaf-Index von " + party.get_critical_coalitions()/denom + "\n");
		}
		return result;
	}
}
