package com.example.springproj3;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;

import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class FirestoreIntegrationTest {

    @Test
    public void AddToFirestore() throws Exception {
        FileInputStream serviceAccount =
                    new FileInputStream(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));

        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setProjectId("spring-project-3")
                .build();
        FirebaseApp.initializeApp(options);
        Firestore db = FirestoreClient.getFirestore();

        DocumentReference docRef = db.collection("users").document("pJVzsMLpeTBEGoAvmJGd");
        // Add document data  with id "pJVzsMLpeTBEGoAvmJGd" using a hashmap
        Map<String, Object> data = new HashMap<>();
        data.put("id", 1);
        data.put("username", "Hermione");
        data.put("password", "Leviossa");
        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(data);

        // result.get() blocks on response
        if(result.get().toString().length()==0){
            throw new Exception("Results are not printed!");
        }
        System.out.println("Update time : " + result.get().getUpdateTime());


        //        try {
//            FileInputStream serviceAccount =
//                    new FileInputStream(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
//        } catch (Exception e){
//            System.out.println("credential file not found");
//        }
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//        FirebaseApp.initializeApp(options);
    }
}





