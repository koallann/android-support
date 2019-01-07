package allancslima.android.support.sample

import allancslima.android.support.core.ui.BaseActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            showLoading()
            Handler().postDelayed({
                showMessage("Hello, World!")
                dismissLoading()
            }, 3000)
        }
    }

}
