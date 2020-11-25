package com.emse.spring.faircorp.hello;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DummyUserService implements UserService {

    public GreetingService myConsoleGreetingService;

    @Autowired
    public DummyUserService(GreetingService myConsoleGreetingService) {
        this.myConsoleGreetingService = myConsoleGreetingService;
    }

    @Override
    public void greetAll() {
        ArrayList<String> myStrings= new ArrayList<String>();
        myStrings.add("Elodie"); myStrings.add("Charles");

        for (int i=0;i<myStrings.size();i++){
            myConsoleGreetingService.greet(myStrings.get(i));
        }

    }
}
