package allancslima.android.support.sample

import allancslima.android.support.core.mvp.Presenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainPresenter : Presenter<MainView>(MainView::class.java) {

    fun onClickButton() {
        Observable.timer(3, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view?.showLoading() }
            .doOnComplete {
                view?.dismissLoading()
                view?.showMessage("Completed!")
            }
            .subscribe()
    }

}
