package com.mongodbtz.mongotz;

import lombok.Getter;
import lombok.Setter;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@Getter
@Setter
public class JunitTest {
    private String responseStr;

    @Test
    public void testNull() {
        assertNotNull(responseStr);
        Result result = JUnitCore.runClasses(JunitTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

}
