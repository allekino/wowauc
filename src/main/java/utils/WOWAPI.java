package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import items.token.Token;
import org.apache.commons.io.IOUtils;

import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by tabtab on 6/28/2017.
 */
public class WOWAPI {
    public <T> T getJson(String ur, Class<T> type) {
        try {
            URL url = new URL(ur);
            try (InputStreamReader reader = new InputStreamReader(url.openStream())) {
                Gson gson = new GsonBuilder().create();
                return gson.fromJson(IOUtils.toString(reader), type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getUrl() {
        String req = "https://eu.api.battle.net/wow/auction/data/Outland?locale=en_GB&apikey=wkdeja5svqv3jxskd2dzr4c2m79f82cv";
        Token token  = getJson(req, Token.class);
        return token.files.get(0).url;
    }
}
