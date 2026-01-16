package com.pms.pmSystem.config.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.pms.pmSystem.config.annotation.Auditable;
import com.pms.pmSystem.data.enums.AuditAction;
import com.pms.pmSystem.entity.model.AuditLogs;
import com.pms.pmSystem.repository.AuditLogsRepository;

import jakarta.transaction.Transactional;

@Aspect
@Component
public class AuditAspect {

    private final ExpressionEvaluator evaluator = new ExpressionEvaluator();
    @Autowired
    private AuditLogsRepository auditLogsRepository;

    @Around("@annotation(auditable)")
    @Transactional
    public Object doAuditLog(ProceedingJoinPoint proceedingJoinPoint, Auditable auditable) throws Throwable {
        Object target = proceedingJoinPoint.getTarget();
        Class<?> targetClass = AopProxyUtils.ultimateTargetClass(target);
        if (targetClass == null && target != null) {
            targetClass = target.getClass();
        }
        AuditMessageContext context = createAuditMessageContext(((MethodSignature) proceedingJoinPoint.getSignature()).getMethod(),
                proceedingJoinPoint.getArgs(), target, targetClass);

        Object doProceed = proceedingJoinPoint.proceed();

        AuditLogs auditLogs = new AuditLogs();
        auditLogs.setActor(context.generateActor());
        auditLogs.setAuditAction(AuditAction.valueOf(context.generateAuditAction()));
        auditLogs.setMessage(context.generateMessage());
        auditLogs.setIpAddress(context.generateIpAddress());
        auditLogs.setDevice(context.generateDevice());
        auditLogs.setOs(context.generateOs());
        auditLogs.setBrowser(context.generateBrowser());
        auditLogsRepository.save(auditLogs);

        return doProceed;
    }

    private AuditMessageContext createAuditMessageContext(Method method, Object[] args, Object target, Class<?> targetClass) {
        return new AuditMessageContext(method.getAnnotation(Auditable.class), method, args, target, targetClass);
    }

    private class AuditMessageContext {

        private final Auditable auditable;
        private final Object target;
        private final Method method;
        private final Object[] args;

        private final EvaluationContext evalContext;

        public AuditMessageContext(Auditable auditable, Method method, Object[] args, Object target, Class<?> targetClass) {
            this.auditable = auditable;
            this.target = target;
            this.method = method;
            this.args = args;

            this.evalContext = evaluator.createEvaluationContext(method, args, target, targetClass);
        }

        public String generateMessage() {
            if (StringUtils.hasText(this.auditable.message())) {
                return evaluator.message(this.auditable.message(), this.method, this.evalContext);
            }
            return "";
        }

        public String generateAuditAction() {
            if (StringUtils.hasText(this.auditable.auditAction())) {
                return evaluator.message(this.auditable.auditAction(), this.method, this.evalContext);
            }
            return "";
        }

        public String generateActor() {
            if (StringUtils.hasText(this.auditable.actor())) {
                return evaluator.message(this.auditable.actor(), this.method, this.evalContext);
            }
            return "";
        }

        public String generateIpAddress() {
            if (StringUtils.hasText(this.auditable.ipAddress())) {
                return evaluator.message(this.auditable.ipAddress(), this.method, this.evalContext);
            }
            return "";
        }

        public String generateDevice() {
            if (StringUtils.hasText(this.auditable.device())) {
                return evaluator.message(this.auditable.device(), this.method, this.evalContext);
            }
            return "";
        }

        public String generateOs() {
            if (StringUtils.hasText(this.auditable.os())) {
                return evaluator.message(this.auditable.os(), this.method, this.evalContext);
            }
            return "";
        }

        public String generateBrowser() {
            if (StringUtils.hasText(this.auditable.browser())) {
                return evaluator.message(this.auditable.browser(), this.method, this.evalContext);
            }
            return "";
        }

    }
}
