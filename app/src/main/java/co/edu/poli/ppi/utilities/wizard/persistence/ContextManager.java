package co.edu.poli.ppi.utilities.wizard.persistence;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * This interface defines the wizard context manager API
 * used to pass data between steps.
 */
public interface ContextManager {
    void loadStepContext(Fragment step);
    void persistStepContext(Fragment step);
    Bundle getContext();
    void setContext(Bundle context);
}
