package miniProject;

public abstract class Nutriment extends Grocery {
    private double weight; // u gramima
    private double kcal; // kalorije na 100g
    private double proteins; // proteini na 100g
    private double carbohydrates; //ugljeni hidrati na 100g
    private double fats; // masti na 100g
    private double fiber; //vlakna na 100g

    public Nutriment(String company, String name, double weight, double kcal, double proteins, double carbohydrates, double fats, double fiber) {
        super(company, name);
        this.weight = weight;
        this.kcal = kcal;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.fiber = fiber;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public double getKcal() {
        return (kcal / 100) * weight;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public double getFiber() {
        return fiber;
    }

    public void update(String company, String name, Double weight, Double kcal, Double proteins, Double carbohydrates, Double fats, Double fiber){
        if(company != null){
            setCompany(company);
        }
        if(name != null){
            setName(name);
        }
        if(weight != null){
            this.weight += weight;
        }
        if(kcal != null){
            this.kcal += kcal;
        }
        if(proteins != null){
            this.proteins += proteins;
        }
        if(carbohydrates != null){
            this.carbohydrates += carbohydrates;
        }
        if(fats != null){
            this.fats += fats;
        }
        if(fiber != null){
            this.fiber += fiber;
        }
    }

    public double getTotalProteins(){
        return weight * (proteins / 100);
    }

    public double getTotalCarbohydrates(){
        return weight * (carbohydrates / 100);
    }

    public double getTotalFats(){
        return weight * (fats / 100);
    }

    public double getTotalFiber(){
        return weight * (fiber / 100);
    }

    public double sumOfNutriment(){ //verovatno nije na ovo mislio
        return getTotalProteins() + getTotalCarbohydrates() + getTotalFats() + getTotalFiber();
    }

//   @Override //--> jedna ideja; ako se trazi npr procenat proteina na 100 grama u odnosu na ukupnu kolicinu proteina na nekoj kilazi zaokruzeno na 2 decimale(vrv ne to)
//    public String returnMSg() {
//        String returnMsg = "Company: " + getCompany() + "\nName: " + getName() + "\nWeight: 100g\n" + "Kcal: " + kcal + "\n" +
//                           "Proteins: " + (Math.round((proteins / getTotalProteins()) * 10000.0) / 100) + "%\n" +
//                           "Carbohydrates: " + (Math.round((carbohydrates / getTotalCarbohydrates()) * 10000.0) / 100) + "%\n" +
//                           "Fats: " + (Math.round((fats / getTotalFats()) * 10000.0) / 100) + "%\n" +
//                           "Fiber: " + (Math.round((fiber / getTotalFiber()) * 10000.0) / 100) + "%\n";
//       return returnMsg;
//    }

    @Override //ako se podrazumeva da samo ova 4 svojstva mogu da se gledaju kao hranljive vrednosti onda mozemo samo da ispisemo kolicinu proteina na 100 grama i + % itd...
    public String toString() {
        String returnMsg = "Company: " + getCompany() + "\nName: " + getName() + "\nWeight: 100g\n" + "Kcal: " + kcal + "\n" +
                           "Proteins: " + proteins + "%\n" + "Carbohydrates: " + carbohydrates + "%\n" + "Fats: " + fats + "%\n" + "Fiber: " + "%";
        return returnMsg; //kao string sa svaki slucaj ako zatreba za neki ispis posle za neku petlju ili slicno
    }

    public String totalNutrientTable(){ //isto string ako zatreba za kasnije
        String returnMassage = "Company: " + getCompany() + "\nName: " + getName() + "\nWeight: " + weight + "\nKcal: " + getKcal() + "\n" +
                           "Proteins: " + getTotalProteins() + "\n" +
                           "Carbonhydrates: " + getTotalCarbohydrates() + "\n" +
                           "Fats: " + getTotalFats() + "\n" +
                           "Fiber: " + getTotalFiber();
        return returnMassage;
    }
}
