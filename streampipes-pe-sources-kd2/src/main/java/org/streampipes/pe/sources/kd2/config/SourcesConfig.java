package org.streampipes.pe.sources.kd2.config;

import org.streampipes.commons.config.old.ClientConfiguration;

/**
 * Created by riemer on 18.11.2016.
 */
public class SourcesConfig {

    public final static String serverUrl;
    public final static String iconBaseUrl;
    public final static String topicPrefixBiodata;

    static {
        serverUrl = ClientConfiguration.INSTANCE.getWebappUrl();
        iconBaseUrl = ClientConfiguration.INSTANCE.getIconUrl() +"/img";
        topicPrefixBiodata = "kd2.biodata.";
    }
}
