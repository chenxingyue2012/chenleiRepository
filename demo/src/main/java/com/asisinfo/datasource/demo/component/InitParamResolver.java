package com.asisinfo.datasource.demo.component;

import com.asisinfo.datasource.demo.domain.InitParam;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Iterator;

public class InitParamResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return InitParam.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        InitParam initParam = new InitParam();
        Iterator<String> fields = webRequest.getParameterNames();

        while (fields.hasNext()) {
            String field = fields.next();
            initParam.setValue(field, webRequest.getParameter(field));
        }
        return initParam;
    }
}
