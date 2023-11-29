package com.brocamp.AcousticAlchemy.controller;

import com.brocamp.AcousticAlchemy.model.OrderProducts;
import com.brocamp.AcousticAlchemy.service.OrderDetailsService;
import com.brocamp.AcousticAlchemy.service.OrderProductsService;
import com.brocamp.AcousticAlchemy.serviceimpl.PdfGeneratorServiceImpl;
import com.razorpay.Order;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@Controller
public class InvoiceController {
    private OrderDetailsService orderDetailsService;
    private OrderProductsService orderProductsService;
    private PdfGeneratorServiceImpl pdfGeneratorService;



    @GetMapping("/invoice/{id}")
    public void customerOrderInvoice(@PathVariable("id")long id,HttpServletResponse response) throws IOException {

        if(orderDetailsService.existsById(id)){
            OrderProducts orderProducts=orderProductsService.findByOrderProductId(id);

            response.setContentType("application/pdf");
            DateFormat dateFormat=new SimpleDateFormat("yy-mm-dd-hh-mm-ss");
            String currentDAteTime= dateFormat.format(new Date());
            String headerKey="Content Disposition";
            String headerValue="attachment; filename=pdf_"+currentDAteTime+".pdf";
            response.setHeader(headerKey,headerValue);
            pdfGeneratorService.export(response,orderProducts);

        }


    }
}
