public class SameNumberCount {

    int threeCnt;
    int fourCnt;
    int fiveCnt;
    int fiveBonusCnt;
    int sixCnt;

    public SameNumberCount(int threeCnt, int fourCnt, int fiveCnt, int fiveBonusCnt, int sixCnt) {
        this.threeCnt = threeCnt;
        this.fourCnt = fourCnt;
        this.fiveCnt = fiveCnt;
        this.fiveBonusCnt = fiveBonusCnt;
        this.sixCnt = sixCnt;
    }

    public int receiveMoney() {
        return WinningPrice.THREE.getPrice() * threeCnt
                + WinningPrice.FOUR.getPrice() * fourCnt
                + WinningPrice.FIVE.getPrice() * fiveCnt
                + WinningPrice.FIVE_BONUS.getPrice() * fiveBonusCnt
                + WinningPrice.SIX.getPrice() * sixCnt;
    }
}
