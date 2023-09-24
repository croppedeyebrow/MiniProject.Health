package Healthproject_Jdbc.Food;

import Healthproject_Jdbc.MainView.MainViewMain;

import java.util.Scanner;

public class FoodMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodDao foodDao = new FoodDao();

        while(true) {
            System.out.println("==========식품 정보==========");
            System.out.println("[1] 오늘 먹은 음식은? : ");
            System.out.println("[2] 이 음식의 칼로리는? : ");
            System.out.println("[3] 탄/단/지를 입력해주세요 : ");
            System.out.println("[4] 밥을 먹은 시간대는? : [1]아침 [2]점심 [3]저녁 ");
            System.out.println("[5] 음식에 사용한 돈은? : ");
            System.out.println("[6] 건강한 식단을 지키셨나요? [1]yes [2]no");
            System.out.println("[7] 메인메뉴로 돌아가기");
            System.out.println("[8] 종료");

            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    System.out.print("오늘 먹은 음식은 무엇인가요?? : ");
                    String foodName = scanner.nextLine();
                    FoodVo food1 = new FoodVo(foodName,0,0,0,0,0,0, "");
                    boolean added1 = foodDao.AddFood(food1);

                    if (added1) {
                        System.out.println("오늘의 식사 항목이 등록되었어요.");
                    } else {
                        System.out.println("드신 식사를 등록하는데에 실패했어요.");
                    }
                    break;


                case 2 :
                    System.out.print("이 음식의 칼로리는?: ");
                    int kcal = scanner.nextInt();
                    scanner.nextLine();
                    FoodVo food2 = new FoodVo("", kcal, 0, 0, 0, 0, 0, "");
                    boolean added2 = foodDao.AddFood(food2);

                    if (added2) {
                        System.out.println("칼로리가 추가되었습니다.");
                    } else {
                        System.out.println("칼로리 추가 실패.");
                    }
                    break;

                case 3 :
                    System.out.print("탄/단/지를 입력해주세요: ");
                    int tan = scanner.nextInt();
                    int dan = scanner.nextInt();
                    int ji = scanner.nextInt();
                    scanner.nextLine();
                    FoodVo food3 = new FoodVo("", 0, tan, dan, ji, 0, 0, "");
                    boolean added3 = foodDao.AddFood(food3);

                    if (added3) {
                        System.out.println("탄/단/지를 정상적으로 추가했어요.");
                    } else {
                        System.out.println("탄/단/지를 다시 입력해주세요.");
                    }
                    break;

                case 4 :
                    System.out.print("밥을 먹은 시간대는? : [1]아침 [2]점심 [3]저녁 ");
                    int eatTimeChoice = scanner.nextInt();
                    scanner.nextLine();

                    String eatTime;
                    switch (eatTimeChoice) {
                        case 1:
                            eatTime = "1";
                            break;
                        case 2:
                            eatTime = "2";
                            break;
                        case 3:
                            eatTime = "3";
                            break;
                        default:
                            System.out.println("잘못된 선택입니다.");
                            continue;
                    }
                    FoodVo food4 = new FoodVo("", 0, 0, 0, 0, eatTimeChoice, 0, "");
                    boolean added4 = foodDao.AddFood(food4);


                    if (added4) {
                        System.out.println("식사시간을 정상적으로 추가했어요.");
                    } else {
                        System.out.println("식사시간을 다시 입력해주세요.");
                    }
                    break;

                case 5:
                    System.out.print("음식에 사용한 돈은? : ");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    FoodVo food5 = new FoodVo("", 0, 0, 0, 0, 0, price, "");
                    boolean added5 = foodDao.AddFood(food5);

                    if (added5) {
                        System.out.println("가격이 추가되었습니다.");
                    } else {
                        System.out.println("가격 추가 실패.");
                    }
                    break;


                case 6 :
                    System.out.print("건강한 식단을 지키셨나요? [1]yes [2]no ");
                    int gfbfChoice = scanner.nextInt();
                    scanner.nextLine();

                    int gfbf;
                    switch (gfbfChoice) {
                        case 1:
                            gfbf = 1;
                            break;
                        case 2:
                            gfbf = 2;
                            break;
                        default:
                            System.out.println("잘못된 선택입니다. [1] 또는 [2] 중에서 선택해주세요.");
                            continue; // 다시 선택 메뉴로 돌아가기
                    }
                    FoodVo food6 = new FoodVo("", 0, 0, 0, 0, 0, 0, String.valueOf(gfbf));
                    boolean added6 = foodDao.AddFood(food6);

                    if (added6) {
                        System.out.println("건강한 식단 정보가 추가되었습니다.");
                    } else {
                        System.out.println("건강한 식단 정보 추가 실패.");
                    }
                    break;


                case 7 :
                    System.out.println("메인메뉴로 돌아갑니다 : ");
                    MainViewMain.main(args);
                    return;


                case 8 :
                    System.out.println("프로그램을 종료합니다.");
                    foodDao.close();
                    System.exit(0);






            }

        }

    }
}
