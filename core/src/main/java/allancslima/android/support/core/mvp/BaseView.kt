package allancslima.android.support.core.mvp

import android.support.annotation.StringRes

interface BaseView {

    fun showLoading()

    fun dismissLoading()

    fun showMessage(@StringRes message: Int)

    fun showMessage(message: CharSequence)

}
