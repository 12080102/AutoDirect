package crunch.kevin.springmvc.javabean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import crunch.kevin.springmvc.dao.ProductDao;

public class ProductCount {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"SpringConfig.xml");
	ProductDao pd = (ProductDao) context.getBean("ProductDao");
	private int classicCars;
	private int vintageCars;
	private int motorcycles;
	private int ships;
	private int boats;
	private int trains;
	private int truckandbus;
	private int plains;
	private int cars;
	private int waters;

	public ProductCount() {
		// TODO Auto-generated constructor stub
		classicCars = pd.getProductsCount("Classic Cars");
		vintageCars = pd.getProductsCount("Vintage Cars");
		motorcycles = pd.getProductsCount("Motorcycles");
		ships = pd.getProductsCount("Ships");
		boats = pd.getProductsCount("Boats");
		trains = pd.getProductsCount("Trains");
		truckandbus = pd.getProductsCount("Trucks and Buses");
		plains = pd.getProductsCount("Planes");
		cars = classicCars + vintageCars;
		waters = ships + boats;
	}

	public int getCars() {
		return cars;
	}

	public void setCars(int cars) {
		this.cars = cars;
	}

	public int getWaters() {
		return waters;
	}

	public void setWaters(int waters) {
		this.waters = waters;
	}

	public int getClassicCars() {
		return classicCars;
	}

	public void setClassicCars(int classicCars) {
		this.classicCars = classicCars;
	}

	public int getVintageCars() {
		return vintageCars;
	}

	public void setVintageCars(int vintageCars) {
		this.vintageCars = vintageCars;
	}

	public int getMotorcycles() {
		return motorcycles;
	}

	public void setMotorcycles(int motorcycles) {
		this.motorcycles = motorcycles;
	}

	public int getShips() {
		return ships;
	}

	public void setShips(int ships) {
		this.ships = ships;
	}

	public int getBoats() {
		return boats;
	}

	public void setBoats(int boats) {
		this.boats = boats;
	}

	public int getTrains() {
		return trains;
	}

	public void setTrains(int trains) {
		this.trains = trains;
	}

	public int getTruckandbus() {
		return truckandbus;
	}

	public void setTruckandbus(int truckandbus) {
		this.truckandbus = truckandbus;
	}

	public int getPlains() {
		return plains;
	}

	public void setPlains(int plains) {
		this.plains = plains;
	}

}
