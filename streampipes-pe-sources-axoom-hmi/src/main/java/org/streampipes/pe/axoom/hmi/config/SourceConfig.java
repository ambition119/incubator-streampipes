package org.streampipes.pe.axoom.hmi.config;

import org.streampipes.commons.config.old.ClientConfiguration;

/**
 * Created by riemer on 21.04.2017.
 */
public class SourceConfig {

  private static final String iconUrl = ClientConfiguration.INSTANCE.getIconUrl() +"/img/";

  public static final String getIconUrl(String pictureName) {
    return iconUrl +pictureName +".png";
  }
}
