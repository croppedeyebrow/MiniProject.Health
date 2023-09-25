package Healthproject_Jdbc.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodDao {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public FoodDao(Connection conn) {
        this.conn=conn;
    }



    //식품 정보 추가
    public boolean AddFood(FoodVo food) {
        try {
            String sql = "INSERT INTO food (foodName, fCal, fTan, fDan, fJi, eatTime, fPrice, healthyGbn)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, food.getFoodName());
            statement.setInt(2, food.getfCal());
            statement.setInt(3, food.getfTan());
            statement.setInt(4, food.getfDan());
            statement.setInt(5, food.getfJi());
            statement.setInt(6, food.getEatTime());
            statement.setInt(7, food.getfPrice());
            statement.setInt(8, food.getHealthyGbn());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    //식품 정보 삭제
    public boolean deleteFood(String foodName) {
        try {
            String sql = "DELETE FROM food WHERE foodName=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, foodName);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    //식품 정보 수정
    public boolean updateFood(String foodname, FoodVo newFood) {
        try {
            String sql ="UPDATE food SET fCal=?, fTan=?, fDan=?, fJi=?, eatTime=?, fPrice=?, healthyGbn=? " +
                    "WHERE foodName=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, newFood.getfCal());
            statement.setInt(2, newFood.getfTan());
            statement.setInt(3, newFood.getfDan());
            statement.setInt(4, newFood.getfJi());
            statement.setInt(5, newFood.getEatTime());
            statement.setInt(6, newFood.getfPrice());
            statement.setInt(7, newFood.getHealthyGbn());
            statement.setString(8, newFood.getFoodName());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    //식품 정보 조회

    public  void SearchFood() {
        try {
            String sql = "SELECT * FROM FOOD";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String foodName = resultSet.getString("foodName");
                int fCal = resultSet.getInt("fCal");
                int fTan = resultSet.getInt("fTan");
                int fDan = resultSet.getInt("fDan");
                int fJi = resultSet.getInt("fJi");
                int eatTime = resultSet.getInt("eatTime");
                int fPrice = resultSet.getInt("fPrice");
                int healthyGbn = resultSet.getInt("healthyGbn");

                System.out.println("오늘 먹은 음식은 : " + foodName);
                System.out.println("이 음식의 칼로리는? : " + fCal);
                System.out.println("탄수화물량은? : " + fTan);
                System.out.println("단백질량은? : " + fDan);
                System.out.println("지방량은? : " + fJi);
                System.out.println("밥을 먹은 시간대는? : " + eatTime);
                System.out.println("음식에 사용한 돈은? : " + fPrice);
                System.out.println("건강한 식단을 지키셨나요? : " + healthyGbn);
                System.out.println();

                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




