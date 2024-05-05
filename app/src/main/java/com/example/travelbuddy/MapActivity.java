package com.example.travelbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.graphics.drawable.Drawable;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        AppCompatButton affinity = findViewById(R.id.affinity);

        affinity.setOnClickListener(v -> {

            Intent intent = new Intent(MapActivity.this, MatchingListActivity.class);
            startActivity(intent);
            finish();

        });

        // Initialize OSMDroid
        Configuration.getInstance().load(this, getSharedPreferences("osmdroid", MODE_PRIVATE));

        // Create MapView
        MapView map = findViewById(R.id.mapview);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.getController().setZoom(8.0);
        GeoPoint startPoint = new GeoPoint(51.5074, -0.1278); // Coordinates for London
        map.getController().setCenter(startPoint);
        // Define your items representing activities
        ArrayList<OverlayItem> items = new ArrayList<>();

// Add items for each activity
        items.add(new OverlayItem("Launch Together", "Duration: 1 hour", new GeoPoint(51.5074, -0.1278))); // London
        items.add(new OverlayItem("Chess tournament", "Duration: 2 hours", new GeoPoint(40.7128, -74.0060))); // New York
        items.add(new OverlayItem("Concert: Beatles", "Duration: 3 hours", new GeoPoint(48.8566, 2.3522))); // Paris
        items.add(new OverlayItem("Hiking group", "Duration: 4 hours", new GeoPoint(41.403706, 2.173504))); // Barcelona

        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<>(
                items,

                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
                        // Handle tap event for a marker
                        return true;
                    }

//                    final Drawable markerDrawable = new ColorDrawable(Color.BLUE);
//
//                    overlayItem.setMarker(markerDrawable);

                    @Override
                    public boolean onItemLongPress(final int index, final OverlayItem item) {

                        // Handle long press event for a marker
                        AlertDialog.Builder builder = new AlertDialog.Builder(MapActivity.this);
                        builder.setTitle("Travelers List");

                        // Create a list of items with names and percentages
                        String[] items = new String[]{"Andreea: 80%", "Maria: 70%", "Michele: 90%", "Nandhni: 50%"};

                        builder.setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Handle click on item in the list
                                // You can perform additional actions based on the selected item if needed
                                Toast.makeText(MapActivity.this, "Selected: " + items[which], Toast.LENGTH_SHORT).show();
                            }
                        });

                        // Display the dialog
                        builder.show();

                        return true;
                    }

                },
                getApplicationContext()); // Pass the application context

        // Set whether to focus items on tap
        mOverlay.setFocusItemsOnTap(true);

        // Add the overlay to the map
        map.getOverlays().add(mOverlay);
//        Object overlayItem;
//        ItemizedIconOverlay itemizedOverlay;
//        itemizedOverlay.addItem((OverlayItem) overlayItem);

    }
}
