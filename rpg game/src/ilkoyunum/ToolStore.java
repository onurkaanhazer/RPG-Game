package ilkoyunum;

import java.util.Scanner;

public class ToolStore extends NormalLoc {
     Scanner Scan=new Scanner(System.in);
	ToolStore(Player player) {
		super(player,"Mağaza");
		
	
	}
	public boolean getLocation() {
		System.out.println("para :"+player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zırhlar");
		System.out.println("3. Çıkış");
		System.out.println("Seçiminiz : ");
		int selTool= Scan.nextInt();
		int selItemID;
		switch(selTool) {
		case 1:
			selItemID=weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID=armorMenu();
			buyArmor(selItemID);
			
			
		}
		return true;
				
	}
	public int armorMenu() {
		
		System.out.println("1. Hafif Zırh\t < Engelleme : 1 - Para : 15>");
		System.out.println("2. Orta Zırh\t < Engelleme : 3 - Para : 25>");
		System.out.println("3. Ağır Zırh\t < Engelleme : 5 - Para : 40>");
    	System.out.println("4. Çıkış ");
    	System.out.println("Zırh Seçiniz");
    	int selArmorID=Scan.nextInt(); 
    	return selArmorID;
	
		
	}
	public void buyArmor(int itemID) {
		    	int avoid=0;
		    	int price=0;
		    	String aName=null;
		    		switch(itemID) {
		    		case 1:
		    			avoid=1;
		    			price=15;
		    			aName="Hafif Zırh";
		    			break;
		    		case 2:
		    			avoid=3;
		    			price=25;
		    			aName="Orta Zırh";
		    			break;
		    		case 3:
		    			avoid=5;
		    			price=40;
		    			aName="ağır Zırh";
		    			break;
		    		case 4:
		    			System.out.println("Çıkış yapılıyor.");
		    			break;
		    		default:
		    			System.out.println("Geçersiz İşlem !");
		    			break;
		    		}
		    	if(price>0) {
		    		if(player.getMoney()>price && (price>0)) {
		    			player.getInv().setArmor(avoid);
		        		player.getInv().setaName(aName);
		        		player.setMoney(player.getMoney()-price);
		        		System.out.println(aName +" Satın aldınız önceki zırh değeriniz : "+player.getInv().getArmor());
		            	System.out.println("Kalan Para : "+player.getMoney());
		        	}else {
		        		System.out.println("Para Yetersiz !");
		    	}
		    		
		    	
		    }
		
		
		
		
		
		
		
		
		
	}
    public int weaponMenu() {
    	System.out.println("1. Tabanca\t < Para : 25 - Hasar : 2>");
    	System.out.println("2. Kılıç\t < Para : 35 - Hasar : 3>");
    	System.out.println("3. Tüfek\t < Para : 45 - Hasar : 7>");
    	System.out.println("4. Çıkış ");
    	System.out.println("Silah Seçiniz");
    	int selWeaponID=Scan.nextInt(); 
    	return selWeaponID;

    }
    public void buyWeapon(int itemID) {
    	int damage=0;
    	int price=0;
    	String wName=null;
    		switch(itemID) {
    		case 1:
    			damage=2;
    			price=25;
    			wName="Tabanca";
    			break;
    		case 2:
    			damage=3;
    			price=35;
    			wName="Kılıç";
    			break;
    		case 3:
    			damage=7;
    			price=45;
    			wName="Tüfek";
    			break;
    		case 4:
    			System.out.println("Çıkış yapılıyor.");
    			break;
    		default:
    			System.out.println("Geçersiz İşlem !");
    			break;
    		}
    	if(price>0) {
    		if(player.getMoney()>price && (price>0)) {
    			
        		player.getInv().setDamage(damage);
        		player.getInv().setwName(wName);
        		player.setMoney(player.getMoney()-price);
        		System.out.println(wName +" Satın aldınız önceki hasarınız : "+player.getDamage()+"Yeni hasarınız : "+player.getTotalDamage());
            	System.out.println("Kalan Para : "+player.getMoney());
        	}else {
        		System.out.println("Para Yetersiz !");
    	}
    		
    	
    }
}

}