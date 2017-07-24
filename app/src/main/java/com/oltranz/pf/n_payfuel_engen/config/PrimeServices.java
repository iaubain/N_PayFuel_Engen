package com.oltranz.pf.n_payfuel_engen.config;

import com.oltranz.pf.n_payfuel_engen.models.commonmodels.CommonBranch;
import com.oltranz.pf.n_payfuel_engen.models.login.LoginRequest;
import com.oltranz.pf.n_payfuel_engen.models.login.LoginResponse;
import com.oltranz.pf.n_payfuel_engen.models.logout.LogoutRequest;
import com.oltranz.pf.n_payfuel_engen.models.logout.LogoutResponse;
import com.oltranz.pf.n_payfuel_engen.models.payments.PaymentsResponse;
import com.oltranz.pf.n_payfuel_engen.models.pump.PumpResponse;
import com.oltranz.pf.n_payfuel_engen.models.register.RegisterRequest;
import com.oltranz.pf.n_payfuel_engen.models.register.RegisterResponse;
import com.oltranz.pf.n_payfuel_engen.models.reserve.ReserveModel;
import com.oltranz.pf.n_payfuel_engen.models.reserve.ReserveResponse;
import com.oltranz.pf.n_payfuel_engen.models.sales.SalesRequest;
import com.oltranz.pf.n_payfuel_engen.models.sales.SalesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by Owner on 7/9/2016.
 */
public interface PrimeServices {
    //String BASE_URL="http://41.186.53.35:8080/"; //Link to MTN server
    String BASE_URL="http://41.74.172.131:8080/"; //Link to AOS server, production
    String LOGIN_URL="EngenPayFuel/android/login";
    String REGISTER_URL="EngenPayFuel/DeviceManagementService/device/register";
    String GET_PAYMENTS = "EngenPayFuel/PaymentModeManagementService/paymentmodes/";
    String GET_PUMPS = "EngenEquipment/pump/pumpDash";
    String RESERVE_PUMP = "EngenEquipment/assign/create";
    String LOGOUT_URL = "EngenPayFuel/android/logout";
    String SALES_URL = "EngenPayFuel/android/sale";

    @POST(PrimeServices.LOGIN_URL)
    Call<LoginResponse> login(@Body LoginRequest login);

    @POST(PrimeServices.LOGOUT_URL)
    Call<LogoutResponse> logout(@Body LogoutRequest logoutRequest);

    @POST(PrimeServices.REGISTER_URL)
    Call<RegisterResponse> enrolDevice(@Body RegisterRequest registerRequest);

    @GET(PrimeServices.GET_PAYMENTS+"{userId}")
    Call<PaymentsResponse> getPaymentsMode(@Path("userId") String userId);

    @POST(PrimeServices.GET_PUMPS)
    Call<PumpResponse> getPumps(@Body CommonBranch commonBranch);

    @POST(PrimeServices.RESERVE_PUMP)
    Call<ReserveResponse> reservePump(@Body List<ReserveModel> reserveRequest);

    @POST(PrimeServices.SALES_URL)
    Call<SalesResponse> postSales(@Body SalesRequest salesRequest);
}
