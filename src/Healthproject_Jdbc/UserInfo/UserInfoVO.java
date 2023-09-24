package Healthproject_Jdbc.UserInfo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

public class UserInfoVO {
    private String user_id;
    private String user_pw;
    private String user_name;
    private int user_birth;
    private double user_height;
    private double user_weight;
    private double user_goal_weight;
    private Timestamp user_created_on;
    private int rankId;


    public UserInfoVO( String user_id, String user_pw, String user_name, int user_birth, double user_height, double user_weight, double user_goal_weight, Timestamp user_created_on) {
        this.user_id = user_id;
        this.user_pw = user_pw;
        this.user_name = user_name;
        this.user_birth = user_birth;
        this.user_height = user_height;
        this.user_weight = user_weight;
        this.user_goal_weight = user_goal_weight;
        this.user_created_on = user_created_on;
        this.rankId = rankId;


    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(int user_birth) {
        this.user_birth = user_birth;
    }

    public double getUser_height() {
        return user_height;
    }

    public void setUser_height(double user_height) {
        this.user_height = user_height;
    }

    public double getUser_weight() {
        return user_weight;
    }

    public void setUser_weight(double user_weight) {
        this.user_weight = user_weight;
    }

    public double getUser_goal_weight() {
        return user_goal_weight;
    }

    public void setUser_goal_weight(double user_goal_weight) {
        this.user_goal_weight = user_goal_weight;
    }

    public Timestamp getUser_created_on() {
        return user_created_on;
    }

    public void setUser_created_on(Timestamp user_created_on) {
        this.user_created_on = user_created_on;
    }

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public UserInfoVO() {
    }
}





