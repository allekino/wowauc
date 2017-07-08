package items;

/**
 * Created by tabtab on 6/29/2017.
 */
public class Auction {
    String auc;
    public int item;
    public long bid;
    public long buyout;
    public int quantity;

    public Auction(Auction a) {
        this.auc = a.auc;
        this.item = a.item;
        this.bid = a.bid;
        this.buyout = a.buyout;
        this.quantity = a.quantity;
    }
}
