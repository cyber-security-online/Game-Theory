import java.util.HashSet;
import java.util.Set;

/**
 * Main program.
 * 
 * @author André Dalwigk
 *
 */
public class Main {
	public static void main(final String... args) {
		// Define the parties.
		Set<PoliticalParty> parties = new HashSet<>();
		parties.add(new PoliticalParty("CDU",26.8));
		parties.add(new PoliticalParty("SPD",20.5));
		parties.add(new PoliticalParty("Die Linke",9.2));
		parties.add(new PoliticalParty("Grüne",8.9));
		parties.add(new PoliticalParty("CSU",6.2));
		parties.add(new PoliticalParty("FDP",10.7));
		parties.add(new PoliticalParty("AfD",12.6));
		parties.add(new PoliticalParty("Sonstige",5.0));
		final Election election = new Election(50.0, parties);
		System.out.println(election.calculate_banzhaf_power_index());
	}
}
