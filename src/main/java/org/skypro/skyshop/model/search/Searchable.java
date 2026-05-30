package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    UUID getId();

    String getSearchTerms();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return getSearchTerms() + " - " + getContentType();
    }
}
