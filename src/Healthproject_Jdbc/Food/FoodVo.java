package Healthproject_Jdbc.Food;

public class FoodVo {
    private int foodID;
    private String foodName; // 식품명
    private int fCal; // 칼로리
    private int fTan; // 탄수화물량
    private int fDan; // 단백질량
    private int fJi; // 지방량
    private int eatTime; // 식사시간대
    private int fPrice; // 식단 가격
    private int healthyGbn; // 건강식단여부

    public FoodVo(int foodID, String foodName, int fCal, int fTan, int fDan, int fJi, int eatTime, int fPrice, int healthyGbn) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.fCal = fCal;
        this.fTan = fTan;
        this.fDan = fDan;
        this.fJi = fJi;
        this.eatTime = eatTime;
        this.fPrice = fPrice;
        this.healthyGbn = healthyGbn;

    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getfCal() {
        return fCal;
    }

    public void setfCal(int fCal) {
        this.fCal = fCal;
    }

    public int getfTan() {
        return fTan;
    }

    public void setfTan(int fTan) {
        this.fTan = fTan;
    }

    public int getfDan() {
        return fDan;
    }

    public void setfDan(int fDan) {
        this.fDan = fDan;
    }

    public int getfJi() {
        return fJi;
    }

    public void setfJi(int fJi) {
        this.fJi = fJi;
    }

    public int getEatTime() {
        return eatTime;
    }

    public void setEatTime(int eatTime) {
        this.eatTime = eatTime;
    }

    public int getfPrice() {
        return fPrice;
    }

    public void setfPrice(int fPrice) {
        this.fPrice = fPrice;
    }

    public int getHealthyGbn() {
        return healthyGbn;
    }

    public void setHealthyGbn(int healthyGbn) {
        this.healthyGbn = healthyGbn;
    }
}


