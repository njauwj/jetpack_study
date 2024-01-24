package com.wj.lifecycle

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

//val context表示是类的属性可以直接使用,context仅仅表示是参数别的地方无法使用
//发布App后记得给App获取位置的权限
class MyLocationObserver(private val context: Context) : DefaultLifecycleObserver {


    private var locationService: LocationManager? = null

    private var locationListener: LocationListener? = null

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        startGetLocation()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        stopGetLocation()
    }

    private fun stopGetLocation() {
        Log.d("wj", "stopGetLocation")
        locationService?.removeUpdates(locationListener!!)
    }


    private fun startGetLocation() {
        Log.d("wj", "startGetLocation")
//        var locationService = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        locationService = context.getSystemService(LocationManager::class.java)
        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                Log.d("wj", "location changed -> ${location.toString()}")
            }
        }
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        locationService?.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            300,
            1F,
            locationListener!!
        )

    }

}