package com.hr.payroll.controller;

import com.hr.payroll.entity.Payment;
import com.hr.payroll.service.PaymentService;
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

    @GetMapping(value = "/{workerId}/days/{day}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,  @PathVariable Integer day){
        return ResponseEntity.ok(paymentService.getPayment(workerId, day));
    }
}
