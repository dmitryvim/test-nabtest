package com.mikhaylovich.nabtest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JsonMapperTest {

    @Test
    public void testParseJson() throws Exception {
        String json = "{\n" +
                "  \"name\": \"name1\",\n" +
                "  \"phone\": \"phone1\"\n" +
                "}";
        Person person = JsonMapper.parseJson(json, Person.class);
        assertEquals(person.getName(), "name1");
        assertEquals(person.getPhone(), "phone1");
    }

    @Test
    public void testConvertToJson() throws Exception {
        Person person = new Person("name1", "phone1");
        String json = JsonMapper.convertToJson(person);
        String expected = "{\n" +
                "  \"name\": \"name1\",\n" +
                "  \"phone\": \"phone1\"\n" +
                "}";
        assertEquals(json.replaceAll("\\s+",""), expected.replaceAll("\\s+",""));
    }
}