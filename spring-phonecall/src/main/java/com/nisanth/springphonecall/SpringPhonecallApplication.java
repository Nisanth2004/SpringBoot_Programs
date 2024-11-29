package com.nisanth.springphonecall;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;

@SpringBootApplication
public class SpringPhonecallApplication implements ApplicationRunner {



    private  final static String SID_ACCOUNT="AC448c77d30c58c70748e26ae19e7a5bf4";
    private  final static String AUTH_ID="6031f793fd65f507c6b865f37e77c3b9";
    private final static String FROM_NUMBER="+19384006973";
    private final static  String TO_NUMBER="+919943322935";


    static {
        Twilio.init(SID_ACCOUNT,AUTH_ID);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringPhonecallApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Call.creator(new PhoneNumber(TO_NUMBER),new PhoneNumber(FROM_NUMBER),
                new URI("http://demo.twilio.com/docs/voice.xml")).create();

    }
}
