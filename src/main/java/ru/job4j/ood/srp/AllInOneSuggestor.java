package ru.job4j.ood.srp;

import java.util.List;

public class AllInOneSuggestor implements Suggestor {

    @Override
    public List<Work> getSuggestions() {
        return null;
    }

    @Override
    public Work buy() {
        return null;
    }

    @Override
    public List<Work> sortByRelease() {
        return null;
    }
}

/*"1. Реализация Suggestor имеет различный функционал, который стоило бы разделить на отдельные интерфейсы:" +
        " для поиска работ из предложений основываясь на  истории," +
        " отдельно покупка интересующей работы," +
        " отдельно сортировка"

"2. Стоило сделать отдельные реализации интерфейса Suggestor для разных работ, для расширяемости приложения," +
        " кроме того получается что класс зависит от реализаций а не от абстракций"

"3. В интерфейсе Work дата резиза работы дана в опредделенном форматеяЯ,  который может измениться"*/

