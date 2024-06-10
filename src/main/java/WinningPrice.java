public enum WinningPrice {

    THREE(5000), FOUR(50000), FIVE(1500000), FIVE_BONUS(30000000), SIX(2000000000);

    private int price;

    WinningPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
