package com.zawlynn.dependency.utils;

import com.zawlynn.dependency.constant.Constants;

public class CommonUtils {
    private static CommonUtils instance;
    public static CommonUtils getInstance(){
        if(instance==null){
            instance=new CommonUtils();
        }
        return instance;
    }
    public String getMoviePoster(String url){
        return Constants.BASE_POSTER_PATH+url;
    }
}
