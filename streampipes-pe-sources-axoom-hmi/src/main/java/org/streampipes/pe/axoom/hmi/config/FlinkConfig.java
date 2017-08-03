package org.streampipes.pe.axoom.hmi.config;

import org.streampipes.commons.config.old.ClientConfiguration;

public class FlinkConfig {

	public static final String JAR_FILE = "./semantic-epa-sources-axoom-hmi.jar";

	public static final String FLINK_HOST = ClientConfiguration.INSTANCE.getFlinkHost();
	
	public static final int FLINK_PORT = ClientConfiguration.INSTANCE.getFlinkPort();

	public static final String iconBaseUrl = ClientConfiguration.INSTANCE.getIconUrl() +"/img";
}
