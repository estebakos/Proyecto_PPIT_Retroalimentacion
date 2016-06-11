package co.edu.poli.ppi.ui;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ppi.utilities.ApplicationSession;
import co.edu.poli.ppi.utilities.wizard.Wizard;
import co.edu.poli.ppi.utilities.wizard.WizardFlow;
import co.edu.poli.ppi.utilities.wizard.layouts.BasicWizardLayout;

/**
 * Created by TEBAN on 4/06/2016.
 */
public class EvaluationWizard extends BasicWizardLayout {
    @Override
    public WizardFlow onSetup() {
        WizardFlow.Builder wizardFlow = new WizardFlow.Builder();
        for (int i = 0; i < ApplicationSession.getEvaluationSteps(); i++) {
            wizardFlow.addStep(EvaluationStep.class);
        }

        return wizardFlow.create();
    }

    public EvaluationWizard()
    {
    }
}
