package com.example.aksha.melahackmap;

import android.os.Debug;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.esri.arcgisruntime.layers.Layer;
import com.esri.arcgisruntime.mapping.LayerList;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;

import junit.framework.Assert;

public class MainActivity extends AppCompatActivity {




    private MapView mMapView;
    private boolean isFoodLayer = true;
    private boolean isClassesLayer = true;
    private boolean isPerformanceLayer = true;
    private boolean isOtherLayer = true;

    private Layer FoodLayer;
    private Layer ClassesLayer;
    private Layer PerformanceLayer;
    private Layer OtherLayer;

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMapView =(MapView)findViewById(R.id.mapView);
//        ArcGISMap map = new ArcGISMap(Basemap.Type.TOPOGRAPHIC, 34.056295, -117.195800, 16);

        String smap = "https://dinocoproduction.maps.arcgis.com/home/webmap/viewer.html?webmap=b06b20e3deb84a36b3e5d96046daddde";
        String crowdsourceMap = "https://www.arcgis.com/home/webmap/viewer.html?webmap=a8d97240fa284e4fa8b98ac7c5be4951";

        ArcGISMap map = new ArcGISMap(smap);
        mMapView.setMap(map);



        final Button btnFoodTruck = (Button) findViewById(R.id.btnfoodtruck);

        btnFoodTruck.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {


                                                LayerList operationalLayers = mMapView.getMap().getOperationalLayers();
                                                ArcGISMap newMap = mMapView.getMap();
                                                String layername;
                                                int index=0;
                                                if(isFoodLayer)
                                                {
                                                    for(Layer layer : operationalLayers)
                                                {
                                                    layername= layer.getName();
                                                    if(layername.equals("Foods"))
                                                    {
                                                        isFoodLayer = false;
                                                        FoodLayer = layer;
                                                        index = operationalLayers.indexOf(layer);
                                                        newMap.getOperationalLayers().remove(index);
                                                        mMapView.setMap(newMap);
                                                        break;
                                                    }
                                                }
                                                }
                                                else
                                                {
                                                    //add the layer back.
                                                    isFoodLayer = true;
                                                    mMapView.getMap().getOperationalLayers().add(FoodLayer);
                                                }
                                            }
                                        });
    }
}
