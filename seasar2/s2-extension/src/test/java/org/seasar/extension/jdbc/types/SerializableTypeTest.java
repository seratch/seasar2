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
package org.seasar.extension.jdbc.types;

import java.io.Serializable;

import junit.framework.TestCase;

/**
 * @author taedium
 * 
 */
public class SerializableTypeTest extends TestCase {

    /**
     * 
     * @throws Exception
     */
    public void testToText() throws Exception {
        SerializableType type = new SerializableType(BytesType.BYTES_TRAIT);
        Aaa aaa = new Aaa();
        assertEquals("'" + aaa + "'", type.toText(aaa));
    }

    /**
     * @throws Exception
     */
    public void testSerializaAndDeserialize() throws Exception {
        SerializableType type = new SerializableType(BytesType.BYTES_TRAIT);
        Aaa aaa = new Aaa();
        aaa.text = "HOGE";
        byte[] bytes = type.serialize(aaa);
        aaa = (Aaa) type.deserialize(bytes);
        assertEquals("HOGE", aaa.text);
    }

    /**
     * 
     * @author taedium
     * 
     */
    public static class Aaa implements Serializable {

        private static final long serialVersionUID = 1L;

        /** */
        public String text;

    }

}
