package com.djekgrif.example.permissions

/**
 * Created by djek-grif on 3/6/18.
 */
interface RequestPermissionHandler {
    fun requestPermissions(permissions: Array<String>, permissionListener: PermissionListener)
}