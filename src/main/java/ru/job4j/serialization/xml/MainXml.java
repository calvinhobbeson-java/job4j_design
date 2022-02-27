package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class MainXml {
    public static void main(String[] args) throws Exception {
        TraderXml trader = new TraderXml(46, new LoginXml("Nguen@gmail.com"),
                new String[]{"freeTrader", "VIP", "HighVIP"},
                true);
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(TraderXml.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(trader, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            TraderXml result = (TraderXml) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

    }
}
