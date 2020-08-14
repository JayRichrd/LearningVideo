package com.cxp.learningvideo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {
    companion object {
        const val PERMISSION_REQUEST_FROM_MAIN = 1
    }
    val PERMISSIONS_STORAGE = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Android 6以上动态权限申请
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestNecessaryPermission(PERMISSIONS_STORAGE)
        }
    }

    fun clickSimplePlayer(view: View) {
        startActivity(Intent(this, SimplePlayerActivity::class.java))
    }

    fun clickSimpleTriangle(view: View) {
        val intent = Intent(this, SimpleRenderActivity::class.java)
        intent.putExtra("type", 0)
        startActivity(intent)
    }

    fun clickSimpleTexture(view: View) {
        val intent = Intent(this, SimpleRenderActivity::class.java)
        intent.putExtra("type", 1)
        startActivity(intent)
    }

    fun clickOpenGLPlayer(view: View?) {
        startActivity(Intent(this, OpenGLPlayerActivity::class.java))
    }

    fun clickMultiOpenGLPlayer(view: View?) {
        startActivity(Intent(this, MultiOpenGLPlayerActivity::class.java))
    }

    fun clickEGLPlayer(view: View?) {
        startActivity(Intent(this, EGLPlayerActivity::class.java))
    }

    fun clickSoulPlayer(view: View?) {
        startActivity(Intent(this, SoulPlayerActivity::class.java))
    }

    fun clickEncoder(view: View?) {
        startActivity(Intent(this, SynthesizerActivity::class.java))
    }

    fun clickFFmpegInfo(view: View?) {
        startActivity(Intent(this, FFmpegActivity::class.java))
    }

    private fun requestNecessaryPermission(permissions: Array<String>) {
        val permissionList = arrayListOf<String>()
        permissions.forEach { permission ->
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission)
            }
        }
        if (permissionList.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionList.toTypedArray(),PERMISSION_REQUEST_FROM_MAIN)
        }
    }
}
