package com.LMG.API.utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Utils {
    public RequestSpecification req;
    public RequestSpecification requestSpecification() throws IOException {
        if(req==null){
            PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));

            req= (RequestSpecification) new RequestSpecBuilder().setBaseUri(ReusableMethods.getGlobalValue("URI_MAX_EGYPT")).


                    build();
            return req;
        }return req;
    }
}
