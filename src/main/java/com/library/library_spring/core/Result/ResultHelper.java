package com.library.library_spring.core.Result;

import com.library.library_spring.core.config.Msg;
import com.library.library_spring.dto.CursorResponse;
import org.springframework.data.domain.Page;

public class ResultHelper {

    public static Result insufficientStockError(String msg) {
        return new Result("409", Msg.INSUFFICIENT_STOCK, false);
    }
    public static <T> ResultData<T> created(T data){
        return new ResultData<>("201", Msg.CREATED,true , data);
    }
    public static <T> ResultData<T> validateError(T data){
        return new ResultData<>("400", Msg.VALIDATE_ERROR, false, data );
    }
    public static <T> ResultData<T> success(T data){
        return new ResultData<>("200", Msg.OK, true, data );
    }

    public static Result ok(){
        return new Result("200", Msg.OK, true);
    }
    public static Result notFoundError(String msg){
        return new Result("404", msg, false );
    }
    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData) {
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());

        return ResultHelper.success(cursor);
    }

}
