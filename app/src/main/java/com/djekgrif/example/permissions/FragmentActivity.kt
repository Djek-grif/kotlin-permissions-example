package com.djekgrif.example.permissions

import android.os.Bundle

/**
 * Created by djek-grif on 3/6/18.
 */
class FragmentActivity : PermissionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, SimpleRequestPermissionsFragment.newInstance())
            }.commit()
        }
    }
}