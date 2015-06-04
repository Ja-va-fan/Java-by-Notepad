import java.util.List;
import java.util.ArrayList;

public class ReplaceAll {
	public static void main(String... args) {
		String phrase = "If the mountain will not come to Muhammad, then Muhammad must go to the mountain.";

		ReplaceManager replaceManager = new ReplaceManager();
		replaceManager.add("mountain", "icecream truck");
		replaceManager.add("m......n", "future");
		
		for (Replaces replaces : replaceManager.getList()) {
			System.out.format("The regexp '%s' is replaced by '%s':\nResults in: '%s'\n\n"
					, replaces.regexp
					, replaces.string
					, phrase.replaceAll(replaces.regexp, replaces.string)
			);
		}
		
		System.out.println( phrase.replaceAll("mountain", "icecream truck") );
		System.out.println( phrase.replaceAll("m......n", "end") );
		System.out.println( phrase.replaceAll("m.{6}n", "m.{6}n") );
		System.out.println( phrase.replaceAll("Muhammad", "Mikael") );
		System.out.println( phrase.replaceAll("mountain", "icecream truck").replaceAll("Muhammad", "Mikael") );
		
		System.out.println( phrase.replaceAll("m.in", "icecream truck").replaceAll("Muhammad", "Mikael").replaceAll("\\s", "-") );
		
	}
}
	
class ReplaceManager {
	List<Replaces> replacesList = new ArrayList<>();
	public void add(String regexp, String string) {
		replacesList.add(new Replaces(regexp, string));
	}		
	public List<Replaces> getList() {
		return replacesList;
	}
}

class Replaces {
	public String regexp;
	public String string;
	public Replaces(String regexp, String string) {
		this.regexp = regexp;
		this.string = string;
	}
}
	
