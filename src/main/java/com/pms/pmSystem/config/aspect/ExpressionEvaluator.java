package com.pms.pmSystem.config.aspect;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import org.springframework.expression.Expression;

public class ExpressionEvaluator {

    private ParameterNameDiscoverer paramNameDiscoverer = new DefaultParameterNameDiscoverer();

    private SpelExpressionParser parser = new SpelExpressionParser();

    private Map<String, Expression> messageCache = new ConcurrentHashMap<String, Expression>();

    private Map<String, Method> targetMethodCache = new ConcurrentHashMap<String, Method>();

    public EvaluationContext createEvaluationContext(
            Method method, Object[] args, Object target, Class<?> targetClass) {

        AuditExpressionRootObject rootObject
                = new AuditExpressionRootObject(method, args, target, targetClass);
        return new LazyParamAwareEvaluationContext(rootObject,
                this.paramNameDiscoverer, method, args, targetClass, this.targetMethodCache);
    }

    public String message(String messageExpression, Method method, EvaluationContext evalContext) {
        String key = toString(method, messageExpression);
        Expression keyExp = this.messageCache.get(key);
        if (keyExp == null) {
            keyExp = this.parser.parseExpression(messageExpression);
            this.messageCache.put(key, keyExp);
        }
        return keyExp.getValue(evalContext, String.class);
    }

    private String toString(Method method, String expression) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getDeclaringClass().getName());
        sb.append("#");
        sb.append(method.toString());
        sb.append("#");
        sb.append(expression);
        return sb.toString();
    }
}
