package exceptions.ue.liga;

import java.util.ArrayList;
import java.util.Collections;

public class Liga {
	
	private String Name;
	private ArrayList<Team> Teams;
	ComparatorName name= new ComparatorName();
	
	public Liga(String name) {
		super();
		Name = name;
		Teams =  new ArrayList<>();
	}
	
	public void add(String name) throws TeamAlreadyExistsException {
		for (Team team : Teams) {
			if(name.equals(team.getName())) {
				throw new TeamAlreadyExistsException();
			}
		}
		this.Teams.add(new Team(name));
	}
	
	public ArrayList<Team> getAllTeams() {
		Collections.sort(Teams, name);
		return Teams;
	}
	
	public Team findTeam(String teamY) {
		for (Team team : Teams) {
			if(team.equals(teamY)) {
				return team;
			}
		}
		return null;
	}
	
	public void newGame(String teamA,int goalsA, String teamB, int goalsB) throws TeamNotFoundException {
		Team A = findTeam(teamA);
		Team B = findTeam(teamB);
		
		if(A == null || B == null) {
			throw new TeamNotFoundException();
		}
		else {
			try {
				A.gameFinished(goalsA, goalsB);
				B.gameFinished(goalsB, goalsA);
			} catch (GoalsMustBePrositivException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
