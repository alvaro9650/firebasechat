package com.example.alumno.firebasechat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_contactos.*



class Contactos : AppCompatActivity() {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "sample_text")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "sample_text")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "text")
        mFirebaseAnalytics!!.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
