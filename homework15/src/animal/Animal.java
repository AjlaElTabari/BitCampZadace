package animal;

public class Animal {
	
	private static byte habitat = 1;
	private static byte time = 1;
	
	@SuppressWarnings("unused")
	private String name;
	private byte activityTime;
	private byte waterNeeded;
	
	/**
	 * @param name
	 * @param activityTime
	 * @param waterNeeded
	 */
	public Animal(String name, byte activityTime, byte waterNeeded) {
		super();		
		this.name = name;
		this.activityTime = activityTime;
		this.waterNeeded = waterNeeded;
	}
	
	public void printStatus() {
		if (activityTime == time && habitat >= waterNeeded) {
			System.out.println("It’s fine. The animal is active and has water.");
		} else if (activityTime == time && habitat < waterNeeded) {
			System.out.println("The animal is active, but does not have enough water.");			
		} else if (activityTime != time && habitat >= waterNeeded) {
			System.out.println("The animal is not active, but has enough water.");
		} else {
			System.out.println("The animal is not active and it does not have enough water.");
		}
	}
	
	public static void cycleDayNight() {
		time = (byte) ((time == 1) ? 0 : 1);
	}
	
	public static void setAmountOfWater(byte water) {
		habitat = water;
	}
}