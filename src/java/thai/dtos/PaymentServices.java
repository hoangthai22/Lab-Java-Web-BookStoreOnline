/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thai.dtos;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PaymentServices {

    private static final String CLIENT_ID = "AVw_fOO4zILmKrqf4YmmuNy02-3aZcVmwpW6RD7PsWqg55ExjFBKn888cJC_1b_epEKsfxsa69H68V5S";
    private static final String CLIENT_SECRET = "EDqB1pq7v-wtTutyj-YIMaNzc5Umqd-UQpLonz8L1OJOELDHjI2Bdg7uFrQ6hhnCWbkDBR_gXZYKgzld";
    private static final String MODE = "sandbox";

    public String authorizePayment(OrderObj order)
            throws PayPalRESTException {

        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(order);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);

    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
      
        payer.setPaymentMethod("paypal");
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("Hoang")
                .setLastName("Thai")
                .setEmail("user_test_2@gmail.com");
        payer.setPayerInfo(payerInfo);
        
        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8181/J3.L.P0018.TheBookStore/shoppingcart.jsp");
        redirectUrls.setReturnUrl("http://localhost:8181/J3.L.P0018.TheBookStore/MainController?action=ReviewOrder");

        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(OrderObj order) {
        Details details = new Details();
        details.setShipping(order.getOrderShip() + "");
        details.setSubtotal(order.getOrderSubTotal() + "");
        details.setTax(order.getOrderTax() + "");
        details.setShippingDiscount("-"+order.getOrderDiscount());

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(order.getOrderTotal() + "");
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(order.getOrderID());

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<>();

        Item item = new Item();
        item.setCurrency("USD");
        item.setName(order.getOrderID());
        item.setPrice(order.getOrderSubTotal() + "");
        item.setTax(order.getOrderTax() + "");
        item.setQuantity("1");

        items.add(item);
        itemList.setItems(items);
        
        transaction.setItemList(itemList);

        List<Transaction> listTransaction = new ArrayList<>();
        listTransaction.add(transaction);

        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }

        return approvalLink;
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }

    public Payment executePayment(String paymentId, String payerId)
            throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        return payment.execute(apiContext, paymentExecution);
    }
}
