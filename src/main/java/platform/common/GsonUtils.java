package platform.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.List;

public class GsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(GsonUtils.class);

    public static List toList(String json) {
        List list;
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<List>() {}.getType();
        try {
            list = gson.fromJson(json, listType);
        } catch (Exception e) {
            logger.error("CONY01060: JSON转换为List失败", e);
            return null;
        }
        return list;
    }

}
