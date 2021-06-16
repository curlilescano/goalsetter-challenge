package utils;

import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExternalConfiguration extends APIManager {

    private final Logger LOG = LoggerFactory.getLogger(ExternalConfiguration.class);
    protected final String STORAGE_HOST = "https://mlescano.api.stdlib.com/goalsetter-feature-toggles@dev/";
    protected final String GET_PROPERTY_ENDPOINT = "getProperty";

    public String getExternalProperty(String key) {
        LOG.info("Getting value from {} property", key);
        String url = STORAGE_HOST + GET_PROPERTY_ENDPOINT + "/?key=" + key;
        Response response = triggerEndpointAction(url);
        String responseString = getBodyAsString(response.body());
        return getValueOfResponse(responseString);
    }

}
