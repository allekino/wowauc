package utils;

import items.Auc;
import items.AucExt;
import items.Auction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by death on 7/8/2017.
 */
public class GetItems {

    static List<Auction> auctionsBase;

    public GetItems() {
        update();
    }

    public static void update() {
        WOWAPI wowapi = new WOWAPI();
        Auc auc = wowapi.getJson(wowapi.getUrl(), Auc.class);
        auctionsBase = auc.auctions;
    }

    public static List<AucExt> getItems(int itemId) {
        if (auctionsBase == null) {
            new GetItems();
        }
        List<AucExt> auctions = new ArrayList<>();
        auctionsBase.forEach(n -> auctions.add(new AucExt(n)));

        List<AucExt> res = auctions.stream().filter(a -> a.item == itemId).collect(Collectors.toList());
        return res;
    }
}
