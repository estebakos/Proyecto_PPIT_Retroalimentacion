package co.edu.poli.ppi.network.listeners;

import co.edu.poli.ppi.model.SocializacionResp;

/**
 * Created by TEBAN on 4/06/2016.
 */
public interface WsListener {
    void onAuthenticate(String token);
    void onAuthenticationFail();
    void onSocialization(SocializacionResp body);
    void onSocializationFail();
    void onCriteriaReady();
    void onCriteriaProblem();
    void onNoteReady(String note);
    void onNoteProblem();
}
