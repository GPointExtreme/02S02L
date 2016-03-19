package exceptions.ue.transporter;

public class Transporter {
	
	public void beam(String person, String from, String to, boolean urgent) 
	throws TransporterMalfunctionException {
		if(urgent == true) {
			if(Math.random()<0.70) {
				throw new TransporterMalfunctionException("Beam failed Scotty!");
			}
		}
	}
	
	public void shutdown() {
		System.out.println("Transporter shutdown");
	}
}
