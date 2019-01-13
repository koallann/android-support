package allancslima.android.support.sample

import allancslima.android.support.core.ui.BaseActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : BaseActivity(), MainView {

    private val presenter: MainPresenter by lazy { MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)

        findViewById<Button>(R.id.button).setOnClickListener {
            presenter.onClickButton()
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

}
