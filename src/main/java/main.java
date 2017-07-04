import items.Auc;
import items.Auction;
import utils.WOWAPI;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tabtab on 6/28/2017.
 */
public class main {

    static String url;

    public static void main(String[] args) {
        WOWAPI wowapi = new WOWAPI();
        Auc auc = wowapi.getJson(wowapi.getUrl(), Auc.class);
        List<Auction> auctions = auc.auctions;
        List<Auction> dreamleafs = auctions.stream().filter(a -> a.item == 124102).collect(Collectors.toList());

        List<Auction> filtered = dreamleafs.stream()
                .filter(d -> Math.abs(d.buyout / 100 / d.quantity) < 1800)
                .collect(Collectors.toList());

    }
}
