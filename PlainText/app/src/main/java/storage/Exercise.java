package storage;

public class Exercise {
    private int idExercise;
    private String type;
    private String firstExercise;
    private String secondExercise;
    private String thirdExercise;
    private String date;

    public Exercise(int idExercise, String type, String firstExercise, String secondExercise, String thirdExercise, String date) {
        this.idExercise = idExercise;
        this.type = type;
        this.firstExercise = firstExercise;
        this.secondExercise = secondExercise;
        this.thirdExercise = thirdExercise;
        this.date = date;
    }



    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstExercise() {
        return firstExercise;
    }

    public void setFirstExercise(String firstExercise) {
        this.firstExercise = firstExercise;
    }

    public String getSecondExercise() {
        return secondExercise;
    }

    public void setSecondExercise(String secondExercise) {
        this.secondExercise = secondExercise;
    }

    public String getThirdExercise() {
        return thirdExercise;
    }

    public void setThirdExercise(String thirdExercise) {
        this.thirdExercise = thirdExercise;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
