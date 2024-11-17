package com.hcm.sale_laptop.data.repository;

import com.hcm.base.BaseRepository;
import com.hcm.base.BaseResponse;
import com.hcm.sale_laptop.data.api.ApiService;
import com.hcm.sale_laptop.data.api.RetrofitClient;
import com.hcm.sale_laptop.data.model.network.request.CancelOrderRequest;
import com.hcm.sale_laptop.data.model.network.response.OrderResponse;

import io.reactivex.rxjava3.core.Single;

public class OrderRepository extends BaseRepository {

    private final ApiService apiService;

    public OrderRepository() {
        apiService = RetrofitClient.getInstance().create(ApiService.class);
    }

    public Single<OrderResponse> getOrderByUser(String id) {
        return applySingle(apiService.getOrderByUser(id));
    }

    public Single<BaseResponse<Object>> cancelOrder(CancelOrderRequest request) {
        return applySingle(apiService.cancelOrder(request));
    }

    public Single<OrderResponse> getDataReview() {
        return applySingle(apiService.getDataReview());
    }
}
