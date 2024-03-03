package ilkoyunum;

public class SafeHouse extends NormalLoc {

	SafeHouse(Player player ) {
		super(player,"Güveni ev");

	}
     public boolean getLocation() {
    	 player.setHealth(player.getrHealth());
    	 System.out.println("Canınız tamamıyla doldu...");
    	 System.out.println("Şuan Güvenli Ev adlı yerdesiniz.");
    	 return true;
     }
}










