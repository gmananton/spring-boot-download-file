package com.gman.domain;

import java.util.Collection;

/**
 * Created by Anton Mikhaylov on 23.12.2020.
 */
public interface SearchableItem {

    String getId();

    String getValue();

    Collection<String> getAdditionalFields();
}
