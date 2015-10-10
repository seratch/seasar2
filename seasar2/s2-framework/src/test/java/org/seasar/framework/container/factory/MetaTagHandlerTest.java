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
package org.seasar.framework.container.factory;

import junit.framework.TestCase;

import org.seasar.framework.container.MetaDef;
import org.seasar.framework.container.S2Container;

/**
 * @author higa
 * 
 */
public class MetaTagHandlerTest extends TestCase {

    private static final String PATH = "org/seasar/framework/container/factory/MetaTagHandlerTest.dicon";

    /**
     * @throws Exception
     */
    public void testMeta() throws Exception {
        S2Container container = S2ContainerFactory.create(PATH);
        assertEquals("1", 1, container.getMetaDefSize());
        MetaDef md = container.getMetaDef("aaa");
        assertEquals("2", "111", md.getValue());
        assertNotNull("3", md.getContainer());
        assertEquals("4", 1, md.getMetaDefSize());
        MetaDef md2 = md.getMetaDef(0);
        assertEquals("5", "222", md2.getValue());
    }
}
