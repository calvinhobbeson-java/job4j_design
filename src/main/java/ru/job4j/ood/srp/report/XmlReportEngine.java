package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class XmlReportEngine implements Report {

    private Store store;

    public XmlReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employees(store.findBy(filter)), writer);
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Employees {
        @XmlElement(name = "employee")
        private List<EmpXML> employees;
        public Employees() { }
        public Employees(List<Employee> employees) {
            this.employees = employees.stream().map(EmpXML::new).collect(Collectors.toList());
        }
    }
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class EmpXML {
        private String name, hired, fired;
        private double salary;
        public EmpXML() { }
        public EmpXML(Employee employee) {
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
            this.name = employee.getName();
            this.hired = DATE_FORMAT.format(employee.getHired().getTime());
            this.fired = DATE_FORMAT.format(employee.getFired().getTime());
            this.salary = employee.getSalary();
        }
    }
}