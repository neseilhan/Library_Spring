package com.library.library_spring.core.Result;

import com.library.library_spring.core.config.Msg;

public class ResultHelper {

    public static <T> ResultData<T> created(T data){
        return new ResultData<>("201", Msg.CREATED,true , data);
    }

}
