package com.namanx.booking_ms.service.impl;

import com.namanx.booking_ms.repository.PaymentRepo;
import com.namanx.booking_ms.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    public final PaymentRepo paymentRepo;
}
