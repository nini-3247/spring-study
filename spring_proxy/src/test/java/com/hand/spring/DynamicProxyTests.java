package com.hand.spring;

import com.hand.spring.proxy.dynamic.rent.*;
import org.junit.jupiter.api.Test;
import sun.tools.jar.CommandLine;

public class DynamicProxyTests {
    @Test
    public void dynamicRentProxyTest_1() {
        Tenant tenant = new Tenant("robert");
        Client client = new Client("cjh");
        SolidIntermediary intermediary = new SolidIntermediary();
        IntermediaryInvocationHandler handler = new IntermediaryInvocationHandler();
        handler.setRent(intermediary);
        Rent proxy = (Rent) handler.getProxy();
        client.rentFrom(proxy);
    }
}
