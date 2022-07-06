package com.github.astat1cc.sergeybalakintesttask.featuremap.presentation.fragments.map

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.astat1cc.sergeybalakintesttask.featuremap.databinding.FragmentMapBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

class MapFragment : Fragment() {

    private lateinit var binding: FragmentMapBinding

    private lateinit var googleMap: GoogleMap
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private val requestLocationPermissionsLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (permissions.entries.all { it.value }) {
            // user granted all permissions
            showUserPosition()
        } else {
            if (permissions.entries.any { shouldShowRequestPermissionRationale(it.key) }) {
                showPermissionRationaleDialog()
            } else {
                showPermissionRequiredSettingsLinkDialog()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mapView.onCreate(savedInstanceState)

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())

        binding.mapView.getMapAsync {
            googleMap = it
            setMapPins()
        }

        binding.findMeTextView.setOnClickListener { requestLocationPermissions() }
    }

    private fun setMapPins() {
        val moscow = LatLng(55.739283, 37.624476)
        val randomPositions = getRandomPositionsAround(moscow, radiusInKilometers = 1000L)
        randomPositions.forEach { position ->
            val marker = MarkerOptions().position(position).title("Random pin").icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
            )
            googleMap.addMarker(marker)
        }
    }

    // returns list of random positions that are within given radius of given position
    private fun getRandomPositionsAround(position: LatLng, radiusInKilometers: Long): List<LatLng> {
        val random = Random()
        val randomPoints = (1..10).map {
            val x0 = position.latitude
            val y0 = position.longitude

            val radiusInDegrees = radiusInKilometers / 111f

            val u = random.nextDouble()
            val v = random.nextDouble()
            val w = radiusInDegrees * sqrt(u)
            val t = 2 * Math.PI * v
            val x = w * cos(t)
            val y = w * sin(t)

            // Adjust the x-coordinate for the shrinking of the east-west distances
            val newX = x / cos(y0)

            val foundLatitude = newX + x0
            val foundLongitude = y + y0
            LatLng(foundLatitude, foundLongitude)
        }
        return randomPoints
    }

    @SuppressLint("MissingPermission")
    private fun showUserPosition() {
        fusedLocationProviderClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
            .addOnSuccessListener { location ->
                moveCameraToUserPosition(location)
            }
    }

    private fun moveCameraToUserPosition(location: Location?) {
        location?.let {
            val position = LatLng(location.latitude, location.longitude)
            val cameraUpdate = CameraUpdateFactory.newLatLngZoom(position, MAP_CAMERA_ZOOM)
            val marker = MarkerOptions().position(position).title("Your position").icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
            )
            googleMap.addMarker(marker)
            googleMap.animateCamera(cameraUpdate)
        }
    }

    private fun requestLocationPermissions() {
        when {
            hasAllLocationPermissions(requireContext()) -> {
                showUserPosition()
            }
            LOCATION_PERMISSIONS.any { shouldShowRequestPermissionRationale(it) } -> {
                showPermissionRationaleDialog()
            }
            else -> requestLocationPermissionsLauncher.launch(LOCATION_PERMISSIONS)
        }
    }

    private fun showPermissionRationaleDialog() {
        AlertDialog.Builder(requireContext())
            .setMessage("You need to accept location permission to find your location.")
            .setPositiveButton("Ok") { _, _ ->
                requestLocationPermissionsLauncher.launch(LOCATION_PERMISSIONS)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun showPermissionRequiredSettingsLinkDialog() {
        AlertDialog.Builder(requireContext())
            .setMessage("You need to accept this permission from the settings.")
            .setPositiveButton("Ok") { _, _ ->
                val appDetailsSettingsIntent = Intent(
                    Settings.ACTION_APPLICATION_SETTINGS
                )
                startActivity(appDetailsSettingsIntent)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onDestroyView() {
        binding.mapView.onDestroy()
        super.onDestroyView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    companion object {

        private const val MAP_CAMERA_ZOOM = 15f

        private val LOCATION_PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

        private fun hasAllLocationPermissions(context: Context) =
            LOCATION_PERMISSIONS.all {
                ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
            }
    }
}