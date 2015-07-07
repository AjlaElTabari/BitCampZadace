package homework_oop;

/**
 * @author ajla
 *
 */
public interface Connectable {
	public void connect(Computer c);
	public void connect(Network n);
	public void disconnect();
	
}
