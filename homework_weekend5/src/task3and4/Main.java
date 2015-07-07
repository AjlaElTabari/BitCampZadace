package task3and4;

import task1.StoryCharacter;
import task2.Event;
import task2.Goal;

public class Main {

	public static void main(String[] args) {
		
		/* In a distant, but not so unrealistic, future where mankind has abandoned earth because it has become covered with trash
		 * from products sold by the powerful multi-national Buy N Large corporation, WALL-E, a garbage collecting robot has been 
		 * left to clean up the mess. Mesmerized with trinkets of Earth's history and show tunes, WALL-E is alone on Earth except 
		 * for a sprightly pet cockroach. One day, EVE, a sleek (and dangerous) reconnaissance robot, is sent to Earth to find proof 
		 * that life is once again sustainable. WALL-E falls in love with EVE. WALL-E rescues EVE from a dust storm and shows her a 
		 * living plant he found amongst the rubble. Consistent with her "directive", EVE takes the plant and automatically enters a 
		 * deactivated state except for a blinking green beacon. WALL-E, doesn't understand what has happened to his new friend, but, 
		 * true to his love, he protects her from wind, rain, and lightning, even as she is unresponsive.
		*/
		
		StoryCharacter eve = new StoryCharacter("EVE", true, true);

		Goal goal = new Goal("Clean up the mess", Goal.HARD, Event.LOVE, eve);

		Protagonist wallE = new Protagonist("WALL-E", false, true, goal);
		
		
		StoryCharacter cockroach = new StoryCharacter("Cockroach", false, true);
		StoryCharacter plant = new StoryCharacter("Valuable plant", true, false);

		wallE.addAlly(eve);
		wallE.addAlly(cockroach);
		wallE.addAlly(plant);
		
		
		wallE.attainGoal();
	}

}
