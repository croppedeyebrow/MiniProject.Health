package Healthproject_Jdbc.FirstVIEW;

import Healthproject_Jdbc.JoinMember.JoinMemberMain;
import Healthproject_Jdbc.Login.HealthLoginMain;
import jdk.jfr.StackTrace;

import java.util.Scanner;

public class FirstVIEMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("==========당신의 운동 비서==========");
            System.out.println("원하는 작업을 선택하세요 (1/2/3):  ");
            System.out.println(" [1] 로그인하기:  ");
            System.out.println("[2] 회원가입하기:  ");
            System.out.println("[3] 서비스 종료하기");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    HealthLoginMain.main(args);
                    break;
                case 2:
                    JoinMemberMain.main(args);
                    break;
                case 3:
                    System.out.println("서비스를 종료합니다.");
                    return;
                default:
                    System.out.println("선택하신 사항이 올바르지 않습니다. 다시 고르세요.");
                    break;
            }
        }
    }
}

