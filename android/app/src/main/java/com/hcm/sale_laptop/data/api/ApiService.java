package com.hcm.sale_laptop.data.api;

import com.hcm.sale_laptop.data.model.network.request.LoginRequest;
import com.hcm.sale_laptop.data.model.network.request.SignupRequest;
import com.hcm.sale_laptop.data.model.network.response.BannerResponse;
import com.hcm.sale_laptop.data.model.network.response.BrandResponse;
import com.hcm.sale_laptop.data.model.network.response.LoginResponse;
import com.hcm.sale_laptop.data.model.network.response.ProductResponse;
import com.hcm.sale_laptop.data.model.network.response.ProductSaleResponse;
import com.hcm.sale_laptop.data.model.network.response.SignupResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST(EndPoint.LOGIN)
    Single<LoginResponse> login(@Body LoginRequest signupRequest);

    @POST(EndPoint.SIGNUP)
    Single<SignupResponse> signupUser(@Body SignupRequest signupRequest);

    @GET(EndPoint.ADMIN_CATEGORY)
    Single<BrandResponse> getDataBrand();

    @GET(EndPoint.ADMIN_PRODUCT)
    Single<ProductResponse> getDataProducts();

    @GET(EndPoint.ADMIN_BANNER)
    Single<BannerResponse> getDataBanners();

    @GET(EndPoint.ADMIN_PRODUCT_SALE)
    Single<ProductSaleResponse> getDataProductSales();

    @GET(EndPoint.ADMIN_PRODUCT)
    Single<ProductResponse> searchProducts(@Query("title") String keyWord);

    @GET(EndPoint.ADMIN_CATEGORY)
    Single<ProductResponse> getProductsByBrand(@Query("category") String id);
}
