public class Winning {

    int threeWinningCnt;
    int fourWinningCnt;
    int fiveWinningCnt;
    int fiveBonusWinningCnt;
    int sixWinningCnt;

    public Winning(int threeWinningCnt, int fourWinningCnt, int fiveWinningCnt, int fiveBonusWinningCnt, int sixWinningCnt) {
        this.threeWinningCnt = threeWinningCnt;
        this.fourWinningCnt = fourWinningCnt;
        this.fiveWinningCnt = fiveWinningCnt;
        this.fiveBonusWinningCnt = fiveBonusWinningCnt;
        this.sixWinningCnt = sixWinningCnt;
    }

    public int receiveWinningMoney() {
        return WinningPrice.THREE.getPrice() * threeWinningCnt
                + WinningPrice.FOUR.getPrice() * fourWinningCnt
                + WinningPrice.FIVE.getPrice() * fiveWinningCnt
                + WinningPrice.FIVE_BONUS.getPrice() * fiveBonusWinningCnt
                + WinningPrice.SIX.getPrice() * sixWinningCnt;
    }

    public double calculateTotalRate(int cnt) {
        return Math.round((double)receiveWinningMoney() / (cnt * 1000) * 100.0) / 100.0;
    }
}
