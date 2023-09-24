package Healthproject_Jdbc.Login;

import Healthproject_Jdbc.MainView.MainViewMain;
import Healthproject_Jdbc.common.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HealthLoginMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("원하는 작업을 선택하세요 (1/2): ");
            System.out.println("1. 아이디/비밀번호 입력");
            System.out.println("2. 초기화면으로 나가기");



            int choice = scanner.nextInt();


              switch (choice) {


                 case 1:

                    System.out.print("갓생러의 당신의 아이디는 :  ");
                    String userId = scanner.nextLine();

                    System.out.print("당신의 비밀번호는 :  ");
                    String password = scanner.nextLine();

                    LoginVo loginVo = new LoginVo(" 갓생러의 당신의 아이디는", "당신의 비밀번호는");
                    loginVo.setUser_id(userId);
                    loginVo.setUser_pw(password);

                    LoginDao loginDao = new LoginDao();
                    boolean loginResult = loginDao.LoginUser(loginVo);

                    if (loginResult) {
                        System.out.println("어서오세요 환영합니다.");

                        MainViewMain mainViewMain = new MainViewMain();
                        mainViewMain.main(args);


                    } else {
                        System.out.println("로그인 실패 : ID/PW를 다시 한번 확인해주세요.");
                    }
                    break;

                case 2:
                    System.out.println("초기 화면으로 돌아갑니다");
                    return;
                default:
                    System.out.println("올바른 선택을 하지 않았습니다. 다시 선택해주세요");
                    break;

            }
        }
    }
}







