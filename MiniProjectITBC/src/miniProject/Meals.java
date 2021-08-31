package miniProject;

import java.util.ArrayList;
import java.util.List;

public class Meals {
    private List<Meal> meals;

    public Meals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void add(Meal m) {
        for (Meal x : meals) {
            if (x.equals(m)) {
                return;
            }
        }
        meals.add(m);
    }

    public void remove(Meal m) {
        for (int i = 0; i < meals.size(); i++) {
            if (meals.get(i).equals(m)) {
                meals.remove(i);
                return;
            }
        }
    }

    public List<Meal> search(String s) {
        List<Meal> returnList = new ArrayList<>();
        for (Meal m : meals) {
            if (m.getName().contains(s)) {
                returnList.add(m);
            }
        }
        return returnList;
    }
    //toString() - Исписује сва јела:
    //[{ id }] | Name: { name }
    //нпр. [57b53f64-0809-11ec-9a03-0242ac130003] | Name: Шпагете са

    @Override
    public String toString() {
        String returnMsg = "";
        for (Meal m : meals) {
            returnMsg = returnMsg.concat("[" + m.getId() + "]").concat(" | Name: " + m.getName() + "\n");
        }
        return returnMsg;
    }

    //List<Meal> search(double kcal) - Враћа сва јела са мање од kcal калорија
    public List<Meal> search(double kcal) {
        List<Meal> returnList = new ArrayList<>();
        for (Meal m : meals) {
            double sumKcal = m.getKcal();
            if (sumKcal < kcal) {
                returnList.add(m);
            }
        }
        return returnList;
    }

    //*List<Meal> search(List<Nutriment> nutriment) - Враћа она јела која могу да се
    //направе уз помоћ прослеђене листе намирница
    //Коришћење: Корисник унесе све што има у фрижидеру, метода му враћа све
    //што може да направи уз помоћ ствари које већ има ; *Додатно: Шта ако желимо да претражујемо по више параметара?
    public List<Meal> search(List<Nutriment> nutriment) {
        List<Meal> returnList = new ArrayList<>();
        for (Meal m : meals) {
            List<Nutriment> tmpMealNutriment = m.getNutriments();
            int i = 0;
            boolean exists = false;

            for (int j = 0; j < tmpMealNutriment.size(); j++) {
                for (int k = 0; k < nutriment.size(); k++) {
                    if(tmpMealNutriment.get(j).equals(nutriment.get(k))){ //koristimo poredjenje preko kompanije i imena
                        exists = true;
                        break;
                    }
                }
                if(exists){
                    i++; //ako si naso taj jedan sastojak povecaj i za 1; treba da nadjemo sastojaka koliko je duzina list<nutriment> nutriment
                    //to mozemo jer su sastojci jedinstveni(povecava se gramaza kad se unosi isti a ne dodaje se nov nutritijent) i zato brisemo iz liste da ne radimo i++ za isti nutritijent vise od jednom
                }
            }
            if(i == nutriment.size()){
                returnList.add(m);
            }
        }
        return returnList;
    }

}

