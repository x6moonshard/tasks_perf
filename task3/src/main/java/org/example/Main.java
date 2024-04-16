package org.example;

import org.example.model.MainJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void toJSON(MainJSON mainJSON) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("report.json"), mainJSON);
    }

    public static void main(String[] args) throws IOException {

        JSONParser parser = new JSONParser();
        MainJSON mainJSON = new MainJSON();

        try (FileReader tests = new FileReader("tests.json");) {

            JSONObject testsJSON = (JSONObject) parser.parse(tests);

            mainJSON.setId(((Long) testsJSON.get("id")).intValue());
            mainJSON.setTitle((String) testsJSON.get("title"));
            mainJSON.setValue((String) testsJSON.get("value"));

        } catch (Exception e) {
            System.out.println(e);
        }

        try (FileReader values = new FileReader("values.json");) {

            JSONObject valuesJSON = (JSONObject) parser.parse(values);

            JSONArray valuesJsonArray = (JSONArray) valuesJSON.get("values");

            mainJSON.setValues(valuesJsonArray);

        } catch (Exception e) {
            System.out.println(e);
        }

        toJSON(mainJSON);
    }
}