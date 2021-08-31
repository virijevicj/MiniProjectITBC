package miniProject;

import java.util.List;
import java.util.Objects;

public class Meal implements Energy {
    private int id;
    private static int i = 1;
    private List<Nutriment> nutriments; // sta ide u jelo
    private String name; //ime jela

    public Meal(List<Nutriment> nutriments, String name) {
        this.id = i++;
        this.nutriments = nutriments;
        this.name = name;
    }


    public void add(Nutriment n) {
        boolean exist = false;
        int index = 0;
        for (int i = 0; i < nutriments.size(); i++) {
            if (nutriments.get(i).equals(n)) {
                exist = true;
                index = i;
                break;
            }
        }
        if (exist) {
            nutriments.get(index).update(null, null, n.getWeight(), null, null, null, null, null);
        } else {
            nutriments.add(n);
        }
    }

    public void remove(Nutriment n){
        nutriments.remove(n);
    }

    public void remove(Nutriment n, double weight){
        boolean exist = false;
        int index = 0;
        for (int i = 0; i < nutriments.size(); i++) {
            if (nutriments.get(i).equals(n)) {
                exist = true;
                index = i;
                break;
            }
        }
        if (exist) {
            nutriments.get(index).update(null, null, -n.getWeight(), null, null, null, null, null);
        }
    }

    @Override
    public double getKcal() {
        double sum = 0;
        for (Nutriment n : nutriments) {
            sum = sum + n.getKcal();
        }
        return sum;
    }

    public double getProteins(){
        double sum = 0;
        for(Nutriment n : nutriments){
            sum = sum + n.getTotalProteins();
        }
        return sum;
    }

    public double getCarbohydrates(){
        double sum = 0;
        for(Nutriment n : nutriments){
            sum = sum + n.getTotalCarbohydrates();
        }
        return sum;
    }

    public double getFats(){
        double sum = 0;
        for(Nutriment n : nutriments){
            sum = sum + n.getTotalFats();
        }
        return sum;
    }

    public double getFiber(){
        double sum = 0;
        for(Nutriment n : nutriments){
            sum = sum + n.getTotalFiber();
        }
        return sum;
    }

    public List<Nutriment> getNutriments() {
        return nutriments;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Meal meal = (Meal) o;
        if(this.id == meal.id){
            return true;
        }
        return false;
    }

}
