package hello.core.order;

public interface OrderService {
//    주문 관리 기능
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
