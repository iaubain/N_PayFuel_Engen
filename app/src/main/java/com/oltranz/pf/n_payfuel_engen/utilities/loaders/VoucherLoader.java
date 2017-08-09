package com.oltranz.pf.n_payfuel_engen.utilities.loaders;

import android.content.Context;
import android.util.Log;

import com.oltranz.pf.n_payfuel_engen.config.QRServiceGenerator;
import com.oltranz.pf.n_payfuel_engen.config.VoucherServices;
import com.oltranz.pf.n_payfuel_engen.models.vouchers.Voucher;
import com.oltranz.pf.n_payfuel_engen.utilities.DataFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ISHIMWE Aubain Consolateur. email: iaubain@yahoo.fr / aubain.c.ishimwe@oltranz.com Tel: +250 785 534 672 / +250 736 864 662 on 8/8/2017.
 */

public class VoucherLoader {
    private Context context;
    private OnVoucherLoader mListener;
    private String message = "";

    public VoucherLoader(Context context, OnVoucherLoader mListener) {
        this.context = context;
        this.mListener = mListener;
    }

    public void validateVoucher(String voucherNumber) {
        try {
            VoucherServices voucherServices = QRServiceGenerator.createService(VoucherServices.class, VoucherServices.BASE_URL);
            Call<String> callService = voucherServices.voucherDetails(voucherNumber);
            callService.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    int statusCode = response.code();
                    Log.d("Response", "Status: " + statusCode + "\n" + "Body: " + response.body());
                    if (statusCode == 500) {
                        message = "Internal server error";
                        mListener.onValidateVoucher(false, "(" + statusCode + ")" + " " + message);
                        return;
                    } else if (statusCode != 200) {
                        message = response.message();
                        mListener.onValidateVoucher(false, "(" + statusCode + ")" + " " + message);
                        return;
                    }

                    if (response.body() == null) {
                        message = "Empty server response";
                        mListener.onValidateVoucher(false, "(" + statusCode + ")" + " " + message);
                        return;
                    }

                    String result = response.body();

                    if (result.toLowerCase().contains("error")) {
                        mListener.onValidateVoucher(false, "Voucher is not found.");
                        return;
                    }
                    Voucher voucher = (Voucher) DataFactory.stringToObject(Voucher.class, response.body());
                    if (voucher == null) {
                        mListener.onValidateVoucher(false, "Internal application error. Can't parse voucher object.");
                    } else {
                        mListener.onValidateVoucher(true, voucher);
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    message = "Network failure. " + t.getMessage();
                    mListener.onValidateVoucher(false, message);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            mListener.onValidateVoucher(false, "General application error: " + e.getMessage());
        }
    }

    public void redeemVoucher(final String voucherNumber) {
        try {
            VoucherServices voucherServices = QRServiceGenerator.createService(VoucherServices.class, VoucherServices.BASE_URL);
            Call<String> callService = voucherServices.redeemVoucher(voucherNumber);
            callService.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    int statusCode = response.code();
                    Log.d("Response", "Status code: " + statusCode + "\nBody: " + response.body());
                    if (statusCode == 500) {
                        message = "Internal server error";
                        mListener.onRedeemVoucher(false, "(" + statusCode + ")" + " " + message);
                        return;
                    } else if (statusCode != 200) {
                        message = response.message();
                        mListener.onRedeemVoucher(false, "(" + statusCode + ")" + " " + message);
                        return;
                    }

                    if (response.body() == null) {
                        message = "Empty server response";
                        mListener.onRedeemVoucher(false, "(" + statusCode + ")" + " " + message);
                        return;
                    }

                    if (response.body().equals("1")) {
                        mListener.onRedeemVoucher(true, "(" + statusCode + ")" + " Voucher: " + voucherNumber + " successfully redeemed. With code: " + response.body());
                    } else {
                        mListener.onRedeemVoucher(false, "(" + statusCode + ")" + " Voucher: " + voucherNumber + " failed to be redeemed. With code: " + response.body());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    message = "Network failure. " + t.getMessage();
                    mListener.onRedeemVoucher(false, message);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            mListener.onRedeemVoucher(false, "General application error: " + e.getMessage());
        }
    }

    public interface OnVoucherLoader {
        void onValidateVoucher(boolean isDone, Object voucher);

        void onRedeemVoucher(boolean isDone, String redeemResult);
    }
}
