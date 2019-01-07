package allancslima.android.support.core.ui

import allancslima.android.support.core.R
import allancslima.android.support.core.mvp.BaseView
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private val rootView: FrameLayout by lazy { findViewById<FrameLayout>(R.id.root) }
    private val progressBar: ProgressBar by lazy { findViewById<ProgressBar>(R.id.progressBar) }
    private var contentView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_base)
    }

    override fun setContentView(@LayoutRes view: Int) {
        setContentView(LayoutInflater.from(this).inflate(view, rootView, false))
    }

    override fun setContentView(view: View) {
        contentView = view
        rootView.addView(contentView)
        dismissLoading()
    }

    override fun showLoading() {
        contentView?.visibility = View.INVISIBLE
        progressBar.visibility = View.VISIBLE
    }

    override fun dismissLoading() {
        contentView?.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun showMessage(@StringRes message: Int) {
        showMessage(getString(message))
    }

    override fun showMessage(message: CharSequence) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()
    }

}
