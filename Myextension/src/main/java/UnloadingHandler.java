import burp.api.montoya.MontoyaApi;
import burp.api.montoya.extension.ExtensionUnloadingHandler;

public class UnloadingHandler implements ExtensionUnloadingHandler {

    private MyFirstHttpHandler handler;

    public UnloadingHandler( MyFirstHttpHandler handler){

        this.handler = handler;
    }
    @Override
    public void extensionUnloaded() {
        String Hash = "hash";
        MAPI.getAPI().persistence().preferences().setString(Hash, this.handler.getHash());

    }
}
