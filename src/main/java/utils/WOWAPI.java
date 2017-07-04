package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.IOUtils;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by tabtab on 6/28/2017.
 */
public class WOWAPI {
    public <T> T getAucJson(String ur, Class<T> type) {
        try {
            URL url = new URL(ur);
//            String reader = IOUtils.toString(new InputStreamReader(url.openStream()));
//            return new Gson().fromJson(reader, type);
            try (InputStreamReader reader = new InputStreamReader(url.openStream())){
                Gson gson = new GsonBuilder().create();
                return  gson.fromJson(IOUtils.toString(reader), type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
