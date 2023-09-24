package Healthproject_Jdbc.Login;

import Healthproject_Jdbc.common.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public boolean LoginUser(LoginVo loginVo) {
        try (Connection connection = Common.getConnection()) {
            String sql = "SELECT * FROM USER_INFO WHERE USER_ID = ? AND USER_PW = ?";


            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, loginVo.getUser_id());
                preparedStatement.setString(2, loginVo.getUser_pw());

                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return false;

            }
    }



}
