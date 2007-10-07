/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
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
package org.seasar.extension.jdbc.it.auto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.it.entity.Department;
import org.seasar.extension.unit.S2TestCase;

/**
 * @author taedium
 * 
 */
public class AutoBatchInsertTest extends S2TestCase {

    private JdbcManager jdbcManager;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        include("jdbc.dicon");
    }

    /**
     * 
     * @throws Exception
     */
    public void testTx() throws Exception {
        List<Department> list = new ArrayList<Department>();
        Department department = new Department();
        department.departmentId = 98;
        department.departmentName = "hoge";
        list.add(department);
        Department department2 = new Department();
        department2.departmentId = 99;
        department2.departmentName = "foo";
        list.add(department2);

        int[] result = jdbcManager.insert(list).executeBatch();
        assertEquals(2, result.length);

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("departmentId", 98);
        department = jdbcManager.from(Department.class).where(m)
                .getSingleResult();
        assertEquals(98, department.departmentId);
        assertEquals(0, department.departmentNo);
        assertEquals("hoge", department.departmentName);
        assertNull(department.location);
        assertEquals(0, department.version);

        m.put("departmentId", 99);
        department = jdbcManager.from(Department.class).where(m)
                .getSingleResult();
        assertEquals(99, department.departmentId);
        assertEquals(0, department.departmentNo);
        assertEquals("foo", department.departmentName);
        assertNull(department.location);
        assertEquals(0, department.version);
    }

    /**
     * 
     * @throws Exception
     */
    public void test_includesTx() throws Exception {
        List<Department> list = new ArrayList<Department>();
        Department department = new Department();
        department.departmentId = 98;
        department.departmentNo = 98;
        department.departmentName = "hoge";
        department.location = "foo";
        department.version = 1;
        list.add(department);
        Department department2 = new Department();
        department2.departmentId = 99;
        department2.departmentNo = 99;
        department2.departmentName = "bar";
        department2.location = "baz";
        department2.version = 1;
        list.add(department2);

        int[] result = jdbcManager.insert(list).includes("departmentId",
                "departmentNo", "location", "version").executeBatch();
        assertEquals(2, result.length);

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("departmentId", 98);
        department = jdbcManager.from(Department.class).where(m)
                .getSingleResult();
        assertEquals(98, department.departmentId);
        assertEquals(98, department.departmentNo);
        assertNull(department.departmentName);
        assertEquals("foo", department.location);
        assertEquals(1, department.version);

        m.put("departmentId", 99);
        department = jdbcManager.from(Department.class).where(m)
                .getSingleResult();
        assertEquals(99, department.departmentId);
        assertEquals(99, department.departmentNo);
        assertNull(department.departmentName);
        assertEquals("baz", department.location);
        assertEquals(1, department.version);
    }

    /**
     * 
     * @throws Exception
     */
    public void test_excludesTx() throws Exception {
        List<Department> list = new ArrayList<Department>();
        Department department = new Department();
        department.departmentId = 98;
        department.departmentNo = 98;
        department.departmentName = "hoge";
        department.location = "foo";
        department.version = 1;
        list.add(department);
        Department department2 = new Department();
        department2.departmentId = 99;
        department2.departmentNo = 99;
        department2.departmentName = "bar";
        department2.location = "baz";
        department2.version = 1;
        list.add(department2);

        int[] result = jdbcManager.insert(list).excludes("departmentName",
                "location").executeBatch();
        assertEquals(2, result.length);

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("departmentId", 98);
        department = jdbcManager.from(Department.class).where(m)
                .getSingleResult();
        assertEquals(98, department.departmentId);
        assertEquals(98, department.departmentNo);
        assertNull(department.departmentName);
        assertEquals("TOKYO", department.location);
        assertEquals(1, department.version);

        m.put("departmentId", 99);
        department = jdbcManager.from(Department.class).where(m)
                .getSingleResult();
        assertEquals(99, department.departmentId);
        assertEquals(99, department.departmentNo);
        assertNull(department.departmentName);
        assertEquals("TOKYO", department.location);
        assertEquals(1, department.version);
    }

}
