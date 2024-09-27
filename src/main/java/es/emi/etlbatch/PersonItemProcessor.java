package es.emi.etlbatch;

import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemProcessor;

@Log4j2
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) {

        final String firstName = person.getFirstname().toUpperCase();
        final String lastName = person.getLastname().toUpperCase();

        Person transformedPerson = new Person(firstName, lastName, person.getAge());

        log.info("Converting ({}) into ({})", person, transformedPerson);

        return transformedPerson;
    }
}
