package items;

/**
 * Created by tabtab on 7/7/2017.
 */
public class AucExt extends Auction {
    private String auc;
    public int item;
    public long bid;
    public long buyout;
    public int quantity;

    public long singlePrice;

    public AucExt(Auction a) {
        singlePrice = a.buyout / a.quantity / 10000;
        auc = a.auc;
        item = a.item;
        bid = a.bid;
        buyout = a.buyout;
        quantity = a.quantity;
    }
}
