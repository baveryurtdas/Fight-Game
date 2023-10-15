
public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;


    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    void run() {
        if (isCheck()) { //Siklet sınırlamalarını kontrol etme

            double randomFight = Math.random() * 100; //Rastgele başlayacak dövüşçüyü seçme

            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println(this.f1.name + " Kalan Sağlık : " + this.f1.health);
                System.out.println(this.f2.name + " Kalan Sağlık : " + this.f2.health);


                // Başlayacak dövüşçü ilk dövüşçüyse
                if (randomFight <= 50) {
                    System.out.println(this.f1.name + " oyuncusu ilk darbeyi vuruyor.");
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                }
                // Başlayacak Dövüşçü 2. dövüşçü ise
                else {
                    System.out.println(this.f2.name + " oyuncusu ilk darbeyi vuruyor.");
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }


                }

            }
        } else {
            System.out.println("Sporcuların sikletleri uymuyor.");
        }
    }


    //Siklet kontrolünü yapma
    boolean isCheck() {
        return ((this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight));
    }

    //Maçı kazanan dövüşçüyü ekrana yazdırma
    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(this.f2.name + " maçı kazandı !");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " maçı kazandı !");
            return true;
        }

        return false;
    }
}
