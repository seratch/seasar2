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
package org.seasar.extension.jdbc.gen.internal.exception;

import org.junit.Test;
import org.seasar.extension.jdbc.gen.internal.exception.TemplateRuntimeException;

import freemarker.template.TemplateException;

/**
 * @author taedium
 * 
 */
public class TemplateRuntimeExceptionTest {

    /**
     * 
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        TemplateRuntimeException e = new TemplateRuntimeException(
                new TemplateException(null));
        System.out.println(e.getMessage());
    }
}
