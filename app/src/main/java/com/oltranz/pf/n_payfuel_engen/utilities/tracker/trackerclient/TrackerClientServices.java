package com.oltranz.pf.n_payfuel_engen.utilities.tracker.trackerclient;

import com.oltranz.pf.n_payfuel_engen.utilities.tracker.trackerconfig.HeaderConfig;
import com.oltranz.pf.n_payfuel_engen.utilities.tracker.trackermodels.CommandList;
import com.oltranz.pf.n_payfuel_engen.utilities.tracker.trackermodels.CommandReport;
import com.oltranz.pf.n_payfuel_engen.utilities.tracker.trackermodels.PingRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;


/**
 * Created by Owner on 7/9/2016.
 */
public interface TrackerClientServices<T> {
    String BASE_URL = "http://41.74.172.132:8080/";
    String POS_INFO_URL = "DeviceMonitor/informative/receiver/";
    String POS_PING_URL = "DeviceMonitor/informative/ping/";

    //    Ping info url
    @POST(TrackerClientServices.POS_PING_URL)
    Call<CommandList> makePing(@Header(HeaderConfig.CMD) String cmd, @Header(HeaderConfig.DEVICE_TYPE) String deviceType, @Body PingRequest pingRequest);

    //    Command report url
    @POST(TrackerClientServices.POS_INFO_URL)
    Call<String> reportCommand(@Header(HeaderConfig.CMD) String cmd, @Header(HeaderConfig.DEVICE_TYPE) String deviceType, @Header(HeaderConfig.DEVICE_ID) String deviceId, @Header(HeaderConfig.REPORT_ID) String reportId, @Body CommandReport commandReport);

}
