package com.bookshop.service.impl;

import com.bookshop.model.Order;
import com.bookshop.model.Product;
import com.bookshop.model.PurchaseHistory;
import com.bookshop.repository.OrderRepository;
import com.bookshop.repository.ProductRepository;
import com.bookshop.repository.PurchaseHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final PurchaseHistoryRepository purchaseHistoryRepository;

    @Transactional
    public Boolean purchase(Long productId, Long customerId, int quantity, int price) {
        Order order = new Order();
        order.setProductId(productId);
        order.setCustomerId(customerId);
        order.setQuantity(quantity);
        order.setPrice(price);
        orderRepository.save(order);
        return true;
    }

    @Transactional
    public void saveHistory(Long customerId, Long productId) {
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setCustomerId(customerId);
        purchaseHistory.setProductId(productId);
        purchaseHistory.setCreatedDate(new Date());
        purchaseHistoryRepository.save(purchaseHistory);
    }

    public void registerNewProducts() {
        Product product = new Product();
        product.setName("Easy Java");
        product.setPrice(500);
        product.setQuantity(5);
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
