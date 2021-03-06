/*
 * Copyright 2004-2015 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.framework.aop.interceptors;

import org.seasar.framework.unit.S2FrameworkTestCase;

/**
 * @author koichik
 * 
 */
public class HotAwareDelegateInterceptorTest extends S2FrameworkTestCase {

    private Hello hello;

    protected void setUp() throws Exception {
        super.setUp();
        include("HotAwareDelegateInterceptorTest.dicon");
        register(HelloImpl.class, "hello2");
    }

    /**
     * @throws Exception
     */
    public void testInvoke() throws Exception {
        assertEquals("Hello", hello.greeting());
    }

    /**
     * @author koichik
     * 
     */
    public interface Hello {
        /**
         * @return
         */
        public String greeting();
    }

    /**
     * @author koichik
     * 
     */
    public static class HelloImpl implements Hello {
        public String greeting() {
            return "Hello";
        }
    }

}