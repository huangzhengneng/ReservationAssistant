package com.gkzxhn.xjyyzs.requests;


import com.gkzxhn.xjyyzs.requests.bean.ApplyResult;
import com.gkzxhn.xjyyzs.requests.bean.LoginResult;
import com.gkzxhn.xjyyzs.requests.bean.SearchResultBean;
import com.gkzxhn.xjyyzs.requests.bean.UpdateInfo;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * author:huangzhengneng
 * email:943852572@qq.com
 * date: 2016/8/8.
 * function:相关api请求服务
 */

public interface ApiService {

    /**
     * 登录
     * @param body
     * @return
     */
    @POST("login")
    Observable<LoginResult> login(
            @Body RequestBody body
    );

    /**
     * 获取当天申请结果列表
     * @param orgCode
     * @return
     */
    @GET("applies")
    Observable<ApplyResult> getCurrentDayData(
            @Header("Authorization") String token,
            @Query("orgCode") String orgCode
    );

    /**
     * 修改密码
     * @param token
     * @param body
     * @return
     */
    @PUT("users/{token}")
    Observable<ResponseBody> changePwd(
            @Header("Authorization") String token,
            @Path("token") String token_,
            @Body RequestBody body
    );

    /**
     * 预约申请
     * @param token
     * @param body
     * @return
     */
    @POST("applies")
    Observable<ResponseBody> apply(
            @Header("Authorization") String token,
            @Body RequestBody body
    );

    /**
     * 按时间段查询
     * @param token
     * @param start_time
     * @param end_time
     * @param orgCode
     * @return
     */
    @GET("search")
    Observable<SearchResultBean> searchByTime(
            @Header("Authorization") String token,
            @Query("start") String start_time,
            @Query("end") String end_time,
            @Query("orgCode") String orgCode
    );

    /**
     * 更新检查
     * @return
     */
    @GET("xjp/file/versionContent")
    Observable<UpdateInfo> updateCheck();
}
