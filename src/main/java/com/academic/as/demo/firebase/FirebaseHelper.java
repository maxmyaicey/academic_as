package com.academic.as.demo.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn(value = "initFirebase")
public class FirebaseHelper {

    @Value("${email_suffix}")
    String emailSuffix;

    public FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    public FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public void createUser(String username, String plainPassword) throws FirebaseAuthException {

        UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest();
        createRequest.setEmail(username + emailSuffix);
        createRequest.setEmailVerified(true);
        createRequest.setPassword(plainPassword);

        firebaseAuth.createUser(createRequest);
    }

}
