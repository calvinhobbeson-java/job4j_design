package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonReportEngineTest {

    @Test
    public void whenAccountantsGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee emp1 = new Employee("Ivan", now, now, 25000);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(emp1);
        Report engine = new JsonReportEngine(store, parser);
        String rsl = engine.generate(em -> true);
        StringBuilder exp = new StringBuilder()
                .append("[").append("{").append("\"name\":\"")
                .append(emp1.getName()).append("\",")
                .append("\"hired\":{").append("\"year\":")
                .append(emp1.getHired()
                        .get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(emp1.getHired()
                        .get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(emp1.getHired()
                        .get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(emp1.getHired()
                        .get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(emp1.getHired()
                        .get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(emp1.getHired()
                        .get(Calendar.SECOND)).append("},")
                .append("\"fired\":{").append("\"year\":")
                .append(emp1.getFired()
                        .get(Calendar.YEAR)).append(",")
                .append("\"month\":").append(emp1.getFired()
                        .get(Calendar.MONTH)).append(",")
                .append("\"dayOfMonth\":").append(emp1.getFired()
                        .get(Calendar.DAY_OF_MONTH)).append(",")
                .append("\"hourOfDay\":").append(emp1.getFired()
                        .get(Calendar.HOUR_OF_DAY)).append(",")
                .append("\"minute\":").append(emp1.getFired()
                        .get(Calendar.MINUTE)).append(",")
                .append("\"second\":").append(emp1.getFired()
                        .get(Calendar.SECOND)).append("},")
                .append("\"salary\":").append(emp1.getSalary())
                .append("}")
                .append("]");
        assertThat(rsl).isEqualTo(exp.toString());
    }
}