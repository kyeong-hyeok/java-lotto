public enum LottoRank {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5);

    private final int rank;

    LottoRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
