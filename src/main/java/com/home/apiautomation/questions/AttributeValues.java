package com.home.apiautomation.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import java.util.Map;
import java.util.logging.Level;
import static com.home.apiautomation.utils.BaseLogger.LOGGER_INFO;

public class AttributeValues implements Question<Boolean> {

    private final Map<String, String> attributeValuesExpected;
    private final JsonPath serviceResponse = SerenityRest.lastResponse().jsonPath();

    private AttributeValues(Map<String, String> attributeValuesExpected){
        this.attributeValuesExpected = attributeValuesExpected;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean correctValues = !attributeValuesExpected.isEmpty() && attributeValuesExpected.keySet().stream()
                .allMatch(attribute -> serviceResponse.getString("data." + attribute).equals(attributeValuesExpected.get(attribute)));

        if (!correctValues) {LOGGER_INFO.log(Level.SEVERE, this::messageError);}

        return correctValues;
    }

    private String messageError(){
        return String.format("ERROR - The value of the attributes in the response are different from the expected values: %s. Response: %s",
                attributeValuesExpected.toString(), serviceResponse.prettify());
    }

    public static AttributeValues areEqualsTo(Map<String, String> attributeValuesExpected) {
        return new AttributeValues(attributeValuesExpected);
    }

}
