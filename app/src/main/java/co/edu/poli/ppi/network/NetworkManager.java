package co.edu.poli.ppi.network;

import co.edu.poli.ppi.model.SocializacionResp;
import co.edu.poli.ppi.network.listeners.LoginListenr;
import co.edu.poli.ppi.network.listeners.MenuListenr;
import co.edu.poli.ppi.network.listeners.WsListener;
import co.edu.poli.ppi.network.ws.WsManager;
import co.edu.poli.ppi.utilities.ApplicationSession;

/**
 * Created by TEBAN on 4/06/2016.
 */
public class NetworkManager implements WsListener{
    private static NetworkManager ourInstance = new NetworkManager();
    private WsManager wsManager;
    private LoginListenr loginListenr;
    private MenuListenr menuListenr;

    public LoginListenr getLoginListenr() {
        return loginListenr;
    }

    public MenuListenr getMenuListenr() {
        return menuListenr;
    }

    public void setMenuListenr(MenuListenr menuListenr) {
        this.menuListenr = menuListenr;
    }

    public void setLoginListenr(LoginListenr loginListenr) {
        this.loginListenr = loginListenr;
    }

    public static NetworkManager getInstance() {
        return ourInstance;
    }

    private NetworkManager() {
        wsManager = new WsManager(this);
    }

    public void authenticate(int identificationType, String identification, String password)
    {
        wsManager.Authenticate(identificationType, identification,password);
    }

    @Override
    public void onAuthenticate(String token) {
        ApplicationSession.setToken(token);
        loginListenr.onAuthenticate();
    }

    @Override
    public void onAuthenticationFail() {
        loginListenr.onAuthenticateProblem();
    }

    @Override
    public void onSocialization(SocializacionResp body) {
        if(menuListenr != null)
        {
            menuListenr.onSocialization(body);
        }
    }

    @Override
    public void onSocializationFail() {
        menuListenr.onSocializationFail();
    }

    @Override
    public void onCriteriaReady() {
        menuListenr.onCriteriaReady();
    }

    @Override
    public void onCriteriaProblem() {
        menuListenr.onCriteriaProblem();
    }

    @Override
    public void onNoteReady(String note) {
        menuListenr.onNoteReady(note);
    }

    @Override
    public void onNoteProblem() {
        menuListenr.onNoteProblem();
    }

    public void getSocialization() {
        wsManager.getSocialization();
    }

    public void sendCriteria() {
        wsManager.putCriteria();
    }

    public void getNote() {
        wsManager.getNote();
    }
}
