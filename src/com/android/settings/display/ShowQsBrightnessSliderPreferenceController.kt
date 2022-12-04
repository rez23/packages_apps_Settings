package com.android.settings.display

import android.content.Context
import android.provider.Settings
import com.android.settings.core.TogglePreferenceController
import android.provider.Settings.Secure.QS_SHOW_BRIGHTNESS_SLIDER;
import com.android.settings.R

open class ShowQsBrightnessSliderPreferenceController(
    context: Context,
    key: String
) : TogglePreferenceController(
    context,
    key
) {
    companion object {
        private const val QS_SHOW_BRIGHTNESS_SIDER_ENABLED = 1
        private const val QS_SHOW_BRIGHTNESS_SLIDER_DISABLED = 0

        private const val SYSTEM_KEY = QS_SHOW_BRIGHTNESS_SLIDER
        private const val DEFAULT_VALUE = QS_SHOW_BRIGHTNESS_SIDER_ENABLED
    }

    override fun getSliceHighlightMenuRes(): Int {
        return R.string.menu_key_display;
    }

    @AvailabilityStatus
    override fun getAvailabilityStatus(): Int {
        return AVAILABLE
    }

    override fun isChecked(): Boolean {
        return Settings.Secure.getInt(
            mContext.contentResolver,
            SYSTEM_KEY,
            DEFAULT_VALUE
        ) != 0
    }

    override fun setChecked(isChecked: Boolean): Boolean {
        Settings.Secure.putInt(
            mContext.contentResolver,
            SYSTEM_KEY,
            if (isChecked)
                QS_SHOW_BRIGHTNESS_SIDER_ENABLED
            else
                QS_SHOW_BRIGHTNESS_SLIDER_DISABLED
        )

        return true
    }
}