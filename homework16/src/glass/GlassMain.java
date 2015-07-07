package glass;

public class GlassMain {

	public static void main(String[] args) {
		Glass g1 = new Glass(200);
		System.out.println(g1.getFilling());
		
		g1.addLiquid("water", 100);
		g1.addLiquid("juice", 20);
		g1.addLiquid("water", 20);
		g1.addLiquid("water", 100);
		
		g1.emptyGlass();
		System.out.println(g1.getFilling());

	}

}