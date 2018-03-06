package com.djekgrif.example.permissions

import android.Manifest
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.request_permissions.*

/**
 * Created by djek-grif on 3/6/18.
 */
class SimpleRequestPermissionsFragment : Fragment() {

    companion object {
        fun newInstance(): SimpleRequestPermissionsFragment {
            return SimpleRequestPermissionsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.request_permissions, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity is RequestPermissionHandler).let {
            val permissionHandler = activity as RequestPermissionHandler

            requestCameraPermissionBtn.setOnClickListener({
                permissionHandler.requestPermissions(arrayOf(Manifest.permission.CAMERA), object : PermissionListener {
                    override fun permissionsGranted() {
                        Toast.makeText(activity, "Camera permission granted :)", Toast.LENGTH_LONG).show()
                    }

                    override fun permissionsDenied() {
                        Toast.makeText(activity, "Camera permission denied :(", Toast.LENGTH_LONG).show()
                    }
                })
            })

            requestCameraAndMicPermissionBtn.setOnClickListener({
                permissionHandler.requestPermissions(arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO), object : PermissionListener {
                    override fun permissionsGranted() {
                        Toast.makeText(activity, "Camera and Mic permissions granted :)", Toast.LENGTH_LONG).show()
                    }

                    override fun permissionsDenied() {
                        Toast.makeText(activity, "Camera and Mic permissions denied :(", Toast.LENGTH_LONG).show()
                    }
                })
            })
        }
    }
}