package exceptions.ue.liga;

public class DemoApp {

	public static void main(String[] args) {
		Liga bundesliga = new Liga("T-Mobile Bundesliga");
		try {
			bundesliga.add("SK Sturm");
			bundesliga.add("SK Rapid");
			bundesliga.add("Wacker Tirol");
		} catch (TeamAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			bundesliga.newGame("SK Sturm", 3, "SK Rapid", 2);
		} catch (TeamNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(bundesliga.findTeam("SK Sturm"));

	}

}
