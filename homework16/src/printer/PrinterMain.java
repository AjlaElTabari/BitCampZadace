package printer;

public class PrinterMain {

	public static void main(String[] args) {

		Printer p2 = new Printer("BITCamp Printer");
		System.out.println(p2);
		
		p2.addPaper(150);
		System.out.println(p2);
		
		p2.addInk();
		System.out.println(p2);
		
		p2.printPages(20);
		System.out.println(p2);
		System.out.println(p2.getInkAvailable());
		System.out.println(p2.getPaperAvailable());
		System.out.println(p2.getPrintedPages());
		System.out.println(Printer.getTotalPrintedPages());

		System.out.println(p2);
		
		Printer p3 = new Printer("Some Printer");		
		p3.addPaper(150);
		System.out.println(p3);
		
		p3.addInk();
		System.out.println(p3);
		
		p3.printPages(30);
		System.out.println(p3);
		System.out.println(p3.getInkAvailable());
		System.out.println(p3.getPaperAvailable());
		System.out.println(p3.getPrintedPages());
		
		System.out.println(Printer.getTotalPrintedPages());

	}

}
