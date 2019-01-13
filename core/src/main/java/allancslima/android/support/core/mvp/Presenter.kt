package allancslima.android.support.core.mvp

import java.lang.ref.WeakReference

abstract class Presenter<View>(viewClass: Class<View>) {

    private var viewReference: WeakReference<View>? = null
    val view: View?
        get() = viewReference?.get()

    init {
        if (!viewClass.isInterface) {
            throw IllegalArgumentException("The class passed on constructor must be a interface!")
        }
    }

    fun attachView(view: View) {
        viewReference = WeakReference(view)
    }

    fun detachView() {
        viewReference?.clear()
    }

}
