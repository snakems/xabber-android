package com.xabber.android.ui.preferences;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.xabber.android.R;
import com.xabber.android.ui.activity.ManagedActivity;
import com.xabber.android.ui.activity.PreferenceSummaryHelper;
import com.xabber.android.ui.color.BarPainter;

public class ContactListSettings extends ManagedActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isFinishing())
            return;

        setContentView(R.layout.activity_with_toolbar_and_container);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_default);

        setSupportActionBar(toolbar);

        BarPainter barPainter = new BarPainter(this, toolbar);
        barPainter.setDefaultColor();
        
        setTitle(PreferenceSummaryHelper.getPreferenceTitle(getString(R.string.preference_contacts)));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new ContactListSettingsFragment()).commit();
        }
    }
}
