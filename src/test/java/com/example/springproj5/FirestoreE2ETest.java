package com.example.springproj5;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;

@SpringBootTest
public class FirestoreE2ETest {

    @Test
    public void AuthenticationFirestore() throws Exception{
        FileInputStream serviceAccount =
                new FileInputStream("spring-project-3-firebase-adminsdk-dang2-d8fc83122b.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setProjectId("spring-project-3")
                .build();
        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();
        String uid = "FtKYtblnGlUnxhRBSbtRZ0XmbjD3";
        DocumentReference docRef = db.collection("users").document(uid);
        ApiFuture<DocumentSnapshot> query = docRef.get();
        DocumentSnapshot document = query.get();
        System.out.println("Name: " + document.getString("name"));
        System.out.println("Surname: " + document.getString("surname"));
        System.out.println("Number: " + document.getString("number"));


        Assertions.assertEquals("Vivian",document.getString("name"));
        Assertions.assertEquals("Leigh",document.getString("surname"));
        Assertions.assertEquals("+994000000",document.getString("number"));
    }

}
