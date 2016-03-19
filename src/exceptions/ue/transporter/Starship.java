package exceptions.ue.transporter;

public class Starship {

	private String name;
	private Transporter transporter = new Transporter();
	
	public void beamUp(String person, String from) {
		try {
			transporter.beam(person, from, name, true);
		} catch (TransporterMalfunctionException e) {
			e.printStackTrace();
		}
		finally {
			this.transporter.shutdown();
		}
	}
}
