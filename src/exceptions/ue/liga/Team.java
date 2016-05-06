package exceptions.ue.liga;

public class Team implements Comparable<Team>{
	
	private String Name;
	private int CountWon;
	private int CountLost;
	private int CountDraw;
	private int GoalsScored;
	private int GoalsGot;
	private int Points;
	private int PlayedRounds;
	
	public Team(String name) {
		super();
		Name = name;
		CountWon = 0;
		CountLost = 0;
		CountDraw = 0;
		GoalsScored = 0;
		GoalsGot = 0;
		Points = 0;
		PlayedRounds = 0;
	}

	@Override
	public String toString() {
		return "Team [Name=" + Name + ", CountWon=" + CountWon + ", CountLost=" + CountLost + ", CountDraw=" + CountDraw
				+ ", GoalsScored=" + GoalsScored + ", GoalsGot=" + GoalsGot + ", Points=" + Points + ", PlayedRounds="
				+ PlayedRounds + "]";
	}

	public String getName() {
		return Name;
	}

	public int getCountWon() {
		return CountWon;
	}

	public int getCountLost() {
		return CountLost;
	}

	public int getCountDraw() {
		return CountDraw;
	}

	public int getGoalsScored() {
		return GoalsScored;
	}

	public int getGoalsGot() {
		return GoalsGot;
	}

	public int getPoints() {
		return Points;
	}

	public int getPlayedRounds() {
		return PlayedRounds;
	}

	@Override
	public int compareTo(Team o) {
		if(this.Points < o.Points) {
			return -1;
		}
		if(this.Points > o.Points) {
			return 1;
		}
		if(this.Points == o.Points) {
			if((this.GoalsScored-this.GoalsGot) < (o.GoalsScored-o.GoalsGot)) {
				return -1;
			}
			if((this.GoalsScored-this.GoalsGot) > (o.GoalsScored-o.GoalsGot)) {
				return 1;
			}
		}
		return 0;
	}

	public void gameFinished(int goalsScored, int goalsGot) throws GoalsMustBePrositivException {
		if(goalsScored < 0 || goalsGot < 0) {
			throw new GoalsMustBePrositivException();
		}
		if(goalsScored > goalsGot) {
			CountWon++;
			GoalsScored+=goalsScored;
			GoalsGot+=goalsGot;
			PlayedRounds++;
			Points+=3;
		}
		if(goalsScored < goalsGot) {
			CountLost++;
			GoalsScored+=goalsScored;
			GoalsGot+=goalsGot;
			PlayedRounds++;
		}
		if(goalsScored == goalsGot) {
			CountDraw++;
			GoalsScored+=goalsScored;
			GoalsGot+=goalsGot;
			PlayedRounds++;
			Points+=1;
		}
	}
}
