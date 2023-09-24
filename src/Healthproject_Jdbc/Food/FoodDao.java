package Healthproject_Jdbc.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodDao {

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;



    //식품 정보 추가
    public boolean AddFood(FoodVo food) {
        try {
            String sql = "INSERT INTO food (foodName, kcal, tan, dan, ji, eatTime, price, gfbf)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, food.foodName);
            statement.setInt(2, food.kcal);
            statement.setInt(3, food.tan);
            statement.setInt(4, food.dan);
            statement.setInt(5, food.ji);
            statement.setInt(6, food.eatTime);
            statement.setInt(7, food.price);
            statement.setString(8, food.gfbf);

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
            String sql ="UPDATE food SET kcal=?, tan=?, dan=?, ji=?, eatTime=?, price=?, gfbf=? " +
                    "WHERE foodName=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, newFood.kcal);
            statement.setInt(2, newFood.tan);
            statement.setInt(3, newFood.dan);
            statement.setInt(4, newFood.ji);
            statement.setInt(5, newFood.eatTime);
            statement.setInt(6, newFood.price);
            statement.setString(7, newFood.gfbf);
            statement.setString(8, newFood.foodName);

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
                int kcal = resultSet.getInt("kcal");
                int tan = resultSet.getInt("tan");
                int dan = resultSet.getInt("dan");
                int ji = resultSet.getInt("ji");
                int eatTime = resultSet.getInt("eatTime");
                int price = resultSet.getInt("price");
                String gfbf = resultSet.getString("gfbf");

                System.out.println("오늘 먹은 음식은 : " + foodName);
                System.out.println("이 음식의 칼로리는? : " + kcal);
                System.out.println("탄수화물량은? : " + tan);
                System.out.println("단백질량은? : " + dan);
                System.out.println("지방량은? : " + ji);
                System.out.println("밥을 먹은 시간대는? : " + eatTime);
                System.out.println("음식에 사용한 돈은? : " + price);
                System.out.println("건강한 식단을 지키셨나요? : " + gfbf);
                System.out.println();
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




