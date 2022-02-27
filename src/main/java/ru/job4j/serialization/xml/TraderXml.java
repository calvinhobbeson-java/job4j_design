package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "trader")
@XmlAccessorType(XmlAccessType.FIELD)
public class TraderXml {
    @XmlAttribute
    private int id;
    @XmlElement
    private LoginXml login;
    @XmlElementWrapper
    @XmlElement(name = "status")
    private String[] statuses;
    @XmlAttribute
    private boolean isActive;

    public TraderXml() { }

    public TraderXml(int id, LoginXml login, String[] statuses, boolean isActive) {
        this.id = id;
        this.login = login;
        this.statuses = statuses;
        this.isActive = isActive;
    }

}
