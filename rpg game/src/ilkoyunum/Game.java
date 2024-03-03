package ilkoyunum;

import java.util.Scanner;

public class Game {
	 Player player;
	 Location location;
	 Scanner scan=new Scanner(System.in);
	 public void login() {
	     Scanner Scan=new Scanner(System.in);
		 System.out.println("Macera Oyununa Hoşgeldiniz!");
		 System.out.println("Oyun Başlamadan Önce İsminizi Giriniz");
		 String playerName=Scan.nextLine();
		 player=new Player(playerName);
		 player.selectCha();
		 start();
	 }
	public void start() {
	while(true) {
		System.out.println();
		System.out.println("==================================================================");
		System.out.println();
		System.out.println("Eylem Gerçekleştirmek İçin Bir Yer Seçiniz : ");
		System.out.println("1. Güvenli Ev -->Size ait güvenli bir mekan,düşmak yok !");
		System.out.println("2. Mağara --> Karşınıza belki zombi çıkabilir !");
		System.out.println("3. Orman -->  Karşınıza belki vampir çıkabilir !");
		System.out.println("4. Nehir --> Karşınıza belki ayı çıkabilir !"); 
		System.out.println("5. Mağaza --> Buradan silah veya zırh satın alabilirsiniz !");
		System.out.print("Gitmek istediğiniz mekan : ");
		int selLoc=scan.nextInt();
		while(selLoc<0 || selLoc>5) {
			System.out.println("Lütfen geçerli bir mekan seçimim yapınız !");
			selLoc=scan.nextInt();
		}
		switch(selLoc) {
		case 1:
			location=new SafeHouse(player);
			break;
		case 2:
			location=new Cave(player);
			break;
		case 3:
			location=new Forest(player);
			break;
		case 4:
			location=new River(player);
			break;
		case 5:
			location=new ToolStore(player);
			break;
			default:
			location=new SafeHouse(player);
		}
		if(location.getClass().getName().equals("SafeHouse")) {
			if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
				System.out.println("Tebrikler oyunu kazandınız ! ");
				break;
			}
		}
		if(!location.getLocation()) {
			System.out.println("Oyun Biiti !");
			break;
		}
	}
	}


}
