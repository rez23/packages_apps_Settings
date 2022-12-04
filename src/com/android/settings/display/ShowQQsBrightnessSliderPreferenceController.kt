package com.android.settings.display

import android.content.Context
import android.provider.Settings
import com.android.settings.R
import com.android.settings.core.TogglePreferenceController

class ShowQQsBrightnessSliderPreferenceController(
    context: Context,
    key: String
): TogglePreferenceController(context,key) {

    companion object {
        const val QQS_SHOW_BRIGHTNESS_SLIDER_ON = 1
        const val QQS_SHOW_BRIGHTNESS_SIDER_OFF = 0
    }
    override fun getSliceHighlightMenuRes(): Int {
        return R.string.menu_key_display
    }

    override fun getAvailabilityStatus(): Int {
        return AVAILABLE
    }

    override fun isChecked(): Boolean {
        return Settings.Secure.getInt(
            mContext.contentResolver,
            Settings.Secure.QQS_SHOW_BRIGHTNESS_SLIDER,
            QQS_SHOW_BRIGHTNESS_SIDER_OFF
        ) == QQS_SHOW_BRIGHTNESS_SLIDER_ON
    }

    override fun getSummary(): CharSequence {
        return mContext.getText(
            if (isChecked)
                R.string.auto_brightness_summary_on
            else
                R.string.auto_brightness_summary_off
        )

    }
    override fun setChecked(isChecked: Boolean): Boolean {
        TODO("Not yet implemented")
    }

}