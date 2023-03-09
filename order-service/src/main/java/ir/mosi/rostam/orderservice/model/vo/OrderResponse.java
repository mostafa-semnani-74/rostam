package ir.mosi.rostam.orderservice.model.vo;

import ir.mosi.rostam.orderservice.model.entity.Order;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private Order order;
    private List<ProductVO> productVO;
}
