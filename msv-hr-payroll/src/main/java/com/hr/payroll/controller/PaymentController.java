package com.hr.payroll.controller;

import com.hr.payroll.entity.Payment;
import com.hr.payroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{day}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,  @PathVariable Integer day){
        return ResponseEntity.ok(paymentService.getPayment(workerId, day));
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer day){
        Payment payment = new Payment("Brann", 400.0, day);
        return ResponseEntity.ok(payment);
    }
}
