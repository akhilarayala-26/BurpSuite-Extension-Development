import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;


public class Myextension implements BurpExtension{

    @Override
    public void initialize(MontoyaApi api) {

        MAPI.initialize(api);
        api.extension().setName("My First Extension");
        String tib3rius = "Tib3rius";

        api.logging().logToOutput(tib3rius);

        String hash = "";

        if(api.persistence().preferences().stringKeys().contains("hash")){
            hash = api.persistence().preferences().getString("hash");
        }

        MyFirstHttpHandler handler = new MyFirstHttpHandler(hash);
        api.http().registerHttpHandler(handler);

        api.extension().registerUnloadingHandler(new UnloadingHandler(handler));

    }


}
