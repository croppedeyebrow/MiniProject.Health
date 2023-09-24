package Healthproject_Jdbc.Food;

public class FoodVo {
    public String foodName; // 식품명
    public int kcal; // 칼로리
    public int tan; // 탄수화물
    public int dan; // 단백질
    public int ji; // 지방
    public int eatTime; // 식사분기
    public int price; // 식단 가격
    public String gfbf; // 식단수준

    public FoodVo(String foodName, int kcal, int tan, int dan, int ji, int eatTime, int price, String gfbf) {
        this.foodName = foodName;
        this.kcal = kcal;
        this.tan = tan;
        this.dan = dan;
        this.ji = ji;
        this.eatTime = eatTime;
        this.price = price;
        this.gfbf = gfbf;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getTan() {
        return tan;
    }

    public void setTan(int tan) {
        this.tan = tan;
    }

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public int getJi() {
        return ji;
    }

    public void setJi(int ji) {
        this.ji = ji;
    }

    public int getEatTime() {
        return eatTime;
    }

    public void setEatTime(int eatTime) {
        this.eatTime = eatTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGfbf() {
        return gfbf;
    }

    public void setGfbf(String gfbf) {
        this.gfbf = gfbf;
    }
}


