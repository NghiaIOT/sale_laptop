package com.hcm.sale_laptop.data.api;

import com.hcm.base.BaseResponse;
import com.hcm.sale_laptop.data.model.network.request.LoginRequest;
import com.hcm.sale_laptop.data.model.network.request.OrderRequest;
import com.hcm.sale_laptop.data.model.network.request.SignupRequest;
import com.hcm.sale_laptop.data.model.network.response.BannerResponse;
import com.hcm.sale_laptop.data.model.network.response.BrandResponse;
import com.hcm.sale_laptop.data.model.network.response.LoginResponse;
import com.hcm.sale_laptop.data.model.network.response.OrderResponse;
import com.hcm.sale_laptop.data.model.network.response.ProductResponse;
import com.hcm.sale_laptop.data.model.network.response.ProductSaleResponse;
import com.hcm.sale_laptop.data.model.network.response.SignupResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
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

    @GET(EndPoint.ADMIN_PRODUCT)
    Single<ProductResponse> getProductsByBrand(@Query("category_id") String id);

    @POST(EndPoint.ORDERS)
    Single<BaseResponse<Object>> order(@Body OrderRequest request);

    @GET(EndPoint.ORDERS_ALL)
    Single<OrderResponse> getOrderData();

    @GET(EndPoint.ORDERS_BY_USER)
    Single<OrderResponse> getOrderByUser(@Query("user_id") String id);

    @DELETE(EndPoint.ORDERS)
    Single<BaseResponse<Object>> cancelOrder(
            @Header("Authorization") String token,
            @Query("order_id") String orderId,
            @Query("reason") String reason);

    @GET(EndPoint.ORDERS_REVIEW)
    Single<OrderResponse> getDataReview();
}
