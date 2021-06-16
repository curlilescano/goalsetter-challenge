package utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOError;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class APIManager {

    private final Logger LOG = LoggerFactory.getLogger(APIManager.class);

    protected Response triggerEndpointAction(String url) {
        return executeCall(new Request.Builder().url(url).get().build());
    }

    private OkHttpClient getOkHttpClient() {
        try {
            OkHttpClient builder = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();
            return builder;
        } catch (IOError e) {
            LOG.info("Problem with okHTTP client");
            throw new RuntimeException((e));
        }
    }

    protected Response executeCall(Request request) {
        try {
            return getOkHttpClient().newCall(request).execute();
        } catch (IOException e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    public String getBodyAsString(ResponseBody body) {
        String stringBody = null;
        try {
            stringBody = body.string();
            body.close();
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        return stringBody;
    }

    public String getValueOfResponse(String responseString) {
        JSONArray jsonArray = new JSONArray(responseString);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        return jsonObject.getString("Value");
    }

}
