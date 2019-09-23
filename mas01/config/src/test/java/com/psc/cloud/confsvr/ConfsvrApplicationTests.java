package com.psc.cloud.confsvr;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ConfsvrApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void defaultConfigTest() throws Exception{
        String result1 = this.restTemplate.getForObject("/order/default", String.class);
        String result2 = this.restTemplate.getForObject("/work/default", String.class);
        assertTrue(result1.contains("default")&& result2.contains("default"));
        System.out.println(result1);
        System.out.println(result2);
    }
    @Test
    public void devConfigTest() throws Exception{
        String result1 = this.restTemplate.getForObject("/order/dev", String.class);
        String result2 = this.restTemplate.getForObject("/work/dev", String.class);
        assertTrue(result1.contains("default")&& result2.contains("dev"));
        System.out.println(result1);
        System.out.println(result2);
    }
    @Test
    public void prodConfigTest() throws Exception{
        String result1 = this.restTemplate.getForObject("/order/prod", String.class);
        String result2 = this.restTemplate.getForObject("/work/prod", String.class);
        assertTrue(result1.contains("default")&& result2.contains("prod"));
        System.out.println(result1);
        System.out.println(result2);
    }
}
