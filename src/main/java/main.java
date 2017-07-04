import items.Auc;
import items.Auction;
import utils.WOWAPI;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tabtab on 6/28/2017.
 */
public class main {
    static String getAuctions = "http://auction-api-eu.worldofwarcraft.com/auction-data/ef92b9868d1316c1066e9fb5e6d979a0/auctions.json";
    static String url;

    public static void main(String[] args) {
        Auc auc = new WOWAPI().getAucJson(getAuctions, Auc.class);
        List<Auction> auctions = auc.auctions;
        List<Auction> dreamleafs = auctions.stream().filter(a -> a.item == 124102).collect(Collectors.toList());

        List<Auction> filtered = dreamleafs.stream()
                .filter(d -> Math.abs(d.buyout / 100 / d.quantity) < 1800)
                .collect(Collectors.toList());

    }
}
