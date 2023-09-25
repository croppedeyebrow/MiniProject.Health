package Healthproject_Jdbc.Food;

import Healthproject_Jdbc.Challenge.ChallengeDao;
import Healthproject_Jdbc.MainView.MainViewMain;

import java.sql.Connection;
import java.util.Scanner;

public class FoodMain {
    private static Connection conn;
    private static int RANKTbId;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodDao foodDao = new FoodDao(conn);

        while (true) {
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
                    FoodVo food1 = new FoodVo(0,foodName, 0, 0, 0, 0, 0, 0, 0);
                    boolean added1 = foodDao.AddFood(food1);

                    if (added1) {
                        System.out.println("오늘의 식사 항목이 등록되었어요.");
                    } else {
                        System.out.println("드신 식사를 등록하는데에 실패했어요.");
                    }
                    break;


                case 2:
                    System.out.print("하루 동안 먹은 음식의 칼로리는?: ");
                    int totalCalories = 0;

                    System.out.print("아침에 먹은 음식의 칼로리를 입력하세요: ");
                    int breakfastCalories = scanner.nextInt();
                    totalCalories += breakfastCalories;

                    System.out.print("점심에 먹은 음식의 칼로리를 입력하세요: ");
                    int lunchCalories = scanner.nextInt();
                    totalCalories += lunchCalories;

                    System.out.print("저녁에 먹은 음식의 칼로리를 입력하세요: ");
                    int dinnerCalories = scanner.nextInt();
                    totalCalories += dinnerCalories;


                    scanner.nextLine();
                    FoodVo food2 = new FoodVo(0,"", totalCalories, 0, 0, 0, 0, 0, 0);
                    boolean added2 = foodDao.AddFood(food2);

                    if (added2) {
                        System.out.println("칼로리가 추가되었습니다.");
                    } else {
                        System.out.println("칼로리 추가 실패.");
                    }
                    break;

                case 3:
                    System.out.print("하루 동안의 탄/단/지를 입력해주세요: ");
                    int ftanTotal = 0; // 탄수화물 누적 변수
                    int fdanTotal = 0; // 단백질 누적 변수
                    int fjiTotal = 0;  // 지방 누적 변수

// 아침, 점심, 저녁 각각의 탄/단/지를 입력 받아 누적합니다.
                    System.out.print("아침 식단 탄수화물 입력: ");
                    int breakfastTan = scanner.nextInt();
                    ftanTotal += breakfastTan;

                    System.out.print("아침 식단 단백질 입력: ");
                    int breakfastDan = scanner.nextInt();
                    fdanTotal += breakfastDan;

                    System.out.print("아침 식단 지방 입력: ");
                    int breakfastJi = scanner.nextInt();
                    fjiTotal += breakfastJi;

                    System.out.print("점심 식단 탄수화물 입력: ");
                    int lunchTan = scanner.nextInt();
                    ftanTotal += lunchTan;

                    System.out.print("점심 식단 단백질 입력: ");
                    int lunchDan = scanner.nextInt();
                    fdanTotal += lunchDan;

                    System.out.print("점심 식단 지방 입력: ");
                    int lunchJi = scanner.nextInt();
                    fjiTotal += lunchJi;

                    System.out.print("저녁 식단 탄수화물 입력: ");
                    int dinnerTan = scanner.nextInt();
                    ftanTotal += dinnerTan;

                    System.out.print("저녁 식단 단백질 입력: ");
                    int dinnerDan = scanner.nextInt();
                    fdanTotal += dinnerDan;

                    System.out.print("저녁 식단 지방 입력: ");
                    int dinnerJi = scanner.nextInt();
                    fjiTotal += dinnerJi;

                    FoodVo food3 = new FoodVo(0,"", 0, ftanTotal, fdanTotal, fjiTotal, 0, 0, 0);
                    boolean added3 = foodDao.AddFood(food3);

                    if (added3) {
                        System.out.println("탄/단/지를 정상적으로 추가했어요.");
                    } else {
                        System.out.println("탄/단/지를 다시 입력해주세요.");
                    }
                    break;

                case 4:
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
                    FoodVo food4 = new FoodVo(0,"", 0, 0, 0, 0, eatTimeChoice, 0, 0);
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
                    int totalspent =0;
                    scanner.nextLine();
                    totalspent +=price;
                    FoodVo food5 = new FoodVo(0,"", 0, 0, 0, 0, 0, totalspent, 0);
                    boolean added5 = foodDao.AddFood(food5);

                    if (added5) {
                        System.out.println("가격이 추가되었습니다.");
                    } else {
                        System.out.println("가격 추가 실패.");
                    }
                    break;

                case 7:
                    System.out.println("메인메뉴로 돌아갑니다 : ");
                    MainViewMain.main(args);
                    return;


                case 8:
                    System.out.println("프로그램을 종료합니다.");
                    foodDao.close();
                    System.exit(0);


                case 6:
                    System.out.print("건강한 식단 체크하러 가기 : ");
                    int gfbfChoice = scanner.nextInt();
                    scanner.nextLine();

                    // 아침, 점심, 저녁에 대한 점수를 각각 입력 받습니다.
                    System.out.print("아침 식단을 지켰나요? [1]yes [2]no: ");
                    int breakfast = scanner.nextInt();

                    System.out.print("점심 식단을 지켰나요? [1]yes [2]no: ");
                    int lunch = scanner.nextInt();

                    System.out.print("저녁 식단을 지켰나요? [1]yes [2]no: ");
                    int dinner = scanner.nextInt();



                        boolean updated = ChallengeDao.UpdateTotalScore(RANKTbId, breakfast,lunch,dinner, 5);

                        if (updated) {
                            System.out.println("건강한 식단 정보가 추가되었습니다.");
                        } else {
                            System.out.println("건강한 식단 정보 추가 실패.");
                        }
                        break;



                    }

            }

        }
    }

