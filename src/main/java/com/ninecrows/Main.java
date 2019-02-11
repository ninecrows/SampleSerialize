package com.ninecrows;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PayloadClass serializeMe = new PayloadClass();

        ObjectMapper mapper = new ObjectMapper();
        try {
            String result = mapper.writeValueAsString(serializeMe);
            System.out.println(result);
            PayloadClass clonedCopy = mapper.readValue(result, PayloadClass.class);
            System.out.println("Clone created");
        } catch (IOException failed) {
            System.out.println(failed.toString());
        }
    }
}
