package co.edu.poli.ppi.network.listeners;

import co.edu.poli.ppi.model.SocializacionResp;

/**
 * Created by TEBAN on 4/06/2016.
 */
public interface MenuListenr {
    void onSocialization(SocializacionResp resp);
    void onSocializationFail();
    void onCriteriaReady();
    void onCriteriaProblem();

    void onNoteProblem();

    void onNoteReady(String note);
}
