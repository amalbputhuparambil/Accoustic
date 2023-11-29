package com.brocamp.AcousticAlchemy.serviceimpl;

import com.brocamp.AcousticAlchemy.model.OrderProducts;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class PdfGeneratorServiceImpl  {
    public void export(HttpServletResponse response, OrderProducts orderProducts) throws IOException {
        Document document=new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());

        document.open();
        Font fontTitle= FontFactory.getFont(FontFactory.COURIER_BOLD);
        fontTitle.setSize(20);
        Paragraph paragraph=new Paragraph("INVOICE OF YOUR ORDER",fontTitle);
        paragraph.setAlignment(paragraph.ALIGN_CENTER);

        Font fontparaph=new Font();
        fontparaph.setSize(500);
        Paragraph paragraph1=new Paragraph("\n"+"\n"+"\n"+"Order Id : "+orderProducts.getOrderDetails().getId() + "\n"+
                "Product name  : "+orderProducts.getProduct().getName() + "\n"+
                "Orderd Date : "+orderProducts.getOrderDetails().getOrderDate() + "\n"+
                "Delevery Date: "+orderProducts.getOrderDetails().getDeliveryDate() + "\n"+
                "Payment Type : "+ orderProducts.getOrderDetails().getPaymentMethods().getPaymentMode()   + "\n"+"\n"+"\n"+
                "Amount: "+orderProducts.getProduct().getSalePrice()+ "\n"+

                "------------------------------------------------------------------------"+"\n"+
                "\n"+"\n");


        Font fontparaph1=new Font();
        fontparaph1.setSize(500);
      Paragraph paragraph2=new Paragraph("Delevery Address"+"\n"+"\n"+
              "Customer name : "+orderProducts.getOrderDetails().getAddress().getRecipientName()+"\n"+
              "House Name : "+orderProducts.getOrderDetails().getAddress().getHouseDetails()+"\n"+
              "Place : "+orderProducts.getOrderDetails().getAddress().getCity()+"\n"+
              "State : "+orderProducts.getOrderDetails().getAddress().getState()+"\n"+
              "Address Type : "+orderProducts.getOrderDetails().getAddress().getTypeOfAddress()+"\n"+
              "Pincode: "+orderProducts.getOrderDetails().getAddress().getPinCode()+"\n"+
              "Phone number: "+orderProducts.getOrderDetails().getAddress().getPhoneNumber()+"\n"+"\n"
              +"\n"+"\n"+"\n"+"\n"+
              "---------------------------------------------------------------------------- -");

document.add(paragraph);
document.add(paragraph1);
document.add(paragraph2);
document.close();
    }

}
