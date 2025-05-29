package com.nile.pantelis.myweatherapp.domain.location


import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.core.content.ContextCompat

@SuppressLint("UnrememberedMutableState")
@Composable
fun rememberLocationState(context: Context): State<Pair<Double?, Double?>> {
    val locationHelper = remember { LocationHelper(context as android.app.Activity) }

    val latitude = remember { mutableStateOf<Double?>(null) }
    val longitude = remember { mutableStateOf<Double?>(null) }

    val permissionGranted = remember { mutableStateOf(false) }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        permissionGranted.value = isGranted
    }

    LaunchedEffect(Unit) {
        val hasPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (hasPermission) {
            permissionGranted.value = true
        } else {
            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    LaunchedEffect(permissionGranted.value) {
        if (permissionGranted.value) {
            locationHelper.getLastLocation { location ->
                latitude.value = location?.latitude
                longitude.value = location?.longitude
            }
        }
    }

    return derivedStateOf { Pair(latitude.value, longitude.value) }
}
