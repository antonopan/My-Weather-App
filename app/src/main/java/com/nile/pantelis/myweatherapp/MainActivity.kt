package com.nile.pantelis.myweatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nile.pantelis.myweatherapp.domain.location.LocationHelper
import com.nile.pantelis.myweatherapp.domain.location.rememberLocationState
import com.nile.pantelis.myweatherapp.ui.theme.MyWeatherAppTheme
import com.nile.pantelis.myweatherapp.view.MainScreen

class MainActivity : ComponentActivity() {

//    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationHelper: LocationHelper
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        locationHelper = LocationHelper(this)

//        // Check permission and request if needed
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PERMISSION_GRANTED) {
//            locationHelper.getLastLocation { location ->
//                locationHelper.getLastLocation { location ->
//                    handleLocation(location) { lat, lng ->
//                        if (lat != null && lng != null) {
//                            // Use lat/lng here
//                            Log.d("MainActivity", "Received from callback: $lat, $lng")
//                        }
//                    }
//                }
//            }
//        } else {
//            locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
//        }

        val activity = this

        enableEdgeToEdge()
        setContent {

            val locationState = rememberLocationState(this)
            val (lat, lng) = locationState.value

            MyWeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = Wmo.codes[Demo.weatherResponse.daily.weather_code[0]]!!,
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        latitude = lat,
                        longitude = lng
                    )
                }
            }
        }
    }

//    private val locationPermissionLauncher = registerForActivityResult(
//        ActivityResultContracts.RequestPermission()
//    ) { isGranted: Boolean ->
//        if (isGranted) {
//            locationHelper.getLastLocation { location ->
//                handleLocation(location) { lat, lng ->
//                    if (lat != null && lng != null) {
//                        // Use lat/lng here
//                        Log.d("MainActivity", "Received from callback: $lat, $lng")
//                    }
//                }
//            }
//        } else {
//            Log.d("MainActivity", "Location permission denied")
//        }
//    }
//
//    private fun handleLocation(location: Location?, callback: (Double?, Double?) -> Unit) {
//        location?.let {
//            val lat = it.latitude
//            val lng = it.longitude
//            Log.d("MainActivity", "Lat: $lat, Lng: $lng")
//            callback(lat, lng)
//        } ?: run {
//            Log.d("MainActivity", "Location is null")
//            callback(null, null)
//        }
//    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyWeatherAppTheme {
        Greeting("Android")
    }
}