package com.oltranz.pf.n_payfuel_engen.config;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ISHIMWE Aubain Consolateur. email: iaubain@yahoo.fr / aubain.c.ishimwe@oltranz.com Tel: +250 785 534 672 / +250 736 864 662 on 8/8/2017.
 */

public interface VoucherServices {
    String BASE_URL = "http://41.74.172.132:9000/";
    String QR_CONSUME = "oltranz/vouchers/vouchers/consumed";
    String QR_DETAILS = "oltranz/vouchers/vouchers/check";

    @POST(VoucherServices.QR_CONSUME)
    Call<String> redeemVoucher(@Query("voucherNumber") String voucherNumber);

    @POST(VoucherServices.QR_DETAILS)
    Call<String> voucherDetails(@Query("voucherNumber") String voucherNumber);
}
