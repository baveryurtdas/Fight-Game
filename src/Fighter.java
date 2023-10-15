public class Fighter {
    String name;
    int damage;
    int health;
    int weight;

    int dodge;

    Fighter(String name, int damage, int health, int weight, int dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        if (dodge >= 0 && dodge <= 100) {
            this.dodge = dodge;
        } else {
            this.dodge = 0;
        }

    }


    int hit(Fighter foe) {
        System.out.println(this.name + " => " + foe.name + " " + this.damage + " hasar vurdu. ");

        //Rakip saldırıyı savurursa;
        if (foe.isDodge()) {
            System.out.println(foe.name + " gelen hasarı blokladı!");
            System.out.println("---------------");
            return foe.health;
        }
        //Hasar sonucu rakibin sağlık puanını güncelleme

        if (foe.health - this.damage < 0) {
            return 0;
        }
        return foe.health - this.damage; //Rakibe hasar vurma

    }


    //Dövüşçünün vurduğu hasarı savurmak için random bir değer üretip bu değer aralığını belirleme

    boolean isDodge() {
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.dodge;
    }

}
