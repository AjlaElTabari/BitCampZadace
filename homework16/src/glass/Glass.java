package glass;

/**
 * Represents a glass, and simulating filling and emptying the glass 
 * @author ajla
 *
 */
public class Glass {
	private String liquidType;
	private int filling;
	private int maxCapacity;
	
	
	public Glass(int maxCapacity) {
		this.liquidType = null;
		this.filling = 0;
		this.maxCapacity = maxCapacity;
	}

	/**
	 * @return the liquidType
	 */
	public String getLiquidType() {
		return liquidType;
	}

	/**
	 * @return the filling
	 */
	public int getFilling() {
		return filling;
	}

	/**
	 * @return the maxCapacity
	 */
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	/**
	 * Add liquids to the glass
	 * receives String as type of liquid and int as amount of liquid
	 */
	public void addLiquid(String liquidType, int liquidAmount) {
		if(this.liquidType == null) {
			this.liquidType = liquidType;
			if(this.filling + liquidAmount <= this.maxCapacity) {
				this.filling += liquidAmount;
			} else {
				this.filling = this.maxCapacity;
			}
		} else if(this.liquidType.equals(liquidType)) {
			if(this.filling + liquidAmount <= this.maxCapacity) {
				this.filling += liquidAmount;
			} else {
				this.filling = this.maxCapacity;
			}
		} else {
			System.out.println("It is impossible to add this type of liquid in this glass.");
		}
		System.out.println(this.filling);
	}
	
	/**
	 * Empties the glass
	 */
	
	public void emptyGlass() {
		this.filling = 0;
	}
}
