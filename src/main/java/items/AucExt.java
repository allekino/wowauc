package items;

/**
 * Created by tabtab on 7/7/2017.
 */
public class AucExt extends Auction {
    public long singlePrice;

    public AucExt(Auction a) {
        super(a);
        singlePrice = a.buyout / a.quantity / 10000;
    }
}
