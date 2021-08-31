package miniProject;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //1.jelo
        OilsSpicesAndOther f = new OilsSpicesAndOther("Dijamant", "ulje", 10, 23, 0.2, 35, 25, 2);
        Food f1 = new Food("Idea", "jaja", 72, 300, 24.1 , 17.9, 15, 3.1);
        Food f2 = new Food("Zlatiborac", "slaninva", 200, 540, 30.2, 4.3, 3, 1.2);
        Food f3 = new Food("Imlek", "sir", 150, 420.2, 13,25.3, 22, 18);
        Drink f4 = new Drink("Imlek", "jogurt", 100, 200, 5, 12, 10.2, 12);
        ArrayList<Nutriment> dorucak = new ArrayList<>();
        dorucak.add(f1); dorucak.add(f2); dorucak.add(f3); dorucak.add(f4); dorucak.add(f);

        //2.jelo
        Food f5 = new Food("Maxi", "piletina", 500, 390.2, 72.3, 24, 20, 31.2);
        Food f6 = new Food("Maxi", "pire", 250, 200, 12, 53, 48, 11);
        Food f7 = new Food("Dijamant", "margarin", 150, 120, 11, 55, 45, 12);
        Drink f8 = new Drink("Imlek", "mleko", 1000, 100.3, 3, 49.2, 40, 9.4);
        OilsSpicesAndOther f9 = new OilsSpicesAndOther("Tuzla", "so", 1000, 4, 0.1, 0.3, 0.2, 0);
        Food f10 = new Food("Pijaca", "kupus salata", 1450.2,18, 1, 2, 1.2, 29);
        ArrayList<Nutriment> rucak = new ArrayList<>();
        rucak.add(f); rucak.add(f5); rucak.add(f6); rucak.add(f7); rucak.add(f8); rucak.add(f9); rucak.add(f10);
        //3.jelo
        Food f11 = new Food("RioMare", "tunjevina", 180, 122.2, 11, 18, 14.2, 9.2);
        Food f12 = new Food("Pijaca", "cherry paradajz", 120, 90, 2, 5, 1.2, 52.1);
        Food f13 = new Food("Pijaca", "rukola", 150, 11, 1, 1,1, 25);
        ArrayList<Nutriment> salata = new ArrayList<>();
        salata.add(f11); salata.add(f12); salata.add(f13); salata.add(f3);
        //4.jelo
        Food f14 = new Food("Maxi", "pizza testo", 250, 112, 2, 89, 59, 11);
        Food f15 = new Food("Zlatiborac", "kackavalj", 150, 110, 5.2, 45, 40, 12.2);
        Food f16 = new Food("Maxi", "pecurke", 100, 69, 11, 12, 5, 24);
        Food f17 = new Food("Zlatiborac", "pizza sunka", 250, 115.4, 11, 15, 8, 4);
        Drink f18 = new Drink("Maxi", "paradajz sos", 200, 25, 1, 5, 2, 2);
        OilsSpicesAndOther f19 = new OilsSpicesAndOther("Maxi","origano", 10, 2, 0, 0.2,0.1,1.2 );
        ArrayList<Nutriment> vecera = new ArrayList<>();
        vecera.add(f14); vecera.add(f15); vecera.add(f16); vecera.add(f17); vecera.add(f18); vecera.add(f19);

        Meal jelo1 = new Meal(dorucak,"Jaja sa slaninom i sirom");
        Meal jelo2 = new Meal(rucak, "Piletina sa pireom i kupus salatom");
        Meal jelo3 = new Meal(salata, "Salata sa tunjevinom");
        Meal jelo4 = new Meal(vecera, "Pizza");
        List<Meal> mealsLIst = new ArrayList<>();
        mealsLIst.add(jelo1); mealsLIst.add(jelo2); mealsLIst.add(jelo3); mealsLIst.add(jelo4);

        //ispisivanje svih jela
        Meals meals = new Meals(mealsLIst);
        System.out.println(meals.toString());
        //proveravanje search metode
        List<Meal> l = meals.search("Jaja");
        Meals ll= new Meals(l);
        System.out.println(ll.toString());
        //proveravanje search metode sa kalorijama
        List<Meal> l2 = meals.search(900);
        Meals ll2 = new Meals(l2);
        System.out.println(ll2.toString());
        //proveravanje search metode sa kalorijama
        List<Meal> l3 = meals.search(1000);
        Meals ll3 = new Meals(l3);
        System.out.println(ll3.toString());
        //proverava nutritivnih vrednosti jela
        System.out.println(jelo1.getName() +"\n"+ jelo1.getKcal() +"\n" + jelo1.getProteins() + "\n" + jelo1.getCarbohydrates() + "\n" + jelo1.getFats() + "\n" + jelo1.getFiber());

        Fridge fridge = new Fridge(dorucak);
        Food f20 = new Food("Idea", "jaja", 72, 300, 24.1 , 17.9, 15, 3.1);
        fridge.add(f20); //prosireno - vec postoji
        Food f21 = new Food("Maxi", "jaja", 72, 300, 24.1 , 17.9, 15, 3.1);
        fridge.add(f21); //dodat- razlikuju se objekti
        //provera u odnosu na frizider- trebalo bi samo dorucak da vrati
        List<Meal> l4 = meals.search(fridge.getNutriments());
        Meals ll4 = new Meals(l4);
        System.out.println(ll4.toString());



    }
}
