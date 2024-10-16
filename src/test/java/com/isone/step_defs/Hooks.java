package com.isone.step_defs;

import com.isone.utilities.BrowserUtils;
import com.isone.utilities.Driver;
import org.junit.After;

public class Hooks {


    @After
    public void tearDown()  {
        BrowserUtils.sleep(3);
        Driver.getInstance().close();
    }
}
