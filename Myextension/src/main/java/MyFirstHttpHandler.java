import burp.api.montoya.http.handler.*;
import burp.api.montoya.http.message.requests.HttpRequest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class MyFirstHttpHandler implements HttpHandler {
    private String hash = "";

    public MyFirstHttpHandler(String hash){
        this.hash = hash;

    }
    public String getHash(){
        return this.hash;
    }
    @Override
    public RequestToBeSentAction handleHttpRequestToBeSent(HttpRequestToBeSent httpRequestToBeSent) {
        String Xhash = "X-Hash";

        if(!this.hash.isEmpty() && httpRequestToBeSent.isInScope()) {
            HttpRequest request = httpRequestToBeSent.withAddedHeader(Xhash, this.hash);
            return RequestToBeSentAction.continueWith(request);
        }
        return null;
    }

    @Override
    public ResponseReceivedAction handleHttpResponseReceived(HttpResponseReceived httpResponseReceived) {
        if(httpResponseReceived.initiatingRequest().isInScope()) {
            String input = "";
            String age = "Age";
            String date = "Date";
            if (httpResponseReceived.hasHeader(age)) {
                input += httpResponseReceived.headerValue(age);
            }

            if (httpResponseReceived.hasHeader(date)) {
                input += httpResponseReceived.headerValue(date);
            }

            String sha256 = "SHA-256";
            try {
                MessageDigest digest = MessageDigest.getInstance(sha256);
                digest.update(input.getBytes(StandardCharsets.UTF_8));
                this.hash = HexFormat.of().formatHex(digest.digest());
                MAPI.getAPI().logging().logToOutput(("Hash generated: " + this.hash));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}

