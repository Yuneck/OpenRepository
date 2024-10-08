import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	
public class Shop {
	
// -----MAIN VARIABLES-----
	public static int currentDay;
	public static int currentMoney;
	public static boolean gameStarting;
	public List<Order> orders;

	public static int orderCounter = 0;
	
//-----PRODUCT-----
	public static class Product {
    public String productName;
    public double productPrice;
    // Konstruktor
    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    } 
    //Getter i Setter dla nazwy produktu
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    // Getter i Setter dla ceny produktu
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    // Metoda do wyświetlania informacji o produkcie
    public void displayProduct() {
        System.out.println("Product name: : " + productName);
        System.out.println("Product price: " + productPrice);
        }
	}
	

//-----ORDER MANAGER-----
	public static class OrderManager {  
	private static OrderManager instance = new OrderManager();
	private OrderManager(){
		this.orders = new ArrayList<>();
		}
	public static OrderManager getInstance(){
      return instance;
   } 
    private List<Order> orders;
 
    // Add order to list
    public void addOrder(Order order) {
        this.orders.add(order);
        orderCounter++;
    }
    // Deleting order from list
    public void deleteOrder(Order order) {
        this.orders.remove(order);
        orderCounter--;
    }
    // Displaying all orders
    public void displayAllOrders() {
        System.out.println("All Orders:");
        for (Order order : orders) {
            order.displayOrder();
            System.out.println(); // Dodaje odstęp między zamówieniami
        }
    }
}

//-----CREATE ORDER MANAGER-----
	public static void createOrderManager() {
		System.out.println("\n-----CREATING ORDER MANAGER-----");
		OrderManager orderManager = 
        OrderManager.getInstance();
		System.out.println("Hello, it's day " + currentDay);
		mainMenu();
	}
	
// -----CHECK ORDERS-----
	static void checkOrders() {
		OrderManager orderManager = 
        OrderManager.getInstance();
		System.out.println("\n-----CHECK ORDERS-----");
		System.out.println("Orders in total: " + orderCounter);
		orderManager.displayAllOrders();
		mainMenu();
	}
	
// -----CREATE DUMMY ORDERS-----
	static void createDummies() {
		OrderManager orderManager = 
        OrderManager.getInstance();
		System.out.println("\n-----CREATING DUMMY ORDERS-----");
		Order order1 = new Order(101, "Anna Nowak");
        order1.addItem("Smartphone");
        order1.addItem("Etui na telefon");
        order1.addItem("Ładowarka");

        // Dodawanie zamówienia do sklepu
        orderManager.addOrder(order1);

        // Tworzenie drugiego zamówienia
        Order order2 = new Order(102, "Piotr Kowalski");
        order2.addItem("Laptop");
        order2.addItem("Torba na laptopa");

        // Dodawanie zamówienia do sklepu
        orderManager.addOrder(order2);
		mainMenu();
	}
	
// -----CREATE RANDOM ORDER-----
	static void createRandomOrder() {
		OrderManager orderManager = 
        OrderManager.getInstance();
        int orderItemsAmount = (int)(Math.random() * 5) + 1;
        int i = 1;
        String customerName = new String[] {"Kubica", "Małysz", "Pudzian", "Makłowicz", "Wajda"}[(int)(Math.random()*5)];
        
		System.out.println("\n-----CREATING RANDOM ORDER-----");
		Order randomOrder = new Order(orderCounter + 1, customerName);	
		while(i<=orderItemsAmount){
		      String itemName = new String[]{"Laptop", "Monitor", "Telefon", "Myszka", "Klawiatura"}[(int)(Math.random()*5)];
		      randomOrder.addItem(itemName);
		      i++;
		}   
        // Dodawanie zamówienia do sklepu
     orderManager.addOrder(randomOrder);
   //  mainMenu();
	}
		
// -----CREATE CUSTOM ORDER-----
	static void createOrder() {
		OrderManager orderManager = 
        OrderManager.getInstance();
        int orderItemsAmount = (int)(Math.random() * 5) + 1;
        int i = 1;
        String customerName = new String[] {"Kubica", "Małysz", "Pudzian", "Makłowicz", "Wajda"}[(int)(Math.random()*5)];
        
		System.out.println("\n-----CREATING RANDOM ORDER-----");
		Order randomOrder = new Order(orderCounter + 1, customerName);	
		while(i<=orderItemsAmount){
		      String itemName = new String[]{"Laptop", "Monitor", "Telefon", "Myszka", "Klawiatura"}[(int)(Math.random()*5)];
		      randomOrder.addItem(itemName);
		      i++;
		}   
        // Dodawanie zamówienia do sklepu
     orderManager.addOrder(randomOrder);
   //  mainMenu();
	}

// -----DEBUG CREATE RANDOM ORDER-----
	static void debugCreateOrder() {
		OrderManager orderManager = 
        OrderManager.getInstance();
        int orderItemsAmount = (int)(Math.random() * 5) + 1;
        int i = 1;
        String customerName = new String[] {"Kubica", "Małysz", "Pudzian", "Makłowicz", "Wajda"}[(int)(Math.random()*5)];
        
		System.out.println("\n-----CREATING RANDOM ORDER-----");
		Order randomOrder = new Order(orderCounter + 1, customerName);	
		while(i<=orderItemsAmount){
		      String itemName = new String[]{"Laptop", "Monitor", "Telefon", "Myszka", "Klawiatura"}[(int)(Math.random()*5)];
		      randomOrder.addItem(itemName);
		      i++;
		}   
        // Dodawanie zamówienia do sklepu
     orderManager.addOrder(randomOrder);
     mainMenu();
	}
// -----NEW DAY-----
	static void newDay() {
		int newOrdersAmount = (int)(Math.random() * 5) + 1;
		int i = 1;
		System.out.println("\n-----NEW DAY-----");
		currentDay++;
		System.out.println("Hello, it's day " + currentDay);
		while(i<=newOrdersAmount){
		     createOrder();
		     i++;
		     System.out.println(i);}
		mainMenu();
	}
	
// -----CHECK DAY-----
	static void showDay() {
		System.out.println("\n-----CHECK DAY-----");
		System.out.println("Current day is: " + currentDay);
		mainMenu();
	}
	
// -----CHECK MONEY-----	
	static void showMoney() {
		System.out.println("\n-----CHECK MONEY-----"); 
		System.out.println("Current money is: " + currentMoney);
		mainMenu();
		}
		
// -----ADD MONEY-----	
	static void addMoney() {
		System.out.println("\n-----ADD MONEY-----");
		System.out.println("How much you want to add?");
		System.out.println("Amount:");
		Scanner scnr = new Scanner(System.in);
		String newMoney = scnr.next();
		currentMoney = currentMoney + Integer.valueOf(newMoney);
		System.out.println("You just added " + newMoney);
		mainMenu();
		}
			
// -----MAIN MENU-----
	static void mainMenu() {
		if(gameStarting == true){
			System.out.println("Welcome to javaShop!");
			gameStarting = false;}
		else{}
		System.out.println( "\n-----MAIN MENU-----");
		System.out.println("1 - Check Current Money");
		System.out.println("2 - Check Current Day");
		System.out.println("3 - New Day");
		System.out.println("4 - Add Money");
		System.out.println("5 - Check Orders");
		System.out.println("6 - Add Dummy Orders");
		System.out.println("7 - Add Random Order DEBUG");
		
		Scanner scnr = new Scanner(System.in);
		String mainMenuAnswer = scnr.next();
		int mainMenuOption = Integer.parseInt(mainMenuAnswer);
            switch (mainMenuOption) {
                case 1:
                    showMoney();
                    break;
                case 2:
                    showDay();
                    break;
                case 3:
                    newDay();
                    break;
                case 4:
                    addMoney();
                    break;
                case 5:
                    checkOrders();
                    break;
                case 6:
                    createDummies();
                    break;
                case 7:
                    debugCreateOrder();
                    break;	
                default:
                    break;
            }
	}
	
//=====MAIN VOID=====
	public static void main(String[] args) {      	gameStarting = true;
		currentDay = 1;
		mainMenu();
	}
}