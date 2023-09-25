package Healthproject_Jdbc.Challenge;

public class ChallengeVo {

    private int RANK_TB_ID;        // 사용자 ID
    private int TOTAL_SCORE;  // 누적 점수
    private int AVG_SCORE;   // 평균 점수
    private int rank;            // 순위

    public ChallengeVo(int RANK_TB_ID, int TOTAL_SCORE, int AVG_SCORE, int rank) {
        this.RANK_TB_ID = RANK_TB_ID;
        this.TOTAL_SCORE = TOTAL_SCORE;
        this.AVG_SCORE = AVG_SCORE;
        this.rank = rank;

    }

    public int getRANK_TB_ID() {
        return RANK_TB_ID;
    }

    public void setRANK_TB_ID(int RANK_TB_ID) {
        this.RANK_TB_ID = RANK_TB_ID;
    }

    public int getTOTAL_SCORE() {
        return TOTAL_SCORE;
    }

    public void setTOTAL_SCORE(int TOTAL_SCORE) {
        this.TOTAL_SCORE = TOTAL_SCORE;
    }

    public int getAVG_SCORE() {
        return AVG_SCORE;
    }

    public void setAVG_SCORE(int AVG_SCORE) {
        this.AVG_SCORE = AVG_SCORE;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}






