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
		super("�`�[�Y");
	}
	
	public int getPrice(){
		return 100;
	}
}

class Tomato extends Topping{
	public Tomato() {
		super("�g�}�g");
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
		super("�`���\�[�X");
	}
}

class BasilSauce extends Sauce
{
	public BasilSauce() {
		super("�o�W���\�[�X");
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
		System.out.println("" + name + "�̒���������܂����B");
	}

	public int getPrice(){
		return price;
	}

	void add(Topping topping){
		listTopping.add(topping);
		System.out.println("�g�b�s���O:" + topping.getName() + "��ǉ����܂����B");
	}

	void add(Sauce sauce){
		listSauce.add(sauce);
		System.out.println("�\�[�X:" + sauce.getName() + "��ǉ����܂����B");
	}

	void order(){
		int sum = this.price;
		System.out.println("��{����:" + this.price + "�~�B");
		
		for(Topping topping: listTopping){
			sum += topping.getPrice();
			System.out.println("�g�b�s���O:" + topping.getPrice() + "�~�B");
		}

		for(Sauce sauce: listSauce){
			sum += sauce.getPrice();
			System.out.println("�\�[�X:" + sauce.getPrice() + "�~�B");
		}
		System.out.println("���v:" + sum + "�~�ł��B");
	}
}

class PizzaSample{
	public static void main(String[] args) {
		Pizza pizza = new Pizza("�`���\�[�X�s�U", 1000);
		pizza.add(new Cheeze());
		pizza.add(new Tomato());
		pizza.add(new ChiliSauce());
		pizza.order();
	}
}
