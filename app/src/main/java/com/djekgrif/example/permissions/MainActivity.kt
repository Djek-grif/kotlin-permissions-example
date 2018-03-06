package com.djekgrif.example.permissions

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissionsActivityBtn.setOnClickListener({ startActivity(Intent(this@MainActivity, SimpleRequestPermissionsActivity::class.java)) })
        permissionsFragmentBtn.setOnClickListener({ startActivity(Intent(this@MainActivity, FragmentActivity::class.java)) })
    }
}
