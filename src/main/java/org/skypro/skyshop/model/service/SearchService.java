package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search (String query) {
        return storageService.getAllSearchables().stream()
                .filter(s -> s.getSearchTerms().contains(query))
                .map(SearchResult::fromSearchable)
                .toList();
    }
}
