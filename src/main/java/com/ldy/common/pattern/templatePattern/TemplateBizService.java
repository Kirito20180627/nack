package com.ldy.common.pattern.templatePattern;


public class TemplateBizService {

    public BaseBizResult<String> query(String bizId){

        CommonBizTemplate commonBizTemplate = new CommonBizTemplate();
        BaseBizResult<String> result= commonBizTemplate.execute(
                new CommonBizCallback<String>() {
                    /*** 前置入参验证*/
                    @Override
                    public void beforeCheck() {
                        if(bizId.isEmpty()){
                            throw  new BizRuntimeException("001","入参id值为空");
                        }
                        if("a".equals(bizId)){
                            throw  new BizRuntimeException("002","入参id值不能是a");
                        }
                    }
                    /**操作逻辑* @return */
                    @Override
                    public String doAction() {
                        //具体业务逻辑层返回
                        return "业务数据";
                    }
                    /*** 后置处理  */
                    @Override
                    public void afterAction(String o) {
                        if(o.equals("成功返回业务数据")){
                            System.out.println("记录日志log.....");
                        }
                    }

                    @Override
                    public void finallyAction(String s) {
                    }
                });
        System.out.println(result.getData());
        return result;
    }
}
