package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class XmlReportEngineTest {

    @Test
    public void whenGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee employee = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(employee);
        Report report = new XmlReportEngine(store);
        String expect = String.format("""
                        <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                        <employees>
                            <employee>
                                <name>%s</name>
                                <hired>%s</hired>
                                <fired>%s</fired>
                                <salary>%s</salary>
                            </employee>
                        </employees>
                        """,
                employee.getName(), parser.parse(employee.getHired()),
                parser.parse(employee.getFired()), employee.getSalary());
        assertThat(report.generate(em -> true)).isEqualTo(expect);
    }
}