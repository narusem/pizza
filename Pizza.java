package pizza;

import java.util.ArrayList;

interface Price{
	int getPrice();
}

abstract class Topping implements Price{

	private String name;

	Topping(String name){
		this.name = name;
	}

	String getName(){
		return this.name;
	}
}

class Cheeze extends Topping{
	public Cheeze() {
		super("チーズ");
	}
	
	public int getPrice(){
		return 100;
	}
}

class Tomato extends Topping{
	public Tomato() {
		super("トマト");
	}

	public int getPrice(){
		return 100;
	}
}

class Sauce implements Price{
	private String name;

	Sauce(String name){
		this.name = name;
	}

	String getName(){
		return this.name;
	}

	public int getPrice(){
		return 50;
	}
}

class ChiliSauce extends Sauce
{
	public ChiliSauce() {
		super("チリソース");
	}
}

class BasilSauce extends Sauce
{
	public BasilSauce() {
		super("バジルソース");
	}
}

class Pizza implements Price{
	private String name;
	private int price;
	private ArrayList<Topping> listTopping = new ArrayList<Topping>();
	private ArrayList<Sauce> listSauce = new ArrayList<Sauce>();

	Pizza(String name, int price){
		this.name = name;
		this.price = price;
		System.out.println("" + name + "の注文が入りました。");
	}

	public int getPrice(){
		return price;
	}

	void add(Topping topping){
		listTopping.add(topping);
		System.out.println("トッピング:" + topping.getName() + "を追加しました。");
	}

	void add(Sauce sauce){
		listSauce.add(sauce);
		System.out.println("ソース:" + sauce.getName() + "を追加しました。");
	}

	void order(){
		int sum = this.price;
		System.out.println("基本料金:" + this.price + "円。");
		
		for(Topping topping: listTopping){
			sum += topping.getPrice();
			System.out.println("トッピング:" + topping.getPrice() + "円。");
		}

		for(Sauce sauce: listSauce){
			sum += sauce.getPrice();
			System.out.println("ソース:" + sauce.getPrice() + "円。");
		}
		System.out.println("合計:" + sum + "円です。");
	}
}

class PizzaSample{
	public static void main(String[] args) {
		Pizza pizza = new Pizza("チリソースピザ", 1000);
		pizza.add(new Cheeze());
		pizza.add(new Tomato());
		pizza.add(new ChiliSauce());
		pizza.order();
	}
}
