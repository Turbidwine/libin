package com.example.redisdemo;

import com.example.mapper.TagMapper;
import com.example.model.CustomerCampaignTag;
import com.example.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TagMapper tagMapper;

    @Test
    public void dataAdd(){
        long start1 = new Date().getTime();
        for (int i = 2132; i <=2145 ; i++) {
            //long start = new Date().getTime();
            int pageIndex = i;
            int a  = (pageIndex-1)*1000;
            List<CustomerCampaignTag> b =tagMapper.selectCustomerPage(a);
            //long end = new Date().getTime();
            //System.out.println("查询时间------------------"+(end-start)/1000);
            customerService.saveAll(b);

        }
        long end1 = new Date().getTime();
        System.out.println("写入时间------------------"+(end1-start1)/1000);
    }
}
