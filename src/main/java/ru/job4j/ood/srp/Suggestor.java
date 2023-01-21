package ru.job4j.ood.srp;

import java.util.List;

public interface Suggestor {
    List<Work> getSuggestions();
    Work buy();
    List<Work> sortByRelease();
}
