package Healthproject_Jdbc.MainView;

import Healthproject_Jdbc.Challenge.ChallengeMain;
import Healthproject_Jdbc.JoinMember.JoinMemberMain;
import Healthproject_Jdbc.Login.HealthLoginMain;
import Healthproject_Jdbc.TotalControl.TotalControlMain;

import java.util.Scanner;

public class MainViewMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("==========당신의 운동 비서==========");
            System.out.println("원하는 작업을 선택하세요 (1/2/3/4):  ");
            System.out.println("[1] 전체 관리 현황:  ");
            System.out.println("[2] 상세 관리 메뉴:  ");
            System.out.println("[3] 챌린지 ");
            System.out.println("[4] 로그아웃 ");


            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TotalControlMain.main(args);
                    break;
                case 2:
                    DetailMain.main(args);
                    break;
                case 3:
                    ChallengeMain.main(args);
                    return;

                case 4:
                    System.out.println("로그아웃 되었습니다.");
                    HealthLoginMain.main(args);
                    return;

                default:
                    System.out.println("선택하신 사항이 올바르지 않습니다. 다시 고르세요.");
                    break;
            }
        }
    }
}






