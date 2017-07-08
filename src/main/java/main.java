import items.Auc;
import items.AucExt;
import items.Auction;
import utils.WOWAPI;

import java.util.ArrayList;
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
        List<Auction> auctionsBase = auc.auctions;

        List<AucExt> auctions = new ArrayList<>();
        auctionsBase.stream().forEach(n -> auctions.add(new AucExt(n)));

        List<AucExt> dreamleafs = auctions.stream().filter(a -> a.item == 124102).collect(Collectors.toList());

        List<List<Auction>> lists = new ArrayList<>();


        for (int i = 0; i < 25; i++) {
            int finalI = i;
            lists.add(dreamleafs.stream()
                    .filter(d -> Math.abs(d.buyout / 100 / d.quantity) < finalI * 100)
//                    .filter(d -> d.quantity > 10)
                    .filter(d -> d.buyout > 0)
                    .collect(Collectors.toList()));
        }
//        lists = lists.stream().filter(l -> l.size() > 0).collect(Collectors.toList());

    }
}
