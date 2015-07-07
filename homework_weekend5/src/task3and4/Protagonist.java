package task3and4;


import task1.StoryCharacter;
import task2.Goal;

/**
 * Describes a good guy in the story
 * @author ajla
 *
 */
public class Protagonist extends StoryCharacter {
	
	// Declaration and initialization of global variables
	private static final int MAX_ALLIES = 3;
	private static int ALLIES_NO = 0;
	private static final int MIN_CHANCE_TO_SUCCEED = 50;
	
	// class properties
	private Goal goal;
	private StoryCharacter[] allies;
	private StoryCharacter enemy;
	
	/**
	 * Constructor
	 * demands proper initialization of object
	 * @param name
	 * @param sex
	 * @param isCapable
	 * @param goal
	 */
	public Protagonist(String name, boolean sex, boolean isCapable, Goal goal) {
		super(name, sex, isCapable);
		this.goal = goal;
		this.enemy = null;
		this.allies = new StoryCharacter[MAX_ALLIES];
	}

	/**
	 * @return the goal
	 */
	public Goal getGoal() {
		return goal;
	}

	/**
	 * @param goal the goal to set
	 */
	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	/**
	 * @return the allies
	 */
	public StoryCharacter[] getAllies() {
		return allies;
	}

	/**
	 * @return the enemy
	 */
	public StoryCharacter getEnemy() {
		return enemy;
	}

	/**
	 * @param enemy the enemy to set
	 */
	public void setEnemy(StoryCharacter enemy) {
		this.enemy = enemy;
	}

	/**
	 * Adds an ally to the allies array
	 * One protagonist cannot have more then 3 allies
	 * @param ally
	 */
	public void addAlly(StoryCharacter ally) {	
			if(ALLIES_NO == MAX_ALLIES) {
				throw new ArrayIndexOutOfBoundsException("No more allies allowed!");
			} else {
				ALLIES_NO++;
				for (int i = 0; i < allies.length; i++) {
					if (allies[i] == null) {
						allies[i] = ally;
						break;
					}
				}
			}
	}
	
	/**
	 * Calculate what chances the protagonist has 
	 * to attain theirs goal. The calculation depends on
	 * how many allies the protagonist has, and on their capabilities
	 * also, it depends on goal difficulty
	 */
	public void attainGoal() {
		if(isAlive()) {
			int chance = 0;
			if(isCapable()){
				if (chance + 40 < 100) {
					chance += 40;
				} else {
					chance = 100;
				}
			}
			for (int i = 0; i < allies.length; i++) {
				if(allies[i].isCapable()){
					if (chance + 20 < 100) {
						chance += 20;
					} else {
						chance = 100;
					}
				}
			}
			if(enemy != null && enemy.isCapable()){
				if (chance - 30 > 0) {
					chance -= 30;
				} else {
					chance = 0;
				}
			}
			if(goal.getDifficulty() == Goal.HARD){
				if (chance - 20 > 0) {
					chance -= 20;
				} else {
					chance = 0;
				}
			} else if (goal.getDifficulty() == Goal.IMPOSSIBLE) {
				// if goal is impossible chances will be decreased by 100%,
				// but it cannot go under 0 %, so we will set it to zero, immediately
				chance = 0;
			}
			hasSucceeded(chance);
		} else {
			System.out.println("Your protagonist is already dead :(");
		}
	}
	
	/**
	 * Checks if protagonist has succeeded in his/hers goal
	 * If protagonist has mode then 50% chances than he/she will succeed
	 * Also, if he/she succeed, one of allies become capable, and if he/she
	 * does not succeed one of the allies has to die, and another one became capable
	 * @param chance
	 */
	private void hasSucceeded(int chance){
		if(chance >= MIN_CHANCE_TO_SUCCEED){
			System.out.println(getName() + " succeded in " + goal.getName() + ".");
			int randomAllyIndex = (int)Math.random() * 3 + 1;
			if (!allies[randomAllyIndex].isCapable()) {
				allies[randomAllyIndex].becameCapable();
			}
		} else {
			System.out.println(getName() + " failed in " + goal.getName() + ".");
			int randomAllyIndex = (int)Math.random() * 3 + 1;
			if (!allies[randomAllyIndex].isCapable()) {
				allies[randomAllyIndex].becameCapable();
			}
			randomAllyIndex = (int)Math.random() * 3 + 1;
			if (!allies[randomAllyIndex].isAlive()) {
				allies[randomAllyIndex].killCharacter();
			}
		}
	}
	
}
