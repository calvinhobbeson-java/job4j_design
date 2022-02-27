package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "login")
public class LoginXml {

    @XmlAttribute
    private String login;

    public LoginXml() { }

    public LoginXml(String login) {
        this.login = login;
    }
}
