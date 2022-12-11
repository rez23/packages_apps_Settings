package com.android.settings.display

import android.app.settings.SettingsEnums
import android.os.Bundle
import com.android.settings.R
import com.android.settings.dashboard.DashboardFragment
import com.android.settings.search.BaseSearchIndexProvider
import com.android.settingslib.search.SearchIndexable

@SearchIndexable(forTarget = SearchIndexable.ALL and SearchIndexable.ARC.inv())
class ShowQsBrightnessSliderSettings: DashboardFragment() {

    companion object {
        @JvmStatic private val TAG = "ShowQsBrightnessSliderSettings"
        @JvmStatic val SEARCH_INDEX_DATA_PROVIDER = BaseSearchIndexProvider(R.xml.show_qs_broghtness_slider_detail)
    }

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
    }
    override fun getMetricsCategory(): Int {
        return SettingsEnums.SETTINGS_AUTO_BRIGHTNESS
    }

    override fun getPreferenceScreenResId(): Int {
        return R.xml.show_qs_brightness_slider_detail
    }

    override fun getHelpResource(): Int {
       return R.string.help_url_auto_brightness
    }

    override fun getLogTag(): String {
        return TAG
    }

}