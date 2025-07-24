package homeworks.homework03;

public class TV {
    private String manufacturerTV;
    private String modelTV;
    private int diagonalScreen;
    private String resolutionScreen;
    private String typeMatrix;

    public TV(String manufacturerTV, String modelTV, int diagonalScreen,
              String resolutionScreen, String typeMatrix) {
        this.manufacturerTV = manufacturerTV;
        this.modelTV = modelTV;
        this.diagonalScreen = diagonalScreen;
        this.resolutionScreen = resolutionScreen;
        this.typeMatrix = typeMatrix;
    }

    public TV(String modelTV, int diagonalScreen, String resolutionScreen,
              String typeMatrix) {
        manufacturerTV = "Samsung";
        this.modelTV = modelTV;
        this.diagonalScreen = diagonalScreen;
        this.resolutionScreen = resolutionScreen;
        this.typeMatrix = typeMatrix;
    }

    public TV() {
        manufacturerTV = "Горизонт";
        modelTV = "Ц-355";
        diagonalScreen = 20;
        resolutionScreen = "200x100";
        typeMatrix = "Wake up Neo... The Matrix has you";
    }

    public void turnOnTV() {
        System.out.println("Телевизор " + getManufacturerTV() + " включён.");
    }

    public void turnOffTV() {
        System.out.println("Телевизор " + getManufacturerTV() + " выключен.");
    }

    public String getManufacturerTV() {
        return manufacturerTV;
    }

    public void setManufacturerTV(String manufacturerTV) {
        this.manufacturerTV = manufacturerTV;
    }

    public String getModelTV() {
        return modelTV;
    }

    public void setModelTV(String modelTV) {
        this.modelTV = modelTV;
    }

    public int getDiagonalScreen() {
        return diagonalScreen;
    }

    public void setDiagonalScreen(int diagonalScreen) {
        this.diagonalScreen = diagonalScreen;
    }

    public String getResolutionScreen() {
        return resolutionScreen;
    }

    public void setResolutionScreen(String resolutionScreen) {
        this.resolutionScreen = resolutionScreen;
    }

    public String getTypeMatrix() {
        return typeMatrix;
    }

    public void setTypeMatrix(String typeMatrix) {
        this.typeMatrix = typeMatrix;
    }

    @Override public String toString() {
        return "Производитель: " + manufacturerTV + "\nМодель: " + modelTV
                + "\nДиагональ экрана: " + diagonalScreen + "\nРазрешение экрана: "
                + resolutionScreen + "\nТип матрицы: " + typeMatrix;
    }
}