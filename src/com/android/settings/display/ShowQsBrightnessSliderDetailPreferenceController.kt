package com.android.settings.display

import android.content.Context
import android.widget.Switch
import androidx.preference.PreferenceScreen
import com.android.settings.widget.SettingsMainSwitchPreference
import com.android.settingslib.widget.OnMainSwitchChangeListener

class ShowQsBrightnessSliderDetailPreferenceController(
    context: Context,
    key: String
) : ShowQsBrightnessSliderPreferenceController(context,key),
    OnMainSwitchChangeListener {

    override fun onSwitchChanged(switchView: Switch?, isChecked: Boolean) {
        if (isChecked != isChecked()) {
            setChecked(isChecked)
        }
    }

    @AvailabilityStatus
    override fun getAvailabilityStatus(): Int {
        return AVAILABLE
    }

    override fun isPublicSlice(): Boolean {
        return true
    }

    override fun displayPreference(screen: PreferenceScreen?) {
        super.displayPreference(screen)

        val pref = screen?.findPreference<SettingsMainSwitchPreference>(
            preferenceKey
        )

        pref?.addOnSwitchChangeListener(this)
        pref?.isChecked = isChecked
    }

}