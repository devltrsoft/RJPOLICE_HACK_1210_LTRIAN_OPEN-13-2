package com.ltrsoft.police_app;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ltrsoft.police_app.fragment.AllMapFragment;

import java.util.Objects;

public class Dashboard extends Fragment implements OnMapReadyCallback{


    public Dashboard() {
        // Required empty public constructor
    }
    private ImageView Cadd;
    private boolean isLocationPermissionOk, istraffic;
    private Marker currentMarker;
    private Location currentLocation;
    private LatLng currentlatlng;
    private Button button;
    private CardView add_button_card;
    private BottomNavigationView navigationView,adminBottomDashNav;
    private GoogleMap mMap;
    private ImageView add_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          View view= inflater.inflate(R.layout.dashboard, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.maps);
        Cadd=view.findViewById(R.id.cadd);
        mapFragment.getMapAsync( this);
        requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.dashboard_layout, new Emergancy_page()).commit();
        navigationView = view.findViewById(R.id.bottomdashnav);
        add_btn = view.findViewById(R.id.cadd);
        add_button_card=view.findViewById(R.id.image_card);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "Compalin add page  Clicked", Toast.LENGTH_SHORT).show();
//                CreateComplainPage complainPage = new CreateComplainPage();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .addToBackStack(null)
//                        .replace(R.id.dashboard_layout, complainPage)
//                        .commit();
            }
        });

        Cadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_Complain_page  add_complain_page = new Add_Complain_page();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_layout, add_complain_page).commit();

            }
        });


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.ecall) {
                    Toast.makeText(getContext(), "Ecall Clicked", Toast.LENGTH_SHORT).show();
                    Emergancy_page emergencyPage = new Emergancy_page();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_layout, emergencyPage).commit();

                } else if (id == R.id.ecomplaints) {
                    Toast.makeText(getContext(), "Compalint Clicked", Toast.LENGTH_SHORT).show();
                    Police_Complaint_History_Page policeComplaintHistoryPage = new Police_Complaint_History_Page();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_layout, policeComplaintHistoryPage).commit();

                } else if (id == R.id.enews) {
                    Toast.makeText(getContext(), "News", Toast.LENGTH_SHORT).show();
                    News_page newsPage = new News_page();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_main,  newsPage);
                    fragmentTransaction.addToBackStack("fragmenttag");
                    fragmentTransaction.commit();
                } else if (id == R.id.emassge) {
                    Toast.makeText(getContext(), "Message clicked", Toast.LENGTH_SHORT).show();
//                    Messeges message = new Messeges();
//                    loadfragment(message);
                }
                return false;
            }
        });
        final GoogleMap[] googleMap = new GoogleMap[1]; // Directly use a GoogleMap variable

        if (mapFragment != null) {
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap map) {
                    if (map != null) {
                        googleMap[0] = map;


                        googleMap[0].setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                            @Override
                            public void onMapClick(LatLng latLng) { // Handle the map click event here
                                Toast.makeText(getActivity(), "Clicked on the map", Toast.LENGTH_SHORT).show();
                                AllMapFragment allMapFragmet=new AllMapFragment();

                                getFragmentManager().beginTransaction()
                                        .replace(R.id.main_container, allMapFragmet)
                                        .addToBackStack(null)
                                        .commit();
                            }
                        });
                    }
                }
            });
        }


        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack("fragmenttag", FragmentManager.POP_BACK_STACK_INCLUSIVE);


        return view;
    }


    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Example: Set the initial map type (you can choose from: MAP_TYPE_NORMAL, MAP_TYPE_SATELLITE, MAP_TYPE_HYBRID, MAP_TYPE_TERRAIN)
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext());

        if (ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            isLocationPermissionOk = false;
            return;
        }

        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @SuppressLint("PotentialBehaviorOverride")
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    moveCameraToLocation(location);
                } else {
                    Toast.makeText(getContext(), "Location is null", Toast.LENGTH_SHORT).show();
                    Log.d("Location", "null");
                }
            }
        });
    }

    private void moveCameraToLocation(Location location) {
        LatLng currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(currentLatLng, 15);

        MarkerOptions markerOptions = new MarkerOptions()
                .position(currentLatLng)
                .title("Current Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        if (currentMarker != null) {
            currentMarker.remove();
        }

        currentMarker = mMap.addMarker(markerOptions);
        currentMarker.setTag(703);
        mMap.animateCamera(cameraUpdate);
    }

}