package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;


@Disabled
class GeneratorPetrArsentevTest {
    @Test
    public void whenGenerateThenGetString() {
        GeneratorPetrArsentev generator = new GeneratorPetrArsentev();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "you");
        String  result = generator.produce(template, args);
        assertThat(result.equals("I am a Petr, Who are you? "));
    }

    @Test
    public void whenKeyMismatchThenGetException() {
        GeneratorPetrArsentev generator = new GeneratorPetrArsentev();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("Surename", "Arsentev");
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenMapHasMoreKeyThanNeededThenGetException() {
        GeneratorPetrArsentev generator = new GeneratorPetrArsentev();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("Surename", "Arsentev");
        args.put("Subject", "you");
        assertThatThrownBy(() -> generator.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

}