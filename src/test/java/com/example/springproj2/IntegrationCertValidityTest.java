package com.example.springproj2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.FileInputStream;
import java.net.URL;
import java.security.cert.*;

@SpringBootTest
public class IntegrationCertValidityTest {
    private static final String testURL = "https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos";

    @Test
    public void checkCertValidity() throws Exception {
        URL obj = new URL(testURL);
        HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
        conn.connect();
        Certificate[] certs =  conn.getServerCertificates();
        if (certs == null || certs.length == 0 || (!(certs[0] instanceof X509Certificate))) {
            throw new SSLPeerUnverifiedException("No server's end-entity certificate");
        }
        CertificateFactory cf = CertificateFactory.getInstance("X509");
        FileInputStream certFile = new FileInputStream("mockapi.cer");
        X509Certificate localCert =  (X509Certificate) cf.generateCertificate(certFile);
        if(!localCert.equals(certs[0])){
            throw new CertificateException("The sertificate is not valid with the local!");
        }

    }


}
