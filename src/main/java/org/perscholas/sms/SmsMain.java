package org.perscholas.sms;

import lombok.AllArgsConstructor;
import org.perscholas.sms.util.InitializerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class SmsMain {

    static final Long userId = 1L;

    @Autowired
    public SmsMain(InitializerUtil initializerUtil) {
        initializerUtil.initializeData();
    }

    public static void main(String[] args) {
        SpringApplication.run(SmsMain.class, args);



    }
}
