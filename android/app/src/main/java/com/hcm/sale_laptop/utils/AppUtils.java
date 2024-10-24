package com.hcm.sale_laptop.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hcm.sale_laptop.R;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AppUtils {
    public static void openPlayStoreForApp(Context context) {
        final String appPackageName = context.getPackageName();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_market_link) + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.login_failed) + appPackageName)));
        }
    }

    public static void setImageUrl(ImageView imageView, String url) {
        if (stringNullOrEmpty(url)) {
            url = "https://laptop88.vn/media/news/724_banner_800x300_4.png";
        }
        final Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.ic_downloading_24)
                .error(R.drawable.ic_close_24)
                .into(imageView);
    }

    public static boolean isNetworkConnected(Context context) {
        final ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            final NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }

    public static String getTimestamp() {
        return new SimpleDateFormat(Constants.DATA_FORMAT, Locale.US).format(new Date());
    }

    public static boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static String loadJSONFromAsset(Context context, String jsonFileName) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream is = manager.open(jsonFileName);

        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        return new String(buffer, StandardCharsets.UTF_8);
    }

    public static boolean stringNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static <T> boolean checkListHasData(List<T> list) {
        return list != null && !list.isEmpty();
    }

    @SuppressLint("DefaultLocale")
    public static SpannableString customPrice(float price) {
        // Số tiền
        final String priceString = String.format("%.0f", price);
        // Đơn vị tiền tệ
        final String currency = "VNĐ";
        // Tạo SpannableString
        final SpannableString spannableString = new SpannableString(priceString + " " + currency);

        // Đổi màu cho phần "VNĐ"
        spannableString.setSpan(new ForegroundColorSpan(
                        Color.parseColor("#FF0808")),
                priceString.length() + 1,
                spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }
}
