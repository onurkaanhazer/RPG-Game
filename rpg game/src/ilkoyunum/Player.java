package ilkoyunum;

import java.util.Scanner;

public class Player {
	private int damage,health,money,rHealth;
	private String name,cName;
	private Inventory inv;
	  Scanner scan=new Scanner(System.in);
	  
	  
	public  Player(String name) {
		this.name = name;
		this.inv=new Inventory();
	}
    public void selectCha() {
         switch(chaMenu()) {
         // Samuray Seçildi
         case 1:
        	 setcName("Samuray");
        	 setDamage(5);
        	 setHealth(21);
        	 setMoney(15);
        	 setrHealth(21);
        	 break;
        // Okçu Seçildi
         case 2:
        	 setcName("Okçu");
        	 setDamage(7);
        	 setHealth(18);
        	 setMoney(20);
        	 setrHealth(18);
        	 break;
        // Şovalye Seçildi
         case 3:
        	 setcName("Şovalye");
        	 setDamage(8);
        	 setHealth(24);
        	 setMoney(5);
        	 setrHealth(24);
        	 break;
         default:
        	 setcName("Samuray");
             setDamage(5);
             setHealth(21);
             setMoney(15);
             setrHealth(21);
         
         }
         System.out.println("Karakter Adı: "+ getcName()+"\t Karakterin Hasarı :"+getDamage()+"\tKarakterin Sağlığı: "+getHealth()+"\tKarakterin Parası: "+getMoney());
         
         
    }
    public int chaMenu() {
    	System.out.println("Lütfen Bir Karakter Seciniz:");
    	System.out.println("1- Samuray\t Hasar: 5\t Sağlık: 21\tPara: 15");
    	System.out.println("2-   Okçu\t Hasar: 7\t Sağlık: 18\tPara: 20");
    	System.out.println("3- Şovalye\t Hasar: 8\t Sağlık: 24\tPara: 5");
    	System.out.print("Karakter Seçiminiz");
    	int chaID=scan.nextInt();
    	
    	while(chaID<0 || chaID>4) {
    		System.out.println("Lütfen Geçerli Bir Karakter Giriniz !");
    		 chaID=scan.nextInt();
    	}
    	
    	return chaID;
    }


    public int getTotalDamage() {
    	return this.getDamage()+this.getInv().getDamage();
    }

	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Inventory getInv() {
		return inv;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}
	public int getrHealth() {
		return rHealth;
	}
	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}
	  
	  
	}


