/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.root.mapdemo;

import com.example.root.chamna.R;

/**
 * A list of all the demos we have available.
 */
public final class DemoDetailsList {

    /** This class should not be instantiated. */
    private DemoDetailsList() {
    }

    public static final DemoDetails[] DEMOS = {
            new DemoDetails(R.string.basic_map_demo_label,
                    R.string.basic_map_demo_description,
                    BasicMapDemoActivity.class),
            new DemoDetails(R.string.camera_demo_label,
                    R.string.camera_demo_description,
                    CameraDemoActivity.class),
            new DemoDetails(R.string.camera_clamping_demo_label,
                    R.string.camera_clamping_demo_description,
                    CameraClampingDemoActivity.class),
            new DemoDetails(R.string.circle_demo_label,
                    R.string.circle_demo_description,
                    CircleDemoActivity.class),
            new DemoDetails(R.string.events_demo_label,
                    R.string.events_demo_description,
                    com.example.root.mapdemo.EventsDemoActivity.class),
            new DemoDetails(R.string.ground_overlay_demo_label,
                    R.string.ground_overlay_demo_description,
                    com.example.root.mapdemo.GroundOverlayDemoActivity.class),
            new DemoDetails(R.string.indoor_demo_label,
                    R.string.indoor_demo_description,
                    com.example.root.mapdemo.IndoorDemoActivity.class),
            new DemoDetails(R.string.layers_demo_label,
                    R.string.layers_demo_description,
                    com.example.root.mapdemo.LayersDemoActivity.class),
            new DemoDetails(R.string.lite_demo_label,
                    R.string.lite_demo_description,
                    com.example.root.mapdemo.LiteDemoActivity.class),
            new DemoDetails(R.string.lite_list_demo_label,
                    R.string.lite_list_demo_description,
                    com.example.root.mapdemo.LiteListDemoActivity.class),
            new DemoDetails(R.string.location_source_demo_label,
                    R.string.location_source_demo_description,
                    com.example.root.mapdemo.LocationSourceDemoActivity.class),
            new DemoDetails(R.string.map_in_pager_demo_label,
                    R.string.map_in_pager_demo_description,
                    com.example.root.mapdemo.MapInPagerDemoActivity.class),
            new DemoDetails(R.string.marker_demo_label,
                    R.string.marker_demo_description,
                    com.example.root.mapdemo.MarkerDemoActivity.class),
            new DemoDetails(R.string.marker_close_info_window_on_retap_demo_label,
                    R.string.marker_close_info_window_on_retap_demo_description,
                    com.example.root.mapdemo.MarkerCloseInfoWindowOnRetapDemoActivity.class),
            new DemoDetails(R.string.multi_map_demo_label,
                    R.string.multi_map_demo_description,
                    com.example.root.mapdemo.MultiMapDemoActivity.class),
            new DemoDetails(R.string.my_location_demo_label,
                    R.string.my_location_demo_description,
                    com.example.root.mapdemo.MyLocationDemoActivity.class),
            new DemoDetails(R.string.options_demo_label,
                    R.string.options_demo_description,
                    com.example.root.mapdemo.OptionsDemoActivity.class),
            new DemoDetails(R.string.polygon_demo_label,
                    R.string.polygon_demo_description,
                    com.example.root.mapdemo.PolygonDemoActivity.class),
            new DemoDetails(R.string.polyline_demo_label,
                    R.string.polyline_demo_description,
                    com.example.root.mapdemo.PolylineDemoActivity.class),
            new DemoDetails(R.string.programmatic_demo_label,
                    R.string.programmatic_demo_description,
                    com.example.root.mapdemo.ProgrammaticDemoActivity.class),
            new DemoDetails(R.string.raw_map_view_demo_label,
                    R.string.raw_map_view_demo_description,
                    com.example.root.mapdemo.RawMapViewDemoActivity.class),
            new DemoDetails(R.string.retain_map_demo_label,
                    R.string.retain_map_demo_description,
                    com.example.root.mapdemo.RetainMapDemoActivity.class),
            new DemoDetails(R.string.save_state_demo_label,
                    R.string.save_state_demo_description,
                    com.example.root.mapdemo.SaveStateDemoActivity.class),
            new DemoDetails(R.string.snapshot_demo_label,
                    R.string.snapshot_demo_description,
                    com.example.root.mapdemo.SnapshotDemoActivity.class),
            new DemoDetails(R.string.split_street_view_panorama_and_map_demo_label,
                    R.string.split_street_view_panorama_and_map_demo_description,
                    com.example.root.mapdemo.SplitStreetViewPanoramaAndMapDemoActivity.class),
            new DemoDetails(R.string.street_view_panorama_basic_demo_label,
                    R.string.street_view_panorama_basic_demo_description,
                    com.example.root.mapdemo.StreetViewPanoramaBasicDemoActivity.class),
            new DemoDetails(R.string.street_view_panorama_events_demo_label,
                    R.string.street_view_panorama_events_demo_description,
                    com.example.root.mapdemo.StreetViewPanoramaEventsDemoActivity.class),
            new DemoDetails(R.string.street_view_panorama_navigation_demo_label,
                    R.string.street_view_panorama_navigation_demo_description,
                    com.example.root.mapdemo.StreetViewPanoramaNavigationDemoActivity.class),
            new DemoDetails(R.string.street_view_panorama_options_demo_label,
                    R.string.street_view_panorama_options_demo_description,
                    com.example.root.mapdemo.StreetViewPanoramaOptionsDemoActivity.class),
            new DemoDetails(R.string.street_view_panorama_view_demo_label,
                    R.string.street_view_panorama_view_demo_description,
                    com.example.root.mapdemo.StreetViewPanoramaViewDemoActivity.class),
            new DemoDetails(R.string.styled_map_demo_label,
                    R.string.styled_map_demo_description,
                    com.example.root.mapdemo.StyledMapDemoActivity.class),
            new DemoDetails(R.string.tags_demo_label,
                    R.string.tags_demo_description,
                    com.example.root.mapdemo.TagsDemoActivity.class),
            new DemoDetails(R.string.tile_coordinate_demo_label,
                    R.string.tile_coordinate_demo_description,
                    com.example.root.mapdemo.TileCoordinateDemoActivity.class),
            new DemoDetails(R.string.tile_overlay_demo_label,
                    R.string.tile_overlay_demo_description,
                    com.example.root.mapdemo.TileOverlayDemoActivity.class),
            new DemoDetails(R.string.ui_settings_demo_label,
                    R.string.ui_settings_demo_description,
                    com.example.root.mapdemo.UiSettingsDemoActivity.class),
            new DemoDetails(R.string.visible_region_demo_label,
                    R.string.visible_region_demo_description,
                    com.example.root.mapdemo.VisibleRegionDemoActivity.class),
    };
}
