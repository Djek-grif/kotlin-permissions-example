package com.djekgrif.example.permissions

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.request_permissions.*

/**
 * Created by djek-grif on 3/6/18.
 */
class SimpleRequestPermissionsActivity : PermissionActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request_permissions)
        requestCameraPermissionBtn.setOnClickListener({
            requestPermissions(arrayOf(Manifest.permission.CAMERA), object : PermissionListener {
                override fun permissionsGranted() {
                    Toast.makeText(this@SimpleRequestPermissionsActivity, "Camera permission granted :)", Toast.LENGTH_LONG).show()
                }

                override fun permissionsDenied() {
                    Toast.makeText(this@SimpleRequestPermissionsActivity, "Camera permission denied :(", Toast.LENGTH_LONG).show()
                }
            })
        })
        requestCameraAndMicPermissionBtn.setOnClickListener({
            requestPermissions(arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO), object : PermissionListener {
                override fun permissionsGranted() {
                    Toast.makeText(this@SimpleRequestPermissionsActivity, "Camera and Mic permissions granted :)", Toast.LENGTH_LONG).show()
                }

                override fun permissionsDenied() {
                    Toast.makeText(this@SimpleRequestPermissionsActivity, "Camera and Mic permissions denied :(", Toast.LENGTH_LONG).show()
                }
            })
        })
    }
}