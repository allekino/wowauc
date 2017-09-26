import items.AucExt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import utils.GetItems;
import utils.Items;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by death on 7/8/2017.
 */
public class AucTest {
    private static final Logger Log = LogManager.getLogger(AucTest.class);

    @Test
    public void auc() {
        while (true) {
            GetItems.update();
            Map<Double, List<AucExt>> Dreamleaf = filter(Items.Dreamleaf);
            Map<Double, List<AucExt>> Aethril = filter(Items.Aethril);
            Map<Double, List<AucExt>> Fjarnskaggl = filter(Items.Fjarnskaggl);
            Map<Double, List<AucExt>> Foxflower = filter(Items.Foxflower);
            int a = 0;
        }
    }


    private Map<Double, List<AucExt>> filter(int id) {
        Map<Double, List<AucExt>> lists = new TreeMap<>();
        List<AucExt> items = GetItems.getItems(id);
        Log.info(String.format("Фильтр итемов для %d", id));
        double inc = 1;
        for (double i = 0; i < 30; i += 0.5) {
            double finalI = i;
            List<AucExt> found = items.stream()
                    .filter(d -> Math.abs(d.buyout / 100 / d.quantity) < finalI * 100
                            && Math.abs(d.buyout / 100 / d.quantity) > (finalI - inc) * 100)
                    .filter(d -> d.buyout > 0)
                    .collect(Collectors.toList());
            if (found.size() > 0) {
                lists.put(i, found);
            }
        }
        return lists;
    }
}
