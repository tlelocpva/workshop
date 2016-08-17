package br.pucrs.elo.vacilationpoints;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.google.gson.Gson;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import br.pucrs.elo.vacilationpoints.worker.Worker;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);

            String strJsonTest = "{\n" +
                    "  \"workers\": [\n" +
                    "    {\n" +
                    "      \"id\": 1,\n" +
                    "      \"name\": \"Andrei Martins\",\n" +
                    "      \"image\": \"andrei.png\",\n" +
                    "      \"vacilationList\": [\n" +
                    "        {\n" +
                    "          \"type\": \"Atraso\",\n" +
                    "          \"date\": \"16/08/2014\",\n" +
                    "          \"value\": 1\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"type\": \"Atraso\",\n" +
                    "          \"date\": \"17/08/2014\",\n" +
                    "          \"value\": 1\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": 2,\n" +
                    "      \"name\": \"Anderson Armani\",\n" +
                    "      \"image\": \"armani.png\",\n" +
                    "      \"vacilationList\": [\n" +
                    "        {\n" +
                    "          \"type\": \"Atraso\",\n" +
                    "          \"date\": \"16/08/2014\",\n" +
                    "          \"value\": 2\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"type\": \"Atraso\",\n" +
                    "          \"date\": \"17/08/2014\",\n" +
                    "          \"value\": 3\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            Reader reader = new StringReader(strJsonTest);
        Gson gson = new Gson();
        Worker[] workers = gson.fromJson(strJsonTest, Worker[].class);

        System.out.println(workers);
    }
}