package com.djekgrif.example.permissions

import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.widget.Toast

/**
 * Created by djek-grif on 3/6/18.
 */
abstract class PermissionActivity : AppCompatActivity(), RequestPermissionHandler {

    companion object {
        const val PERMISSIONS_REQUEST: Int = 7777
    }

    private var permissionListener: PermissionListener? = null

    override fun requestPermissions(permissions: Array<String>, permissionListener: PermissionListener) {
        if (!isPermissionAllowed(permissions)) {
            this.permissionListener = permissionListener
            if (!isShowPermissionRationale(permissions)) {
                Log.i("PermissionActivity", "Show dialog 'Request permissions' for: ${TextUtils.join(", ", permissions)}")
                ActivityCompat.requestPermissions(this, permissions, PERMISSIONS_REQUEST)
            }
        } else {
            permissionListener.permissionsGranted()
        }
    }

    private fun isPermissionAllowed(permissions: Array<String>): Boolean {
        permissions.iterator().forEach {
            if (ActivityCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }

    private fun isShowPermissionRationale(permissions: Array<String>): Boolean {
        permissions.iterator().forEach {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, it)) {
                Toast.makeText(this, "Please allow permission $it in App Settings", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSIONS_REQUEST -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permissionListener?.permissionsGranted()
            } else {
                permissionListener?.permissionsDenied()
                Log.w("PermissionActivity", "Permission denied for: ${TextUtils.join(", ", permissions)}")
            }
        }
    }
}