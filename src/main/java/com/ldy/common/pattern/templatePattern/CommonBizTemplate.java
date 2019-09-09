package com.ldy.common.pattern.templatePattern;

public class CommonBizTemplate implements CommonBizOperations {
    @Override
    public <T> BaseBizResult<T> execute(CommonBizCallback<T> callback) {
        T t=null;
        try {
            callback.beforeCheck();
            t=callback.doAction();
            callback.afterAction(t);
            return buildSucceedResult(t);
        } catch (BizRuntimeException e) {
            return buildErrorResult(e.getErrorCode(),e.getErrorMsg());
        }catch (Exception e){
            return buildErrorResult("911","未知异常");
        }finally {
            callback.finallyAction(t);
        }
    }
    private static <T> BaseBizResult<T> buildSucceedResult(T data){
        return new BaseBizResult<>(data);
    }
    private static BaseBizResult buildErrorResult(String errorCode, String errorMsg){
        return new BaseBizResult(errorCode,errorMsg);
    }
}
