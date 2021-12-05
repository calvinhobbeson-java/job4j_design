package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        ru.job4j.io.Config config = new ru.job4j.io.Config(path);
        config.load();
        assertThat(config.value("name"), is("Roman"));
        assertThat(config.value("surname"), is("Pakhomov"));
    }

    @Test
    public void whenEmptyAndComments() {
        String path = "./data/empty_strings_and_coments.properties";
        ru.job4j.io.Config config = new ru.job4j.io.Config(path);
        config.load();
        assertThat(config.value("name"), is("Roman"));
        assertThat(config.value("surname"), is("Pakhomov"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInvalidFileFormat() {
        String path = "./data/invalid.properties";
        Config config = new Config(path);
        config.load();
    }
}
