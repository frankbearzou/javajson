package com.frankbearzou.javajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ObjectMapperTest {


    @Test
    public void testObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        String carJson = "{\"brand\": \"Mercedes\", \"doors\": 5}";

        try {
            Car car = objectMapper.readValue(carJson, Car.class);

            assertEquals("Mercedes", car.getBrand());
            assertEquals(5, car.getDoors());
            assertEquals("Mercedes: 5", car.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testJsonNode() {
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                        "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                        "  \"nestedObject\" : { \"field\" : \"value\" } }";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);

            String brand = jsonNode.get("brand").asText();
            assertEquals("Mercedes", brand);

            int doors = jsonNode.get("doors").asInt();
            assertEquals(5, doors);

            String owner1 = jsonNode.get("owners").get(0).asText();
            assertEquals("John", owner1);

            String nestedObject = jsonNode.get("nestedObject").get("field").asText();
            assertEquals("value", nestedObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGenerateJson() {
        ObjectMapper objectMapper = new ObjectMapper();

        Car car = new Car("BMW", 5);
        try {
            String s = objectMapper.writeValueAsString(car);
            System.out.println(s);
            assertTrue(s.contains("brand"));
            assertTrue(s.contains("BMW"));
            assertTrue(s.contains("doors"));
            assertTrue(s.contains("5"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
