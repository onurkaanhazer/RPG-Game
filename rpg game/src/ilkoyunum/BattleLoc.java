package ilkoyunum;

public abstract class BattleLoc extends Location {
   protected Obstacle obstacle;
   protected String award;
	BattleLoc(Player player,String name,Obstacle obstacle,String award) {
		super(player);
		this.obstacle=obstacle;
		this.name=name;
		this.award=award;
	}
	
	
	public boolean getLocation() {
	    int obsCount = obstacle.count();
	    System.out.println("Şuan buradasınız : " + this.getName());
	    System.out.println("Dikkatli olun ! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor !");
	    System.out.print("<S>avaş veya <K>aç :");
	    String selcase = Scan.nextLine();
	    selcase = selcase.toUpperCase();
	    if (selcase.equals("S")) {
	        if (combat(obsCount)) {
	            System.out.println(this.getName() + " Bölgesindeki Tüm düşmanları temizlediniz !");
	            if (this.award.equals("food") && player.getInv().isFood() == false) {
	                System.out.println(this.award + "Kazandınız !");
	                player.getInv().setFood(true);
	            } else if (this.award.equals("firewood") && player.getInv().isFirewood() == false) {
	                System.out.println(this.award + "Kazandınız !");
	                player.getInv().setFirewood(true);
	            } else if (this.award.equals("Water") && player.getInv().isWater() == false) {
	                System.out.println(this.award + "Kazandınız !");
	                player.getInv().setWater(true);
	            }
	            return true;
	        } else {
	            System.out.println("Öldünüz !");
	            return false;
	        }
	    }
	   
	    if (player.getHealth() <= 0) {
	        System.out.println("Öldünüz !");
	        return false;
	    }
	    return true;
	}

	public boolean combat(int obsCount) {
	    for (int i = 0; i < obsCount; i++) {
	        int defObsHealth = obstacle.getHealth();
	        playerStats();
	        enemyStats();
	        while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
	            System.out.print("<V>ur veya <K>aç");
	            String selcase = Scan.nextLine();
	            selcase = selcase.toUpperCase();
	            if (selcase.equals("V")) {
	                System.out.println("Vuruş Gerçekleştirdiniz !");
	                obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
	                afterHit();
	                if (obstacle.getHealth() > 0) {
	                    System.out.println();
	                    System.out.println("Canavar size vurdu !");
	                    player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
	                    afterHit();
	                }
	            } else {
	               
	                System.out.println("Savaştan kaçtınız !");
	                return false;
	            }
	        }

	        if (obstacle.getHealth() <= 0 && player.getHealth() > 0) {
	            System.out.println("Düşmanı yendiniz !");
	            player.setMoney(player.getMoney() + obstacle.getAward());
	            System.out.println("Güncel paranız : " + player.getMoney());
	            obstacle.setHealth(defObsHealth);
	        }
	        System.out.println("-----------------");
	    }
	    return true;
	}

		
		
	
	public void playerStats() {
		System.out.println("Oyuncu değerleri\n----------");
		System.out.println("Oyuncunun Sağlığı : "+this.getPlayer().getHealth());
		System.out.println("Oyuncunun Hasarı : "+this.getPlayer().getTotalDamage());
		System.out.println("Oyuncunun Parası : "+this.getPlayer().getMoney());
		if(player.getInv().getDamage()>0) {
			System.out.println("Silah : "+player.getInv().getwName());
		}
		if(player.getInv().getArmor()>0) {
			System.out.println("Zırh : "+player.getInv().getaName());
		}
	}
	public void enemyStats() {
		System.out.println();
		System.out.println(obstacle.getName()+" Değerleri\n----------");
		System.out.println("Canavarın Sağlığı : " +obstacle.getHealth());
		System.out.println("Canavarın Hasarı : " +obstacle.getDamage());
		System.out.println("Canavrı Yenince Verilen Para : " +obstacle.getAward());
		
	}
	public void afterHit() {
		System.out.println("Oyuncu Canı:"+player.getHealth());
		System.out.println(obstacle.getName()+" Canı:"+obstacle.getHealth());
		System.out.println();
		
		
	}
	
}
