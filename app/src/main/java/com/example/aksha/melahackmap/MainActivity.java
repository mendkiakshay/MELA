package com.example.aksha.melahackmap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;
import  android.widget.ImageButton;

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

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }


    @Override


    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMapView =(MapView)findViewById(R.id.mapView);


        //https://www.arcgis.com/home/webmap/viewer.html?webmap=d9335f701eef4dc1be1ff5577905524e

        //latest
                        //https://www.arcgis.com/home/webmap/viewer.html?webmap=9d62ef957eb046e999f8ac3cd889ce98
        String smap = "https://www.arcgis.com/home/webmap/viewer.html?webmap=9d62ef957eb046e999f8ac3cd889ce98";


        ArcGISMap map = new ArcGISMap(smap);
        mMapView.setMap(map);

        final Button btnFoodTruck = (Button) findViewById(R.id.btnfoodtruckImg);

       final Context currentContext = this;

        btnFoodTruck.setOnClickListener(new View.OnClickListener()
        {
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
                                                    if(layername.equals("Food"))
                                                    {
                                                        btnFoodTruck.setBackground(getDrawable(getImageId(currentContext,"foodoff")));
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
                                                    btnFoodTruck.setBackground(getDrawable(getImageId(currentContext,"food")));
                                                    isFoodLayer = true;
                                                    mMapView.getMap().getOperationalLayers().add(FoodLayer);

                                                }
                                            }
                                        });

        final Button btnClasses = (Button) findViewById(R.id.btnClasses);


        btnClasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayerList operationalLayers = mMapView.getMap().getOperationalLayers();
                ArcGISMap newMap = mMapView.getMap();
                String layername;
                int index=0;
                if(isClassesLayer)
                {
                    for(Layer layer : operationalLayers)
                    {
                        layername= layer.getName();
                        if(layername.equals("Class"))
                        {
                            btnClasses.setBackground(getDrawable(getImageId(currentContext,"classoff")));
                            isClassesLayer = false;
                            ClassesLayer = layer;
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
                    btnClasses.setBackground(getDrawable(getImageId(currentContext,"classon")));
                    isClassesLayer = true;
                    mMapView.getMap().getOperationalLayers().add(ClassesLayer);
                }
            }
        });



        final Button btnPerformances = (Button) findViewById(R.id.btnPerformances);
        btnPerformances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayerList operationalLayers = mMapView.getMap().getOperationalLayers();
                ArcGISMap newMap = mMapView.getMap();
                String layername;
                int index=0;
                if(isPerformanceLayer)
                {
                    for(Layer layer : operationalLayers)
                    {
                        layername= layer.getName();
                        if(layername.equals("Performance"))
                        {
                            btnPerformances.setBackground(getDrawable(getImageId(currentContext,"performanceoff")));
                            isPerformanceLayer = false;
                            PerformanceLayer = layer;
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
                    btnPerformances.setBackground(getDrawable(getImageId(currentContext,"performance")));
                    isPerformanceLayer = true;
                    mMapView.getMap().getOperationalLayers().add(PerformanceLayer);
                }
            }
        });


        final Button btnOthers = (Button) findViewById(R.id.btnOthers);
        btnOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayerList operationalLayers = mMapView.getMap().getOperationalLayers();
                ArcGISMap newMap = mMapView.getMap();
                String layername;
                int index=0;
                if(isOtherLayer)
                {
                    for(Layer layer : operationalLayers)
                    {
                        layername= layer.getName();
                        if(layername.equals("Other"))
                        {
                            btnOthers.setBackground(getDrawable(getImageId(currentContext,"otheroff")));
                            isOtherLayer = false;
                            OtherLayer = layer;
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
                    btnOthers.setBackground(getDrawable(getImageId(currentContext,"other")));
                    isOtherLayer = true;
                    mMapView.getMap().getOperationalLayers().add(OtherLayer);
                }
            }
        });



    }

    public void RefreshMap()
    {


    }
}
