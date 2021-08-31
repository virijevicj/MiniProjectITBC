package miniProject;

import java.util.List;

public class Fridge {
    private List<Nutriment> nutriments;

    public Fridge(List<Nutriment> nutriments) {
        this.nutriments = nutriments;
    }

    public List<Nutriment> getNutriments() {
        return nutriments;
    }

    //Методе:
    //add(Nutriment n)
    //Додаје у листу ако већ не постоји
    //Ако већ постоји, додати повећати његову масу
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
            System.out.println("prosireno");
        } else {
            nutriments.add(n);
            System.out.println("dodat");
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
}
